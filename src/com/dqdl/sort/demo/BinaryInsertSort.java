package com.dqdl.sort.demo;

/**
 * 二分查找插入排序 和直接插入排序相比，该算法通过二分查找已排序的序列，找到目标元素应当放置的位置
 * 效率：O(N^2)，对于初始基本有序的序列，效率上不如直接插入排序；对于随机无序的序列，效率比直接插入排序要高
 * 
 * 二分插入排序时，通常先检查待排序序列前面一部分是否已经是有序的，如果是的，则不必对前面已经是有序的子序列进行重排序，提升效率
 * @author Administrator
 *
 */

public class BinaryInsertSort extends Sort {

	@Override
	protected int[] sort(int[] targetArray) {
		this.binaryInsert(targetArray);
		return null;
	}
	

	public static void main(String[] args) {
		BinaryInsertSort binaryInsertSort = new BinaryInsertSort();
		int[] targetArray = new int[]{2,1,23,44,3,42,4,555,343,23,2323,23231,343,232,1231,343};
		System.out.println("orig array --> "+ binaryInsertSort.printArray(targetArray));
		binaryInsertSort.sort(targetArray);
		System.out.println("sorted array --> "+binaryInsertSort.printArray(targetArray));

	}

	/**
	 * 插入排序
	 * 
	 * @param ary
	 */
	private void binaryInsert(int[] ary) {
		int setValueCount = 0;
		// 从数组第二个元素开始排序，因为第一个元素本身肯定是已经排好序的
		for (int j = 1; j < ary.length; j++) {// 复杂度 n
			// 保存当前值
			int key = ary[j];
			// ∆ 利用二分查找定位插入位置
			// int index = binarySearchAsc(ary, ary[j], 0, j - 1);// 复杂度：O(logn)
			// int index = binarySearchDesc(ary, ary[j], 0, j - 1);//
			// 复杂度：O(logn)
			int index = binarySearchDesc2(ary, ary[j], 0, j - 1);// 复杂度：O(logn)
			System.out.println("第" + j + "个索引上的元素要插入的位置是：" + index);
			// 将目标插入位置，同时右移目标位置右边的元素
			for (int i = j; i > index; i--) {// 复杂度,最差情况：(n-1)+(n-2)+...+n/2=O(n^2)
				ary[i] = ary[i - 1]; // i-1 <==> index
				setValueCount++;
			}
			ary[index] = key;
			setValueCount++;
		}
		System.out.println("\n 设值次数(setValueCount)=====> " + setValueCount);
	}

	/**
	 * 二分查找 升序 递归
	 * 
	 * @param ary
	 *            给定已排序的待查数组
	 * @param target
	 *            查找目标
	 * @param from
	 *            当前查找的范围起点
	 * @param to
	 *            当前查找的返回终点
	 * @return 返回目标在数组中，按顺序应在的位置
	 */
	private int binarySearchAsc(int[] ary, int target, int from, int to) {
		int range = to - from;
		// 如果范围大于0，即存在两个以上的元素，则继续拆分
		if (range > 0) {
			// 选定中间位
			int mid = (to + from) / 2;
			// 如果临界位不满足，则继续二分查找
			if (ary[mid] > target) {
				/*
				 * mid > target, 升序规则，target较小，应交换位置 前置， 即target定位在mid位置上， 根据
				 * 查找思想， 从from到 mid-1认为有序， 所以to=mid-1
				 */
				return binarySearchAsc(ary, target, from, mid - 1);
			} else {
				/*
				 * mid < target, 升序规则，target较大，不交换位置，查找比较的起始位置应为mid+1
				 */
				return binarySearchAsc(ary, target, mid + 1, to);
			}
		} else {
			if (ary[from] > target) {// 如 5,4, 要插入的是4
				return from;
			} else {
				return from + 1;
			}
		}
	}

	/**
	 * 二分查找 降序， 递归
	 */
	private int binarySearchDesc(int[] ary, int target, int from, int to) {
		int range = to - from;
		if (range > 0) {
			int mid = (from + to) >>> 1;
			if (ary[mid] > target) {
				return binarySearchDesc(ary, target, mid + 1, to);
			} else {
				return binarySearchDesc(ary, target, from, mid - 1);
			}
		} else {
			if (ary[from] > target) {// 如 5,4, 要插入的是4
				return from + 1;
			} else {
				return from;
			}
		}
	}

	/**
	 * 二分查找 降序， 非递归
	 */
	private int binarySearchDesc2(int[] ary, int target, int from, int to) {
		// while(from < to) {
		for (; from < to;) {
			int mid = (from + to) >>> 1;
			if (ary[mid] > target) {
				from = mid + 1;
			} else {
				to = mid - 1;
			}
		}
		// from <==> to;
		if (ary[from] > target) {// 如 5,4, 要插入的是4
			return from + 1;
		} else {
			return from;
		}
	}

}
