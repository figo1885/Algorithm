package com.sort.merge;

public class MergeSort {

	/**
	 * 归并排序可以分为多路归并和双路归并
	 * 但是核心思想是：递归+合并
	 * 递归目的在于把大的数组分解成一个一个的小的数组，递归的终止条件就是分解到只有一个字符
	 * 合并的目的在于把最小的元素逐个合并起来
	 */
	public static void sort(int[] Array,int begin, int end)
	{
		if(begin < end)
		{
			int mid = (begin + end)/2;
		    sort(Array,begin,mid);
		    sort(Array,mid+1,end);
		    merge(Array,begin,mid,mid+1,end);
		}
	}
	public static void merge(int[] Array, int start1, int end1, int start2, int end2)
	{
		int i = start1;
		int j = start2;
		int k = 0;
		int[] tempArray = new int[end2 - start1 +1];
		while(i<=end1 && j<=end2)
		{
			if(Array[i]>Array[j])
			{
				tempArray[k++] = Array[j++];
			}else
			{
				tempArray[k++]=Array[i++];
			}
		}
		while(i<=end1)
		{
			tempArray[k++] = Array[i++];
		}
		while(j<=end2)
		{
			tempArray[k++] = Array[j++];
		}
		/*k=start1;
		for(int item:tempArray)
		{
			Array[k++] = item;
		}*/
		System.arraycopy(tempArray, 0, Array, start1, tempArray.length);
	}
	
	
	public static int[] sort2(int[] Array)
	{
		if(Array.length == 1)
		{
			return Array;
		}
		int mid = Array.length/2;
		int[] temp1 = new int[mid];
		int[] temp2 = new int[Array.length-mid];
		System.arraycopy(Array, 0, temp1, 0, temp1.length);
		System.arraycopy(Array, mid, temp2, 0, temp2.length);
		temp1 = sort2(temp1);
		temp2 = sort2(temp2);
		return merge2(temp1,temp2);
	}
	public static int[] merge2(int[] Array1, int[] Array2)
	{
		int[] newArray = new int[Array1.length+Array2.length];
		int i=0;
		int j=0;
		int k=0;
		while(i<Array1.length && j<Array2.length)
		{
			if(Array1[i]>Array2[j])
			{
				newArray[k++] = Array2[j++];
			}else
			{
				newArray[k++] = Array1[i++];
			}
		}
		while(i<Array1.length)
		{
			newArray[k++] = Array1[i++];
		}
		while(j<Array2.length)
		{
			newArray[k++] = Array2[j++];
		}
		return newArray;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Array[] = {3,6,5,4,7,9,3};
		//MergeSort.sort(Array, 0,Array.length-1);
		int newArray[] = MergeSort.sort2(Array);
		//int newArray[] = MergeSort.merge2(Array, Array2);
		for(int item:newArray)
		{
			System.out.println(item);
		}
		
	}

}
