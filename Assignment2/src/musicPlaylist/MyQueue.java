package musicPlaylist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import musicPlaylist.Song;

public class MyQueue extends LinkedList {

	private Scanner programScanner;
	ArrayList<Song> queue = new ArrayList<Song>();
	String[] orderedList;
	
	public MyQueue(String fileName) throws IOException {
		try {
			
			FileInputStream inputFile = new FileInputStream(fileName);
			programScanner = new Scanner(inputFile);
			
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
				String trackName = artistEntryData[1];
//				System.out.println("Artist Information ");
//				System.out.println("Track Position: " + artistEntryData[0]);
//				System.out.println("Track Name: " + artistEntryData[1]);
//				System.out.println("Track Artist: " + artista);
//				System.out.println("Track Streams: " + artistEntryData[3]);
//				System.out.println("Track URL: " + artistEntryData[4]);
//				System.out.println("==============================================");
				Song curr = new Song(trackName);
				this.queue.add(curr);	
			}
			
			
			
			printQueue();
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	
	}
	public MyQueue() {
		super();
	}
	
	public ArrayList<Song> getQueue() {
		return this.queue;
	}
	
	public void printQueue() {
		String[] testList = new String[this.queue.size()];
		for(int i=0; i<this.queue.size(); i++) {
			testList[i] = this.queue.get(i).getTrack().toLowerCase();
		}
		Arrays.sort(testList);
		orderedList = testList;
		
//		System.out.println("====================SORTED LIST======================");
		for(int i=0; i<this.queue.size(); i++) {
			System.out.println(testList[i]);
		}
		
	}
	
	public String[] getOrderedList() {
		return orderedList;
	}
	public void setOrderedList(String[] orderedList) {
		this.orderedList = orderedList;
		setQueueFromList();
	}
	public void setQueue(ArrayList<Song> queue) {
		this.queue = queue;
	}
	public void setQueueFromList() {
		for(String s: this.orderedList) {
			this.queue.add(new Song(s));
		}
	}

	
}
