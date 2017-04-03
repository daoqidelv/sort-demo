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
	 * ϣ�������ԭ��:�Ľ���Ĳ������򣬵���ÿ�α��ƶ��Ĳ���������1���ʼ���ٵؽ�����������������ɼ򵥵Ĳ�������
	 * ������ʱ��󲿷�����˳���Ѿ�ȷ����ֻ��Ҫͨ��n�αȽϾͿ����������
	 */
	@Override
	protected int[] sort(int[] targetArray) 
    {
        int j = 0;
        int temp = 0;
        //ÿ�ν���������Ϊԭ����һ��
        for (int increment = targetArray.length / 2; increment > 0; increment /= 2)
        {
	        for (int i = increment; i < targetArray.length; i++) 
	        {
	            temp = targetArray[i];
	            for (j = i; j >= increment; j -= increment) 
	            {
		            if(temp <= targetArray[j - increment])//�����С������ֻ���޸�����
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
