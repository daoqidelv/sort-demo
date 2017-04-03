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
	 * ��������
	 * 
	 * �ӵ�һ��Ԫ�ؿ�ʼ����Ԫ�ؿ�����Ϊ�Ѿ�������
     * ȡ����һ��Ԫ�أ����Ѿ������Ԫ�������дӺ���ǰɨ�� 
     * �����Ԫ�أ������򣩴�����Ԫ�أ�����Ԫ���Ƶ���һλ��  
     * �ظ�����3��ֱ���ҵ��������Ԫ��С�ڻ��ߵ�����Ԫ�ص�λ��  
     * ����Ԫ�ز��뵽��λ����  
     * �ظ�����2  
	 */
	@Override
	protected int[] sort(int[] targetArray) {
		int tmp = 0;
		int size = targetArray.length;
		for(int i = 0; i < size; i++) {
			for(int j = i; j > 0; j--) {
				//�����ǰ�������Ԫ�ر�֮ǰ�Ѿ��ź����ĳ��Ԫ�ش������߻���
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
