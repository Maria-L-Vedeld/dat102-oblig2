package no.dat102.u7.oppg1;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class OPPG1b {


		    public static void insertionSort(int[] arr) {
		        int n = arr.length;

		        for (int i = 2; i < n; i += 2) {
		            int minst = Math.min(arr[i - 1], arr[i]);
		            int storst = Math.max(arr[i - 1], arr[i]);

		            int j = i - 2;
		            while (j >= 0 && storst < arr[j]) {
		                arr[j + 2] = arr[j];
		                j--;
		            }
		            arr[j + 2] = storst;

		            while (j >= 0 && minst < arr[j]) {
		                arr[j + 1] = arr[j];
		                j--;
		            }
		            arr[j + 1] = minst;
		        }
		    }

		    public static void main(String[] args) {
		        int n = 300000; // tiden øker med n
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

