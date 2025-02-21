package no.dat102.u7.oppg2;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class OPPG2b {

	    public static void insertionSorter(Integer[] a) {
	        int n = a.length;
	        for (int i = 1; i < n; i++) {
	            int temp = a[i];
	            int j = i - 1;
	            while (j >= 0 && temp < a[j]) {
	                a[j + 1] = a[j];
	                j--;
	            }
	            a[j + 1] = temp;
	        }
	    }

	    public static void utvalgSorter(Integer[] a) {
	        int n = a.length;
	        for (int i = 0; i < n - 1; i++) {
	            int minIndex = i;
	            for (int j = i + 1; j < n; j++) {
	                if (a[j] < a[minIndex]) {
	                    minIndex = j;
	                }
	            }
	            int temp = a[minIndex];
	            a[minIndex] = a[i];
	            a[i] = temp;
	        }
	    }

	    public static void kvikkSorter(Integer[] arr, int lav, int hoy) {
	        if (lav < hoy) {
	            int pi = partition(arr, lav, hoy);
	            kvikkSorter(arr, lav, pi - 1);
	            kvikkSorter(arr, pi + 1, hoy);
	        }
	    }

	    private static int partition(Integer[] a, int lav, int hoy) {
	        int pivot = a[hoy];
	        int i = lav - 1;
	        for (int j = lav; j < hoy; j++) {
	            if (a[j] < pivot) {
	                i++;
	                int temp = a[i];
	                a[i] = a[j];
	                a[j] = temp;
	            }
	        }
	        int temp = a[i + 1];
	        a[i + 1] = a[hoy];
	        a[hoy] = temp;
	        return i + 1;
	    }

	    public static void mergeSorter(Integer[] arr) {
	        Arrays.sort(arr);
	    }

	    public static void main(String[] args) {
	        int[] sizes = {32000, 64000, 128000};
	        for (int n : sizes) {
	            Integer[] arr = new Random().ints(n, 0, 1000000).boxed().toArray(Integer[]::new);

	            Instant start = Instant.now();
	            insertionSorter(arr.clone());
	            Instant slutt = Instant.now();
	            System.out.println(n + "\tInnsetting: " + Duration.between(start, slutt).toMillis() + " ms");

	            start = Instant.now();
	            utvalgSorter(arr.clone());
	            slutt = Instant.now();
	            System.out.println(n + "\tUtvalg: " + Duration.between(start, slutt).toMillis() + " ms");

	            start = Instant.now();
	            kvikkSorter(arr.clone(), 0, n - 1);
	            slutt = Instant.now();
	            System.out.println(n + "\tKvikk: " + Duration.between(start, slutt).toMillis() + " ms");

	            start = Instant.now();
	            mergeSorter(arr.clone());
	            slutt = Instant.now();
	            System.out.println(n + "\tFlette: " + Duration.between(start, slutt).toMillis() + " ms");
	            System.out.println("**************************************");
	        }
	    }
	}
