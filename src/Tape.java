

public class Tape {
	
	Cell pointer;

	/**
	 * Public constructor for the tape, wich creates a new cell with blank content already.
	 */
	public Tape() {
		
		pointer = new Cell();
		
		pointer.content = ' ';

	}
	
	/**
	 * This method is used to get the object of the cell that is in the current pointer.
	 * @return the cell that the pointer in the current position holds
	 */
	public Cell getCurrentCell() {
		
		return pointer;
		
	}
	
	/**
	 * Instead of returning the entire cell, this method returns only the 
	 * content of the cell held by the current pointer.
	 * @return the char which is the content of the cell held by the pointer in the current position
	 */
	public char getContent() {
		
		return pointer.content;
		
	}
	
	/**
	 * Sets the content of the cell for the current pointer
	 * @param ch The char which should be placed in the cell
	 */
	public void setContent(char ch) {
		
		pointer.content = ch;
		
	}
	
	/**
	 * This method moves the pointer to the left position.
	 * If there is no cell in the left position, it creates
	 * one with a blank value
	 */
	public void moveLeft() {
		
		if(pointer.prev == null){
			Cell cell = new Cell();
			cell.content = ' ';
			
			pointer.prev = cell;
			cell.next = pointer;			
		}
		
		pointer = pointer.prev;
		
	}
	
	/**
	 * This method moves the pointer to the right position.
	 * If there is no cell in the rigth position, it creates
	 * one with a blank value
	 */
	public void moveRight() {
		
		if(pointer.next == null) {
			Cell cell = new Cell();
			cell.content = ' ';
			
			pointer.next = cell;
			cell.prev = pointer;
		}
		
		pointer = pointer.next;
		
	}
	
	/**
	 * This method uses another pointer to go throughout all the
	 * tape and return each of the values in a single string
	 * @return the entire content of the tape
	 */
	public String getTapeContents() {
		
		String content = "";
		Cell selector = pointer;
		
		while(selector.prev != null) {
			
			selector = selector.prev;
			
		}
		
		while(selector.next != null) {
			
			if(!(selector.content == ' ' && selector.next == null)) {
				content += selector.content;
			}
			
			selector = selector.next;
			
		}
		
		return content;
		
	}
}
