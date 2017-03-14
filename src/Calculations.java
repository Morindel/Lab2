
public class Calculations {
	public static void main(String args [])
	{	
		//Wektory
		double [] x = {1.0,2.0,3.0,4.0}; 
		
		double[][] m = {{10,10,10,10},{10,10,10,10},{10,10,10,10},{10,10,10,10}};
		
		Vector v1 = new Vector(x);
		System.out.println("Wektor 1 powstaly przez skopiowanie utworzonej wczesniej tablicy (arraycopy) tablicy " + " \n" + v1);
		
		Vector v2 = new Vector(4); 
		try
		{
			for(int i = 0 ; i< v2.getLength();i++)
				v2.modifyVector(i, i);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			throw new ArrayIndexOutOfBoundsException("Wyszedles po za zakres tablicy ");
		}
		System.out.println("Wektor 2 powstaly przez wypelnienie pustej tablicy " + "\n"+  v2);
		
		Vector v3 = v1.add(v2);
		System.out.println("Wektor 1 + Wektor 2" + "\n" + v3);
		
		Vector v4 = v1.substract(v2);
		System.out.println("Wektor 1 - Wektor 2" + "\n" + v4);
		
		v1.modifyVector(1, 3);
		System.out.println("Wektor 1 po modyfikacj drugiego elemntu (2 na 3)" + "\n" + v1);
		
		System.out.println("Drugi element Wektora 2 : " + v2.getElement(1));
		
		System.out.println("Iloczyn skalarny vektora 1 i 2 : " + v1.scalar(v2));
		
		//Macierze
		Matrix m1 = new Matrix(4,4);
		try
		{
		 for (int i = 1; i <= m1.getSizex(); i++) {
	        	for(int j = 1; j <= m1.getSizey(); j++)
	        	m1.modifyElement(i, j, 5);
		 }
		}
		 catch(ArrayIndexOutOfBoundsException e)
		 {
			 throw new ArrayIndexOutOfBoundsException("Wyszedles po za macierz ");
		 }
		
		 System.out.println("Wypelnienie pustej macierzy 4x4 5-tkami" + "\n" + m1);
	 
		 Matrix m2 = new Matrix(m);
		 System.out.println("Przekazanie utworzonej wczesniej tablicy do konstruktora" + "\n" + m2);
		 
		 Matrix m3 = m1.addMatrix(m2);
		 System.out.println("Macierz 1 + Macierz 2" + "\n" + m3);
		 
		 Matrix m4 = m1.substractMatrix(m2);
		 System.out.println("Macierz 1 - Macierz 2" + "\n" + m4);
		 
		 m1.modifyElement(2, 2, 3);
		 System.out.println("Ustawienie drugiego elementu x i y macierzy pierwszej na 3 zamiast 5" + "\n" + m1);
		 
		 System.out.println("Pobranie [2,2] elementu macierzy 1 : " + m1.getElement(2, 2) );
		
		 Vector v5 = m1.vectorMmatrix(v1);
		 
		 System.out.println("Macierz 1 * wektor 1" + "\n" + v5);
	}
}
