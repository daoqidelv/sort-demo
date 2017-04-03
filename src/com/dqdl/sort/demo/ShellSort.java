package com.dqdl.sort.demo;

public class ShellSort extends Sort {
	
	public static void main(String[] args) {
		ShellSort shellSort = new ShellSort();
		int[] targetArray = new int[]{2,1,23,44,3,42,4,555,343,23,2323,23231,343,232,1231,343};
		System.out.println("orig array --> "+ shellSort.printArray(targetArray));
		shellSort.sort(targetArray);
		System.out.println("sorted array --> "+shellSort.printArray(targetArray));
	}

	/**
	 * 希尔排序的原理:改进版的插入排序，但是每次比移动的步长不再是1，最开始快速地进行索引增长，最后变成简单的插入排序，
	 * 但是这时候大部分数的顺序已经确定，只需要通过n次比较就可以完成排序
	 */
	@Override
	protected int[] sort(int[] targetArray) 
    {
        int j = 0;
        int temp = 0;
        //每次将步长缩短为原来的一半
        for (int increment = targetArray.length / 2; increment > 0; increment /= 2)
        {
	        for (int i = increment; i < targetArray.length; i++) 
	        {
	            temp = targetArray[i];
	            for (j = i; j >= increment; j -= increment) 
	            {
		            if(temp <= targetArray[j - increment])//如想从小到大排只需修改这里
		            {   
		                targetArray[j] = targetArray[j - increment];
		            }
		            else
		            {
		                break;
		            }	            
	            } 
	            targetArray[j] = temp;
	        }	    
        }
	    return targetArray;
    }

}
