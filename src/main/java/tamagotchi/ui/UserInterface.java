package tamagotchi.ui;

import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import tamagotchi.logic.Tamagotchi;

public class UserInterface extends Application {

    final int WIDTH = 400;
    final int HEIGHT = 300;

    public void start(Stage ventana) {

        Tamagotchi tamagotchi = new Tamagotchi();

        Label lblEstado = new Label("Ver estado");
        Label lblAlimentar = new Label("Alimentar");
        Label lblJugar = new Label("Jugar");


        Button btnEstado = new Button(lblEstado.getText());
        Button btnAlimentar = new Button(lblAlimentar.getText());
        Button btnJugar = new Button(lblJugar.getText());


        HBox menuLayout = new HBox(10);
        menuLayout.getChildren().addAll(btnEstado, btnAlimentar, btnJugar);
        menuLayout.setFillHeight(true);

        Label lblTextoCentral = new Label();

        Label lblSalir = new Label("Salir");
        Button btnSalir = new Button(lblSalir.getText());

        BorderPane mainLayout = new BorderPane();
        mainLayout.setPrefSize(400,300);
        mainLayout.setTop(menuLayout);
        mainLayout.setCenter(lblTextoCentral);
        mainLayout.setBottom(btnSalir);

        btnEstado.setOnAction(event -> {
            tamagotchi.actualizarTiempo();
            lblTextoCentral.setText(tamagotchi.estado());
        });

        btnAlimentar.setOnAction(event -> {
            tamagotchi.actualizarTiempo();
            tamagotchi.alimentar();
            lblTextoCentral.setText("Alimentado!");
        });

        btnJugar.setOnAction(event -> {
            tamagotchi.actualizarTiempo();
            tamagotchi.jugar();
            lblTextoCentral.setText("Jugado!");
        });

        btnSalir.setOnAction(event -> {
            Platform.exit();
        });


        Scene vista = new Scene(mainLayout);

        ventana.setScene(vista);
        ventana.setTitle("Tamagotchi!");
        ventana.show();

    }

}
