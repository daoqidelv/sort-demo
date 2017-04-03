package com.dqdl.sort.demo;

public class MergeSort extends Sort {
	
	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int[] targetArray = new int[]{2,1,23,44,3,42,4,555,343,23,2323,23231,343,232,1231,343};
		System.out.println("orig array --> "+ mergeSort.printArray(targetArray));
		mergeSort.sort(targetArray);
		System.out.println("sorted array --> "+mergeSort.printArray(targetArray));

	}

	@Override
	protected int[] sort(int[] targetArray) {
		return sort(targetArray, 0, targetArray.length-1);
	}

	/**
     * �鲢����
     * ���:�����������������ϣ������ϲ���һ���µ������ ���Ѵ��������з�Ϊ���ɸ������У�ÿ��������������ġ�Ȼ���ٰ����������кϲ�Ϊ������������
     * ʱ�临�Ӷ�ΪO(nlogn)
     * �ռ临�Ӷ�O(n)
     * �ȶ�����ʽ
     * @param nums ����������
     * @return �����������
     */
    public static int[] sort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // ���
            sort(nums, low, mid);
            // �ұ�
            sort(nums, mid + 1, high);
            // ���ҹ鲢
            merge(nums, low, mid, high);
        }
        return nums;
    }

    /**
     * ��������low��highλ�õ�����������
     * @param nums ����������
     * @param low ���ŵĿ�ʼλ��
     * @param mid �����м�λ��
     * @param high ���Ž���λ��
     */
    public static void merge(int[] nums, int low, int mid, int high) {
    	//�ռ临�ӶȲ�����
        int[] temp = new int[high - low + 1];
        int i = low;// ��ָ��
        int j = mid + 1;// ��ָ��
        int k = 0;

        // �ѽ�С�������Ƶ���������
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // �����ʣ�������������
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // ���ұ߱�ʣ�������������
        while (j <= high) {
            temp[k++] = nums[j++];
        }

        // ���������е�������nums����
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];
        }
    }


}
