package com.dqdl.sort.demo;

public class QuickSort extends Sort {
	


	public static void main(String[] args) {
		int[] targetArray = new int[]{2,1,23,44,3,42,4,555,343,23,2323,23231,343,232,1231,343};
		int[] targetArray2 = targetArray.clone();
		
		QuickSort quickSort = new QuickSort();
		System.out.println("orig array --> "+ quickSort.printArray(targetArray));
		quickSort.sort(targetArray);
		System.out.println("quickSort sorted array --> "+quickSort.printArray(targetArray));
		
		
		quickSort.quickSortByOneInThree(targetArray2,  0, targetArray.length-1 );
		System.out.println("quickSortByOneInThree sorted array --> "+quickSort.printArray(targetArray2));
	}
	



	@Override
	protected int[] sort(int[] targetArray) {
		return this.quickSort(targetArray, 0, targetArray.length-1);
	}
	

	private int[] quickSort(int[] targetArray, int low, int high) {
		if(low < high)
        {
			int middleOneIndex = findMiddleOne(targetArray, low, high);
			quickSort(targetArray, low, middleOneIndex-1);
			quickSort(targetArray, middleOneIndex+1, high);
        }
		return targetArray;
	}
	
	private int[] quickSortByOneInThree(int[] targetArray, int low, int high) {
		if(low < high)
        {
			int middleOneIndex = partitionFromThree(targetArray, low, high);
			quickSortByOneInThree(targetArray, low, middleOneIndex-1);
			quickSortByOneInThree(targetArray, middleOneIndex+1, high);
        }
		return targetArray;
	}
	
	/**
	 * 從指定序列及其起始位置找出中間數應當在的位置，满足如下条件：比中间数小的数据在左边，比中间数大的数据在它的右边
	 * 中位数的选定：选取 序列的首位元素
	 * @param targetArray
	 * @param low
	 * @param high
	 * @return
	 */
	private int findMiddleOne(int[] targetArray, int low, int high) {
		//空间复杂度产生点
		int tmp =  targetArray[low];
		while(low < high) {
			while(low < high && tmp <= targetArray[high]) {
				high --;
			} 
			targetArray[low] = targetArray[high];
			
			while(low < high && tmp >= targetArray[low]) {
				low ++;
			}
			targetArray[high] = targetArray[low];
		} 
		targetArray[low] = tmp;
		return low;
		
	}
	
	/**
	 * 從指定序列及其起始位置找出中間數應當在的位置，满足如下条件：比中间数小的数据在左边，比中间数大的数据在它的右边
	 * 中位数的选定：选取 序列的首位、末尾、中位三個位置的數字中数值居中的元素
	 * 比起直接使用数组的首位元素作为中位数，该方法更加高效。
	 * @param targetArray
	 * @param low
	 * @param high
	 * @return
	 */
	private int partitionFromThree(int[] targetArray, int low, int high) {
		int tmp = findMiddleOneFromThree(targetArray, low, high);
		while(low < high) {
			while(low < high && tmp <= targetArray[high]) {
				high --;
			} 
			targetArray[low] = targetArray[high];
			
			while(low < high && tmp >= targetArray[low]) {
				low ++;
			}
			targetArray[high] = targetArray[low];
		} 
		targetArray[low] = tmp;
		return low;
	}
	
	/**
	 * 從序列的首位、末尾、中位三個位置的數字中，取出值在中間的元素
	 * @param targetArray
	 * @param low
	 * @param high
	 * @return
	 */
	private int findMiddleOneFromThree (int[] targetArray, int low, int high) {

		int mid = low+(high-low)/2;
		if(targetArray[mid] > targetArray[mid]) {
			swap(targetArray[mid] , targetArray[mid]);
		}
		
		if(targetArray[low] > targetArray[high]) {
			swap(targetArray[high] , targetArray[low]);
		}
		
		 if(targetArray[mid]>targetArray[low]){
            swap(targetArray[mid],targetArray[low]);
        }		
		int key = targetArray[low];
		return key;
	}
	


}
