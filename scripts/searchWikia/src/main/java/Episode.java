
import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Episode {
	private String name;
	private int number;
	private String episodeURL;

	public Episode(String name, int number, String episodeURL) {
		this.name = name;
		this.number = number;
		this.episodeURL = episodeURL;
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		return "[" + this.number + ", " + this.name + ", " + this.episodeURL + "]";
	}

	/*class method that uses the episodeURL to return the text of
	the episode's plot, currently as a string although we will probably
	want to feed it into a txt file or something and then do standard IO
	for the search*/
	public String getPlotText(){
		String episodeURL = this.episodeURL;
		Document doc = null;
		System.out.println("entered getPlotText \n");
		try {
			doc = Jsoup.connect(episodeURL).userAgent("Mozilla/5.0").get();
		}
		catch (Exception e){ //the code inside the above try wouldn't compile without this catch
			System.out.println("\n \n \n ERROR ERROR ERROR \n \n \n");
     		doc = null;
    	}
		Elements plotMarker = doc.select("h2> span#Plot"); //find the plot header
		plotMarker = plotMarker.parents(); 
		Element plotElement = plotMarker.first().nextElementSibling(); //navigate to plot text
		String plot = "";
		while(plotElement.tag().getName().equals("p")){ //iterate through <p> elements until we hit the end of the plot summary
			plot = plot + plotElement.text();
			plotElement = plotElement.nextElementSibling();
		}
		return plot;
	}
//TODO: Generalize this so that it works on wikia other than bojack horseman... probably with the API

	public static void main(String[] args) {

		/*System.out.println("Begining... \n");
		String episodeURL = "http://bojackhorseman.wikia.com/wiki/BoJack_Horseman:_The_BoJack_Horseman_Story,_Chapter_One";
		Episode first = new Episode("The Bojack Horseman Story",1, episodeURL);
		System.out.println("Plot is: " + first.getPlotText());*/
	}
}
