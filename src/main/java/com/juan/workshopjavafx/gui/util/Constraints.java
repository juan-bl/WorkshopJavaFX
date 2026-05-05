package com.juan.workshopjavafx.gui.util;

import javafx.scene.control.TextField;

public class Constraints {
    // metodo para so aceitar números
    public static void setTextFildInteger(TextField txt) {
        txt.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null && !newValue.matches("\\d*")) {
                txt.setText(oldValue);
            }
        });
    }

    // metodo para ter um número maximo de digitos
    public static void setTextFildMaxLength(TextField txt, int max) {
        txt.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null && newValue.length() > max) {
                txt.setText(oldValue);
            }
        });
    }

    // metodo para so aceitar números decimais com apenas um ponto
    public static void setTextFildDouble(TextField txt) {
        txt.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null && !newValue.matches("\\d*([\\.]\\d*)?")) {
                txt.setText(oldValue);
            }
        });
    }
}
