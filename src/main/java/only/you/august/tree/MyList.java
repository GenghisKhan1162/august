package only.you.august.tree;

import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.Iterator;

public class MyList implements ILinkedList {

	
	private int _size = 0;

	private Node _head = new Node(null, null);

	private static class Node {
		public String value;
		public Node next;
		
		public Node(String _value, Node _next) {
			this.value = _value;
			this.next = _next;
		}	
		
	}
	
	private class Iterra implements Iterator<String>{

		private Node currentPosition = _head;
		
		@Override
		public boolean hasNext() {
			return currentPosition.next != null;
		}

		@Override
		public String next() {
			String result = currentPosition.next.value;
			currentPosition = currentPosition.next;
			return result;
		}
		
	}

	@Override
	public Iterator<String> iterator() {		
		return new Iterra();
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
	public void add(String item) {
		Node cursor = _head;
		while (cursor.next != null) {
			cursor = cursor.next;
		}
		cursor.next = new Node(item, null);
		_size++;
	}

	@Override
	public boolean remove(String item) {
		Node cursor = _head;
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
	public boolean contains(String item) {
		Node cursor = _head.next;
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
	public String[] toArray() {
		String[] result = new String[_size];
		int index = 0;
		Node cursor = _head.next;
		while (cursor != null) {
			result[index++] = cursor.value;
			cursor = cursor.next;
		}
		return result;
	}

	@Override
	public int indexOf(String item) {
		Node cursor = _head.next;
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
	public int lastIndexOf(String item) {
		Node cursor = _head.next;
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
	public void insert(int index, String item) {
		if (index < 0 || index >= _size)
			throw new InvalidParameterException();
		Node cursor = _head;
		int current = 0;
		while(cursor != null && current++ < index){
			cursor = cursor.next;
		}
		Node n = new Node(item, cursor.next);
		cursor.next = n;
		_size++;
	}

	@Override
	public String get(int index) {
		if (index < 0 || index >= _size)
			throw new InvalidParameterException();
		Node cursor = _head.next;
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
		Node cursor = _head.next;
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
