/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import apppedidosrestaurante.ManejoJSON;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rociomera
 */
public class Menu {
    List<Producto> productos;
    
    public Menu(){
        //cargar los producto al menu
        productos = new ArrayList<>();
        
//        productos.add(new Producto("cafe expresso", "cafe en agua 200ml", Categoria.BEBIDAS, 1.00, new String[]{"cafe","azucar"},"cafe.jpeg"));
//        productos.add(new Producto("te helado", "200ml de te de manzana", Categoria.BEBIDAS, 1.25, new String[]{"menta","te manzana","azucar"},"te_helado.jpeg"));
//        productos.add(new Producto("papas fritas", "250 gr de papas con salsas", Categoria.SAL, 1.50, new String[]{"papas"},"papas_fritas.jpg"));
//        productos.add(new Producto("humitas", "choclo tierno y queso envuelto en hoja de choclo", Categoria.SAL, 1.75, new String[]{"choclo","queso","mantequilla"},"humitas.jpeg"));
//        productos.add(new Producto("muchin", "mezcla de yuca rallada y queso frita", Categoria.SAL, 0.75, new String[]{"yuca","queso","mantequilla","huevo"},"muchin.png"));
//        productos.add(new Producto("cheesecake", "cheesecake de frutilla", Categoria.DULCE, 2.99, new String[]{"queso","frutillas","azucar","harina"},"cheescake.jpeg"));
//        productos.add(new Producto("mojada chocolate", "torta mojada de chocolate", Categoria.DULCE, 1.99, new String[]{"chocolate","harina","mantequilla","azucar"},"torta_chocolate.jpeg"));   
    
        productos = ManejoJSON.cargarProductos();
    }
    
    public List<Producto> getProductos(){
        return productos;
    }
    
    
    public List<Producto> getProductosPorCategoria(Categoria cat){
        List<Producto> productos_cat = new ArrayList<>();
        for(Producto p: productos){
            if(p.getCategoria().equals(cat))
            productos_cat.add(p);
        }
        return productos_cat;
    }
    
    //TODO: si el producto ya existe se debe lanzar un excepcion 
    public void addProducto(Producto p){
        if(!productos.contains(p))
            productos.add(p);
    }
            
    
}
