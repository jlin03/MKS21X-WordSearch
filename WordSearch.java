import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception

public class WordSearch {
	private char[][]data;
	private int seed;
	private Random randgen;
	private ArrayList<String>wordsToAdd = new ArrayList<String>();
	private ArrayList<String>wordsAdded = new ArrayList<String>();;

	public WordSearch(int rows, int cols, String fileName) {
		data = new char[rows][cols];
		clear();
		try {
			File words = new File(fileName);
			Scanner in = new Scanner(words);
			while(in.hasNext()) {
				wordsToAdd.add(in.nextLine());
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found: " + fileName);
		}
	
		seed = (int)System.currentTimeMillis();
		randgen = new Random(seed);
	}
	
	public WordSearch(int rows, int cols, String fileName, int randSeed) {
		data = new char[rows][cols];
		clear();
		try {
			File words = new File(fileName);
			Scanner in = new Scanner(words);
			while(in.hasNext()) {
				wordsToAdd.add(in.nextLine());
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
	
	
	
	
	
	public String toString() {
		String out = "";
		for(int r = 0;r < data.length;r++) {
			out += "|";
			for(int c = 0;c < data[0].length - 1;c++) {
				out += data[r][c] + " ";
			}
			out += data[r][data[0].length - 1];
			out += "|\n";
		}
		out += "Words: ";
		if(wordsAdded.size() > 0) {
			for(int i = 0; i < wordsAdded.size() - 1;i++) {
				out += wordsAdded.get(i) + ", ";
			}
			out += wordsAdded.get(wordsAdded.size() - 1);
		}
		out += "(seed: " + seed + ")";
		
		return out;
	}
	

}

