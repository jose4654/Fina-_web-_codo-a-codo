package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion_bd {
	// Dirección del controlador JDBC para MySQL
	public String driver = "com.mysql.cj.jdbc.Driver";

	// Método para obtener una conexión a la base de datos
	public Connection getConnection() throws ClassNotFoundException {
		Connection conexion = null;
		try {
			// Carga dinámica del controlador JDBC
			Class.forName(driver);

			// Establecer la conexión a la base de datos
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/oradores", "root", "admin");

		} catch (Exception e) {
			// Manejo de excepciones: imprime el error en la consola
			System.out.println(e);
		}
		// Devuelve la conexión establecida (o null si hay un error)
		return conexion;
	}
	
	
	
	
	

	
	
	
//tiene un public stit main poque nos va decir al toque si me puedo contectar a base de datos 
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	    Connection conexion = null;
	    Conexion_bd con = new Conexion_bd(); // Instancia de la clase de conexión a la base de datos
	    
	    // Establece la conexión a la base de datos utilizando el método getConnection() de la clase Conexion_bd
	    conexion = con.getConnection();    

	    PreparedStatement ps; // Declara un objeto para una consulta preparada
	    ResultSet rs; // Declara un objeto para almacenar los resultados de la consulta

	    
	 // Prepara una consulta SQL para seleccionar todos los registros de la tabla "socios"
	    ps = conexion.prepareStatement("select * from socios"); 

	    // Ejecuta la consulta preparada y almacena los resultados en el ResultSet "rs"
	    rs = ps.executeQuery();

	    // Itera sobre los resultados del ResultSet
	    while (rs.next()) {
	        // Obtiene el valor del campo "apellido" de cada fila en el ResultSet
	        String apellido = rs.getString("apellido");

	        // Imprime el valor del campo "apellido" en la consola
	        System.out.println(apellido);
	    }

		}
	}



