/**
 * 
 * @interface a blue print or prototype of the stack defined in the LinkedStack class.
 * */
public interface Stack {

	void push(Object x);
	Object pop();
	Object top();
	void makeEmpty();
	boolean isEmpty();
	int size();
	
}
