import java.util.Scanner;
import java.util.stream.Stream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class assignment4_file_reading {

	/**
	 *
	 * @param filename
	 * @return number of lines in a text file
	 * @throws Exception
	 */
	public static int getNoLines(String filename) throws Exception{
		try (Stream<String> fileStream = Files.lines(Paths.get(filename))) {
			return (int) fileStream.count();
		} 
	}

	
	/**
	 * 
	 * @param filename source file
	 * @return two dim array (jagged array), where each row in the array contains the values in one line of the file,
	 * the length of each row depends on the number of values in each line of the file.
	 * @throws Exception
	 */	
	public static int[][] create2DArray(String filename) throws Exception {
		int lines = getNoLines(filename); // count number of lines
		int[][] result = new int[lines][]; // initialize 2d array
		try(Scanner fsc = new Scanner(new File(filename))) { // read the file line by line
			int n = 0; 
			while (fsc.hasNextLine()) {
				String line = fsc.nextLine(); // read line
				String[] parts = line.split("\\s+"); // split lines by whitespace
				int[] numbers = new int[parts.length]; // initialize array to store numbers
				for (int j=0; j < parts.length; j++) {
					numbers[j] = Integer.parseInt(parts[j]); // convert to integers
				}
				result[n] = numbers;
				n++;
			}
		}
		return result;
	}
	
	
	/**
	 * 
	 * @param 2d array
	 * @return index of the longest row
	 * @throws illegal argument exception
	 */	
	public static int findLongestRow(int[][] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Array is null or empty");
		}
			int maxLength = 0;
			int longestRow = -1;
			for(int i=0; i<arr.length; i++) {
				if (arr[i].length > maxLength) {
					maxLength = arr[i].length;
					longestRow = i;
				}
			}
			return longestRow;
		}
	
	
	/**
	 * 
	 * @param 2d array and row index
	 * @return max value of the row
	 * @throws illegal argument exception
	 */	
	public static int findMaxInRow(int[][] arr, int rowIndex) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Array is null or empty");
		}
		if (rowIndex < 0 || rowIndex >= arr.length) {
			throw new IllegalArgumentException("Index is out of bounds");
		}
		int max = Integer.MIN_VALUE;
		for (int n=0; n<arr[rowIndex].length; n++) {
			if (arr[rowIndex][n]>max) {
				max = arr[rowIndex][n];
			}
		}
		return max;
	}
	
	
	/**
	 * 
	 * @param 2d array 
	 * @return max value of the file
	 * @throws illegal argument exception
	 */	
	public static int findMax(int[][] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Array is null or empty");
		}
		int max = Integer.MIN_VALUE;
		for (int i=0; i<arr.length; i++) {
			for(int j=0; j < arr[i].length; j++) {
				if (arr[i][j] > max) {
					max = arr[i][j];
				}
			}
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		String filename = "C:\\Users\\benja\\Desktop\\Johnson_CPSC24500\\assignment4Data.txt";
		if (args.length <1) {
			System.out.println("usage: Assignment4 inputFilename ");
			System.exit(0);		
		}
		filename = args[0];
		int arr[][] = null;
		try {
			System.out.println("Number of lines in the file ="+ getNoLines(filename));
			arr = create2DArray(filename);
			int longestRow = findLongestRow(arr);
			System.out.println("Longest row in the file is: "+ (longestRow+1 )+" ,with length of: "
			                      +arr[longestRow].length);
			System.out.println("Max value in first row = "+ findMaxInRow(arr, 0));
			System.out.println("Max value in file = "+ findMax(arr));
		} catch (Exception e) {
			System.out.print(e);
		}
	}
}
