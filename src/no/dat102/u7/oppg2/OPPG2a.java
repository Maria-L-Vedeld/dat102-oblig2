package no.dat102.u7.oppg2;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class OPPG2a {

	    public static void insertionSorter(Integer[] arr) {
	        int n = arr.length;
	        for (int i = 1; i < n; i++) {
	            int temp = arr[i];
	            int j = i - 1;
	            while (j >= 0 && temp < arr[j]) {
	                arr[j + 1] = arr[j];
	                j--;
	            }
	            arr[j + 1] = temp;
	        }
	    }

	    public static void utvalgSorter(Integer[] arr) {
	        int n = arr.length;
	        for (int i = 0; i < n - 1; i++) {
	            int minIndex = i;
	            for (int j = i + 1; j < n; j++) {
	                if (arr[j] < arr[minIndex]) {
	                    minIndex = j;
	                }
	            }
	            int temp = arr[minIndex];
	            arr[minIndex] = arr[i];
	            arr[i] = temp;
	        }
	    }

	    public static void kvikkSorter(Integer[] arr, int low, int high) {
	        if (low < high) {
	            int pi = partition(arr, low, high);
	            kvikkSorter(arr, low, pi - 1);
	            kvikkSorter(arr, pi + 1, high);
	        }
	    }

	    private static int partition(Integer[] arr, int low, int high) {
	        int pivot = arr[high];
	        int i = low - 1;
	        for (int j = low; j < high; j++) {
	            if (arr[j] < pivot) {
	                i++;
	                int temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	            }
	        }
	        int temp = arr[i + 1];
	        arr[i + 1] = arr[high];
	        arr[high] = temp;
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
	            Instant end = Instant.now();
	            System.out.println(n + "\tInnsetting: " + Duration.between(start, end).toMillis() + " ms");

	            start = Instant.now();
	            utvalgSorter(arr.clone());
	            end = Instant.now();
	            System.out.println(n + "\tUtvalg: " + Duration.between(start, end).toMillis() + " ms");

	            start = Instant.now();
	            kvikkSorter(arr.clone(), 0, n - 1);
	            end = Instant.now();
	            System.out.println(n + "\tKvikk: " + Duration.between(start, end).toMillis() + " ms");

	            start = Instant.now();
	            mergeSorter(arr.clone());
	            end = Instant.now();
	            System.out.println(n + "\tFlette: " + Duration.between(start, end).toMillis() + " ms");
	        }
	    }
	}
