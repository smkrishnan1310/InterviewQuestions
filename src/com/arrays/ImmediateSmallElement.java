package com.arrays;

public class ImmediateSmallElement {

	public void findNextMin(int a[]) {

		int lastMin = -1;
		int t = a.length;
		for (int i = a.length - 1; i >= 0; i--) {
			if (t < a.length) {
				//lastMin = a[t] < a[i] ? a[t] : (lastMin < a[i] ? lastMin : -1);
				if(a[t] < a[i]) {
					lastMin=a[t];
				}
				else if(lastMin > a[i]) {
					System.out.println(a[i] + " --> -1");
					continue;
				}
				System.out.println(a[i] + " --> " + lastMin);
			} else {
				System.out.println(a[i] + " --> -1");
			}
			t--;
		}
	}

	public static void main(String args[]) {
		int a[] = { 4,8,5,2,25 };
		ImmediateSmallElement ise = new ImmediateSmallElement();
		ise.findNextMin(a);
	}
}
