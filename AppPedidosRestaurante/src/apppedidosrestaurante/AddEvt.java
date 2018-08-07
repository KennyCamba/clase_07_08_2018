/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppedidosrestaurante;


import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Categoria;
import modelo.Producto;


public class AddEvt implements EventHandler<ActionEvent> {
    private VBox root;
    private TextField nombre;
    private TextField precio;
    private TextField imagen;
    private TextArea desc;
    private TextArea ingre;
    private ComboBox<Categoria> categorias;
    private Button guardar;
    private Button cancelar;
    private Stage stage;
    private Text estado;
    
    public AddEvt() {
        root = new VBox();
        nombre = new TextField();
        precio = new TextField();
        imagen = new TextField();
        desc = new TextArea();
        ingre = new TextArea();
        categorias = new ComboBox<>();
        guardar = new Button("Guardar");
        cancelar = new Button("Cancelar");
        estado = new Text();
        estado.setFill(Color.RED); 
        
        //Solo permite que en el cuadro de texto ingresen numeros
        UnaryOperator<TextFormatter.Change> filter = change -> {
            if (change.getText().matches("[0-9]*"))
                return change;
            return null;
        };
        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        precio.setTextFormatter(textFormatter); 
    }
    
    private void vista() {
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setSpacing(20);     
        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(10); 
        desc.setMaxHeight(70);
        desc.setMaxWidth(250);
        ingre.setMaxHeight(70);
        ingre.setMaxWidth(250);
        grid.addColumn(0, new Label("Nombre"), new Label("Precio"), 
                new Label("Descripcion"), new Label("Categoria"), 
                new Label("Ingredientes"), new Label("Imagen"));
        grid.addColumn(1, nombre, precio, desc, categorias, ingre, imagen);
        categorias.getItems().addAll(Categoria.values());
        root.getChildren().addAll(new Label("Nuevo Producto"), grid);
        HBox botones = new HBox(5, guardar, cancelar);
        botones.setAlignment(Pos.CENTER);
        root.getChildren().addAll(estado, botones); 
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false); 
        stage.show();
        evtCancelar();
        evtGuardar();
    }
    
    @Override
    public void handle(ActionEvent event) {
        vista();
    }
    
    private void evtCancelar() {
        cancelar.setOnAction(e -> stage.close()); 
    }
    
    private void evtGuardar() {
        guardar.setOnAction(e -> {
            estado.setText(""); 
            String nomb = nombre.getText();
            String des = desc.getText();
            Categoria c = categorias.getValue();
            String im = imagen.getText();
            String ing = ingre.getText();
            String prec = precio.getText();
            
            if(nomb.isEmpty() || des.isEmpty() || c == null || im.isEmpty() || 
                    ing.isEmpty() || prec.isEmpty()){
                estado.setText("Por favor llene todos los campos");
            }else{
                String[] str = ing.split(",");
                Producto p = new Producto(nomb, des, c, Double.parseDouble(prec), 
                        str, im); 
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText("Guardado esxitosamente");
                alert.setContentText(p.toString());
                alert.show();
                clear();
            }
                
        }); 
    }
    private void clear() {
        nombre.setText("");
        desc.setText("");
        precio.setText("");
    }
}
