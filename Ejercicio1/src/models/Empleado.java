package models;

import java.io.Serializable;

public class Empleado implements Serializable {


	private static final long serialVersionUID = 5235773145224014142L;
	
	private String empresa;
	private int edad;
	private int numeroEmpleado;

	public Empleado(String empresa, int edad, int numeroEmpleado) {
		super();
		this.empresa = empresa;
		this.edad = edad;
		this.numeroEmpleado = numeroEmpleado;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(int numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	@Override
	public String toString() {
		return "Empresa: " + empresa + "\n edad: " + edad + "\nNumero empleado: " + numeroEmpleado;
	}

}

