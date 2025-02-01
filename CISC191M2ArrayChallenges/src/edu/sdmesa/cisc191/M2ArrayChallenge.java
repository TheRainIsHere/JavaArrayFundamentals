package edu.sdmesa.cisc191;

/**
 * Lead Author(s):
 * @author 
 * @author 
 * <<add additional lead authors here, with a full first and last name>>
 * 
 * Other contributors:
 * <<add additional contributors (mentors, tutors, friends) here, with contact information>>
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * <<add more references here>>
 *  
 * Version/date: 
 * 
 * Responsibilities of class:
 * 
 */
/**
 */
public class M2ArrayChallenge
{
	/**
	 * Purpose: Find a given value in the array given
	 * 
	 * @param array to search
	 * @return true if the value is in the array, otherwise false
	 */
	public static boolean contains(char[] array, char value)
	{
		boolean found = false;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				found = true;
			}
		}
		return found;
	}
	
	/**
	 * Purpose: Return the index of the char the user wants to search
	 * 
	 * @param array to search
	 * @return the int of the index where the char was found, else return -1
	 */
	public static int find(char[] array, char value)
	{
		// int to store index of located char
		int location = -1;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				location = i;
				break;
			}
		}
		
		return location;
	}
	
	/**
	 * Purpose: Count the number of times a given char appears in an array
	 * 
	 * @param array to count the chars from
	 * @return number of times the given char was found
	 */
	public static int countValues(char[] array, char value)
	{
		// int to store count of given char
		int count = 0;
				
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				count += 1;
			}
		}
	
		return count;
	}
	
	/**
	 * Purpose: To determine if the chars in the array are in order alphabetically
	 * 
	 * @param array to check if it's sorted
	 * @return false if not sorted, true if sorted
	 */
	public static boolean inOrder(char[] array)
	{
		// bool to store if in order
		boolean ordered = true;
		
		// escape if there's nothing to compare
		if(array.length <= 1) {
			return ordered;
		}
		
		// Check each char starting at array[0], stop after (length - 1) to avoid going outside of bounds
		for(int i = 0; i < (array.length - 1); i++) {
			if(array[i] > array[i+1]) {
				ordered = false;
				break;
			}
		}
		
		return ordered;
	}
	
	/**
	 * Purpose: To sort two chars in an array, the first index value and the index + 1
	 * 
	 * @param array with values to swap/start sorting
	 * @return void
	 */
	public static void swapElements(char[] array, int index)
	{
		// -2 on array.length to stay in array: 1 for starting at [0], 1 for moving up to swap
		if(index <= (array.length - 2)) {
			char val1 = array[index];
			char val2 = array[index + 1];
			array[index] = val2;
			array[index + 1] = val1;
		}
		
	}
	
	/**
	 * Purpose: Do one pass of an array in the bubbleSort algorithm
	 * 
	 * @param array to be sorted
	 * @return void
	 */
	public static void bubbleUp(char[] array)
	{
		for(int i = 0; i < (array.length - 1); i++) {
			if(array[i] > array[i + 1]) {
				swapElements(array, i);
			}
		}
	}
	
	/**
	 * Purpose: Sort a char array using a bubble sort algorithm
	 * 
	 * @param array to be sorted
	 * @return void
	 */
	public static void bubbleSort(char[] array)
	{
		while(!inOrder(array)) {
			bubbleUp(array);
		}
	}
	
	/**
	 * Purpose: To make a new array with the same chars
	 * 
	 * @param array to copy
	 * @return copied array
	 */
	public static char[] copy(char[] array)
	{
		int length = array.length;
		String rawChar = "";
		
		for(int i = 0; i < length; i++) {
			rawChar += array[i];
		}
		
		return rawChar.toCharArray();
	}
	
	/**
	 * Purpose: Compare two arrays
	 * 
	 * @param arrays to be compared
	 * @return true if equal
	 */
	public static boolean arrayElementsEqual(char[] array01, char[] array02)
	{
		
		if(array01.length != array02.length) {
			return false;
		}
		else {
			for(int i = 0; i < array01.length; i++) {
				if(array01[i] != array02[i]) {
					return false;
				}
			}
			return true;
		}
	}
	
	/**
	 * Purpose: Take the given array and return a backwards one.
	 * 
	 * @param array to reverse
	 * @return reversed array
	 */
	public static char[] backwards(char[] array)
	{
		char[] backArray = copy(array);
		int len = backArray.length;
		
		for(int i = 0; i < (len / 2); i++) {
			int opposite = len - (i + 1);
			char val1 = backArray[i];
			char val2 = backArray[opposite];
			
			backArray[i] = val2;
			backArray[opposite] = val1;
		}
		
		return backArray;
	}
	
	/**
	 * Purpose: To determine if a given array is a palindrome
	 * 
	 * @param array to be tested
	 * @return true if array is a palindrome
	 */
	public static boolean isPalindrome(char[] array)
	{
		char[] revArray = backwards(array);
		
		return arrayElementsEqual(array, revArray);
	}
	
	/**
	 * Purpose: Gets the specified value from a 2D array
	 * 
	 * @param 2D array to get the value from, and the coords of the value
	 * @return value from given coords
	 */
	public static int getElement(int[][] array2D, int x, int y)
	{
		return array2D[x][y];
	}
	
	/**
	 * Purpose: Add together the numbers in a row of a 2D array
	 * 
	 * @param array that needs numbers added together, row index
	 * @return int of row added together
	 */
	public static int addRow(int[][] array2D, int x)
	{
		int total = 0;
		
		for(int i = 0; i < array2D[x].length; i++) {
			total += array2D[x][i];
		}
		
		return total;
	}
	
	/**
	 * Purpose: Add the numbers of a column in a 2D array
	 * 
	 * @param array with columns to add together, column index
	 * @return int total of column added together
	 */
	public static int addColumn(int[][] array2D, int y)
	{
		int total = 0;
		
		for(int[] row : array2D) {
			total += row[y];
		}
		
		return total;
	}
	
	/**
	 * Purpose: Add the int values from left to right diagonal in a 2D array
	 * 
	 * @param square array to add values from
	 * @return int total of left to right diagonal
	 */
	public static int addLeftToRightDiagonal(int[][] array2D)
	{
		int total = 0;
		int loc = 0;
		
		for(int[] row : array2D) {
			total += row[loc];
			loc += 1;
		}
		
		return total;
	}
	
	/**
	 * Purpose: Add the int values from right to left diagonal in a 2D array
	 * 
	 * @param square array to add values from
	 * @return int total of right to left diagonal
	 */
	public static int addRightToLeftDiagonal(int[][] array2D)
	{
		int total = 0;
		
		if(array2D.length > 0) {
			int loc = array2D[0].length - 1;
			
			for(int[] row : array2D) {
				total += row[loc];
				loc -= 1;
			}
		}
		
		return total;
	}
	
	/**
	 * Purpose: Add the int values from last column in every row
	 * 
	 * @param 2D array of int
	 * @return int total of last column values
	 */
	public static int addLastRowElement(int[][] array2D)
	{
		int total = 0;
		
		for(int[] row : array2D) {
			total += row[row.length - 1];
		}
		
		return total;
	}
	
	// Use this template for the methods
	/**
	 * Purpose:
	 * 
	 * @param array
	 * @return
	 */
//	public static ??? ???(???[] array)
//	{
//		return ???;
//	}

}
