
public class Vector {
	private final int size ;
	private double array[] ;
	
	public Vector(int size)
	{
		this.size = size;
		this.array = new double[size];
	}
	
	public Vector(double [] array)
	{
		this.size = array.length;
		this.array = new double [this.size];
		 System.arraycopy(array, 0, this.array, 0,array.length);
	}
	public Vector(Vector obj)
	{
		this.size = obj.size;
		this.array = new double [obj.size];
		 System.arraycopy(obj.array, 0, this.array, 0,array.length);
	}
	public Vector add(Vector obj)
	{
		if( this.size != obj.size )
		{
			throw new IllegalArgumentException("Wektora mają różny rozmiar");
		}
		Vector v = new Vector (size);
		for (int i = 0 ; i < size ; i++ )
			v.array[i] = this.array[i] + obj.array[i];
		return v;
			
	}
	
	public Vector substract(Vector obj)
	{
		if( this.size != obj.size )
		{
			throw new IllegalArgumentException("Wektora mają różny rozmiar");
		}
		Vector v = new Vector (size);
		for (int i = 0 ; i < size ; i++ )
			v.array[i] = this.array[i] - obj.array[i];
		return v;
			
	}
	public void modifyVector(int element,double value)
	{
		array[element] = value;
	}
	
	public int getLength()
	{
		return size;
	}
	
	public double getElement(int element)
	{
		return array[element];
	}
	public double scalar(Vector obj)
	{
		
		if( this.size != obj.size )
		{
			throw new IllegalArgumentException("Wektora mają różny rozmiar");
		}
		double result = 0;
		for (int i = 0 ; i < size ; i++ )
			result += this.array[i]*obj.array[i];
		return result;
	}
	@Override
	public String toString() {
		 StringBuilder s = new StringBuilder();
	        s.append('[');
	        for (int i = 0; i < size; i++) {
	            s.append(array[i]);
	            if (i < size-1) s.append(", ");
	        }
	        s.append(']');
	        return s.toString();
	}
}
