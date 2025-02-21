package no.dat102.u7.oppg1;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class OPPG1b {


		    public static void insertionSort(int[] a) {
		        int n = a.length;

		        for (int i = 2; i < n; i += 2) {
		            int minst = Math.min(a[i - 1], a[i]);
		            int storst = Math.max(a[i - 1], a[i]);

		            int j = i - 2;
		            while (j >= 0 && storst < a[j]) {
		                a[j + 2] = a[j];
		                j--;
		            }
		            a[j + 2] = storst;

		            while (j >= 0 && minst < a[j]) {
		                a[j + 1] = a[j];
		                j--;
		            }
		            a[j + 1] = minst;
		        }
		    }

		    public static void main(String[] args) {
		        int n = 300000; // tiden øker med n
		        Random rand = new Random();
		        int[] a = new int[n];

		        for (int i = 0; i < n; i++) {
		            a[i] = rand.nextInt(1000000);
		        }

		        Instant start = Instant.now();
		        insertionSort(a);
		        Instant slutt = Instant.now();

		        long tid = Duration.between(start, slutt).toMillis();
		        System.out.println("Tid: " + tid + " ms");
		    }
		}

