package com.sort.insert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import com.sort.select.SelectSort;

public class ShellSort {

	/**
	 * 希尔排序是插入排序的一种
	 * 原理：又称增量缩小排序。先将序列按增量划分为元素个数相同的若干组，使用直接插入排序法进行排序，然后不断缩小增量直至为1，最后使用直接插入排序完成排序。
	 * 要点：增量的选择以及排序最终以1为增量进行排序结束。
	 * 增量的取值规则为第一次取总长度的一半,第二次取一半的一半,依次累推直到1为止,刚从下文中看到的这一段描述,感谢!
	 * 
	 */
	//private static Integer[] sortInterval = {3,1};
	
	public static void sort(Integer[] Array)
	{
		Integer sortIntervale = Array.length/2;
		while(sortIntervale>0)
		{
			shell(Array,sortIntervale);
			sortIntervale = sortIntervale/2;
		}
	}
	
	private static void shell(Integer[] Array,Integer sortInterval)
	{
		//for(int i=0;i<sortInterval.length;i++)
		{
			for(int j=0;j<sortInterval;j++)
			{
				for(int m=j + sortInterval;m<Array.length;m=m+sortInterval)
				{
					Integer value = Array[m];
					int n = m;
					while(n>j && Array[n-sortInterval] > value)
					{
						Array[n] = Array[n-sortInterval];
						n = n- sortInterval;
					}
					Array[n]=value;
				}
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//测试一下shell排序和普通的插入排序的效率
		Integer[] list = new Integer[10000];
		Integer[] list2 = new Integer[10000];
        //插入1w个随机数到数组中
        for (int j = 0; j < 10000; j++)
        {
                //Thread.Sleep(1);
        	Integer temp =  new Random().nextInt(10000);
        	list[j] = temp;
        	list2[j] = temp;
        }
		System.out.println("Finish initial two array!");
		long start = System.currentTimeMillis();
		InsertSort.sort(list);
		long end =System.currentTimeMillis();
		System.out.println("normal sort cost time:" + (end - start) + " ms");
		start = System.currentTimeMillis();
		ShellSort.sort(list2);
		end = System.currentTimeMillis();
		System.out.println("Shell sort cost time:" + (end - start) + " ms");
		for(int i = 0;i<10;i++)
		{
			System.out.println(list[i]+":"+list2[i]);
		}
		//实验表明，希尔排序比普通的插入排序快了至少50倍
	}

}
