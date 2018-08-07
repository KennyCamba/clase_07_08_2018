/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

/**
 *
 * @author rociomera
 */
public class Producto {
    private String nombre;
    private String descripcion; //breve descripcion del producto
    private Categoria categoria;
    private double valor; //valor del producto
    private String[] ingredientes; //principales ingredientes del producto
    private String imagenNombre;
    
    public Producto(String nombre, String descripcion, Categoria categoria, 
                            double valor, String[] ingredientes, String imagen){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria =categoria;
        this.valor = valor;
        this.ingredientes = ingredientes;
        this.imagenNombre = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getImagenNombre() {
        return imagenNombre;
    }

    public void setImagenNombre(String imagen_ruta) {
        this.imagenNombre = imagen_ruta;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (this.categoria != other.categoria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", descripcion=" + descripcion + ", categoria=" + categoria + ", valor=" + valor + ", ingredientes=" + String.join(",", ingredientes) + '}';
    }
    
    
}
