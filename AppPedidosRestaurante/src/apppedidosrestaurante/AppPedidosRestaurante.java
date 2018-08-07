/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppedidosrestaurante;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author rociomera
 */
public class AppPedidosRestaurante extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        VenuPare pantallaVentas = new VenuPare();
        Pane root = pantallaVentas.GetRoot();
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Cafeteria Polito!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
