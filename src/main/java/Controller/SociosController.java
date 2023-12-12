package Controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Socios;
import Model.SociosDAO;


@WebServlet("/SociosController")
public class SociosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 //constuctor vacio
    public SociosController() {
        super();
        
    }

	//metodo doget
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = null;
		SociosDAO socioDAO = null;
		
		
	
		try {
			socioDAO= new SociosDAO();
			
			
			
			
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		}
		RequestDispatcher dispacher = null;
		accion=request.getParameter("accion");
		
		if (accion == null || accion.isEmpty()) {
		    dispacher = request.getRequestDispatcher("Vistas/socios.jsp");
		} else if (accion.equals("modificar")) {
			 dispacher = request.getRequestDispatcher("Vistas/modificar.jsp");
		    // Aquí deberías manejar la lógica para obtener el socio a modificar
		    // y redirigir a la página adecuada para la modificación
		} else if (accion.equals("actualizar")) {
			
		    // Aquí deberías manejar la lógica para actualizar los datos del socio
			int id = Integer.parseInt(request.getParameter("id"));
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			int dni = Integer.parseInt(request.getParameter("dni"));
			String mail = request.getParameter("email");
			// Imprimir los valores obtenidos por consola
			System.out.println("ID: " + id);
			System.out.println("Nombre: " + nombre);
			System.out.println("Apellido: " + apellido);
			System.out.println("DNI: " + dni);
			System.out.println("Correo electrónico: " + mail);
			Socios socio = new Socios(id, nombre, apellido, dni, mail, true, LocalDate.now());
			socioDAO.modificarSocio(socio);
			dispacher = request.getRequestDispatcher("Vistas/socios.jsp");
		} else if (accion.equals("eliminar")) {
		    // Aquí deberías manejar la lógica para eliminar un socio
			int id_s = Integer.parseInt(request.getParameter("id"));

			socioDAO.eliminarSocio(id_s);
			dispacher = request.getRequestDispatcher("Vistas/socios.jsp");
		} else if (accion.equals("agregar")) {
			 dispacher = request.getRequestDispatcher("Vistas/nuevo.jsp");
		    // Aquí deberías manejar la lógica para crear un nuevo socio
		} else if (accion.equals("insert")) {
		    // Aquí deberías manejar la lógica para insertar los datos de un nuevo socio
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			int dni = Integer.parseInt(request.getParameter("dni"));
			String mail = request.getParameter("email");

			Socios socio = new Socios(0, nombre, apellido, dni, mail, true, LocalDate.now());
			socioDAO.insertarSocio(socio);
			 dispacher = request.getRequestDispatcher("Vistas/socios.jsp");
		}

		dispacher.forward(request, response);
		
	}

	 //metodo dopost
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
