/**
 * 
 */
package circularlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author James Arama
 * 
 */
public class CircularListReferenceBased<E> implements CircularList<E> {

	private CircularListLink<E> first;
	private int circularListSize;

	/**
	 * Gets index of a link 
	 * @param {CircularListLink<E>} link
	 * @return {int} index
	 */
	private int indexOf(CircularListLink<E> link) {
		if (link == null)
			return -1;

		return link.getIndex();
	}

	/**
	 * Default Constructor
	 */
	public CircularListReferenceBased() {
		this.first = null;
		this.circularListSize = 0;
	}

	/**
	 * Determines whether a list is empty. 
	 * @return {boolean} returns true if the list is empty, otherwise false
	 */
	public boolean isEmpty() {
		return this.first == null;
	}

	/**
	 * Determines the length of a list.	 
	 * @return {int} the number of elements in the list without wrapping
	 */
	public int size() {
		return this.circularListSize;
	}

	/**
	 * Removes all elements from the list.
	 */
	public void clear() {
		this.circularListSize = 0;
		this.first = null;
	}

	/**
	 * Adds a new item to the end of the list. 
	 * @param {E} item the new item to add
	 * @return {boolean} returns true if the list was modified
	 */
	public boolean add(E item) {

		if (item == null)
			return false;

		this.add(this.circularListSize++, item);

		return true;
	}

	/**
	 * Adds a new item to the list at position index. Other items are shifted,
	 * not overwritten. 
	 * @param {int} index where to add the new item
	 * @param  {E} item the new item to add
	 * @throws IndexOutOfBoundsException if index is negative
	 */
	public void add(int index, E item) throws IndexOutOfBoundsException {
		
		if(index < 0)
			throw new IndexOutOfBoundsException("The index provided is a negative value!");
		
		CircularListLink<E> link = new CircularListLink<E>(index, item);
		link.setNextLink(this.first);
		this.first = link;
	}

	/**
	 * Remove and return the item at the given index. 
	 * @param {int} index the position of the item to remove
	 * @return {E} the item that was removed
	 * @throws IndexOutOfBoundsException if index is negative
	 */
	public E remove(int index) throws IndexOutOfBoundsException {

		if (index < 0)
			throw new IndexOutOfBoundsException("The index provided is a negative value!");

		E itemToRemove = this.get(index);

		// create a new list without the item to remove
		CircularListReferenceBased<E> circularList = new CircularListReferenceBased<E>();
		for (E item : this) {
			if (item != itemToRemove)
				circularList.add(item);
		}

		// clear list
		this.clear();

		// recreate the list
		for (E item : circularList)
			this.add(item);

		// update current size
		this.circularListSize = circularList.size();

		return itemToRemove;

	}

	/**
	 * Retrieve the item at the given index without altering the list. 
	 * @param {int} index the position of the item to retrieve
	 * @return {E} the item at position index 
	 * @throws IndexOutOfBoundsException if index is negative or list is empty
	 */
	public E get(int index) throws IndexOutOfBoundsException {

		if ( index < 0 || this.size() == 0)
			throw new IndexOutOfBoundsException("The index provided is a negative value or the List is empty!");

		int n = indexOf(this.first);

		CircularListLink<E> current = this.first;

		// Keep looping till we hit our index to get the appropriate data
		while (n > index) {
			--n;
			current = current.getNextLink();
		}

		return current.getData();
	}

	/**
	 * Generate an iterator for the list. The iterator should visit the items in
	 * a circular pattern. As long as the list is not empty, it should never
	 * stop.
	 */
	public Iterator<E> iterator() {

		final CircularListReferenceBased<E> circularList = this;

		Iterator<E> itr = new Iterator<E>() {

			// the next array index to return
			private int index = 0;

			@Override
			public boolean hasNext() {
				return index < circularList.size();
			}

			@Override
			public E next() {
				if (!hasNext())
					throw new NoSuchElementException();

				return circularList.get(index++);
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}

		};

		return itr;
	}

}
