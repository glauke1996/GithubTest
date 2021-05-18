package queueAndStack;

public class AL {
	char[] arr;
	int numOfElements;
	public AL() {
		this.arr=new char[10];
		this.numOfElements=0;
	}
	public void resize() {
		char[] arr=new char[this.numOfElements*2];
		arr=this.arr.clone();
		this.arr=arr;
	}
	public void add(char character) {
		if(this.numOfElements==arr.length) {
			this.resize();
		}
		arr[this.numOfElements]=character;
		this.numOfElements++;
	}
	public void addAll(int index,char[] arr) {
		for(int i=0; i<arr.length; i++) {
			if(this.numOfElements+arr.length>this.arr.length) {
				resize();
			}
			this.arr[this.numOfElements+i]=arr[i];
		}
	}
	public int size() {
		return this.numOfElements;
	}
	public int get(int index) {
		if (index >= this.numOfElements) {
			throw new IllegalArgumentException("Out Of Bound");
		}
		return this.arr[index];
	}
	
}
