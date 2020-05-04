package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) throws NullPointerException
	{
		if (element == null) {
			throw new NullPointerException();
		}
		
		LLNode<E> prev = tail.prev;
		LLNode<E> newNode = new LLNode<E>(element);
		prev.next = newNode;
		newNode.prev = prev;

		newNode.next = tail;
		tail.prev = newNode;
		size++;
		
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) throws IndexOutOfBoundsException
	{
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		
		int i = 0;
		LLNode<E> curr = head;
		while (i <= index) {
			curr = curr.next;
			i++;
		}
		return curr.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) throws IndexOutOfBoundsException, NullPointerException
	{
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (element == null) {
			throw new NullPointerException();
		}
		
		if (index == size) {
			add(element);
		}
		
		LLNode<E> prev = head;
		LLNode<E> curr = head.next;
		int i = 0;
		while (i < index) {
			prev = curr;
			curr = curr.next;
			i++;
		}


		LLNode<E> newNode = new LLNode<E>(element);
		prev.next = newNode;
		newNode.prev = prev;

		newNode.next = curr;
		curr.prev = newNode;
		size++;
		
	}


	/** Return the size of the list */
	public int size() 
	{
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) throws IndexOutOfBoundsException
	{
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		int i = 0;
		LLNode<E> prev = head;
		LLNode<E> curr = head.next;
		while (i < index) {
			prev = curr;
			curr = curr.next;
			i++;
		}
		
		E element = curr.data;
		LLNode<E> next = curr.next;
		
		prev.next = next;
		next.prev = prev;

		size--;
		return element;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) throws IndexOutOfBoundsException
	{
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		if (element == null) {
			throw new NullPointerException();
		}

		int i = 0;
		LLNode<E> curr = head.next;
		while (i < index) {
			curr = curr.next;
			i++;
		}
		
		E elem = curr.data;
		
		curr.data = element;
		return elem;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
