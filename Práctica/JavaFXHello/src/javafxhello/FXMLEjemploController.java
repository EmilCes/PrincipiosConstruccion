/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package javafxhello;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author cesar
 */
public class FXMLEjemploController implements Initializable {
    
    @FXML
    private TextField tfNombre;
    @FXML
    private Label lbSaludo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnSaludar(ActionEvent event) {
        String nombre = tfNombre.getText();
        if(!nombre.isEmpty()){
            lbSaludo.setText("Hola Buen día " + nombre + ", bienvenido(a)");
        }
    }
    
}
