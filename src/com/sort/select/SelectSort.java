package com.sort.select;

public class SelectSort {

	/**
	 * 属性：选择排序
	 */
	
	/**
	 * 我写的第一个版本，浪费内存
	 * @param Array
	 */
	public static void sort(Integer[] Array)
	{
		for(int i=Array.length-1;i>0;i--)
		{
			Integer pos = 0;
			Integer max = Array[0];
			for(int j=1;j<=i;j++)
			{
				if(Array[j]>max)
				{
					pos = j;
					max = Array[j];
				}
			}
			Array[pos] = Array[i];
			Array[i] = max;
		}
	}
	/**
	 * 稍微改良一点，省去了临时交换空间
	 * @param Array
	 */
	public static void sortEx(Integer[] Array)
	{
		for(int i=0;i<Array.length;i++)
		{
			for(int j=i+1;j<Array.length;j++)
			{
				if(Array[i] > Array[j])
				{
					Integer temp = Array[i];
					Array[i] = Array[j];
					Array[j] = temp;
				}
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] list = {4,5,2,7,88,1,3,8};
		SelectSort.sortEx(list);
		for(Integer item:list)
		{
			System.out.println(item);
		}
	}

}
