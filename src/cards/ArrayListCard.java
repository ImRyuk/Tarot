package cards;

import java.io.Serializable;
import java.util.Random;

public class ArrayListCard implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	private Object [] data;
	private int 	DEFAULT_CAPACITY = 10;
	public int		size;
	private int 	maxSize;
	
	public ArrayListCard() 
	{
		data = new Card[DEFAULT_CAPACITY];
		maxSize = DEFAULT_CAPACITY;
		size = 0;
	}
	public int size() {return size;}
	
	public boolean add(Object e) 
	{
		resizeIfNecessary();
		data[size++] = e;
		return true;
	}
	
	public boolean remove(int index) {
		System.out.println(this.get(index));
	    if (index < 0 || index >= size-1) {
	        // FYI, this would be thrown anyway; not sure if you need to do it
	        throw new IndexOutOfBoundsException("Index out of bounds.");
	    }
	    for(int i = 0; i < this.size; i++){
	        if (i == index) {
	            this.data[i] = null;
	            //Then we modify each object's position from its actual position to the precedent one in order to get rid of the object we'll delete 
	            for(int j = i; j < this.size; j++) {
	            	this.data[j] = this.data[j+1];
	            }
	            //We decremente the size of the ArrayList
	            size--;
	        }
	    }
	    return true;
	}
	
	//Searching with the index
	public Object get(int index) 
	{
		if(index < 0 || index > size-1)
			throw new IndexOutOfBoundsException("Index out of bounds.");
		return data[index];
	}
	
	//Searching with the name
	public Object get(String name)
	{
		Object e = null;
		for(int i = 0; i < this.size; i++){
	        if (this.data[i].toString() == name) {
	            e = this.data[i];
	        }
	    }
		return e;
		
	}
	
	public void shuffleArray() {
        int n = this.size;
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(this.data, i, change);
        }
    }
	
	private static void swap(Object[] a, int i, int change) {
        Object helper = a[i];
        a[i] = a[change];
        a[change] = helper;
    }
	
	private void resizeIfNecessary() 
	{
		if (size + 1 > maxSize)
		{
			Object [] newData = new Object[maxSize + DEFAULT_CAPACITY];
			System.arraycopy(data, 0, newData, 0, maxSize);
			data = newData;
			maxSize = maxSize + DEFAULT_CAPACITY;
		}
	}

}