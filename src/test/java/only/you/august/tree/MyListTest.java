package only.you.august.tree;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MyListTest {

	private ILinkedList<String> _list;

	@Before
	public void _initialize() {
		_list = new MyList<String>();
	}
	@Test
	public void _one() {
		assertThat(_list.size(), equalTo(0));
		assertTrue(_list.isEmpty());
		_list.add("1");
		_list.add("2");
		_list.add("3");
		assertThat(_list.size(), equalTo(3));
		assertFalse(_list.isEmpty());
	}

	@Test
	public void _two() {
		_list.add("one");
		_list.add("two");
		_list.add("three");
		assertThat(_list.size(), equalTo(3));
		assertTrue(_list.contains("two"));
		_list.remove("two");
		assertFalse(_list.contains("two"));
		assertThat(_list.size(), equalTo(2));
		_list.remove("five");
		assertThat(_list.size(), equalTo(2));
	}

	@Test
	public void _three() {
		_list.add("one");
		_list.add("two");
		_list.add("three");
		assertThat(_list.size(), equalTo(3));
		assertFalse(_list.isEmpty());
		_list.clear();
		assertThat(_list.size(), equalTo(0));
		assertTrue(_list.isEmpty());
	}

	@Test
	public void _four() {
		_list.add("z");
		_list.add("y");
		_list.add("x");
		_list.add("w");
		_list.add("v");
		_list.add("u");
		String concated = "";
		for (String s : _list)
			concated += s;
		assertThat(concated, equalTo("zyxwvu"));
	}
	
	@Test
	public void _five() {
		String[] from = new String[] { "zero", "one", "two", "three", "four", "five" };
		for (String s : from)
			_list.add(s);
		Object[] to = _list.toArray();
		assertThat(from.length, equalTo(to.length));
		for (int i = 0; i < to.length; i++) {
			assertThat(from[i], equalTo(to[i]));
		}
	}

	@Test
	public void _six() {
		_list.add("zero");
		_list.add("one");
		_list.add("two");
		_list.add("three");
		_list.add("four");
		_list.add("five");
		_list.add("four");
		_list.add("three");
		_list.add("two");
		_list.add("one");
		_list.add("zero");
		assertThat(_list.indexOf("zero"), equalTo(0));
		assertThat(_list.lastIndexOf("zero"), equalTo(10));
		assertThat(_list.indexOf("three"), equalTo(3));
		assertThat(_list.lastIndexOf("three"), equalTo(7));
		assertThat(_list.indexOf("non-exist"), equalTo(-1));
		assertThat(_list.lastIndexOf("non-exist"), equalTo(-1));
	}

	@Test
	public void _seven() {
		String[] src = new String[] { "zero", "one", "two", "three", "four", "five" };
		for (String s : src)
			_list.add(s);
		for (int i = 0; i < src.length; i++) {
			assertThat(_list.get(i), equalTo(src[i]));
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void _eight() {
		_list.add("zero");
		_list.add("one");
		_list.add("two");
		_list.add("three");
		_list.get(4);
	}

	@Test
	public void _nine() {
		_list.add("zero");
		_list.add("one");
		_list.add("two");
		_list.add("three");
		assertThat(_list.toString(), equalTo("{zero, one, two, three}"));
	}
	
	@Test
	public void _ten(){
		_list.add("three");		
		_list.insert(0, "two");		
		_list.insert(0, "one");		
		_list.insert(0, "zero");
		assertThat(_list.toString(), equalTo("{zero, one, two, three}"));
	}
	
	@Test
	public void _eleven(){
		_list.add("zero");
		_list.add("one");
		_list.add("two");

	}

}
