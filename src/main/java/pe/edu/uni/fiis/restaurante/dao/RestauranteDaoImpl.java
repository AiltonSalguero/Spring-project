package pe.edu.uni.fiis.restaurante.dao;

import pe.edu.uni.fiis.restaurante.model.*;

import java.sql.*;
import java.util.ArrayList;

public class RestauranteDaoImpl implements RestauranteDAO{

    public ListaCategoriaResponse buscarCategorias() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ListaCategoriaResponse response = new ListaCategoriaResponse();
        response.setLista(new ArrayList<Categoria>());
        try{
            //Paso opcional
            Class.forName(JDBC_DRIVER);

            //Conectando a la BD
            conn = DriverManager.getConnection(DB_URL,USUARIO,CLAVE);

            //Creando sentencia
            stmt = conn.createStatement();
            String sql;
            sql = "select id_categoria,nombre from categoria where estado = '1'";
            rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Obtener valores de campos
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id_categoria"));
                categoria.setNombre(rs.getString("nombre"));
                response.getLista().add(categoria);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Manejo de excepciones JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Manejo de excepciones generales
            e.printStackTrace();
        }

        return response;
    }

    /* SQL
    create table usuario(
                        usuario varchar(60) primary key,
                        credencial varchar(60)
  );

select usuario, credencial from usuario;

create table producto(
  co_producto varchar(10) primary key,
  nombre varchar(100),
  precio numeric(9,2)
);

select co_producto, nombre, precio from producto;

insert into usuario(usuario, credencial) VALUES ('rony','miclave');

insert into producto(co_producto, nombre, precio) VALUES ('01','Libro de Spring',56.90);
insert into producto(co_producto, nombre, precio) VALUES ('02','Libro de Vuejs',56.90);
insert into producto(co_producto, nombre, precio) VALUES ('03','Libro de Bulma css',56.90);

commit;
     */
    public UsuarioResponse buscarUsuario(UsuarioRequest usuarioRequest){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioResponse response = new UsuarioResponse();
        response.setAcceso(false);
        try{
            //Paso opcional
            Class.forName(JDBC_DRIVER);

            //Conectando a la BD
            conn = DriverManager.getConnection(DB_URL,USUARIO,CLAVE);

            //Creando sentencia

            String sql;
            sql = "select usuario, credencial from usuario where usuario = ? and credencial = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,usuarioRequest.getUsuario());
            stmt.setString(2,usuarioRequest.getCredencial());
            rs = stmt.executeQuery();

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Obtener valores de campos, si existe algún valor
                response.setAcceso(true);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Manejo de excepciones JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Manejo de excepciones generales
            e.printStackTrace();
        }

        return response;
    }
    public ProductoResponse buscarProductos(ProductoRequest productoRequest){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ProductoResponse response = new ProductoResponse();
        response.setLista(new ArrayList<Producto>());
        try{
            //Paso opcional
            Class.forName(JDBC_DRIVER);

            //Conectando a la BD
            conn = DriverManager.getConnection(DB_URL,USUARIO,CLAVE);

            //Creando sentencia

            String sql;
            sql = "select co_producto, nombre, precio from producto where nombre like '%"+productoRequest.getNombre()+"%'";
            stmt = conn.prepareStatement(sql);
            //stmt.setString(1,productoRequest.getNombre());
            rs = stmt.executeQuery();

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Obtener valores de campos, si existe algún valor
                Producto p = new Producto();
                p.setCodigo(rs.getString("co_producto"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getFloat("precio"));
                response.getLista().add(p);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Manejo de excepciones JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Manejo de excepciones generales
            e.printStackTrace();
        }

        return response;
    }
}
