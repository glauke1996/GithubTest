package queueAndStack;
import java.util.*;
public class ASCII {
	public static void ascii() {
		Scanner scan=new Scanner(System.in);
		Queue queue=new Queue();
		String str="";
		int number=0;
		for(int i=0; i<10; i++) {
			number=scan.nextInt();
			if(number==10||number==-1) {
				System.out.println(str);
				break;
			}
			else if(number<33||number>126) {
				throw new IllegalArgumentException("ERROR:OUT OF BOUND.");
			}
			else {
				queue.offer(number);
				str+=(char)queue.poll();
			}
		}
		System.out.println(str);
	}
	public static void main(String[] args) {
		ascii();
	}
}
