import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.gdata.client.photos.PicasawebService;
import com.google.gdata.data.Extension;
import com.google.gdata.data.photos.AlbumFeed;
import com.google.gdata.data.photos.GphotoEntry;
import com.google.gdata.data.photos.GphotoLocation;
import com.google.gdata.data.photos.UserFeed;

public class MainGeneratePicasaIniFile {

	public static void main(String[] args) {
		try {

			Calendar start = Calendar.getInstance();
			
			start.set(1899, 11, 30, 0, 0);

			PicasawebService myService = new PicasawebService("My Application");
			myService.setUserCredentials(args[0], args[1]);

			// Get a list of all entries
			URL metafeedUrl = new URL(
					"http://picasaweb.google.com/data/feed/api/user/" + args[0]
							+ "?kind=album");
			System.out.println("Getting Picasa Web Albums entries...\n");
			UserFeed resultFeed = myService
					.getFeed(metafeedUrl, UserFeed.class);

			// resultFeed.

			File root = new File(args[2]);
			File[] albuns = root.listFiles();

			int j = 0;
			List<GphotoEntry> entries = resultFeed.getEntries();
			for (int i = 0; i < entries.size(); i++) {
				GphotoEntry entry = entries.get(i);
				String href = entry.getHtmlLink().getHref();

				String name = entry.getTitle().getPlainText();

				for (File album : albuns) {
					if (album.getName().equals(name) && !href.contains("02?")) {
						File picasaini = new File(album, "Picasa.ini");

						if (!picasaini.exists()) {
							StringBuilder builder = new StringBuilder();

							builder.append("\n");
							builder.append("[Picasa]\n");
							builder.append("name=");
							builder.append(name);
							builder.append("\n");
							builder.append("location=");
							Collection<Extension> extensions = entry
									.getExtensions();

							for (Extension extension : extensions) {

								if (extension instanceof GphotoLocation) {
									GphotoLocation location = (GphotoLocation) extension;
									if (location.getValue() != null) {
										builder.append(location.getValue());
									}
								}
							}
							builder.append("\n");
							builder.append("category=Folders on Disk");
							builder.append("\n");
							builder.append("date=");
							String source = name.substring(0, 10);
							
							DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

							Date date = formater.parse(source);
							
							Calendar end = Calendar.getInstance();
							
							end.setTime(date);

							builder.append(daysBetween(start, end));
							builder.append(".000000");
							builder.append("\n");
							builder.append(args[0]);
							builder.append("_lh=");
							builder.append(entry.getGphotoId());
							builder.append("\n");
							builder.append("P2category=Folders on Disk");
							builder.append("\n");
							
							URL feedUrl = new URL(
									"https://picasaweb.google.com/data/feed/api/user/" + args[0] + "/albumid/"
											+ entry.getGphotoId());

							AlbumFeed feed = myService
									.getFeed(feedUrl, AlbumFeed.class);

							
							for (GphotoEntry photo : feed.getEntries()) {
								builder.append("\n");
								builder.append("[");
								builder.append(photo.getTitle().getPlainText());
								builder.append("]");
								builder.append("\n");
								long id = Long.parseLong(photo.getGphotoId());
								
								builder.append("IIDLIST_");
								builder.append(args[0]);
								builder.append("_lh=");
								builder.append(Long.toHexString(id));
								builder.append("\n");
							}

							System.out.println(builder.toString());
							IOUtils.write(builder.toString(), new FileOutputStream(picasaini));
							j++;
						}
					}

				}

			}
			System.out.println(j);
			System.out.println("\nTotal Entries: " + entries.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static long daysBetween(Calendar startDate, Calendar endDate) {
		Calendar date = (Calendar) startDate.clone();
		long daysBetween = 0;
		while (date.before(endDate)) {
			date.add(Calendar.DAY_OF_MONTH, 1);
			daysBetween++;
		}
		return daysBetween;
	}

}
