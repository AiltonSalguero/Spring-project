package pe.edu.uni.fiis.restaurante.model;

import java.util.List;

public class ProductoResponse {
    private List<Producto> lista;

    public List<Producto> getLista() {
        return lista;
    }

    public void setLista(List<Producto> lista) {
        this.lista = lista;
    }
}
