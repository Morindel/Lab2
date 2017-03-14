
public class Matrix {

	private final int sizex;
	private final int sizey;
	private double  array[][];
	
	public int getSizex() {
		return sizex;
	}
	public int getSizey() {
		return sizey;
	}
	
	public Matrix ( int sizey , int sizex)
	{
		if( sizey != sizex)
			throw new IllegalArgumentException("To nie jest macierz kwadratowa");
		 this.sizex = sizex;
		 this.sizey = sizey;
		 this.array = new double[sizey][sizex];
	}
	public Matrix ( double array[][])
	{
		if ( array.length != array[0].length)
			throw new IllegalArgumentException("To nie jest macierz kwadratowa");
		this.sizey = array.length;
		this.sizex = array[0].length;
	    this.array = new double[sizey][sizex];
	    for (int i = 0; i < array.length; i++) {
	        System.arraycopy(array[i], 0, this.array[i], 0, array[0].length);
	    }
	
	}
	
	public void modifyElement (int y , int x , double value)
	{
		try
		{
		this.array[y-1][x-1] = value;
		}
		catch(IndexOutOfBoundsException e)
		{
			throw new IndexOutOfBoundsException("Nie poprawny numer indexu");
		}
	}
	
	public Matrix addMatrix (Matrix obj)
	{
		if(obj.sizex != sizex || obj.sizey != sizey)
			throw new IllegalArgumentException("Macierze nie sa rowne nie mozna ich dodac");
		Matrix m = new Matrix(this.sizey,this.sizex);
		 for (int i = 0; i < sizey; i++) {
	        	for(int j = 0; j < sizex; j++)
	        		m.array[i][j] = array[i][j] + obj.array[i][j];
		 }
		return m;
	        		
	}
	
	public Vector vectorMmatrix(Vector obj)
	{
		
		if(sizex != obj.getLength())
			throw new IllegalArgumentException("Liczba wierszy macierzy musi rownac sie ilosci elementow wektora");
		
		Vector v = new Vector(obj.getLength());
		for (int i = 0; i < sizey; i++) {
			double result = 0 ;
        	for(int j = 0; j < sizex; j++)
        		result+= array[i][j] * obj.getElement(i);
        	v.modifyVector(i, result);
		}
		return v;
	
	}
	public double getElement (int y , int x)
	{
		try
		{
		return this.array[y-1][x-1];
		}
		catch(IndexOutOfBoundsException e)
		{
			throw new IndexOutOfBoundsException("Nie poprawny numer indexu");
		}
	}

	
	public Matrix substractMatrix (Matrix obj)
	{
		if(obj.sizex != sizex || obj.sizey != sizey)
			throw new IllegalArgumentException("Macierze nie sa rowne nie mozna ich odjac");
		Matrix m = new Matrix(this.sizey,this.sizex);
		 for (int i = 0; i < sizey; i++) {
	        	for(int j = 0; j < sizex; j++)
	        		m.array[i][j] = array[i][j] - obj.array[i][j];
		 }
		return m;
	        		
	}
	@Override
	public String toString() {
		 StringBuilder s = new StringBuilder();
	        for (int i = 0; i < sizey; i++) {
	        	s.append("[");
	        	for(int j = 0; j < sizex; j++)
	        	{
	        		s.append(array[i][j]);
	            	if (j != sizex-1) 
	            		s.append(", ");
	        	}
	        	s.append("]");
	        	s.append("\n");
	        }
	     	        return s.toString();
	}
}
