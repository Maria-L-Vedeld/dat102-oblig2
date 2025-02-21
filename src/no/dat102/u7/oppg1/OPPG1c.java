package no.dat102.u7.oppg1;

public class OPPG1c {
	
	public static void optimeringab(Integer[] a) {
		
		int n = a.length;
		
		int minIndex = 0;
		
		for (int i = 1; i < n; i++) {
			if (a[i] < a[minIndex]) {
			minIndex = i;
			}
		}
		int temp = a[0];
		a[0] = a[minIndex];
		a[minIndex] = temp;
		
		for (int i = 2; i < n; i+= 2) {
			int min = Math.min(a[i - 1], a[i]);
			int maks = Math.max(a[i - 1], a[i]);
			
			int j = i - 2;
			while (j >= 0 && a[j] > maks) {
				a[j + 2] = a[j];
				j--;
			}
			a[j + 2] = maks;
			
			while (j >= 0 && a[j] > min) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = min;
		}
	}
	
	

}
