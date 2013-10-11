package circularlist;

public class CircularListLink<E> {
	
	/**
	 * Index of link
	 * @type {int}
	 */
	private int index;
	
	/**
	 * Data of the link
	 * @type {E}
	 */
	private E data;
	
	/**
	 * The next link
	 * @type {CircularListLink<E>}
	 */
	private CircularListLink<E> nextLink;
	
	/**
	 * Our constructor
	 * @param {int} index
	 * @param {E} data
	 */
	public CircularListLink(int index, E data){
		this.index = index;
		this.data = data;
		this.nextLink = null;
	}
	
	/**
	 * Sets the next CircularListLink. 
	 * We want to set the next link for the current CircularListLink provided the link that is being
	 * passed is not null
	 * @param {CircularListLink<E>} link
	 */
	public void setNextLink(CircularListLink<E> link){
		if(link != null)
			this.nextLink = link;
	}
	
	/**
	 * Gets the next CircularListLink
	 * @return {CircularListLink<E>} nextLink
	 */
	public CircularListLink<E> getNextLink(){
		return this.nextLink;
	}
	
	/**
	 * Gets the current CircularListLink's index
	 * @return {int} index
	 */
	public int getIndex(){
		return this.index;
	}
	
	/**
	 * Gets the CircularListLink's data
	 * @return
	 */
	public E getData(){
		return this.data;
	}
}
