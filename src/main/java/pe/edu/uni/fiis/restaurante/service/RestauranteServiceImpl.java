package pe.edu.uni.fiis.restaurante.service;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.uni.fiis.restaurante.dao.RestauranteDAO;
import pe.edu.uni.fiis.restaurante.model.*;

public class RestauranteServiceImpl implements RestauranteService{
    @Autowired
    private RestauranteDAO dao;
    public ListaCategoriaResponse buscarCategorias() {
        return dao.buscarCategorias();
    }

    public UsuarioResponse buscarUsuario(UsuarioRequest usuarioRequest){
        return dao.buscarUsuario(usuarioRequest);
    }
    public ProductoResponse buscarProductos(ProductoRequest productoRequest){
        return dao.buscarProductos(productoRequest);
    }

    public RestauranteDAO getDao() {
        return dao;
    }

    public void setDao(RestauranteDAO dao) {
        this.dao = dao;
    }
}

