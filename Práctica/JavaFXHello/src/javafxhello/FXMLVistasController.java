/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxhello;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;


public class FXMLVistasController implements Initializable {

    @FXML
    private ComboBox<String> cbCarrera;
    @FXML
    private Label lbSeleccionCarrera;
    @FXML
    private ToggleGroup tgColores;
    @FXML
    private RadioButton rbAzul;
    @FXML
    private RadioButton rbVerde;
    @FXML
    private RadioButton rbAmarillo;
    @FXML
    private Pane paneFondoColor;
    ObservableList<String> listaCarreras;
    @FXML
    private CheckBox cbCMas;
    @FXML
    private CheckBox cbJava;
    @FXML
    private CheckBox cbCSharp;
    @FXML
    private CheckBox cbPhp;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaCarreras = FXCollections.observableArrayList("Ingenieria en Software", "Medicina", 
                                                    "Derecho", "Tecnologías Computacionales");
        configurarComboBox();
        configurarCambioColores();
    }  
    
    private void configurarComboBox(){
        cbCarrera.setItems(listaCarreras);
        cbCarrera.valueProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("Valor anterior seleccionado: " + oldValue);
                lbSeleccionCarrera.setText("La carrera seleccionada es: " + newValue);
            }
        });
    }
    
    private void configurarCambioColores(){
        tgColores.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if(rbAzul.isSelected()){
                    paneFondoColor.setStyle("-fx-background-color: #0000FF");
                } else if(rbVerde.isSelected()){
                    paneFondoColor.setStyle("-fx-background-color: #00FF00");
                } else if(rbAmarillo.isSelected()){
                    paneFondoColor.setStyle("-fx-background-color: #FFFF00");
                }
            }
            
        });
    }

    @FXML
    private void clickMostrarSeleccion(ActionEvent event) {
        String seleccionMsj = "Los lenguajes de programación de tu interes son:";
        if(cbCMas.isSelected())
            seleccionMsj += "\n -" + cbCMas.getText();
        if(cbCSharp.isSelected())
            seleccionMsj += "\n -" + cbCSharp.getText();
        if(cbJava.isSelected())
            seleccionMsj += "\n -" + cbJava.getText();
        if(cbPhp.isSelected())
            seleccionMsj += "\n -" + cbPhp.getText();
        
        mostrarAlertaSimple("Opciones seleccionadas", seleccionMsj);
    }
    
    private void mostrarAlertaSimple(String titulo, String mensaje){
        Alert alertaSimple = new Alert(Alert.AlertType.INFORMATION);
        alertaSimple.setTitle(titulo);
        alertaSimple.setHeaderText(null); //Cuando mandas null lo quota
        alertaSimple.setContentText(mensaje);
        alertaSimple.showAndWait(); //No permite continuar hasta que se quite el pop-up
    }
    
}
