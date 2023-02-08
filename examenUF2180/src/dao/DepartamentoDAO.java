package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import conexion.ConexionBD;

import modelo.Departamento;

public class DepartamentoDAO {
	
	private ConexionBD conexion;
	
	public DepartamentoDAO() {
        this.conexion = new ConexionBD();
    }
	
	public int insertarDepartamento(Departamento departamento) {
    	Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		int resultado=0;
		
		try {
			consulta = con.prepareStatement("INSERT INTO Departamentos (cod_departamento, cod_centro, "
					+ "tipo_dir, presupuesto, cod_dpto_jefe, nombre)"
					+ " VALUES (?,?,?,?,?,?) ");
			
			
			consulta.setInt(1, departamento.getCod_departamento() );
			consulta.setInt(2, departamento.getCod_centro());
			consulta.setString(3, departamento.getTipo_dir());
			consulta.setInt(4, departamento.getPresupuesto());
			consulta.setInt(5, departamento.getCod_dpto_jefe());
			consulta.setString(6, departamento.getNombre());
			
			resultado=consulta.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar la inserci�n del centro: "
		        +e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
    }
    
    public ArrayList<Departamento> obtenerDepartamentos() {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		Statement consulta = null;
		ResultSet resultado = null;
		ArrayList<Departamento> lista = new ArrayList<Departamento>();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from departamentos");
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			while(resultado.next()) {
				int cod_departamento = resultado.getInt("cod_departamento");
				int cod_centro = resultado.getInt("cod_centro");
				String tipo_dir = resultado.getString("tipo_dir");
				int presupuesto = resultado.getInt("presupuesto");
				int cod_dpto_jefe = resultado.getInt("cod_dpto_jefe");
				String nombre = resultado.getString("nombre");
				
				Departamento de = new Departamento(cod_departamento, cod_centro, tipo_dir, 
						presupuesto, cod_dpto_jefe, nombre);
				lista.add(de);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre centros: "+e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return lista;
    }
    
    public Departamento obtenerDepartamento(int cod_departamento) {
    	// Obtenemos una conexion a la base de datos.
    			Connection con = conexion.getConexion();
    			PreparedStatement consulta = null;
    			ResultSet resultado = null;
    			Departamento de=null;
    			
    			try {
    				consulta = con.prepareStatement("select * from departamentos"
    						+ " where cod_departamento = ?");
    				consulta.setInt(1, cod_departamento);
    				resultado=consulta.executeQuery();
    				
    				// Bucle para recorrer todas las filas que devuelve la consulta
    				if (resultado.next()) {
    					int cod_centro = resultado.getInt("cod_centro");
    					String tipo_dir = resultado.getString("tipo_dir");
    					int presupuesto = resultado.getInt("presupuesto");
    					int cod_dpto_jefe = resultado.getInt("cod_dpto_jefe");
    					String nombre = resultado.getString("nombre");
    					
    					
    					de = new Departamento(cod_departamento, cod_centro, tipo_dir, presupuesto, cod_dpto_jefe, nombre);
    				}
    				
    			} catch (SQLException e) {
    				System.out.println("Error al realizar la consulta sobre departamentos: "
    			         +e.getMessage());
    			} finally {
    				try {
    					resultado.close();
    					consulta.close();
    					conexion.desconectar();
    				} catch (SQLException e) {
    					System.out.println("Error al liberar recursos: "+e.getMessage());
    				} catch (Exception e) {
    					
    				}
    			}
    			return de;
    }

	
}
