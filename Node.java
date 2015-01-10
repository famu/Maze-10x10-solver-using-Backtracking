/**
 * @class	Node is a modified class studied in lectures. Specially created to store x and y coordinates.
 * 
 * */
public class Node {

	private int x;   //for x coordinate
	private int y;	//for y coordinate
	private Node next;  //for next node in the linked list.


	Node(){ this(0, 0, null); } //Since integers cannot initialized as null.

public Node(int a, int b, Node n){ // constructor with arguments.
	x = a;
	y = b;
	next = n;
}
	
	void setCoordinates(int a, int b){  //Set coordinates
		x=a;
		y=b;
	}
	
	void setNext(Node newNext){ //sets next node in the list
		next=newNext;
	}
	
	int getX(){  //returns x coordinate
		return x;
	}
	
	
	int getY(){ //returns y coordinate
		return y;
	}
	
	Node getNext(){  //returns next node
		return next;
	}
	
}
