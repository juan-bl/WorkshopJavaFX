package com.juan.workshopjavafx;

import com.juan.workshopjavafx.gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private MenuItem menuItemDepartamento;

    @FXML
    private MenuItem menuItemVendedor;

    @FXML
    private MenuItem menuItemAbout;

    @FXML
    public void onMenuItemDepartamentoAction() {
        System.out.println("onMenuItemDepartamentoActio");
    }

    @FXML
    public void onMenuItemVendedorAction() {
        System.out.println("onMenuItemVendedorActio");
    }

    @FXML
    public void onMenuItemAboutAction() {
        loadView("/com/juan/workshopjavafx/About.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void loadView(String nomeAbsoluto) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nomeAbsoluto));
            VBox newVbox = loader.load();
            Scene mainScene = Main.getScene();
            VBox mainVbox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
            Node mainMenu = mainVbox.getChildren().get(0);
            mainVbox.getChildren().clear();
            mainVbox.getChildren().add(mainMenu);
            mainVbox.getChildren().addAll(newVbox.getChildren());
        } catch (IOException e) {
            Alerts.showAlerts("IO exception", "Erro ao carregar a tela", e.getMessage(), Alert.AlertType.ERROR);
        }

    }
}
