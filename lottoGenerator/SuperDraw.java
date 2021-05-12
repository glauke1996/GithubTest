package lottoGenerator;

import java.util.*;

public class SuperDraw {
	Ticket head;
	Ticket tail;
	int size;
	//inner class_________________________________
	static class Ticket {
		int[] number;
		Ticket next;
		
		public Ticket(int[] num) {
			this.number=num.clone();
			this.next=null;
		}
	}
	//_____________________________________________
	
	
	public SuperDraw() {
		this.head=null;
		this.tail=null;
		this.size=0;
	}
	
	public SuperDraw(int numOfTicket) {
		this.size=numOfTicket;
		this.newTicket(numOfTicket, 1);
	}
	public void lastAdd(Ticket ticket) {
		Ticket temp=ticket;
		if(this.head==null) {
			this.head=ticket;
			this.tail=ticket;
		}
		this.tail.next=ticket;
	}
//	public String toString() {
//		return Arrays.toString(this.head.number);
//	}
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
			Ticket ticket=new Ticket(arr);
			lastAdd(ticket);
		}
	}
	private void printAllTicketNumber() {
		if(this.head==this.tail) {
			System.out.println("We found a generated ticket.");
			for(int i=0; i<6;i++) {
				System.out.println(this.head.number[i]);
			}
		}
		
	}
	public static void main(String[] args) {
		SuperDraw sd=new SuperDraw(2);
		
	}
	
	
}
