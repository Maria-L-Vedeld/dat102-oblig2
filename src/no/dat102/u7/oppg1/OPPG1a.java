package no.dat102.u7.oppg1;

public class OPPG1a {
	
	public static void optimalisering(Integer[] a) {
		
		int n = a.length;
		
		int minIndex = 0;
		
		for (int i = 1; i < n; i++) {
			if (a[i] < a[minIndex]) {
				minIndex = i;
			}
		}
		
		int temp = a[0];
		a[0] =a[minIndex];
		a[minIndex] = temp;
		
		for (int i = 2; i < n; i++) {
			int key = a[i];
			int j = i -1;
			while (key < a[j]) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = key;
		}
		
//		while (j >= 0 && temp.compareTo(a[j]) < 0);
	}

}
