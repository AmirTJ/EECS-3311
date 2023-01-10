
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class FourLinkedList<E> implements List<E> {

	/* Inner Class */
	class Node {
		E item;
		Node prev;
		Node next;
		Node fourthNext;
		Node fourthPrev;

		/**
		 * @param give input is an element of generic type E used code from
		 *             https://developer.classpath.org/doc/java/util/LinkedList-source.html
		 */
		public Node(E item) {
			this.item = item;
		}

	}

	/* Instance Variables */
	private Node head;
	private Node tail;
	private int size;
	private Node currentNode;
	private Node firstNode;

	/* Constructor */
	public FourLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	// print all the nodes of doubly linked list
	public void printNodes() {
		// Node current will point to head
		Node currentNode = head;
		if (head == null) {
			System.out.println("Doubly linked list is empty");
			return;
		}
		System.out.println("\nNodes of doubly linked list: \n");

		while (currentNode != null) {
			// Print each node and then go to next.
			String node = String.format(
					" item: <%s> \n 4th prev: <%s> \n prev: <%s> \n next: <%s> \n 4th next: <%s> \n", currentNode.item,
					currentNode.fourthNext, currentNode.prev, currentNode.next, currentNode.fourthNext);
			System.out.println(node);
			currentNode = currentNode.next;
		}
	}

	@Override
	/**
	 * @param give input is an element of generic type E
	 * @return returns true uses code from
	 *         https://developer.classpath.org/doc/java/util/LinkedList-source.html
	 */
	public boolean add(E e) {

		// Create a new node
		Node newNode = new Node(e);

		// if list is empty, head and tail points to newNode
		if (head == null) {
			head = tail = newNode;
			// head's previous will be null
			head.prev = null;
			// tail's next will be null
			tail.next = null;

		} else {
			
			tail.next = newNode;
			
			newNode.prev = tail;
			
			tail = newNode;
		
			tail.next = null;
		}

		Node nodeForward = head;
		Node nodeBack = head;

		for (int i = 0; i < this.size; i++) {
			nodeForward = nodeForward.next;

			if (i >= 3) {
				nodeBack.fourthNext = nodeForward;
				nodeForward.fourthPrev = nodeBack;
				nodeBack = nodeBack.next;
			}
		}

		this.size++;

		return true;
	}

	@Override
	/**
	 * @param index   of the list to insert the element which is of type integer
	 * @param element generic type to be inserted in the LinkedList This method adds
	 *                the given element at the given index in the list
	 */
	public void add(int index, E element) {
		if (index <= this.size) {

			for (int i = 0; i < index; i++) {

				head = head.next;

			}

			head.item = element;
			this.size++;

		}

	}

	@Override
	/**
	 * @param index of type integer
	 * @return returns the removed element at the given index
	 */
	public E remove(int index) {

		Node currentNode = head;

		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;

		}
		E item = currentNode.item;
		currentNode = null;
		this.size--;
		return item;
	}

	@Override
	/**
	 * @param index of type integer
	 * @return returns the element which is at the given index in the list
	 */
	public E get(int index) {

		currentNode = head;

		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}

		return currentNode.item;
	}

	@Override
	/**
	 * @return returns the size of the list
	 */
	public int size() {
		return this.size;
	}

	@Override
	/**
	 * This method clears out everything that exists in the list
	 */
	public void clear() {

		currentNode = head;

		while (currentNode.next != null) {
			currentNode.fourthPrev = null;
			currentNode.prev = null;
			currentNode.fourthNext = null;
			currentNode = currentNode.next;
		}

		currentNode.fourthPrev = null;
		currentNode.prev = null;
		currentNode.fourthNext = null;
		currentNode.next = null;
		size = 0;

	}

	public String toString() {

		String ReturnS = "{";

		Node current = head;
		for (int i = 0; i < this.size - 1; i++) {
			ReturnS += current.item + ", ";
			current = current.next;

		}
		ReturnS += current.item;

		ReturnS += "}";

		return ReturnS;

	}

	// These are the public methods that are needed to be implemented
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}