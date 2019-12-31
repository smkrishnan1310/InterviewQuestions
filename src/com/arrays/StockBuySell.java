package com.arrays;

/** Program to find maximize the profit in single buy sell in O(n) time */
public class StockBuySell {

	/** Will find max profit on Single buy sell on given period of trades */
	public static int findMaxBySingleBuySell(int arr[]) {
		if (null == arr)
			return 0;
		if (arr.length < 2)
			return 0;
		
		int n = arr.length - 1;
		int tmax = n, tmin = n, tpro = 0;
		int max = n, min = n, pro = 0;

		while (tmin >= 0) {
			tpro = arr[tmax] - arr[tmin];
			if (tpro > pro) {
				pro = tpro;
				max = tmax;
				min = tmin;
			} else if (tpro < 0) {
				tmax = tmin;
			}
			tmin--;
		}
		System.out.println("max = " + arr[max] + " min = " + arr[min] + " pro = " + pro);// Just to print all status.
																							// Can modify based on need
		return pro;
	}

	public static void main(String[] args) {
		// int tradedValues[] = { 1, 13, 5, 9, 12, 98, 20, 29 };
		int tradedValues[] = { 90, 99, 98, 96, 20, 26, 25, 75, 77, 78, 76, 79, 6 };
		findMaxBySingleBuySell(tradedValues);
	}

}
