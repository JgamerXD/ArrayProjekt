package com.github.JgamerXD.arrayProject;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static final String SEPERATOR 
	= "----------------------------------------------------------------------";

	enum Commands
	{
		help(Main::help,"help - zeigt die Hilfe an", 0),
		print(Main::printArray, "print - gibt das Array aus", 0),
		gen(Main::gen, "gen <length> - generiert ein neues Array mit <length> Elementen", 1),
		swap(Main::swap, "swap <e1> <e2> - tauscht die Elemente <e1> und <e2> miteinander", 2),
		fill(Main::fill, "fill [elements] - erzeugt ein neues Array mit [elements] als Elemente",1),
		set(Main::set, "set <index> <value>",2);

		public ICommand command;
		public String usage;
		public int args;

		Commands(ICommand command,String usage,int args)
		{
			this.command = command;
			this.usage = usage;
			this.args = args;
		}
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		boolean running = true;
		
		int theArray[] = new int[10];
		for(int i = 0;i < theArray.length;i++)
		{
			theArray[i] = rand.nextInt(100);
		}
		
		String input = "";
		String[] inputArgs = null;
		Commands command = null;

		while(running)
		{
			input = sc.nextLine();
			inputArgs = input.split(" ");
			if(inputArgs[0].equals("stop"))
                running = false;
            if(inputArgs[0].trim().equals(""))
                continue;


			try
			{
				command = Commands.valueOf(inputArgs[0]);
				try {
					if (inputArgs.length - 1 >= command.args)
						theArray = command.command.execute(theArray, inputArgs);
					else
						throw new IllegalArgumentException("Not enough arguments");
				}
				catch(IllegalArgumentException e) {
					System.out.print("Usage: " +command.usage);
				}

			}
			catch (IllegalArgumentException e) {
				help(null, null);
			}

		}
		

	}
	
	public static int[] printArray(int[] arr,String[] args)
	{
		System.out.printf("Array mit %d Elementen:\n", arr.length);
		System.out.println(SEPERATOR);
		for(int i = 0;i < arr.length;i++)
		{
			System.out.printf("[%02d]\t%s\n",i,arr[i]);
		}
		System.out.println(SEPERATOR);
		return arr;
	}
	
	public static int[] swap(int[] arr,String[] args)
	{
		int from, to;
//		try {
			from = Integer.valueOf(args[1]);
			to = Integer.valueOf(args[2]);
//		}
//		catch(Exception e)
//		{
//			return arr;
//		}
		int temp = arr[to];
		arr[to] = arr[from];
		arr[from] = temp;
		
		return arr;
	}

	public static int[] help(int[] arr,String[] args)
	{
		for (Commands command : Commands.values()) {
			System.out.println(command.usage);
		}

		return arr;
	}

	public static int[] gen(int[] arr,String[] args)
	{
		Random rand = new Random();
		arr = new int[Integer.valueOf(args[1])];
		for(int i = 0;i < arr.length;i++)
		{
			arr[i] = rand.nextInt(100);
		}
		return arr;
	}

	public static int[] fill(int[] arr,String[] args)
	{
		Random rand = new Random();
		arr = new int[args.length-1];
		for(int i = 0;i < arr.length;i++)
		{
			arr[i] = Integer.valueOf(args[i + 1]);
		}
		return arr;
	}

	public static int[] set(int[] arr,String[] args)
	{
		int index = Integer.valueOf(args[1]);
		int value = Integer.valueOf(args[2]);
		arr[index] = value;
		return arr;
	}
}