/**
 * @class	LinkedStack is a modified version of original LinkedStack class to comply with the changing of modified Node class.
 * @func	push() allows two values to be pushed into the stack.
 * @func	pop() returns a node containing two coordinates x and y.
 * @func	isEmpty() returns true if stack is empty.
 * @func	top() returns the top node but doesn't pop it.
 * @func	size() returns the size of stack.
 * @makeEmpty() Empties the stack.
 * 			
 * */
public class LinkedStack {
	private Node top;
	private int size;			//for better execution efficiency
	
	public LinkedStack(){ top=null; size = 0;}
	
	public int size() {return size;}
	
	public boolean isEmpty(){ return top==null;}
	
	public void push(int x, int y){  //pair of items must be pushed together.
		Node n = new Node();
		n.setCoordinates(x, y); //seting coordinates into the node 'n'
		n.setNext(top);
		top = n;
		size++;
	}
	
	public Node pop() throws StackException{// returns a node containing pair of coordinates.
		Node temp = new Node();
		if(isEmpty()) throw new StackException("Stack is empty.");
		temp = top;
		top = top.getNext();
		size--;
		return temp;  //returning the node containing x and y coordinates.
	}
	
	public Node top() throws StackException{
		if(isEmpty()) throw new StackException("Stack is empty.");
		return top;
	}
	
	public void makeEmpty(){ top = null; size = 0;}
	
	
}
