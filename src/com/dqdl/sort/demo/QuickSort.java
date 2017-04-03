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
	 * ��ָ�����м�����ʼλ���ҳ����g�������ڵ�λ�ã������������������м���С����������ߣ����м�����������������ұ�
	 * ��λ����ѡ����ѡȡ ���е���λԪ��
	 * @param targetArray
	 * @param low
	 * @param high
	 * @return
	 */
	private int findMiddleOne(int[] targetArray, int low, int high) {
		//�ռ临�ӶȲ�����
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
	 * ��ָ�����м�����ʼλ���ҳ����g�������ڵ�λ�ã������������������м���С����������ߣ����м�����������������ұ�
	 * ��λ����ѡ����ѡȡ ���е���λ��ĩβ����λ����λ�õĔ�������ֵ���е�Ԫ��
	 * ����ֱ��ʹ���������λԪ����Ϊ��λ�����÷������Ӹ�Ч��
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
	 * �����е���λ��ĩβ����λ����λ�õĔ����У�ȡ��ֵ�����g��Ԫ��
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
