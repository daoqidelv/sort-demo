package com.dqdl.sort.demo;

public class BubbleSort extends Sort{

	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
//		int[] targetArray = new int[]{2,1,23,44,3,42,4,555,343,23,2323,23231,343,232,1231,343};
//		int[] targetArray = new int[]{10,9,8,7,6,5,4,3,2,1};
		int[] targetArray = new int[]{1,2,3,4,5,6,7,8,9,10};
//		int[] targetArray = new int[]{1,2,3,4,5,6,7,8,9,10};
		System.out.println("orig array --> "+ bubbleSort.printArray(targetArray));
		bubbleSort.optimizeBubbleSort(targetArray);
		System.out.println("sorted array --> "+bubbleSort.printArray(targetArray));

	}
	
	public int[] sort(int[] targetArray) {
		int num = 0;
		int tmp = 0;
		int size = targetArray.length;
		for(int i=0; i<size; i++) {
			for(int j=i; j<size; j++) {
				num ++;
				if(targetArray[i] > targetArray[j]) {
					tmp = targetArray[j];
					targetArray[j] = targetArray[i];
					targetArray[i] = tmp;
				}
			}
		}
		System.out.println("时间复杂度："+num);
		
		return targetArray;
	}
	
	/**
	 * 优化后的冒泡排序算法
	 * 确保：当原序列是完全有序的时候，时间复杂度为O(n0
	 * @param arr
	 */
	public void optimizeBubbleSort(int arr[]) {
	    boolean didSwap;
	    for(int i = 0, len = arr.length; i < len - 1; i++) {
	        didSwap = false;
	        for(int j = 0; j < len - i - 1; j++) {
	            if(arr[j + 1] < arr[j]) {
	                swap(arr, j, j + 1);
	                didSwap = true;
	            }
	        }
	        if(didSwap == false)
	            return;
	    }    
	}

}
