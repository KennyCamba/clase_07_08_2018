/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppedidosrestaurante;

import com.sun.javafx.collections.ElementObservableListDecorator;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import modelo.Categoria;
import modelo.Menu;
import modelo.Producto;

/**
 *
 * @author Estudiante
 */
public class VenuPare {
    // root como borderpane
    //flowpane me permite colocar los elemntos uno aldo del otro y si no hay espcaio se posciciona en la siguiente fila
    // ponemos un contenedor par poder mas elemntos demtro
    // dentro de los elemtnos pongo contenedores y de alli ponemos los elemtnos centrados , ponemos el posiconamiento para poner el centro
    
    private BorderPane root;
    private Menu menu;
    private CarritoCompras carrito;
    private VBox delta ;
    private Label lbl_total;
    public VenuPare(){// menu border pane
        menu = new Menu();// inicializo esta clase
        lbl_total = new Label();
        root = new BorderPane();
        carrito=new CarritoCompras();
        root.setPrefSize(600, 500);
//        root.setMinHeight(500); controlamos la pantalla minimo de la pantalla pero basico
//        root.setMinWidth(600);
        
        
        // no vamos a crear todo en un mismo contrsutctor 
        //primero creamos uno para el top 
        //2 creamos otro los de derecho y de alli otro para izquierdo
        root.setTop(crearTop());// con esto de aki seteamos en el top el lavel creado al llamar a la funcion para poder obteneerlo
        root.setCenter(crearCentro());
        root.setRight(crearDerecha());
    }
    private HBox crearTop(){
        Label titulo = new Label("VENTAS EMPANADAS DE MAMITA");
        HBox hb=new HBox(titulo);
        hb.setAlignment(Pos.CENTER);
        return hb;
    }
    
    private Pane crearCentro(){
        VBox center = new VBox();
              
        FlowPane fp = new FlowPane();
        fp.setHgap(10);// para dejar espacio horizontal 
        fp.setVgap(10);// para dejar espacio vertical
        
        HBox top = new HBox();
        top.setSpacing(20);
        
        ObservableList<Categoria> options = FXCollections.observableArrayList(
            Categoria.DULCE,
            Categoria.SAL,
            Categoria.BEBIDAS
        );
        
        ComboBox cmb = new ComboBox(options);
        cmb.setOnAction((event) -> {
            fp.getChildren().clear();
            for (Producto p : menu.getProductos()){
            // crear vbox
            if (p.getCategoria().equals(cmb.getSelectionModel().selectedItemProperty().getValue())) {
                VBox boxpro = new VBox();
            // agregar la inagen 
            // creando imagen
            
            Image imag = new Image(CONSTANTES.RUTA_IMAGENES+p.getImagenNombre(),70,70,true,true);
            //* creamos imagen al image view
            ImageView produc = new ImageView(imag);
            produc.setOnMouseClicked((event1)->{
                carrito.agregaCarrito(p);
                lbl_total.setText(String.valueOf(carrito.getValor()));
                VBox elem = new VBox();
                elem.setSpacing(3);                        
                Label lblNombre = new Label (String.format("%s: $%.2f",
                        p.getNombre(),p.getValor()));
                Button btnELiminar = new Button("Elminar ");
                btnELiminar.setOnAction((event2)->{
                    carrito.eliminarProducto(p);
                    delta.getChildren().remove(elem);
                    lbl_total.setText(String.valueOf(carrito.getValor()));
                });
                elem.getChildren().addAll(lblNombre,btnELiminar);
               delta.getChildren().add(elem);
               
            });
            
            //agregar alvbox un label con el nombre y un label con el precio
            fp.getChildren().addAll(produc,new Label(p.getNombre()+p.getValor()));
            // agregar el vbox al flow pane
            fp.getChildren().add(boxpro);
            
            // interfaz apra manejar eventos event handler
            // definimos con el metodo hanbdler
            
            boxpro.setOnMouseClicked((evento)->{
            Label la = new Label(p.getNombre());
            delta.getChildren().add(la);
        });
            
            
            //fp.getChildren().add(new Label(p.getNombre()+p.getValor()));
        
            // agregar al vbox un label con nombre
            //agregar al vbox un label con precio
            // agregar bel bvox al flowpanel 
           
            
            // cuando trabajamos uan variable constante para utilizarla para las constante por defecto dentro de la aplicacion
            // esto trbaja en el directorio de raiz y no dentro de los paquetes
            
            
        
        
//        fp.getChildren().add(new Label("elemento 1"));// aqui añadimos a nuestro flowpane un label 
//        fp.getChildren().add(new Label("elemento 2"));
//        fp.getChildren().add(new Label("elemento 3"));
//        fp.getChildren().add(new Label("elemento 4"));
            }
            
        }
        });
        
        Button btnNUevo = new Button("Nuevo Producto");
        
        
        btnNUevo.setOnAction(new AddEvt());
         
        
        top.getChildren().addAll(cmb, btnNUevo);
        
        center.getChildren().addAll(top, fp);
        return center;
    }
    
    private Pane crearDerecha(){
        Label l1= new Label("compras wii");
        VBox h1=  new VBox();
        h1.setSpacing(10);
        h1.setAlignment(Pos.TOP_LEFT);
        h1.setPrefWidth(200);
        delta = new VBox();
        delta.setSpacing(10);
        h1.setStyle("-fx-background-color:#0000FF;-fx-padding: 10 10 10 10;");
        
//        
//        for (int i =0; i <3;i++){
//            delta.getChildren().add(new Label ("producto"+i));
//        }
        
        HBox total = new HBox(new Label("TOTAL: $"),lbl_total);
        total.setSpacing(15);
        
        Button fin = new Button("finalizacion ");
        h1.getChildren().addAll(delta,total,fin);
        fin.setOnAction((event)->{ System.out.println("Gracias por su compra :v");Platform.exit();
           ;});
        return h1;
        
    }
    
    
    
    public Pane GetRoot(){
        return root;
    }
    
    
    
}
//hacer la clase carrito de comrpas va a tener una lsita de los productos que voy comrpando y esta clase me va a calcular le total a apgar
// tenemos mostrar nombre y precio y de alli eleminar el nombre de las cosas del carrito
// añadimos el botton elimar el elemtno del carrito
// implemnetar metodo carrito y metodo de eliminar