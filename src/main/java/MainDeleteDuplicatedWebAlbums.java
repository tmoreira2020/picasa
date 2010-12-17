/**
 * Copyright (c) 2010 Thiago Leão Moreira. All rights reserved.
 *
 * Licensed under the LGPL License, Version 3.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.gnu.org/licenses/gpl-3.0.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import java.net.URL;
import java.util.List;
import java.util.regex.Pattern;

import com.google.gdata.client.photos.PicasawebService;
import com.google.gdata.data.photos.GphotoEntry;
import com.google.gdata.data.photos.UserFeed;


public class MainDeleteDuplicatedWebAlbums {

	public static void main(String[] args) throws Exception {
		Pattern pattern = Pattern.compile("http://(.)*/\\d\\d\\d\\d\\d\\d\\d\\d02?(.)*");
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
			
			if (pattern.matcher(href).matches()) {
				System.out.println("Deleting duplicated album: " + entry.getTitle().getPlainText());
				entry.delete();
			}
		}

	}

}
