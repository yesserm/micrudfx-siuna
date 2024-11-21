package org.yesserm;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    public void switchToLogin() throws IOException {
        App.setRoot("user");
    }
}