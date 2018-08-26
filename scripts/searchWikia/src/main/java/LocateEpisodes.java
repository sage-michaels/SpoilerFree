
import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LocateEpisodes {

	public static final String WIKIA_SEARCH_URL = "https://www.fandom.wikia.com/?s=";
	public static void main(String[] args) throws IOException {
		//Taking search term input from console
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the search term.");
		String searchTerm = scanner.nextLine();
		/*System.out.println("Please enter the number of results. Example: 5 10 20");
		int num = scanner.nextInt();*/

		//TODO: Handle multiple 'correct' results (i.e. searched 'Rugrats' got 'Rugrats' and 'Rugrats: All Grown Up')
		scanner.close();

		//Format string to match search style for wikia
		searchTerm = searchTerm.replace(' ', '+').toLowerCase();
		//System.out.println(searchTerm);
		
		String searchURL = WIKIA_SEARCH_URL + searchTerm;
		//System.out.println(searchURL);

		//without proper User-Agent, we will get 403 error
		Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();
		
		//below will print HTML data, save it to a file and open in browser to compare
		//System.out.println(doc.html());
		
		//If google search results HTML change the <h3 class="r" to <h3 class="r1"
		//we need to change below accordingly
		//Elements results = doc.select("h3.r > a");
		Elements results = doc.select("div.top-community > a.top-community-content");

		for (Element result : results) {
			String showURL = result.attr("href");
		}


		//Go to episode guide
		String episodesURL = showURL + "/Episode_Guide";
		doc = Jsoup.connect(episodesURL).userAgent("Mozilla/5.0").get();

		Elements season


	}

}
