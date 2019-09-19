/**
 * 
 */
package Laboral;

/**
 * @author estudiante
 *
 */
public class CalculaNominas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			
			Empleado emp = new Empleado("James Cosling","32000032G",'M',4,7);
			
		} catch (DatosNoCorrectosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
