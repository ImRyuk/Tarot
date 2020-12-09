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
	
	public Object get(int index) 
	{
		if(index < 0 || index > size-1)
			return null;
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