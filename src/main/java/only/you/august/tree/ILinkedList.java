package only.you.august.tree;

public interface ILinkedList<T> extends Iterable<T>{

	int size();
	boolean isEmpty();
	void add(T item);
	void insert(int index, T item);
	boolean remove(T item);
	boolean contains(T item);
	void clear();
	Object[] toArray();
	int indexOf(T item);
	int lastIndexOf(T item);
	T get(int index);
}
