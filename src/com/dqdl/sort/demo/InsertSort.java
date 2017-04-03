package com.dqdl.sort.demo;

public class InsertSort extends Sort {
	


	public static void main(String[] args) {
		InsertSort insertSort = new InsertSort();
		int[] targetArray = new int[]{2,1,23,44,3,42,4,555,343,23,2323,23231,343,232,1231,343};
		System.out.println("orig array --> "+ insertSort.printArray(targetArray));
		insertSort.sort(targetArray);
		System.out.println("sorted array --> "+insertSort.printArray(targetArray));

	}

	/**
	 * 插入排序
	 * 
	 * 从第一个元素开始，该元素可以认为已经被排序
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描 
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置  
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置  
     * 将新元素插入到该位置中  
     * 重复步骤2  
	 */
	@Override
	protected int[] sort(int[] targetArray) {
		int tmp = 0;
		int size = targetArray.length;
		for(int i = 0; i < size; i++) {
			for(int j = i; j > 0; j--) {
				//如果当前待排序的元素比之前已经排好序的某个元素大，则两者互换
				if(targetArray[j-1] > targetArray[j]) {
					tmp = targetArray[j-1];
					targetArray[j-1] = targetArray[j];
					targetArray[j] = tmp;
				} else {
					break;
				}
			}
		}
		return targetArray;
	}

}
