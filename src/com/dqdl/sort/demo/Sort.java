package com.dqdl.sort.demo;

public abstract class Sort {
	
	protected abstract int[] sort(int [] targetArray);
	
	public String printArray(int [] targetArray) {
		StringBuffer sb = new StringBuffer();
		for(int i =0; i<targetArray.length; i++) {
			sb.append(targetArray[i]).append(",");
		}
		return sb.toString();
	}
	
	protected void swap(int i, int j) {
		int tmp = i;
		i = j;
		j = tmp;
	}
	
	protected void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
