import java.net.URL;
import java.util.List;

import com.google.gdata.client.photos.PicasawebService;
import com.google.gdata.data.photos.GphotoEntry;
import com.google.gdata.data.photos.UserFeed;


public class MainDeleteDuplicatedwebAlbums {

	public static void main(String[] args) throws Exception {
		PicasawebService myService = new PicasawebService("My Application");
		myService.setUserCredentials(args[0], args[1]);

		// Get a list of all entries
		URL metafeedUrl = new URL(
				"http://picasaweb.google.com/data/feed/api/user/" + args[0]
						+ "?kind=album");
		System.out.println("Getting Picasa Web Albums entries...\n");
		UserFeed resultFeed = myService
				.getFeed(metafeedUrl, UserFeed.class);

		int j = 0;
		List<GphotoEntry> entries = resultFeed.getEntries();
		for (int i = 0; i < entries.size(); i++) {
			GphotoEntry entry = entries.get(i);
			String href = entry.getHtmlLink().getHref();
			
			if (href.contains("02?")) {
				System.out.println("Deleting duplicated album: " + entry.getTitle().getPlainText());
				entry.delete();
			}
		}

	}

}
