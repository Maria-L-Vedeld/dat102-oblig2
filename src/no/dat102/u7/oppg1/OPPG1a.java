package no.dat102.u7.oppg1;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class OPPG1a {

	    public static void insertionSort(int[] a) {
	        int n = a.length;

	        // Finn og flytt minste element til indeks 0
	        int minIndex = 0;
	        for (int i = 1; i < n; i++) {
	            if (a[i] < a[minIndex]) {
	                minIndex = i;
	            }
	        }
	        int temp = a[minIndex];
	        a[minIndex] = a[0];
	        a[0] = temp;

	        // Insertion Sort med forenklet betingelse
	        for (int i = 1; i < n; i++) {
	            temp = a[i];
	            int j = i - 1;
	            while (temp < a[j]) { // Ingen sjekk for j >= 0 nødvendig, tar det bort fra while (j >= 0 && temp.compareTo(a[j]) < 0), og korter ned
	                a[j + 1] = a[j];
	                j--;
	            }
	            a[j + 1] = temp;
	        }
	    }

	    public static void main(String[] args) {
	        int n = 30000; // n^2, stor n gir lang behandligstid
	        Random rand = new Random();
	        int[] a = new int[n];

	        // Fyll tabellen med tilfeldige tall
	        for (int i = 0; i < n; i++) {
	            a[i] = rand.nextInt(1000000);
	        }

	        Instant start = Instant.now();
	        insertionSort(a);
	        Instant slutt = Instant.now();

	        long tid = Duration.between(start, slutt).toMillis(); //regner ms
	        System.out.println("Tid: " + tid + " ms");
	    }
	}

