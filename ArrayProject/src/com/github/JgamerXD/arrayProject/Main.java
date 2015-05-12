package com.github.JgamerXD.arrayProject;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static final String SEPERATOR 
	= "----------------------------------------------------------------------";
	public static final String CLEAR 
	= "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		boolean running = true;
		
		int test[] = new int[10];
		for(int i = 0;i < test.length;i++)
		{
			test[i] = rand.nextInt();
		}
		
		String input = "";
		
		while(running)
		{
			input = sc.next();
			
			switch(input)
			{
				case "print":
					System.out.println(CLEAR);
					printArray(test);
					break;
				case "swap":
					swap(test,sc.nextInt(),sc.nextInt());
					break;
				case "stop":
					running = false;
					break;
				default:
					System.out.println("invalid command");
			}
		}
		

	}
	
	public static void printArray(int[] arr)
	{
		System.out.printf("Array mit %d Elementen:\n",arr.length);
		System.out.println(SEPERATOR);
		for(int i = 0;i < arr.length;i++)
		{
			System.out.printf("[%d]	%s\n",i+1,arr[i]);
		}
		System.out.println(SEPERATOR);
	}
	
	public static int[] swap(int[] arr,int from, int to)
	{
		int temp = arr[to];
		arr[to] = arr[from];
		arr[from] = arr[to];
		
		return arr;
	}

}
