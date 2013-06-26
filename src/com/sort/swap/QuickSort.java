package com.sort.swap;

/**
 * 属性：交换排序
 * 快速排序
 * 1.划分，通过交换把值放到起自身应该处于的序列位置
 * 2.递归，递归使得每个对象排序到自己所在的位置
 * @author thinkpad
 */
public class QuickSort {
	/**
	 * 递归
	 * @param low 低位
	 * @param high 高位
	 * @param Array 要被排序的原始数组
	 */
	public static void sort(Integer low,Integer high, Integer[] Array)
	{
		if(low >= high)
		{
			return;
		}
		else
		{
			Integer pos = partition(low,high,Array);
			sort(low,pos-1,Array);
			sort(pos+1,high,Array);
		}
	}
	/**
	 * 交换操作
	 * @param low 低位
	 * @param high 高位
	 * @param Array 要被排序的原始数组
	 * @return 最终low位存放数字应该所在的位置
	 */
	public static Integer partition(Integer low, Integer high, Integer[] Array)
	{
		Integer baseValue = Array[low];
		Integer i=low;
		Integer j=high;
		while(i<j)
		{
			for(;j>i;j--)
			{
				if(Array[j] < baseValue)
				{
					Array[i] = Array[j];
					i++;
					break;
				}
			}
			for(;i<j;i++)
			{
				if(Array[i] > baseValue)
				{
					Array[j] = Array[i];
					j--;
					break;
				}
			}
		}
		Array[i] = baseValue;
		return i;
	}
	
	//这种传入简单对象的，是传递的副本，之后传递对象的才是传引用，例如String
	public static void changeValue(Integer a, int b)
	{
		a++;
		a = 4;
		b++;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] list = {4,5,3,6,3,2,1};
		//Integer pos = QuickSort.partition(0, list.length-1, list);
		//System.out.println(pos);
		QuickSort.sort(0, list.length-1, list);
		for(Integer item:list)
		{
			System.out.println(item);
		}
		
	}

}
