package only.you.august.tree;

import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.Iterator;

public class MyList<T> implements ILinkedList<T> {

	
	private int _size = 0;

	private Node<T> _head = new Node<T>(null, null);

	private static class Node<T> {
		public T value;
		public Node<T> next;
		
		public Node(T _value, Node<T> _next) {
			this.value = _value;
			this.next = _next;
		}	
		
	}
	
	private class Iterra<R> implements Iterator<R>{

		@SuppressWarnings("unchecked")
		private Node<R> _currentPosition;
		
		public Iterra(Node<R> startFrom){
			_currentPosition = startFrom;
		}
		
		@Override
		public boolean hasNext() {
			return _currentPosition.next != null;
		}

		@Override
		public R next() {
			R result = _currentPosition.next.value;
			_currentPosition = _currentPosition.next;
			return result;
		}
		
	}

	@Override
	public Iterator<T> iterator() {		
		return new Iterra<T>(_head);
	}

	@Override
	public int size() {
		return _size;
	}

	@Override
	public boolean isEmpty() {
		return _size == 0;
	}

	@Override
	public void add(T item) {
		Node<T> cursor = _head;
		while (cursor.next != null) {
			cursor = cursor.next;
		}
		cursor.next = new Node<T>(item, null);
		_size++;
	}

	@Override
	public boolean remove(T item) {
		Node<T> cursor = _head;
		while(cursor.next != null){
			if (cursor.next.value == item){
				cursor.next = cursor.next.next;
				_size--;
				return false;
			}
			cursor = cursor.next;
		}		
		return false;
	}

	@Override
	public boolean contains(T item) {
		Node<T> cursor = _head.next;
		while (cursor != null) {
			if (cursor.value == item)
				return true;
			cursor = cursor.next;
		}
		return false;
	}

	@Override
	public void clear() {
		_head.next = null;
		_size = 0;
	}

	@Override
	public Object[] toArray() {
		Object[] result = new Object[_size];
		int index = 0;
		Node<T> cursor = _head.next;
		while (cursor != null) {
			result[index++] = cursor.value;
			cursor = cursor.next;
		}
		return result;
	}

	@Override
	public int indexOf(T item) {
		Node<T> cursor = _head.next;
		int index = 0;
		while(cursor != null){
			if (cursor.value == item)
				return index;
			index++;
			cursor = cursor.next;
		}		
		return -1;
	}

	@Override
	public int lastIndexOf(T item) {
		Node<T> cursor = _head.next;
		int result = -1;
		int index = 0;
		while(cursor != null){
			if (cursor.value == item){
				result = index;
			}
			index++;
			cursor = cursor.next;
		}		
		return result;
	}
	
	@Override
	public void insert(int index, T item) {
		if (index < 0 || index >= _size)
			throw new InvalidParameterException();
		Node<T> cursor = _head;
		int current = 0;
		while(cursor != null && current++ < index){
			cursor = cursor.next;
		}
		Node<T> n = new Node<T>(item, cursor.next);
		cursor.next = n;
		_size++;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= _size)
			throw new InvalidParameterException();
		Node<T> cursor = _head.next;
		int current = 0;
		while(cursor != null){
			if (current++ == index)
				return cursor.value;
			if (current > index)
				throw new InvalidParameterException();
			cursor = cursor.next;
		}
		throw new InvalidParameterException();
	}

	@Override
	public String toString() {
		String result = "{";
		Node<T> cursor = _head.next;
		while(cursor != null){
			result += cursor.value.toString();
			if (cursor.next != null){
				result += ", ";				
			}
			cursor = cursor.next;
		}
		return result + "}";
	}

}
