package pe.edu.uni.fiis.restaurante.dao;

import pe.edu.uni.fiis.restaurante.model.*;

public interface RestauranteDAO {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/ventas?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    static final String USUARIO = "ventas";
    static final String CLAVE = "ventas";
    public abstract ListaCategoriaResponse buscarCategorias();
    public abstract UsuarioResponse buscarUsuario(UsuarioRequest usuarioRequest);
    public abstract ProductoResponse buscarProductos(ProductoRequest productoRequest);
}
