package only.you.august.tree;

public interface ILinkedList extends Iterable<String>{

	int size();
	boolean isEmpty();
	void add(String item);
	void insert(int index, String item);
	boolean remove(String item);
	boolean contains(String item);
	void clear();
	String[] toArray();
	int indexOf(String item);
	int lastIndexOf(String item);
	String get(int index);
}
