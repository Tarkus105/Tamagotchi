package tamagotchi.ui;

import javafx.geometry.Insets;
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

    public void start(Stage ventana) {

        Tamagotchi tamagotchi = new Tamagotchi();

        Label lblEstado = new Label("Ver estado");
        Label lblAlimentar = new Label("Alimentar");
        Label lblJugar = new Label("Jugar");
        Label lblLimpiar = new Label("Limpiar");
        Label lblCurar = new Label("Curar");


        Button btnEstado = new Button(lblEstado.getText());
        Button btnAlimentar = new Button(lblAlimentar.getText());
        Button btnJugar = new Button(lblJugar.getText());
        Button btnLimpiar = new Button(lblLimpiar.getText());
        Button btnCurar = new Button(lblCurar.getText());


        HBox menuLayout = new HBox(10);
        menuLayout.getChildren().addAll(btnEstado, btnAlimentar, btnJugar, btnLimpiar, btnCurar);
        menuLayout.setFillHeight(true);

        Label lblTextoCentral = new Label();

        Label lblSalir = new Label("Salir");
        Button btnSalir = new Button(lblSalir.getText());

        BorderPane mainLayout = new BorderPane();
        mainLayout.setPrefSize(400, 300);
        mainLayout.setPadding(new Insets(10));
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

        btnLimpiar.setOnAction(event -> {
            tamagotchi.actualizarTiempo();
            tamagotchi.limpiar();
            lblTextoCentral.setText("Limpiado!");
        });

        btnCurar.setOnAction(event -> {
            tamagotchi.actualizarTiempo();
            tamagotchi.curar();
            lblTextoCentral.setText("Curado!");
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
