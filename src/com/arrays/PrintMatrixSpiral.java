package com.arrays;

//Program to print NxN matrix in spiral form

public class PrintMatrixSpiral {

	//Driver Method
	public static void main(String[] args) {
		int n=4;
		int a[][] = new int[n][n];
		int c = 10;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(c + ", ");
				a[i][j] = c++;
			}
			System.out.println();
		}
		new PrintMatrixSpiral().printMatrix(a);
	}

	public void printMatrix(int a[][]) {
		int start = 0;
		int end = a.length - 1;
		int row = 0;
		int col = 0;
		int rl = a.length-1;
		int cl = a.length-1;
		System.out.println("-----------");
		printSpiral(a, start, end, row, col, rl, cl);
	}
	
	void printSpiral(int[][] a, int start, int end, int row, int col, int rl, int cl) {
		while (start <= end && row <= rl && col <= cl) {
			printOuterMatrix(a, start, end, row, col, rl, cl);
			start++;
			end--;
			row++;
			col++;
			rl--;
			cl--;
		}
		printCenter(a);
	}

	private void printCenter(int[][] a) {
		if(a.length%2!=0) {
			int k=a.length/2;
			System.out.println(a[k][k]);
		}
	}

	
	private void printOuterMatrix(int[][] a, int start, int end, int row, int col, int rl, int cl) {
		left2Right(a, start, end, row);
		down(a, start, end, cl);
		Right2left(a, start, end, rl);
		up(a, start, end, col);
	}

	void left2Right(int a[][], int start, int end, int row) {
		for (int i = start; i < end; i++) {
			System.out.println(a[row][i]);
		}
	}

	void Right2left(int a[][], int start, int end, int row) {
		for (int i = end; i > start; i--) {
			System.out.println(a[row][i]);
		}
	}

	void up(int a[][], int start, int end, int col) {
		for (int i = end; i > start; i--) {
			System.out.println(a[i][col]);
		}
	}

	void down(int a[][], int start, int end, int col) {
		for (int i = start; i < end; i++) {
			System.out.println(a[i][col]);
		}
	}
}
