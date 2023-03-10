package conversordivisas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLConversorController implements Initializable {

    @FXML
    private TextField tfPesos;
    @FXML
    private Label lbDolares;
    @FXML
    private TextField tfDolares;
    @FXML
    private Label lbPesos;
    
    private double COSTO_DOLAR = 17.99;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   

    @FXML
    private void btnConvertirADolares(ActionEvent event) {
        
        try{
            float pesosAConvertir = Float.valueOf(tfPesos.getText());
            float dolaresConversion = (float) (pesosAConvertir / COSTO_DOLAR);
            lbDolares.setText(String.valueOf(dolaresConversion));
        } catch(NumberFormatException ex){
            String titulo = "Error";
            String mensaje = "Introduce un formato valido en el campo.";
            mostrarAlertaError(titulo, mensaje);
        }
        
    }

    @FXML
    private void btnConvertirAPesos(ActionEvent event) {
        
        try{
            float dolaresAConvertir = Float.valueOf(tfDolares.getText());
            double pesosConversion = dolaresAConvertir * COSTO_DOLAR;
            lbPesos.setText(String.valueOf(pesosConversion)); 
        } catch(NumberFormatException ex){
            String titulo = "Error";
            String mensaje = "Introduce un formato valido en el campo.";
            mostrarAlertaError(titulo, mensaje);
        }
        
    }
    
    private void mostrarAlertaError(String titulo, String mensaje){
        
        Alert alertaSimple = new Alert(Alert.AlertType.ERROR);
        alertaSimple.setTitle(titulo);
        alertaSimple.setHeaderText(null);
        alertaSimple.setContentText(mensaje);
        alertaSimple.showAndWait();
        
    }
    
}
