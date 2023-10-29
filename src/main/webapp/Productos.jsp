<%@ page
        language="java"
        contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1" %>
<%@ page
        import="java.util.List" %>
<%@ page
        import="models.*" %>
<%@ page
        import="models.Productocl2" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1">
    <title>
        Bootstrap
        demo</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous">
</head>
<body class="d-flex flex-column"
      style="min-height: 100vh">
<header>

    <nav class="navbar bg-body-tertiary">
        <div class="container-fluid">
            <%
                HttpSession sesssion = request.getSession();
                TblUsuariocl2 usuario = (TblUsuariocl2) sesssion.getAttribute("user");
                if(usuario != null){
            %>
                <a class="navbar-brand">Bienvendio Usuario : <%=usuario.getUsuariocl2().toUpperCase() %></a>
            <% }else{ %>
                <a class="navbar-brand">Bienvendio Usuario : INICIE SESION</a>
            <% } %>
        </div>
    </nav>
</header>

<main style="margin: 50px 100px">
    <h2 class="text-center">
        Mantenimiento
        Producto</h2>
    <div class="d-flex gap-4 mt-4">
        <div style="flex: 2">
            <form action="/app/ServletProducto"
                  method="post">
                <input type="hidden"
                       name="accion"
                       value="guardar">
                <div class="mb-3">
                    <label class="form-label">Codigo</label>
                    <input type="text"
                           class="form-control"
                           id="id"
                           name="id"
                           value="0"
                           readonly="readonly">
                </div>
                <div class="mb-3">
                    <label class="form-label">Nombre</label>
                    <input type="text"
                           class="form-control"
                           id="nombrecl2"
                           name="nombrecl2">
                </div>
                <div class="mb-3">
                    <label class="form-label">Precio Venta</label>
                    <input type="text"
                           class="form-control"
                           id="precioventacl2"
                           name="precioventacl2">
                </div>
                <div class="mb-3">
                    <label class="form-label">Precio Compra</label>
                    <input type="text"
                           class="form-control"
                           id="preciocompcl2"
                           name="preciocompcl2">
                </div>
                <div class="mb-3">
                    <label class="form-label">Estado</label>
                    <input type="text"
                           class="form-control"
                           id="estadocl2"
                           name="estadocl2">
                </div>
                <div class="mb-3">
                    <label class="form-label">Descripcion</label>
                    <input type="text"
                           class="form-control"
                           id="descripcl2"
                           name="descripcl2">
                </div>
                <button type="submit"
                        class="btn btn-primary">
                    Submit
                </button>
                <button type="button"
                        class="btn btn-warning"
                        onclick="Limpieza()">
                    Limpieza
                </button>
            </form>
        </div>
        <div style="flex: 4">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">
                        Codigo
                    </th>
                    <th scope="col">
                        Nombre
                    </th>
                    <th scope="col">
                        Precio Venta
                    </th>
                    <th scope="col">
                        Precio Compra
                    </th>
                    <th scope="col">
                        Estado
                    </th>
                    <th scope="col">
                        Descripcion
                    </th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <% List<Productocl2> list = (List<Productocl2>) request.getAttribute("list"); %>
                <% for (Productocl2 prod : list) { %>
                <tr>
                    <th scope="row"><%=prod.getId() %></th>
                    <td><%=prod.getNombrecl2() %></td>
                    <td><%=prod.getPrecioventacl2() %></td>
                    <td><%=prod.getPreciocompcl2() %></td>
                    <td><%=prod.getEstadocl2() %></td>
                    <td><%=prod.getDescripcl2() %></td>
                    <td class="d-flex text-center gap-3 ">
                        <a class="btn btn-success" onclick="Buscar('<%=prod.getId() %>','<%=prod.getNombrecl2() %>','<%=prod.getPrecioventacl2() %>','<%=prod.getPreciocompcl2() %>','<%=prod.getEstadocl2() %>','<%=prod.getDescripcl2() %>')">Editar</a>
                        <form action="/app/ServletProducto" method="post" onsubmit="return confirm('Seguro de eliminar este producto??')">
                            <input type="hidden" name="accion" value="eliminar">
                            <input type="hidden" name="idEliminar" value="<%=prod.getId() %>">
                            <button type="submit" class="btn btn-danger">Eliminar</button>
                        </form>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>

</main>

<div class="bg-body-tertiary pb-3 pb-"
     style="margin-top: auto;">
    <br/>
    <footer class="mx-4">
        <p>
            &copy;
            Mi
            aplicación
            JPA</p>
    </footer>
</div>
<script src="https://code.jquery.com/jquery-3.7.1.js"
        integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
<script>
    function Buscar(codigo, nombre, venta, compra, estado, descr) {
        $('#id').val(codigo)
        $('#nombrecl2').val(nombre)
        $('#precioventacl2').val(venta)
        $('#preciocompcl2').val(compra)
        $('#estadocl2').val(estado)
        $('#descripcl2').val(descr)
    }

    function Limpieza() {
        $('#id').val(0)
        $('#nombrecl2').val("")
        $('#precioventacl2').val("")
        $('#preciocompcl2').val("")
        $('#estadocl2').val("")
        $('#descripcl2').val("")
    }
</script>
</body>
</html>