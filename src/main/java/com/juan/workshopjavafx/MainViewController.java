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
    private MenuItem menuItemDepartment;

    @FXML
    private MenuItem menuItemSeller;

    @FXML
    private MenuItem menuItemAbout;

    @FXML
    public void onMenuItemDepartmentAction() {
        loadView("/com/juan/workshopjavafx/DepartmentList.fxml");
    }

    @FXML
    public void onMenuItemSellerAction() {
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
            // carrega a nova cena : NOVA
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nomeAbsoluto));
            VBox newVbox = loader.load();

            // pega a cena principal : MAIN
            Scene mainScene = Main.getScene(); // do metodo que foi criado na Main

            // salva o VBox da Main = getRoot -> pega ScrollPane, getContent -> pega VBox : MAIN
            VBox mainVbox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            // pega o primeiro elemento da VBox da Main (que é o MenuBar) : MAIN
            Node mainMenu = mainVbox.getChildren().get(0);

            // apaga tudo da tela : MAIN
            mainVbox.getChildren().clear();

            // coloca o menu de volta porque quer manter ele fixo
            mainVbox.getChildren().add(mainMenu);

            // pega a nova VBox salva e joga na tela
            mainVbox.getChildren().addAll(newVbox.getChildren());
        } catch (IOException e) {
            Alerts.showAlerts("IO exception", "Erro ao carregar a tela", e.getMessage(), Alert.AlertType.ERROR);
        }

    }
}
