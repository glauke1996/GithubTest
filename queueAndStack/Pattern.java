package queueAndStack;
import java.util.*;


public class Pattern {
	public static boolean verifyPattern(Stack stack) {
		boolean isPattern=false;
		verifyLoop:
		for(int k=1;k<=stack.getSize();k++) {
			char c=stack.peek(stack.getSize()-k);
			if(c=='d') {
				for(int j=1;j<=stack.getSize();j++) {
					c=stack.peek(stack.getSize()-k-j);
					if(c=='c') {
						for(int i=1;i<=stack.getSize();i++) {
							c=stack.peek(stack.getSize()-k-j-i);
							if(c=='a') {
								isPattern=true;
								break verifyLoop;
					
							}
						}
					}
					else if(c=='d') {
						return isPattern;
					}
				}
				
			}	
		}
		return isPattern;
	}
		
			
	
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String str=scan.next();
		Stack stack=new Stack();
		for(int i=0;i<str.length();i++) {
			stack.push(str.charAt(i));
		}
		if(verifyPattern(stack)) {
			System.out.println("The pattern occurs.");
		}
		else {
			System.out.println("The pattern does not occur.");
		}
		
		
		
	}
}
