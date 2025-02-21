package no.dat102.u7.oppg2;

import java.util.Arrays;
import java.util.Random;

public class OPPG2a {
	
	public static void insertionSort(Integer[] a) {
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for ( int j = i + 1; j < n; j++) {
				if (a[j] < a[minIndex]) {
					minIndex = j;
				}
			}
			int temp = a[i];
			a[i] = a[minIndex];
			a[minIndex] = temp;
		}
	}
	
	public static void quickSortering(Integer[] a, int low, int high) {
		if (low < high) {
			int pi = partition(a, low, high);
			quickSortering(a, low, pi - 1);
			quickSortering(a, pi + 1, high);
		}
	}
	
	private static int partition(Integer[] a, int low, int high) {
		int pivot = a[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (a[j] <= pivot) {
				i++;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		int temp = a [i + 1];
		a[i + 1] = a[high];
		a[high] = temp;
		return i + 1;
	}
	
	public static void mergeSortering(Integer[] a, int start, int slutt) {
		if (start < slutt) {
			int midt = start + (slutt - start) / 2;
			mergeSortering(a, start, midt);
			mergeSortering(a, midt + 1, slutt);
			merge(a, start, midt, slutt);
			
		}
	}
	private static void merge(Integer[] a, int start, int midt, int slutt) {
		int n1 = midt - start + 1;
		int n2 = slutt - midt;
		
		Integer[] startArray = new Integer[n1];
		Integer[] sluttArray = new Integer[n2];
		System.arraycopy(a, start, startArray, 0, n1);
		System.arraycopy(a, midt + 1, sluttArray, 0, n2);
		
		int i = 0, j = 0, k = start;
		while (i < n1 && j < n2) {
			if (startArray[i] <= sluttArray[j]) {
				a[k++] = startArray;
			}else {
				a[k++] = sluttArray[j++];
			}
		}
		while (i < n1) {
			a[k++] = startArray[i++];
		}
		while (j < n2 ) {
			a[k++] = sluttArray[j++];
		}
	}

	public static void testSortering(String navn, Integer[][] data, java.util.function.Consumer<Integer[]> sorter) {
		long startTid = System.nanoTime();
		for (Integer[] array : data) {
			sorter.accept(array.clone());
			
		}
		long slutTid = System.nanoTime();
		System.out.println(navn + "tid: " + (slutTid - startTid) / 1e6 + " ms");
	}
	
	public static void main (String[] args) {
		int n = 3200;
		int antall = 10;
		Random rand = new Random();
		Integer[][] data = new Integer[antall][n];
		
		for (int i = 0; i < antall; i++) {
			for (int j = 0; j < n; j++) {
				data[i][j] = rand.nextInt();
			}
		}
		testSortering("QuickSort", data, arr -> quickStortering(arr, 0, arr.length - 1));
		testSortingMethod("MergeSort", data, arr -> mergeSortering(arr, 0, arr.length - 1));
        testSortingMethod("SelectionSort", data, OPPG2a::selectionSort);
        testSortingMethod("InsertionSortOptimized", data, OPPG2a::insertionSortOptimized);
        testSortingMethod("InsertionSortDouble", data, OPPG2a::insertionSortDouble);
        testSortingMethod("InsertionSortCombined", data, OPPG2a::insertionSortCombined);
	}
	
}












