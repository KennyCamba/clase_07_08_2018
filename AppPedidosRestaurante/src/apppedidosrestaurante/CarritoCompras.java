/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppedidosrestaurante;

import java.util.ArrayList;
import modelo.Producto;

/**
 *
 * @author Juampiece
 */
public class CarritoCompras {
    private double valor;
    private ArrayList<Producto> productos ;

    public CarritoCompras() {
        productos = new ArrayList<>();
    }
    
    
    public void agregaCarrito(Producto p){
        productos.add(p);
        valor+=p.getValor();
        System.out.println(productos);
    }
    public void eliminarProducto(Producto p){
        productos.remove(p);
        valor-=p.getValor();
        System.out.println(productos);
    }
    public double getValor(){
        return valor;
    }
    
}
