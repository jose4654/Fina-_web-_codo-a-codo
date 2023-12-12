<%@page import="Model.SociosDAO"  %>
<%@page import="Model.Socios"%>
<%@page import="java.util.List"%>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>modificar</title>
    <!-- Enlace a Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <div class="container mt-5">
    	<%
		String id=request.getParameter("id");
		int mid;
		mid=Integer.parseInt(id);
		Socios resultado=null;
		SociosDAO socio=new SociosDAO();
		resultado=socio.obtenerSocioPorId(mid);
		%>
      <form action="SociosController?accion=actualizar" method="post">
    <h2 class="text-center mb-4">Modificar Socio</h2>
 
<div class="form-group">
    <label for="id">ID:</label>
    <input type="text" class="form-control" id="id" name="id" value="<%=resultado.getId_s() %>" placeholder="Ingresa el ID">
</div>

    <div class="form-group">
        <label for="nombre">Nombre:</label>
       <input type="text" class="form-control" id="nombre" name="nombre" value="<%=resultado.getNombre() %>" placeholder="Ingresa tu nombre">

    </div>
    <div class="form-group">
        <label for="apellido">Apellido:</label>
        <input type="text" class="form-control" id="apellido" name="apellido" value="<%=resultado.getApellido() %>" placeholder="Ingresa tu apellido">
    </div>
    <div class="form-group">
        <label for="dni">DNI:</label>
        <input type="text" class="form-control" id="dni" name="dni" value="<%=resultado.getDni() %>" placeholder="Ingresa tu DNI">
    </div>
    <div class="form-group">
        <label for="email">Correo electrónico:</label>
        <input type="email" class="form-control" id="email" name="email" value="<%=resultado.getEmail() %>" placeholder="Ingresa tu correo electrónico">
    </div>
    <button type="submit" class="btn btn-primary">Actualizar</button>
</form>

    </div>
    
</body>
</html>