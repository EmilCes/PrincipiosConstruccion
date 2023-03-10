/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package dividircuenta;

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
public class FXMLCuentaController implements Initializable {
    
    @FXML
    private TextField tfMontoCuenta;
    @FXML
    private TextField tfNumeroPersonas;
    @FXML
    private Label lbPagoSinPropina;
    @FXML
    private Label lbPagoConPropina;
    @FXML
    private Label lbMontoTotalPropina;
    
    private double PORCENTAJE_PROPINA = 0.10;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnCalcular(ActionEvent event) {
                
        float montoCuenta = Float.valueOf(tfMontoCuenta.getText());
        double montoConPropina = montoCuenta + (montoCuenta * PORCENTAJE_PROPINA);
        int numeroPersonas = Integer.parseInt(tfNumeroPersonas.getText());

        String pagoSinPropina = Float.toString(montoCuenta / numeroPersonas);
        String pagoConPropina = Double.toString(montoConPropina / numeroPersonas);
        String costoTotalConPropina = Double.toString(montoConPropina);
            
        lbPagoSinPropina.setText(pagoSinPropina);
        lbPagoConPropina.setText(pagoConPropina);
        lbMontoTotalPropina.setText(costoTotalConPropina);
        
    }
    
}
