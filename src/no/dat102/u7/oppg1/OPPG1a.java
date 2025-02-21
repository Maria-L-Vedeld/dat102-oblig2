package no.dat102.u7.oppg1;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class OPPG1a {

	    public static void insertionSort(int[] arr) {
	        int n = arr.length;

	        // Finn og flytt minste element til indeks 0
	        int minIndex = 0;
	        for (int i = 1; i < n; i++) {
	            if (arr[i] < arr[minIndex]) {
	                minIndex = i;
	            }
	        }
	        int temp = arr[minIndex];
	        arr[minIndex] = arr[0];
	        arr[0] = temp;

	        // Insertion Sort med forenklet betingelse
	        for (int i = 1; i < n; i++) {
	            temp = arr[i];
	            int j = i - 1;
	            while (temp < arr[j]) { // Ingen sjekk for j >= 0 nødvendig, tar det bort fra while (j >= 0 && temp.compareTo(a[j]) < 0), og korter ned
	                arr[j + 1] = arr[j];
	                j--;
	            }
	            arr[j + 1] = temp;
	        }
	    }

	    public static void main(String[] args) {
	        int n = 30000; // n^2, stor n gir lang behandligstid
	        Random rand = new Random();
	        int[] arr = new int[n];

	        // Fyll tabellen med tilfeldige tall
	        for (int i = 0; i < n; i++) {
	            arr[i] = rand.nextInt(1000000);
	        }

	        Instant start = Instant.now();
	        insertionSort(arr);
	        Instant end = Instant.now();

	        long timeElapsed = Duration.between(start, end).toMillis(); //regner ms
	        System.out.println("Tid: " + timeElapsed + " ms");
	    }
	}

