package modelo;

import java.util.Objects;

public class Departamento {
	
	private int cod_departamento;
	private int cod_centro;
	private String tipo_dir;
	private int presupuesto;
	private int cod_dpto_jefe;
	private String nombre;
	
	// Constructores
	
	public Departamento() {
		this.cod_departamento=0;
		this.cod_centro=0;
		this.tipo_dir="";
		this.presupuesto=0;
		this.cod_dpto_jefe=0;
		this.nombre="";
	}
	
	public Departamento(int cod_departamento, int cod_centro, String tipo_dir, int presupuesto, int cod_dpto_jefe,
			String nombre) {
		this.cod_departamento = cod_departamento;
		this.cod_centro = cod_centro;
		this.tipo_dir = tipo_dir;
		this.presupuesto = presupuesto;
		this.cod_dpto_jefe = cod_dpto_jefe;
		this.nombre = nombre;
	}
	
	public Departamento(Departamento d) {
		this.cod_departamento = d.cod_departamento;
		this.cod_centro = d.cod_centro;
		this.tipo_dir = d.tipo_dir;
		this.presupuesto = d.presupuesto;
		this.cod_dpto_jefe = d.cod_dpto_jefe;
		this.nombre = d.nombre;
	}
	
	
	// Getters y Setters
	
	public int getCod_departamento() {
		return cod_departamento;
	}

	public int getCod_centro() {
		return cod_centro;
	}

	public String getTipo_dir() {
		return tipo_dir;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public int getCod_dpto_jefe() {
		return cod_dpto_jefe;
	}

	public String getNombre() {
		return nombre;
	}

	public void setCod_departamento(int cod_departamento) {
		this.cod_departamento = cod_departamento;
	}

	public void setCod_centro(int cod_centro) {
		this.cod_centro = cod_centro;
	}

	public void setTipo_dir(String tipo_dir) {
		this.tipo_dir = tipo_dir;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public void setCod_dpto_jefe(int cod_dpto_jefe) {
		this.cod_dpto_jefe = cod_dpto_jefe;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	// HashCode y Equals
	
	@Override
	public int hashCode() {
		return Objects.hash(cod_departamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return cod_departamento == other.cod_departamento;
	}
	
	
	// Metodos
	
	@Override
	public String toString() {
		return "Departamento [cod_departamento=" + cod_departamento + ", cod_centro=" + cod_centro + ", tipo_dir="
				+ tipo_dir + ", presupuesto=" + presupuesto + ", cod_dpto_jefe=" + cod_dpto_jefe + ", nombre=" + nombre
				+ "]";
	}
	
	
	
	
	
	
}
