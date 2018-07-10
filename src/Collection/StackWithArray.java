package Collection;

public class StackWithArray<X>{
	private X[] data;
	private int stackPointer;
	
	public StackWithArray() {
		this.data = (X[]) new Object[1000];
		this.stackPointer = 0;
	}
	
	private void push(X item) {
		this.data[stackPointer] = item;
		this.stackPointer++;
	}
	
	
	public X pop() {
		if (stackPointer == 0) {
			throw new IllegalStateException("No More items on the stack");
		}
		return this.data[--stackPointer];
	}
	
	public boolean contains(X item) {
		boolean found = false;
		for (int i = 0 ; i < this.stackPointer; i ++) {
			if (this.data[i].equals(item)) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public X get(X item) {
		for (int i = 0; i < this.stackPointer; i ++) {
			if (this.data[i].equals(item)) {
				return data[i];
			}
		}
		return null;
	}
}
