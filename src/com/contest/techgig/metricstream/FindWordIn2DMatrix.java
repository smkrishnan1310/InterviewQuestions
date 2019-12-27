package com.contest.techgig.metricstream;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindWordIn2DMatrix {

	public int find(String ar[], String s) {
		ar = removeHash(ar);
		if (null == ar) {
			return -1;
		}
		Pattern p = Pattern.compile(s);
		int count = 0;
		count += findHorizontally(ar, p);
		count += findVerticallyDown(ar, p);
		count += findDiagonallyDown(ar, p);
		count += findDiagonallyUp(ar, p);
		return count;
	}

	public int findVerticallyDown(String ar[], Pattern p) {
		StringBuilder sb = null;
		int count = 0;
		for (int i = 0; i < ar.length; i++) {
			sb = new StringBuilder();
			for (int j = 0; j < ar.length; j++) {
				sb.append(ar[j].charAt(i));
			}
			count += getMatchCount(sb.toString(), p);
		}
		return count;
	}

	public int findDiagonallyDown(String ar[], Pattern p) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ar.length; i++) {
			sb.append(ar[i].charAt(i));
		}
		return getMatchCount(sb.toString(), p);
	}

	public int findDiagonallyUp(String ar[], Pattern p) {
		StringBuilder sb = new StringBuilder();
		int i = ar.length - 1;
		int j = 0;
		while (i >= 0 && j < ar.length) {
			sb.append(ar[i].charAt(j));
			i--;
			j++;
		}
		return getMatchCount(sb.toString(), p);
	}

	public int findHorizontally(String ar[], Pattern p) {
		int count = 0;
		for (int i = 0; i < ar.length; i++) {
			count += getMatchCount(ar[i], p);
		}
		return count;
	}

	public int getMatchCount(String s, Pattern p) {
		Matcher m = p.matcher(s);
		int c = 0;
		while (m.find()) {
			c++;
		}
		return c;
	}

	public String[] removeHash(String ar[]) {
		for (int i = 0; i < ar.length; i++) {
			String s = ar[i];
			s = removeHash(s);
			if (s == null) {
				return null;
			}
			ar[i] = s;
		}
		return ar;
	}

	public String removeHash(String s) {
		if (s != null) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if ('#' != c)
					sb.append(c);
			}
			return sb.toString();
		}
		return null;
	}

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s[] = new String[n];
		for (int i = 0; i < n; i++) {
			s[i] = sc.next();
		}
		String inp = sc.next();
		int count = new FindWordIn2DMatrix().find(s, inp);
		System.out.print(count);
	}
}