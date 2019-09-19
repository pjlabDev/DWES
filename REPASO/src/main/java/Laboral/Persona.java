/**
 * 
 */
package Laboral;

/**
 * @author pedro
 *
 */
public class Persona {
	
	//Atributos
	
	String nombre;
	String dni;
	char sexo;
	
	/**
	 * @param args
	 */
	
	public Persona(String nombre, String dni, char sexo) {
		
		this.nombre = nombre;
		this.dni = dni;
		this.sexo =  sexo;
		
	}
	
	public Persona(String nombre, char sexo) {
		
		this.nombre = nombre;
		this.sexo = sexo;
		
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String imprime() {
		
		return nombre + " " + dni;
		
	}
	
	


}
