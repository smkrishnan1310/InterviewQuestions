package com.general.basics;

public class PrintPyramid {

	/*
	   *
	  ***
	 *****
	*******
	
	*/

	// n-no of floors in pyramid
	public static void printit(int n) {
		int last = (2 * n) - 1;
		int mid = last / 2;
		int j = 0;
		int k = 0;
		int st, end;
		while (j < last) {
			j = 0;
			st = mid - k;
			end = mid + k;
			j = printRow(last, st, j, end);
			k++;
			System.out.println();
		}

	}

	private static int printRow(int last, int st, int j, int end) {
		for (int i = 0; i < last; i++) {
			if (i <= end && i >= st) {
				j++;
				System.out.print("*");
			} else 
				System.out.print(" ");
		}
		return j;
	}

	public static void main(String[] args) {
		printit(20);
	}

}
