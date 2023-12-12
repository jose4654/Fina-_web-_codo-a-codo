package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class SociosDAO {
	//declaramos una conecion 
Connection conexion = null;

public SociosDAO() throws ClassNotFoundException {
	//creamos un objeto de referencia  de la conexion de la base de datos
	Conexion_bd con = new  Conexion_bd();
	// utilizamos el metodo de la conexion
	conexion = con.getConnection();
}
public List<Socios> listaSocios(){
	 PreparedStatement ps; // Declara un objeto para una consulta preparada
	    ResultSet rs; // Declara un objeto para almacenar los resultados de la consulta
	    List<Socios> lista =new ArrayList<>();
	    try {
	    	ps=conexion.prepareStatement("select * from socios");
	    	rs = ps.executeQuery();
	    	while (rs.next()) {//mientras alla un siguiente se va ejecutar el while
	    		
	    		Socios s = new Socios(rs.getInt("id_socio"),rs.getString("nombre"),rs.getString("apellido"),rs.getInt("dni"),rs.getString("mail"),rs.getBoolean("estado"),rs.getDate("fecha_alta").toLocalDate());
	    		lista.add(s);
			}
	    	return lista;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	
}

public boolean insertarSocio(Socios socio){
    PreparedStatement ps; // Declara un objeto para una consulta preparada
    try {
        ps = conexion.prepareStatement("INSERT INTO socios (nombre, apellido, dni, mail, estado, fecha_alta) VALUES (?, ?, ?, ?, ?, ?)");
        ps.setString(1, socio.getNombre());
        ps.setString(2, socio.getApellido());
        ps.setInt(3, socio.getDni());
        ps.setString(4, socio.getEmail());
        ps.setBoolean(5, true);
        ps.setObject(6,LocalDate.now());
        ps.execute();
        
        
        return   true; // Retorna true si se insertó exitosamente
    } catch (SQLException e) {
        System.out.println(e);
        return false;
    }
    //modificar socio
}
public boolean modificarSocio(Socios socio){
    PreparedStatement ps; // Declara un objeto para una consulta preparada
    try {
    	{
   		 ps=conexion.prepareStatement("update socios set nombre=?,apellido=?,dni=?,mail=? where id_socio=?");
   		 ps.setString(1, socio.getNombre());
   		 ps.setString(2, socio.getApellido());
   		 ps.setInt(3, socio.getDni());
   		 ps.setString(4, socio.getEmail());
   		 ps.setInt(5, socio.getId_s());
   		 ps.execute();
   		return true;		
   		} } catch (SQLException e) {
        System.out.println(e);
        return false;
    }
}


public boolean eliminarSocio(int idSocio){
    PreparedStatement ps; // Declara un objeto para una consulta preparada
    try {
        ps = conexion.prepareStatement("DELETE FROM socios WHERE id_socio = ?");
        ps.setInt(1, idSocio);
        
        int resultado = ps.executeUpdate();
        return resultado > 0; // Retorna true si se eliminó exitosamente
    } catch (SQLException e) {
        System.out.println(e);
        return false;
    }
}


public Socios obtenerSocioPorId(int idSocio){
    PreparedStatement ps; // Declara un objeto para una consulta preparada
    ResultSet rs; // Declara un objeto para almacenar los resultados de la consulta
    Socios socio = null; // Inicializa el objeto Socio como nulo
    try {
        ps = conexion.prepareStatement("SELECT * FROM socios WHERE id_socio = ?");
        ps.setInt(1, idSocio);
        
        rs = ps.executeQuery();
       
        while (rs.next()) {
            socio = new Socios(  //agregamos los parametos a la instancia vacia
                rs.getInt("id_socio"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getInt("dni"),
                rs.getString("mail"),
                rs.getBoolean("estado"),
                rs.getDate("fecha_alta").toLocalDate()
            );
        }
        
        return socio;
    } catch (SQLException e) {
        System.out.println(e);
    }
    return null;
    
}






}
