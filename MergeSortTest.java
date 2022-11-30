package test;	


import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.MergeSort;

public class MergeSortTest {

	private static MergeSort sorter;

	@BeforeAll
	public static void setUp() throws Exception {
		sorter = new MergeSort();
	}

	@Test
	public void testMerge() {
		assertMergeArrays(new int [] {2,3,1}, new int[] {1,2,3},0,1,2);
		assertMergeArrays(new int[] {2,4,6,8,3,5,7,9}, new int[] {2,3,4,5,6,7,8,9}, 0, 3,7);
		assertMergeArrays(new int[] {2,4,6,8,3,5,7,9,11}, new int[] {2,3,4,5,6,7,8,9,11}, 0, 3,8);
		assertMergeArrays(new int[] {2,4,6,8,3,5,7,9,11}, new int[] {2,3,4,5,6,7,8,9,11}, 0, 3,8);
		
	}
	
	@Test
    public void testPesquisaBinariaMetamorfico() {
    	final int NUM_METAMORFIC_TESTS = 10000;
    	Random random = new Random();
    	
    	for (int i=0; i < NUM_METAMORFIC_TESTS; i++){
    		int size = random.nextInt(1000);
    		if(size > 1) {    			
    			int[] array = generateRandomIntArray(size);
    			sorter.sort(array,0,size - 1);
    		}
    		
    		
    	}    	    	    	    	
    }
    
    private int[] generateRandomIntArray(int n){
        Random random = new Random();
    	int[] randomIntArray = new int[n];
    	
    	for(int i = 0; i < n; i++)
    		randomIntArray[i] = random.nextInt(1000);
    	
    	return randomIntArray;
    }

	private void assertMergeArrays(int[] arr,int arr2[], int l, int m , int r) {
		sorter = new MergeSort();
		sorter.merge(arr, l,m,r);
		assertArrayEquals(arr,arr2);
	}
	
	

}
