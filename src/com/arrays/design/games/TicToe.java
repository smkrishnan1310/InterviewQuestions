package com.arrays.design.games;

import java.util.Scanner;

class Player {

	String playerName;
	char symbol;

	public Player(String playerName, char symbol) {
		this.playerName = playerName;
		this.symbol = symbol;
	}
}

public class TicToe {

	Scanner sc = new Scanner(System.in);

	Player X = null;
	Player O = null;
	char xx = 'X';
	char oo = 'O';

	int strikeCount = 0;
	int difficulty = 0;
	char board[][];

	Player getPlayerDetails(char c) {
		System.out.println("Enter player " + c + " Name : ");
		return new Player(sc.next(), c);
	}

	boolean isBoardFull() {
		return strikeCount >= (difficulty * difficulty);
	}

	void intializeBoard(int n) {
		board = new char[n][n];
		int c = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = (char) ('.');
				c++;
			}
		}
		printBoard(n);
	}

	void printBoard(int n) {
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				System.out.print("| " + board[i][j] + " |");
				sb.append("-----");
			}
			System.out.println("\n" + sb);
		}
		System.out.println();
	}

	void startGame() {
		//Just to choose player randomly
		int r = (int) (Math.random()*10 % 2);
		Player player = (r == 1) ? X : O;
		boolean gameOver = true;
		while (!isBoardFull()) {
			System.out.println(player.playerName + "( " + player.symbol + " ) - your turn ");
			int pos = sc.nextInt() - 1;
			if (pos == -1 || pos >= (difficulty * difficulty)) {
				System.out.println("Invalid location! type : 1 -" + ((difficulty * difficulty)));
				continue;
			}
			int x = pos / difficulty;
			int y = pos % difficulty;
			if (board[x][y] == xx || board[x][y] == oo) {
				System.out.println("Invalid move! Already occupied!!\n");
				continue;
			}
			board[x][y] = player.symbol;
			strikeCount++;
			printBoard(difficulty);
			if (checkAnyOneWins(player.symbol, x, y)) {
				announceMatchResult(player.symbol);
				gameOver = false;
				break;
			}
			if (player.symbol == xx) {
				player = O;
			} else
				player = X;
		}
		if (gameOver)
			announceMatchResult(getWinner());
	}

	private void announceMatchResult(char winner) {
		if (winner == 'N')
			System.out.println("Game over !... \nMatch draw !! ");
		else if (winner == X.symbol)
			System.out.println("Game over !... \nCongratzz! Player " + X.playerName + " wins!");
		else
			System.out.println("Game over !... \nCongratzz! Player " + O.playerName + " wins!");
	}

	boolean checkRow(int r, char c) {
		for (int i = 0; i < difficulty; i++) {
			if (board[r][i] != c)
				return false;
		}
		return true;
	}

	boolean checkCol(int cl, char c) {
		for (int i = 0; i < difficulty; i++) {
			if (board[i][cl] != c)
				return false;
		}
		return true;
	}

	boolean checkRDiagonal(char c) {
		for (int i = 0; i < difficulty; i++) {
			if (board[i][i] != c)
				return false;
		}
		return true;
	}

	boolean checkLDiagonal(char c) {
		for (int i = 0; i < difficulty; i++) {
			if (board[i][(difficulty - 1) - i] != c)
				return false;
		}
		return true;
	}

	boolean checkAnyOneWins(char c, int x, int y) {
		if (checkRow(x, c))
			return true;
		if (checkCol(y, c))
			return true;
		if (checkRDiagonal(c))
			return true;
		if (checkLDiagonal(c))
			return true;
		return false;
	}

	char getWinner() {
		for (int i = 0; i < difficulty; i++) {
			if (checkRow(i, xx))
				return xx;
			if (checkRow(i, oo))
				return oo;
			if (checkCol(i, xx))
				return xx;
			if (checkCol(i, oo))
				return oo;
		}
		if (checkRDiagonal(xx))
			return xx;
		if (checkLDiagonal(oo))
			return oo;
		return 'N';
	}

	void printInstructions() {
		StringBuilder sb = new StringBuilder();
		sb.append("Player 1 : " + X.playerName + ":" + X.symbol);
		sb.append("\nPlayer 2 : " + O.playerName + ":" + O.symbol);
		sb.append("\nNote: \n-Enter difficulty in numbers." + "\n-Press number to place your mark."
				+ "\n-Choose difficulty in Number : Easy - 3, Medium - 4, Hard - 5");
		System.out.println(sb);
		difficulty = sc.nextInt();
		System.out.println("Refer for position of Numbers in board");
		printModelBoard();
	}

	private void printModelBoard() {
		int c = 1;
		for (int i = 0; i < difficulty; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < difficulty; j++) {
				System.out.print("| " + c++ + " |");
				sb.append("-----");
			}
			System.out.println("\n" + sb);
		}
		System.out.println("\n");
	}

	void gameBegin() {
		System.out.println("Welcome!");
		X = getPlayerDetails(xx);
		O = getPlayerDetails(oo);
		printInstructions();
		while (!(difficulty <= 5 && difficulty >= 3)) {
			System.out.println("Invalid !!");
			difficulty = sc.nextInt();
		}
		System.out.println("------ Game Starts -------\n");
		intializeBoard(difficulty);
		startGame();
		System.out.println("Game over !");
	}

	public static void main(String args[]) {
		new TicToe().gameBegin();
	}
}
