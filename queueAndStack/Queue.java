package queueAndStack;

public class Queue {
	private Node head;
	private Node tail;
	private int size;
	//______________________________________________________innerClass
	public class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data=data;
			this.next=null;
		}
	}
	//_______________________________________________________
	
	public Queue() {
		this.head=null;
		this.tail=null;
		this.size=0;
	}
	public int getSize() {
		return this.size;
	}
	
	public void offer(int data) {
		Node node=new Node(data);
		if(this.head==null&&this.tail==null&&this.size==0) {
			this.head=node;
			this.tail=node;
		}
		else {
			this.tail.next=node;
			this.tail=node;
		}
		this.size++;
	}
	public int poll() {
		Node tmp=this.head;
		int value=0;
		if(this.size==0&&this.head==null&&this.tail==null)
			throw new IllegalArgumentException("This Queue is empty.");
		else if(this.head==this.tail&&this.size==1) {
			value=tmp.data;
			this.head=null;
			this.tail=null;
			tmp.data=0;
		}
		else {
			this.head=head.next;
			value=tmp.data;
			tmp.next=null;
			tmp.data=0;
		}
		this.size--;
		return value;
	}
	public static void main(String[] args) {
		Queue queue=new Queue();
		for(int i=0; i<5; i++)
			queue.offer(i);
		for(int j=0; j<5; j++)
			System.out.println(queue.poll());
	}
	
}
