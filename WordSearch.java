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
	
/**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added in the direction rowIncrement,colIncrement 

     *Words must have a corresponding letter to match any letters that it overlaps.

     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.

     *@param rowIncrement is -1,0, or 1 and represents the displacement of each letter in the row direction
     *@param colIncrement is -1,0, or 1 and represents the displacement of each letter in the col direction

     *@return true when: the word is added successfully. 
     *        false when: the word doesn't fit, OR  rowchange and colchange are both 0,
     *        OR there are overlapping letters that do not match
     */
	
	private boolean addWord(String word,int row, int col, int rowIncrement, int colIncrement){
		if(rowIncrement == 0 && colIncrement == 0) {
			return false;
		}
	
		//if the word breaks past the boundaries of the array index limits
		if((row + (rowIncrement * word.length()) - 1) >= data[0].length || (row + (rowIncrement * word.length()) - 1) < 0) {
			return false;
		}
		if((col + (colIncrement * word.length()) - 1) >= data.length || (col + (colIncrement * word.length()) - 1) < 0) {
			return false;
		}
		
		//check if all characters match
		for(int i = 0;i < word.length();i++) {
			if(data[row+(i * rowIncrement)][col+(i * colIncrement)] != word.charAt(i) && data[row+(i * rowIncrement)][col+(i * colIncrement)] != '_') {
				return false;
			}
		}
		
		//add the word in
		for(int i = 0;i < word.length();i++) {
			data[row+(i * rowIncrement)][col+(i * colIncrement)] = word.charAt(i);
		}
		return true;
		
		
		
    }
	
	
	
	
	
	
	public String toString() {
		String out = "";
		//puzzle
		for(int r = 0;r < data.length;r++) {
			out += "|";
			for(int c = 0;c < data[0].length - 1;c++) {
				out += data[r][c] + " ";
			}
			out += data[r][data[0].length - 1];
			out += "|\n";
		}
		
		//words
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

