package day08;

import java.io.*;
import java.util.*;

public class SuperDraw {
	Ticket head;
	Ticket tail;
	int size;
	//inner class_________________________________
	static class Ticket {
		int[] numbers;
		Ticket next;
		
		public Ticket(int[] arr) {
			this.numbers=arr.clone();
			this.next=null;
		}
		public String toString() {
			return Arrays.toString(this.numbers);
		}
	}
	//_____________________________________________
	
	
	public SuperDraw() {
		this.head=null;
		this.tail=null;
		this.size=0;
	}
	
	public SuperDraw(int numOfTicket) {
		this.newTicket(numOfTicket, 1);
	}
	public void lastAdd(Ticket ticket) {
		if(this.head==null&&this.tail==null&&this.size==0) {
			this.head=ticket;
			this.tail=ticket;
		}
		else {
			this.tail.next=ticket;
			this.tail=ticket;
		}
		this.size++;
	}

	private void newTicket(int numOfTicket,int verbose) {
		Random rnd=new Random();
		int[] arr=new int[6];
		if(numOfTicket==1&&verbose==1) {
			System.out.println("A new ticket was successfully generated.");
		}
		else
			System.out.println(numOfTicket+" new ticket was successfully generated.");
		for (int i=0; i<numOfTicket;i++) {
			System.out.print("The numbers are: ");
			for(int j=0; j<6; j++) {
				int randNum=rnd.nextInt(45)+1;
				arr[j]=randNum;
				System.out.print(randNum+" ");
				
			}
			System.out.println();
//			System.out.println(Arrays.toString(arr));///forTest
			Ticket ticket=new Ticket(arr);
			lastAdd(ticket);
		}
	}
	private void printAllTicketNumber() {
		Ticket temp=this.head;
		if(this.size==1) {
			System.out.println("We found a generated ticket.");
			for(int i=0; i<6;i++) {
				System.out.print(this.head.numbers[i]+" ");
			}
			System.out.println();
		}
		else {
			System.out.println("We Found "+this.size+" generated tickets.");
			while(temp!=null) {
				System.out.println(temp);
				temp=temp.next;
		}
		
		}
	}
	private Ticket verifySequence(int[] arr) {
		Ticket pretemp=this.head;
		Ticket temp=this.head.next;
		if(Arrays.toString(this.head.numbers).equals(Arrays.toString(arr))) {
			System.out.println("The provided sequence of numbers was already generated.");
			return pretemp;
		}
		while(temp!=null) {
			if(Arrays.toString(temp.numbers).equals(Arrays.toString(arr))) {
				System.out.println("The provided sequence of numbers was already generated.");
				return pretemp;
			}
			temp=temp.next;
			pretemp=pretemp.next;
		}
		System.out.println("The provided sequence of numbers was never generated.");
		return temp;
	}
	private void deleteSequence(int[] arr) {
		Ticket pretemp=verifySequence(arr);//if there is no generated ticket that correspond to given array,it returns "temp"=null 
		if(pretemp==null) {
			System.out.println("You can't delete a sequence of the numbers that was never generated.");
			this.size++;
		}
		else if(Arrays.toString(this.head.numbers).equals(Arrays.toString(pretemp.numbers))) {   //pretemp==head
			pretemp.numbers=null;
			this.head=head.next;
			pretemp.next=null;
			System.out.println("the provided sequence of numbers was successfully deleted");
			
		}
		else if(Arrays.toString(pretemp.next.numbers)==Arrays.toString(this.tail.numbers)) {	//temp==tail
			Ticket tmp=this.tail;
			tmp=null;
			pretemp.next=null;
			this.tail=pretemp;
			System.out.println("the provided sequence of numbers was successfully deleted");
			
		}
		else {
			Ticket tmp=pretemp.next;
			pretemp.next=pretemp.next.next;
			tmp=null;
			System.out.println("the provided sequence of numbers was successfully deleted");
			
		}
		this.size--;
	}
	public static int[] inputArray() {
		int[] arr=new int[6];
		try {
			BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Input sequence of 6 numbers. Make sure each numbers has the space between themselves.");
			String str=bf.readLine();
			String[] s=(str.split(" "));
			for (int i=0; i<6; i++) {
				arr[i]=Integer.parseInt(s[i]);
			}
		}
			catch(FileNotFoundException e) {
				System.out.println("FileNotFound");
		}
			catch(IOException e) {
				System.out.println("ProblemsWithFile");
		}
		return arr;
	}
//	int[] StringArrayToIntArray(String[] stringArray)
//	{
//	    return Stream.of(stringArray).mapToInt(Integer::parseInt).toArray();		betterWay to convert String[] to int[]gf
//	}
	public static void main(String[] args) {
		SuperDraw sd=new SuperDraw(1);
		sd.printAllTicketNumber();
		int[] inputArray=inputArray();
		sd.deleteSequence(inputArray);
		sd.printAllTicketNumber();
		
	}
}

