package com.stringManipulations;

/**
 * Little Jhool is still out of his mind - exploring all his happy childhood
 * memories. And one of his favorite memory is when he found a magical ghost,
 * who promised to fulfill one of Little Jhool's wish. Now, Little Jhool was a
 * kid back then, and so he failed to understand what all could he have asked
 * for from the ghost. So, he ends up asking him something very simple. (He had
 * the intuition that he'd grow up to be a great Mathematician, and a Ruby
 * programmer, alas!) He asked the ghost the power to join a set of *the letters
 * r, u, b and y * into a real ruby. And the ghost, though surprised, granted
 * Little Jhool his wish... Though he regrets asking for such a lame wish now,
 * but he can still generate a lot of real jewels when he's given a string. You
 * just need to tell him, given a string, how many rubies can he generate from
 * it? Input Format: The first line contains a number t - denoting the number of
 * test cases. The next line contains a string. Output Format: Print the maximum
 * number of ruby(ies) he can generate from the given string. Constraints: 1 ≤ t
 * ≤ 100 1 ≤ Length of the string ≤ 100 SAMPLE INPUT
 * 
 * 2 rrrruubbbyy rubrubrubrubrubrubrubrubrubrubrubrubrubrb
 */
public class WordFormation {

	public int findOccurences(String str, String inp) {
		int[] arr = new int[26];
		int[] arr2 = new int[26];
		getCharOccurences(str, arr);
		getCharOccurences(inp, arr2);
		int min = 9999;
		min = getNumberOfWords(arr, arr2, min);
		return min;
	}

	private int getNumberOfWords(int[] arr, int[] arr2, int min) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				int tmp = arr2[i] / arr[i];
				min = min > tmp ? tmp : min;
			}
		}
		return min;
	}

	private void getCharOccurences(String inp, int[] arr) {
		for (int i = 0; i < inp.length(); i++) {
			int v = (int) inp.charAt(i);
			v %= 26;
			arr[v]++;
		}
	}

	public static void main(String[] args) {
		System.out.println("Hi");
		WordFormation wf = new WordFormation();
		System.out.println("Ans : " + wf.findOccurences("color", "ccoollrr"));
		System.out.println("Ans : " + wf.findOccurences("ruby", "rrrruubbbyy"));
		System.out.println("Ans : " + wf.findOccurences("ruby", "rubrubrubrubrubrubrubrubrubrubrubrubrubrb"));
	}

}
