import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class MyAbstractList<E> implements MyList<E> {
	protected int size = 0; // The size of the list

	/** Create a default list */
	protected MyAbstractList() {
	}

	/** Create a list from an array of objects */
	protected MyAbstractList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	/** Add a new element at the end of this list */
	public void add(E e) {
		add(size, e);
	}

	/** Return true if this list contains no elements */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Return the number of elements in this list */
	public int size() {
		return size;
	}

	/** Remove the first occurrence of the element o from this list.
	 *  Shift any subsequent elements to the left.
	 *  Return true if the element is removed. */
	public boolean remove(E e) {
		if (indexOf(e) >= 0) {
			remove(indexOf(e));
			return true;
		}
		else 
			return false;
	}

	public boolean addAll(MyList<E> otherList) {
		boolean modified = false;
		if(otherList.size() == 0) return modified;
		else modified = true;

		for (int i = 0; i < otherList.size(); i++) {
			add(otherList.get(i));
		}
		return modified;
	}

	public boolean removeAll(MyList<E> otherList) {
		boolean modified = false;
		for (int i = 0; i < otherList.size(); i++) {
			for (int j = 0; j < size(); j++) {
				if (otherList.get(i) == get(j)) {
					remove(get(j));
					modified = true;
				}
			}
		}
		return modified;
	}

	public boolean retainAll(MyList<E> otherList)  {
		boolean modified = false;
		boolean found;
		MyList<E> removalList = new MyArrayList<>();
		for (int i = 0; i < size(); i++) {
			found = false;
			for (int j = 0; j < otherList.size(); j++) {
				if (otherList.get(j).equals(get(i))) {
					found = true;
				}
			}
			if (found == false) {
				removalList.add(get(i));
				modified = true;
			}
		}
		if (modified) removeAll(removalList);

		return modified;
	}
}