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
		while (j < last) {
			j = 0;
			j = printRow(last, mid, j, k);
			k++;
			System.out.println();
		}

	}

	private static int printRow(int last, int mid, int j, int k) {
		for (int i = 0; i < last; i++) {
			if (i <= (mid + k) && i >= (mid - k)) {
				j++;
				System.out.print("*");
			}else {
				System.out.print(" ");
			}
		}
		return j;
	}

	public static void main(String[] args) {
		printit(10);
	}

}
