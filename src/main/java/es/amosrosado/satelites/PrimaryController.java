package es.amosrosado.satelites;

import es.amosrosado.satelites.entities.Satelite;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.Query;



public class PrimaryController implements Initializable {
    
    private Satelite sateliteSeleccionado;
    @FXML
    private TableView<Satelite> tableViewSatelites;
    @FXML
    private TableColumn<Satelite, String> columnNombre;
    @FXML
    private TableColumn<Satelite, String> columnDescubiertoPor;
    @FXML    
    private TableColumn<Satelite, String> columnDistanciaPlaneta;
    @FXML
    private TableColumn<Satelite, String> columnPlaneta;
    @FXML
    private TextField textFieldNombre;
    @FXML
    private TextField textFieldDescubiertoPor;
    @FXML
    private TextField textFieldDistanciaPlaneta;
    @FXML
    private TextField textFieldPlaneta;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnDescubiertoPor.setCellValueFactory(new PropertyValueFactory<>("descubiertoPor"));
        columnDistanciaPlaneta.setCellValueFactory(new PropertyValueFactory<>("distanciaAlPlaneta"));
        columnPlaneta.setCellValueFactory(
            cellData -> {
                SimpleStringProperty property = new SimpleStringProperty();
                if (cellData.getValue().getPlaneta() != null) {
                    String nombrePlan = (cellData.getValue().getPlaneta().getNombre());
                    property.setValue(nombrePlan);
                }
                return property;
            });
        tableViewSatelites.getSelectionModel().selectedItemProperty().addListener
                ((observable, oldValue, newValue) -> {
                    sateliteSeleccionado = newValue;
                    if (sateliteSeleccionado != null) {
                        textFieldNombre.setText(sateliteSeleccionado.getNombre());
                        textFieldDescubiertoPor.setText(sateliteSeleccionado.getDescubiertoPor()); 
                        textFieldDistanciaPlaneta.setText(sateliteSeleccionado.getDistanciaAlPlaneta());
//                        textFieldPlaneta.setText(sateliteSeleccionado.getPlaneta.toString());
                    } else {
                        textFieldNombre.setText("");
                        textFieldDescubiertoPor.setText("");
                        textFieldDistanciaPlaneta.setText("");
                    }
                });
        cargarTodosSatelites();
    }
    
    private void cargarTodosSatelites(){
        Query querySateliteFindAll = App.em.createNamedQuery("Satelite.findAll");
        List<Satelite> listSatelite = querySateliteFindAll.getResultList();
        tableViewSatelites.setItems(FXCollections.observableArrayList(listSatelite)); 
    }
    
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void onActionButtonNuevo(ActionEvent event) {
//        try {
//            App.setRoot("secondary");
//            SecondaryController secondaryController = (SecondaryController)App.fxmlLoader
//        }
//        
    }

    @FXML
    private void onActionButtonEditar(ActionEvent event) {
        
    }

    @FXML
    private void onActionButtonSuprimir(ActionEvent event) {
        
    }

    @FXML
    private void onActionButtonGuardar(ActionEvent event) {
        if (sateliteSeleccionado != null) {
            sateliteSeleccionado.setNombre(textFieldNombre.getText());
            sateliteSeleccionado.setDescubiertoPor(textFieldDescubiertoPor.getText());
            App.em.getTransaction().begin();
            App.em.merge(sateliteSeleccionado);
            App.em.getTransaction().commit();
            
            int numFilaSeleccionada = tableViewSatelites.getSelectionModel().getSelectedIndex();
            tableViewSatelites.getItems().set(numFilaSeleccionada, sateliteSeleccionado);
            TablePosition pos = new TablePosition(tableViewSatelites, numFilaSeleccionada, null);
            tableViewSatelites.getFocusModel().focus(pos);
            tableViewSatelites.requestFocus();
        }
    }
}
