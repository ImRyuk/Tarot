package cards;

public class ArrayListCard {
	
	private Object [] data;
	private int 	DEFAULT_CAPACITY = 10;
	private int		size;
	private int 	maxSize;
	
	public ArrayListCard() 
	{
		data = new Object[DEFAULT_CAPACITY];
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
	
	public Object get(int index) 
	{
		if(index < 0 || index > size-1)
			throw new IndexOutOfBoundsException("Index out of bounds.");
		return data[index].toString();
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