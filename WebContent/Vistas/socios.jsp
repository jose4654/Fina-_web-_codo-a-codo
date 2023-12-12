<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import= "Model.SociosDAO" %>
<%@page import= "Model.Socios" %>
<%@page import= "java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabla de Socios</title>
    <!-- Enlace a Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4">Tabla de Socios</h2>
        <table class="table">
            <thead>
                <tr>
                    <th>id</th>
                    <th>Nombre</th>
                    <th>DNI</th>
                    <th>Fecha Alta</th>
                    <th>Modificar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            
            <%
            List<Socios> resultado=null;
            SociosDAO socios = new SociosDAO();
            resultado =socios.listaSocios();
            for(int i=0 ;i<resultado.size();i++){
            	String ruta = "SociosController?accion=modificar&id=" + resultado.get(i).getId_s();
            	String rutae = "SociosController?accion=eliminar&id=" + resultado.get(i).getId_s();

            	
            
            %>
            <tr>
            <td><%= resultado.get(i).getId_s() %></td>
            <td><%= resultado.get(i).getNombre() %></td>
            <td><%= resultado.get(i).getDni() %></td>
            <td><%= resultado.get(i).getFecha_alta() %></td>
            <td><a href="<%=ruta%>" class="btn btn-primary">Modificar</a></td>
            <td><a href="<%=rutae%>" class="btn btn-danger">Eliminar</a></td>

            
            
          
                    
                   
                
            </tr>
            
            <%
            } 
            %>
         
        </table>
        <!-- Botón "Agregar" para dirigir a otra página -->
        <div class="text-center">
            <a href="SociosController?accion=agregar" class="btn btn-success">Agregar</a>
        </div>
    </div>

    <!-- Scripts de Bootstrap JS (opcional, si los necesitas) -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
