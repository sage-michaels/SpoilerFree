
import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Season {
	private ArrayList<Episode> episodes;
	private int number;

	public Season(int number) {
		this.episodes = new ArrayList<Episode>();
		this.number = number;
	}

	public String toString() {
		String str = Arrays.toString(this.episodes.toArray());
		return str;
	}

	public void addEpisode(Episode episode) {
		this.episodes.add(episode);
	}

	public static void main(String[] args) {
		Season five = new Season(5);
		System.out.println(five);
		Episode joe = new Episode("Joe", 4, "blah");
		five.addEpisode(joe);
		System.out.println(five);
		Episode bob = new Episode("Bob", 5, "blachfjdksahf");
		five.addEpisode(bob);
		System.out.println(five);
		System.out.println(five.episodes.get(1).getName());
	}
}
	
