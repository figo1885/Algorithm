package com.sort.insert;

public class InsertSort {
	/**
	 * 分类：插入排序
	 * 思想：将数组分为无序区和有序区两个区，然后不断将无序区的第一个元素按大小顺序插入到有序区中去，最终将所有无序区元素都移动到有序区完成排序。
	 * 要点：设立哨兵，作为临时存储和判断数组边界之用。
	 */
	/**
	 * 貌似下面这个写错了，写成冒泡排序了？
	 * 但是面试宝典竟然还是奇葩的就是这么玩的..
	 * 和冒泡不太一样的是，这里是对已经有序的进行交换，冒泡则是对无序的进行交换
	 * @param Array
	 */
	public static void sort(Integer[] Array)
	{
		for(int i=1;i<Array.length;i++)
		{
			for(int j=i;j>0;j--)
			{
				if(Array[j]<Array[j-1])
				{
					Integer temp = Array[j-1];
					Array[j-1] = Array[j];
					Array[j]=temp;
				}
			}
		}
	}
	/**
	 * 下面才是真正的插入排序,插入一定包括移位和哨兵(缓存需要插入的值)
	 * 此例子位升序排列
	 * 一定要插入！
	 */
	public static void sortEx(Integer[] Array)
	{
		if(null == Array || Array.length == 0)
		{
			return;
		}
		for(int i=1;i<Array.length;i++)
		{
			Integer value = Array[i];
			int j=i;
			for(;j>0;j--)
			{
				if(Array[j-1]>value)
				{
					Array[j]=Array[j-1];
				}else
				{
					break;
				}
			}
			Array[j]=value;
		}
	}
	/**
	 * 用while写的更加精简的写法
	 * @param A
	 */
	public static void sortEx1(Integer[] A)
	{
		for(int i=1;i<A.length;i++)
		{
			int j=i;
			int value = A[i];
			while(j>0 && A[j-1]>value)
			{
				A[j] = A[j-1];
				j--;
			}
			A[j]=value;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] list = {4,5,2,7,88,1,3,8};
		InsertSort.sortEx1(list);
		for(Integer item:list)
		{
			System.out.println(item);
		}
	}

}
