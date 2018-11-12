import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception

public class WordSearch {
	private char[][]data;
	private int seed;
	private Random randgen;
	private ArrayList<String>wordsToAdd;
	private ArrayList<String>wordsAdded;

	public WordSearch(int rows, int cols, String fileName) {
		data = new char[rows][cols];
		clear();
		try {
			File words = new File(fileName);
			Scanner scan = new Scanner(words);
			while(scan.hasNext()) {
				wordsToAdd.add(scan.nextLine());
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found: " + fileName);
		}
	
		randgen = new Random();
	}
	
	public WordSearch(int rows, int cols, String fileName, int randSeed) {
		data = new char[rows][cols];
		clear();
		try {
			File words = new File(fileName);
			Scanner scan = new Scanner(words);
			while(scan.hasNext()) {
				wordsToAdd.add(scan.nextLine());
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found: " + fileName);
		}
		
		seed = randSeed;
		randgen = new Random(seed);	
	}
	
	private void clear() {
		for(int r = 0;r < data.length;r++) {
			for(int c = 0;c < data[0].length;c++) {
				data[r][c] = '_';
			}
		}
	}	

}









}
