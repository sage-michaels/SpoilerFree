
import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SpoilerFreeSearch {

	//private ArrayList<Season> seasons;
	
	public static String searchWikia(String showname) throws IOException {
		showname = showname.replace(' ', '+').toLowerCase();
		String searchURL = "https://www.fandom.wikia.com/?s=" + showname;
		
		Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();

		Elements results = doc.select("div.top-community > a.top-community-content");

		String linkHref = results.attr("href");
		linkHref = linkHref + "/Episode_Guide";
		return linkHref;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(searchWikia("Bojack Horseman"));
	}
}
