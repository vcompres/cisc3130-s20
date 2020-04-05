package movieTitles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MovieMain {
	static ArrayList<String> movies = new ArrayList<String>();
	static MovieBST movieTree = new MovieBST();


	public static void main(String[] args) {
		String basePath = new File("").getAbsolutePath();

		scanDocument(basePath + "/src/movieTitles/movies.csv");
//		movieTree.traverseInOrder(movieTree.first);
		movieTree.subSet(movieTree.first,"Bug's Life", "Harry Potter");
	}
	
	static void scanDocument(String filePath) {
		try {
			FileInputStream inputFile = new FileInputStream(filePath);
			Scanner programScanner = new Scanner(inputFile);
			
			// Skip first line of the file
			programScanner.nextLine();

			while(programScanner.hasNextLine()) {
				
					String entry = programScanner.nextLine();
					String[] movieEntryData = entry.split(",");

					
					if(movieEntryData.length > 3) {
//						System.out.println("This data is not properly formatted. Comma Seperated Value does not follow format (ID, Title, Genres)");
//						System.out.println("Data -> \n" + entry);
//						System.out.println("===============================================================");	
						continue;
					}

					
					String titleData = movieEntryData[1];
					int titleDataLength = titleData.length();
					String year = titleData.substring(titleDataLength-5, titleDataLength-1);
//					
//					System.out.println("Movie Information ");
//					System.out.println("Movie ID: " + movieEntryData[0]);
//					System.out.println("Movie Title: " + movieEntryData[1]);
//					System.out.println("Movie Year: " + year);
//					System.out.println("Movie Genres: " + movieEntryData[2]);
//					System.out.println("==============================================");
					movieTree.add(titleData, year);
		}
			programScanner.close();	
		}
		
		
		
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
			
	}
	

}
