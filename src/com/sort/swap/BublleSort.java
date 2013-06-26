package com.sort.swap;

public class BublleSort {

	/**
	 * 属性：交换排序
	 * @param Array
	 */
	public static void sort(Integer[] Array)
	{
		for(int i=Array.length-1;i>0;i--)
		{
			for(int j=0;j<i;j++)
			{
				if(Array[j]>Array[j+1])
				{
					Integer temp = Array[j];
					Array[j]=Array[j+1];
					Array[j+1]=temp;
				}
			}
		}
	}
	/**
	 * 改进的泡泡算法，如果一次都不需要交换，说明当前顺序已经是升序
	 * @param Array
	 */
	public static void sortEx(Integer[] Array)
	{
		boolean isChanged = false;
		for(int i= Array.length-1;i>0;i--)
		{
			isChanged = false;
			for(int j=0;j<i;j++)
			{
				if(Array[j]>Array[j+1])
				{
					isChanged = true;
					Integer temp = Array[j];
					Array[j] = Array[j+1];
					Array[j+1]=temp;
				}
			}
			if(!isChanged)
			{
				break;
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] list = {4,5,2,7,88,1,3,8};
		BublleSort.sortEx(list);
		for(Integer item:list)
		{
			System.out.println(item);
		}
	}

}
