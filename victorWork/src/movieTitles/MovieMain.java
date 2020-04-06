package movieTitles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class MovieMain {
	static ArrayList<String> movies = new ArrayList<String>();
	static ArrayList<Integer> movieYears = new ArrayList<Integer>();
	static MovieBST movieTree = new MovieBST();
	static HashMap<String, Integer> movieGenresAmount = new HashMap<String, Integer>();
	static ArrayList<String> genres = new ArrayList<String>();
	static HashMap<String, Integer> lastFiveYears = new HashMap<String, Integer>();
	// Integer is the year, and the Hashmap contains the String which is genre, and Integer as the amount of times it came out the given year
	static HashMap<Integer, HashMap<String, Integer>> moviesPerYear = new HashMap<Integer, HashMap<String, Integer>>();


	public static void main(String[] args) {
		String basePath = new File("").getAbsolutePath();

		scanDocument(basePath + "/src/movieTitles/movies.csv");
		printGenreAmounts();
		printLastFive();
		printMoviesPerYear();
//		movieTree.traverseInOrder(movieTree.first);
//		movieTree.subSet(movieTree.first,"Bug's Life", "Harry Potter");
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
					String[] movieGenres;					

					
					if(movieEntryData.length > 3) {
//						System.out.println("This data is not properly formatted. Comma Seperated Value does not follow format (ID, Title, Genres)");
//						System.out.println("Data -> \n" + entry);
//						System.out.println("===============================================================");	
						continue;
					} else if(!movieEntryData[1].contains("(")) {
						continue;
					}

					// Title Data
					String titleData = movieEntryData[1].replaceAll("\"", "");
					int titleDataLength = titleData.length();
					String year = titleData.substring(titleDataLength-5, titleDataLength-1);
					
//					System.out.println(titleData);
					// Year Data
					if(titleData.charAt(titleDataLength-1) == ' ') {
						year = titleData.substring(titleDataLength-6, titleDataLength-2);
					} 
					
					//Raw Genre
					String[] genreList = movieEntryData[2].split("\\|");
					
//					 
//					System.out.println("Movie Genres length for movie: " + movieGenres.length);
					
//					
//					System.out.println("Movie Information ");
//					System.out.println("Movie ID: " + movieEntryData[0]);
//					System.out.println("Movie Title: " + movieEntryData[1]);
					
					for(String gen: genreList) {
//						System.out.println(gen);
						
//static HashMap<Integer, HashMap<String, Integer>> moviesPerYear = new HashMap<Integer, HashMap<String, Integer>>();


						if(moviesPerYear.containsKey(Integer.parseInt(year))) {
							if(moviesPerYear.get(Integer.parseInt(year)).containsKey(gen)) {
								moviesPerYear.get(Integer.parseInt(year)).put(gen, moviesPerYear.get(Integer.parseInt(year)).get(gen) + 1);
							} else {
								moviesPerYear.get(Integer.parseInt(year)).put(gen, 1);
								
							}
						} else {
							moviesPerYear.put(Integer.parseInt(year), new HashMap<String, Integer>());
							movieYears.add(Integer.parseInt(year));
							moviesPerYear.get(Integer.parseInt(year)).put(gen, 1);
						}
						
						
						
						if(!movieGenresAmount.containsKey(gen)) {
							movieGenresAmount.put(gen, 1);
							genres.add(gen);
						} else {
							movieGenresAmount.put(gen, movieGenresAmount.get(gen) + 1);
							
						}
						
						if(Integer.parseInt(year) > 2015) {
//							System.out.println("Adding " + titleData + " to genre count " + gen + Integer.parseInt(year));
//							
							for(String gen1: genreList) {
								if(lastFiveYears.containsKey(gen1)) {
									lastFiveYears.put(gen1,lastFiveYears.get(gen1) + 1);
								} else {
									lastFiveYears.put(gen1, 1);
								}
							}
						}
						
						
					}
					
					
					
//					if(movieEntryData[2].contains("|")) {
//						System.out.println("Has more than one 1 genre");
//						System.out.println(movieEntryData[2].length());
//						System.out.println("Genres are: " + genreList.length);
//
//					} else {
//						System.out.println("Has 1 genre");
//						System.out.println(movieEntryData[2].split("\\|")[0]);
//						
//						if(movieGenresAmount.containsKey(movieEntryData[2])) {
//							int num = movieGenresAmount.get(movieEntryData[2]);
//							movieGenresAmount.put(movieEntryData[2], num++);
//						} else {
//							movieGenresAmount.put(movieEntryData[2], 1);
//							genres.add(movieEntryData[2]);
//						}
//					}
//					System.out.println("Movie Year: " + year);
//					System.out.println("Movie Genres: ");
//					for(String genre: movieGenres) {
//						System.out.print(genre);
//					}
//					System.out.println("\n");
//					System.out.println("==============================================");
					movieTree.add(titleData, year);
		}
			
			programScanner.close();	
		}
		catch (FileNotFoundException e) {	
			e.printStackTrace();
		}
			
	}
	static void printGenreAmounts() {
		System.out.println("==============================================");
		System.out.println("All the movie genres are listed below. There are " + genres.size());
		for(String gen: genres) {
			System.out.println(gen + " " + movieGenresAmount.get(gen));
		}
		
	}
	
	static void printLastFive() {
		System.out.println("==============================================");
		System.out.println("All the movies per genre released in the last 5 years.");
		for(String gen: genres) {
			System.out.println(gen + " " + lastFiveYears.get(gen));
		}
		
	}
	
	static void printMoviesPerYear() {
//static HashMap<Integer, HashMap<String, Integer>> moviesPerYear = new HashMap<Integer, HashMap<String, Integer>>();

		System.out.println("==============================================");
		System.out.println("All the movies per genre per year.");
		for(int year: movieYears) {
			System.out.println("===============Movies per Genre - " + year + "======================");
			for(String gen: genres) {
				System.out.println(gen + " " + moviesPerYear.get(year).get(gen));
			}
		}
	}

}
