package circularlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularListArrayBased<E> implements CircularList<E> {
	private E[] circularList;
	private int circularListSize;

	/**
	 * Default Constructor
	 */
	@SuppressWarnings("unchecked")
	public CircularListArrayBased() {
		this.circularList = (E[]) new Object[1];
		this.circularListSize = 0;
	}

	/**
	 * Determines whether a list is empty. 
	 * @return {boolean} returns true if the list is empty, otherwise false
	 */
	public boolean isEmpty() {
		return this.circularListSize > 0;
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
	@SuppressWarnings("unchecked")
	public void clear() {
		this.circularListSize = 0;
		this.circularList = (E[]) new Object[1];
	}


	/**
	 * Adds a new item to the end of the list. 
	 * @param {E} item the new item to add
	 * @return {boolean} returns true if the list was modified
	 */
	@SuppressWarnings("unchecked")
	public boolean add(E item) {

		if (item == null)
			return false;

		E[] newCircularList = (E[]) new Object[this.size() + 1];

		for (int i = 0; i < this.size(); i++) {
			newCircularList[i] = this.get(i);
		}

		// add new item
		this.circularList = newCircularList;
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
		this.circularList[index] = item;
	}


	/**
	 * Remove and return the item at the given index. 
	 * @param {int} index the position of the item to remove
	 * @return {E} the item that was removed
	 * @throws IndexOutOfBoundsException if index is negative
	 */
	@SuppressWarnings("unchecked")
	public E remove(int index) throws IndexOutOfBoundsException {

		E itemToRemove = this.get(index);

		E[] newCircularList = (E[]) new Object[this.size() - 1];

		for (int i = 0; i < this.size(); i++) {
			if (this.get(i) != itemToRemove)
				newCircularList[i] = this.get(i);
		}

		this.circularListSize = this.size() - 1;

		return itemToRemove;
	}

	/**
	 * Retrieve the item at the given index without altering the list. 
	 * @param {int} index the position of the item to retrieve
	 * @return {E} the item at position index 
	 * @throws IndexOutOfBoundsException if index is negative or list is empty
	 */
	public E get(int index) throws IndexOutOfBoundsException {
		if (index > this.size() || index < 0 || this.size() == 0)
			throw new IndexOutOfBoundsException("Index: " + index
					+ " is out of bounds");

		return this.circularList[index];
	}

	/**
	 * Generate an iterator for the list. The iterator should visit the items in
	 * a circular pattern. As long as the list is not empty, it should never
	 * stop.
	 */
	public Iterator<E> iterator() {

		final CircularListArrayBased<E> circularList = this;

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
