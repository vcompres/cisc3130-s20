package Assignment1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class MainAssignment {
	static TopStreamingArtists artistList = new TopStreamingArtists();
	static HashMap<String, Integer> artistInfoList = new HashMap<String, Integer>();
	static ArrayList<String> keys = new ArrayList<String>();

	public static void main(String[] args) {
		String globalFileLocation = "assets/regional-global-weekly-2020-01-17--2020-01-24.csv";
		String usFileLocation = "assets/regional-us-weekly-2020-01-17--2020-01-24.csv";
		
		System.out.println("============================GLOBAL FILE==============================");
		scanDocument(globalFileLocation);
		Collections.sort(keys);
		alphabetizeList();
		artistList = new TopStreamingArtists();
		artistInfoList.clear();
		keys.clear();
		
		System.out.println("============================US FILE==============================");
		scanDocument(usFileLocation);
		Collections.sort(keys);
		alphabetizeList();
		artistList = new TopStreamingArtists();
		artistInfoList.clear();
		keys.clear();
		
		
	}
	
	static void scanDocument(String filePath) {
		try {
			FileInputStream inputFile = new FileInputStream(filePath);
			Scanner programScanner = new Scanner(inputFile);
			
			// Skip first two lines of the file
			programScanner.nextLine();
			programScanner.nextLine();

			while(programScanner.hasNextLine()) {
				
					String entry = programScanner.nextLine();
					String[] artistEntryData = entry.split(",");
					String artista = artistEntryData[2].replaceAll("\"", "").toLowerCase();
					
					if(artistEntryData.length > 5) {
						System.out.println("This data is not properly formatted. Comma Seperated Value does not follow format (Position, Name, Artist, Streams, URL)");
						System.out.println("Data -> \n" + entry);
						System.out.println("===============================================================");	
						continue;
					}
//					System.out.println("Artist Information ");
//					System.out.println("Track Position: " + artistEntryData[0]);
//					System.out.println("Track Name: " + artistEntryData[1]);
//					System.out.println("Track Artist: " + artista);
//					System.out.println("Track Streams: " + artistEntryData[3]);
//					System.out.println("Track URL: " + artistEntryData[4]);
//					System.out.println("==============================================");
					
					if(artistInfoList.containsKey(artista)) {
						int count = artistInfoList.get(artista)+ 1;
						artistInfoList.put(artista, count);
//						System.out.println("Artist " + artista + " has appeared " + count);
						
					} else {
						artistInfoList.put(artista, 1);
						keys.add(artista);
					}
			}
			//keys contains names of all artists
			//atristInfoList contains the artist as key and value as the number of times the artist appears in chart
			
			programScanner.close();
			printArtistList();
			
		
		} 
		
		
		
		
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
			
	}

	static void printArtistList() {

		System.out.println("Here are all the artists on the chart and the times they appeared.");
		for(String artist: keys) {
			System.out.println(artist + " appeared " + artistInfoList.get(artist));
		}
		
	}
	
	static void alphabetizeList() {
		System.out.println("===============================================================");	
		System.out.println("Here is the list of all the artists in alphabetical order");
		System.out.println("===============================================================");	
		for(String name: keys) {
			artistList.insert(name);
		}
		artistList.displayOrderedList();
		System.out.println("===============================================================");	
	}
}
