/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppedidosrestaurante;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Categoria;

import modelo.Producto;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author miguel
 */
public class ManejoJSON {
    
    public static List<Producto> cargarProductos() {
        List<Producto> productos = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            String fileContent = new String(Files.readAllBytes(Paths.get("./src/recursos/productos")));
            Object obj = parser.parse(fileContent);
            JSONArray array = (JSONArray)obj;

            array.forEach((o) -> {
                try {
//                    productos.add((Producto)o);
                    Object o1 = parser.parse(o.toString());
                    JSONObject jo = (JSONObject) o1;
                    
                    
                    JSONArray arr = (JSONArray)jo.get("ingredientes");
                    
                    Iterator i = arr.iterator();
                    String[] ingredientes = new String[arr.size()];
                    int j = 0;
                    while(i.hasNext()) {
                        ingredientes[j] = (String)i.next();
                        j++;
                    }
                    
                    productos.add(new Producto((String)jo.get("nombre"), (String)jo.get("descripcion"), 
                            Categoria.valueOf((String)jo.get("categoria")), (double)jo.get("valor"),
                            ingredientes, (String)jo.get("imagen")));  
                } catch (ParseException ex) {
                    Logger.getLogger(ManejoJSON.class.getName()).log(Level.SEVERE, null, ex);
                } 
                
            });
        } catch (ParseException | 
                IOException e) {
            System.err.println(e);
        }
        return productos;
    }
    
}
