/**
 * 
 */
package Laboral;

import java.io.EOFException;

/**
 * @author pedro
 *
 */
public class CalculaNominas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Ficheros f = new Ficheros();
		
		try {
			
			Empleado emp = new Empleado("James Cosling","32000032G",'M',4,7);
			Empleado emp2 = new Empleado("Ada Lovelace","32000031R",'F');
			
			
//			System.out.println(escribir(emp));
//			System.out.println("-----------------------------------");
//			System.out.println(escribir(emp2));
//			
//			
//			emp2.incrAnyo();
//			System.out.println("------------------------------------------------");
//			emp.setCategoria(9);
//	
//			
//			System.out.println(escribir(emp));
//			System.out.println("-----------------------------------");
//			System.out.println(escribir(emp2));
//			
//			
//			emp.setCategoria(-4);
//			
//			String fichero = "empleados.txt";
//			String fichero2 = "salarios.dat";
//			f.escribirFicheroTexto(emp, fichero);
//			f.escribirFicheroTexto(emp2, fichero);
//			
//			f.leerFicheroTexto(fichero);
//			
//			f.escribirFicheroBinario(emp, fichero2);
//			f.escribirFicheroBinario(emp2, fichero2);
//			
//			
//			String aCadena = emp.imprime();
//			String aCadena2 = emp2.imprime();
//			emp.setCategoria(9);
//			emp2.incrAnyo();
//			String nCadena = emp.imprime();
//			String nCadena2 = emp2.imprime();
//			
//			f.modificarEmpleadoFichero(fichero, aCadena, nCadena);
//			f.modificarEmpleadoFichero(fichero, aCadena2, nCadena2);
//			
//			System.out.println("-----------------------------------------------------------");
//			
//			f.leerFicheroTexto(fichero);
//			
//			
//			String fichero3 = "sueldos.dat";
//			
//			f.escribirFicheroBinarioDniSueldoActualizado(emp, fichero3);
//			f.escribirFicheroBinarioDniSueldoActualizado(emp2, fichero3);
//			
//			
//			f.leerFicheroBinario(fichero2);
//			f.leerFicheroBinario(fichero3);
			
			
			
			
			
			
			
			
			
			
		} catch (DatosNoCorrectosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
	
	
	
	private static String escribir(Empleado e) {
		
		Nomina n = new Nomina();
		
		return e.imprime() + " " + n.sueldo(e);
		
	}
	
	
	

}
