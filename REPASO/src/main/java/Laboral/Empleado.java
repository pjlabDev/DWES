/**
 * 
 */
package Laboral;

/**
 * @author pedro
 *
 */
public class Empleado extends Persona{
	
	//Atributos
	
	private int categoria;
	int anyos;
	
	public Empleado(String nombre, String dni, char sexo, int categoria, int anyos) throws DatosNoCorrectosException {
		
		super(dni, dni, sexo);
		this.setCategoria(categoria);
		if(anyos<0) {
			throw new DatosNoCorrectosException("Anyos no correctos");
		}else {
			this.anyos = anyos;
		}
	
	}
	
	
	public Empleado(String nombre, String dni, char sexo) {
		
		super(dni, dni, sexo);
		
		this.categoria = 1;
		this.anyos = 0;
	
	}


	public int getCategoria() {
		return categoria;
	}


	public void setCategoria(int categoria) throws DatosNoCorrectosException {
		
		if(categoria >= 1 && categoria <= 10) {
			this.categoria = categoria;
		}else {
			throw new DatosNoCorrectosException("Categoria incorrecta");
		}
		
	}
	
	public int incrAnyo() {
		
		return anyos++;
		
	}
	
	
	public String imprime() {
		
		return nombre + dni + sexo + categoria + anyos;
		
	}
	
	public void setSexo(char sexo) throws DatosNoCorrectosException  {
		if(sexo == 'M' || sexo == 'F') {
			this.sexo = sexo;
		}else {
			throw new DatosNoCorrectosException("Este sexo no existe.");
		}
	}
	
	
}
