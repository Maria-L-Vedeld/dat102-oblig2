package no.dat102.u7.oppg1;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class OPPG1c {
	

	    public static void insertionSort(int[] arr) {
	        int n = arr.length;

	        // Flytt minste element fremst
	        int minIndex = 0;
	        for (int i = 1; i < n; i++) {
	            if (arr[i] < arr[minIndex]) {
	                minIndex = i;
	            }
	        }
	        int temp = arr[minIndex];
	        arr[minIndex] = arr[0];
	        arr[0] = temp;

	        // Sorter to elementer av gangen
	        for (int i = 2; i < n; i += 2) {
	            int min = Math.min(arr[i - 1], arr[i]);
	            int max = Math.max(arr[i - 1], arr[i]);

	            int j = i - 2;
	            while (max < arr[j]) {
	                arr[j + 2] = arr[j];
	                j--;
	            }
	            arr[j + 2] = max;

	            while (min < arr[j]) {
	                arr[j + 1] = arr[j];
	                j--;
	            }
	            arr[j + 1] = min;
	        }
	    }

	    public static void main(String[] args) {
	        int n = 300001; //  
	        Random rand = new Random();
	        int[] arr = new int[n];

	        for (int i = 0; i < n; i++) {
	            arr[i] = rand.nextInt(1000000);
	        }

	        Instant start = Instant.now();
	        insertionSort(arr);
	        Instant end = Instant.now();

	        long timeElapsed = Duration.between(start, end).toMillis();
	        System.out.println("Tid: " + timeElapsed + " ms");
	    }
	}
