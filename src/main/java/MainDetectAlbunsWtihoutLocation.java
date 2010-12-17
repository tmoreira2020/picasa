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
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.google.gdata.client.photos.PicasawebService;
import com.google.gdata.data.Extension;
import com.google.gdata.data.photos.GphotoEntry;
import com.google.gdata.data.photos.GphotoLocation;
import com.google.gdata.data.photos.UserFeed;

public class MainDetectAlbunsWtihoutLocation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PicasawebService myService = new PicasawebService("My Application");
			myService.setUserCredentials(args[0], args[1]);

			// Get a list of all entries
			URL metafeedUrl = new URL(
					"http://picasaweb.google.com/data/feed/api/user/" + args[0]
							+ "?kind=album");
			System.out.println("Getting Picasa Web Albums entries...\n");
			UserFeed resultFeed = myService
					.getFeed(metafeedUrl, UserFeed.class);

			SortedSet<String> locations = new TreeSet<String>();
			
			List<GphotoEntry> entries = resultFeed.getEntries();
			for (GphotoEntry entry : entries) {

				String name = entry.getTitle().getPlainText();

				Collection<Extension> extensions = entry.getExtensions();

				for (Extension extension : extensions) {

					if (extension instanceof GphotoLocation) {
						GphotoLocation location = (GphotoLocation) extension;
						String value = location.getValue();  
						if (value == null || value.trim().length() == 0) {
							System.out.println(name);
						} else {
							String correct = "Florianópolis - SC, Brazil";
							if (value.contains("lorian") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "São Francisco do Sul - SC, Brazil";
							if (value.contains("ão Francisco") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Joinville - SC, Brazil";
							if (value.contains("Joinville") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Balneário Camburiú - SC, Brazil";
							if (value.contains("Camburiú") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Barra Velha - SC, Brazil";
							if (value.contains("Barra Velha") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Biguaçu - SC, Brazil";
							if (value.contains("Biguaçu") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Campo Alegre - SC, Brazil";
							if (value.contains("Campo Alegre") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Garopaba - SC, Brazil";
							if (value.contains("Garopa") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Governador Celso Ramos - SC, Brazil";
							if (value.contains("Governador ") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Guarda do Embaú - SC, Brazil";
							if (value.contains("Guarda do Embaú") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Itajuba - SC, Brazil";
							if (value.contains("Itajuba") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Itapema - SC, Brazil";
							if (value.contains("Itapema") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Laguna - SC, Brazil";
							if (value.contains("Faro") || value.contains("Laguna") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Palhoça - SC, Brazil";
							if (value.contains("Palhoça") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Penha - SC, Brazil";
							if (value.contains("Penha") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Curitiba - PR, Brazil";
							if (value.contains("Curitiba") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Foz do Iguaçu - PR, Brazil";
							if (value.contains("Foz do Iguaçu") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Rio de Janeiro - RJ, Brazil";
							if (value.contains("de Janeiro") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Gramado - RS, Brazil";
							if (value.contains("Gramado") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Recife - PE, Brazil";
							if (value.contains("Recife") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Jundiaí - SP, Brazil";
							if (value.contains("Jundiaí") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "São Paulo - SP, Brazil";
							if (value.contains("São Paulo") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Diamond Bar - CA, USA";
							if (value.contains("Diamond") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Hacienda Heights - CA, USA";
							if (value.contains("Hacienda") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Los Angeles - CA, USA";
							if (value.contains("ngeles") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Las Vegas - NV, USA";
							if (value.contains("Las Vegas") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Mammoth - CA, USA";
							if (value.contains("Mammoth") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Miami - FL, USA";
							if (value.contains("Miami") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "New York City - NJ, USA";
							if (value.contains("New York") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Newport Beach - CA, USA";
							if (value.contains("Newport") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Parsippany - NJ, USA";
							if (value.contains("Parsippany") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Palm Springs - CA, USA";
							if (value.contains("Palm Spring") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Pasadena - CA, USA";
							if (value.contains("Pasadena") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "San Jose - CA, USA";
							if (value.contains("San Jose") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "San Pedro - CA, USA";
							if (value.contains("San Pedro") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Tusayan - AZ, USA";
							if (value.contains("Tusayan") || value.contains("Grand Canyon") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Kuala Terengganu - Terengganu,  Malaysia";
							if (value.contains("Terengganu") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Puerto Viejo - Limón,  Costa Rica";
							if (value.contains("Puerto Viejo") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Jacó - Puntarenas,  Costa Rica";
							if (value.contains("Jacó") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Matapalo - Puntarenas,  Costa Rica";
							if (value.contains("Matapalo") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							correct = "Bocas del Toro - Bocas del Toro,  Panama";
							if (value.contains("Bocas del Toro") && !value.equals(correct)) {
								location.setValue(correct);
								entry.update();
							}
							locations.add(value);
						}
					}
				}
			}
			System.out.println(locations.size());
			for (String location : locations) {
				System.out.println(location);
			}
			System.out.println("\nTotal Entries: " + entries.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
