package model;

public class Empresa {

	private String nombre;
	private String contacto;
	public Empresa(String nombre, String contacto) {
		super();
		this.nombre = nombre;
		this.contacto = contacto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", contacto=" + contacto + "]";
	}
	
	
}
