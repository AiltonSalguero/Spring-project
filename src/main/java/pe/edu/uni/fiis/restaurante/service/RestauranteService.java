package pe.edu.uni.fiis.restaurante.service;

import pe.edu.uni.fiis.restaurante.model.*;

public interface RestauranteService {
    public abstract ListaCategoriaResponse buscarCategorias();
    public abstract UsuarioResponse buscarUsuario(UsuarioRequest usuarioRequest);
    public abstract ProductoResponse buscarProductos(ProductoRequest productoRequest);
}
