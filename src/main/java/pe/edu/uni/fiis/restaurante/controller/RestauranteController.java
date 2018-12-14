package pe.edu.uni.fiis.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.uni.fiis.restaurante.model.*;
import pe.edu.uni.fiis.restaurante.service.RestauranteService;

import java.util.ArrayList;

@Controller
@RequestMapping("/servicios")
public class RestauranteController {
    @Autowired
    private RestauranteService service;


    @RequestMapping(value ="getCategorias",method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody ListaCategoriaResponse buscarCategorias(){
        /*
        ListaCategoriaResponse rs = new ListaCategoriaResponse();

        rs.setLista(new ArrayList<Categoria>());
        Categoria c = new Categoria();
        c.setId(1);
        c.setNombre("Piqueos");
        Categoria c1 = new Categoria();
        c1.setId(2);
        c1.setNombre("Parrillas");
        rs.getLista().add(c);
        rs.getLista().add(c1);
        */
        return service.buscarCategorias();
    }

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value ="getUsuario",method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody UsuarioResponse buscarUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        return service.buscarUsuario(usuarioRequest);
    }

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value ="getProductos",method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody ProductoResponse buscarProductos(@RequestBody ProductoRequest productoRequest) {
        return service.buscarProductos(productoRequest);
    }

    public RestauranteService getService() {
        return service;
    }

    public void setService(RestauranteService service) {
        this.service = service;
    }
}
