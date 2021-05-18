package queueAndStack;
import java.util.*;
public class Stack {
	private ArrayList<Character>list=new ArrayList<>();
	
	public Stack() {
	}
	public ArrayList<Character> getStack() {
		return this.list;
	}
	public int getSize() {
		return this.list.size();
	}
//	public String toString() {
//		return list.toString();
//	}
	public void push(char data) {
		this.list.add(data);
	}
	public char pop() {
		char returnValue;
		if(isEmpty()==true) {
			System.out.println("null");
		}
		returnValue= this.list.get(this.list.size()-1);
		this.list.remove(this.list.size()-1);
		return returnValue;
	}
	public boolean isEmpty() {
		boolean isEmpty=false;
		if(this.list.size()==0)
			isEmpty=true;
		return isEmpty;
	}
	public char peek(int index) {
		return this.list.get(index);
	}
	
	public static void main(String[] args) {
		Stack stack=new Stack();
		for(int i=65; i<70;i++) {
			stack.push((char)i);
		}
		System.out.println(stack.peek(3));
		System.out.println(stack.getSize());
		
	}
}
