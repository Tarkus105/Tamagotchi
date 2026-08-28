package tamagotchi.ui;

import javafx.geometry.Insets;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import tamagotchi.logic.Tamagotchi;

import java.time.LocalDateTime;

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
        menuLayout.setHgrow(btnEstado, Priority.ALWAYS);
        menuLayout.setHgrow(btnAlimentar, Priority.ALWAYS);
        menuLayout.setHgrow(btnJugar, Priority.ALWAYS);
        menuLayout.setHgrow(btnLimpiar, Priority.ALWAYS);
        menuLayout.setHgrow(btnCurar, Priority.ALWAYS);
        btnEstado.setMaxWidth(Double.MAX_VALUE);
        btnAlimentar.setMaxWidth(Double.MAX_VALUE);
        btnJugar.setMaxWidth(Double.MAX_VALUE);
        btnLimpiar.setMaxWidth(Double.MAX_VALUE);
        btnCurar.setMaxWidth(Double.MAX_VALUE);
        menuLayout.setFillHeight(true);
        menuLayout.getChildren().addAll(btnEstado, btnAlimentar, btnJugar, btnLimpiar, btnCurar);

        Label lblTextoCentral = new Label();
        lblTextoCentral.setFont(Font.font("Microsoft JhengHei UI", 10));

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
            if (tamagotchi.getCharacter().getEstados().get("Dead")) {
                ventana.setScene(deathScene(tamagotchi));
            }
        });

        btnAlimentar.setOnAction(event -> {
            tamagotchi.actualizarTiempo();
            tamagotchi.alimentar();
            lblTextoCentral.setText("Alimentado!");
            if (tamagotchi.getCharacter().getEstados().get("Dead")) {
                ventana.setScene(deathScene(tamagotchi));
            }
        });

        btnJugar.setOnAction(event -> {
            tamagotchi.actualizarTiempo();
            tamagotchi.jugar();
            lblTextoCentral.setText("Jugado!");
            if (tamagotchi.getCharacter().getEstados().get("Dead")) {
                ventana.setScene(deathScene(tamagotchi));
            }
        });

        btnLimpiar.setOnAction(event -> {
            tamagotchi.actualizarTiempo();
            tamagotchi.limpiar();
            lblTextoCentral.setText("Limpiado!");
            if (tamagotchi.getCharacter().getEstados().get("Dead")) {
                ventana.setScene(deathScene(tamagotchi));
            }
        });

        btnCurar.setOnAction(event -> {
            tamagotchi.actualizarTiempo();
            tamagotchi.curar();
            lblTextoCentral.setText("Curado!");
            if (tamagotchi.getCharacter().getEstados().get("Dead")) {
                ventana.setScene(deathScene(tamagotchi));
            }
        });

        btnSalir.setOnAction(event -> {
            Platform.exit();
        });

        Scene vista = new Scene(mainLayout);

        ventana.setScene(vista);
        ventana.setTitle("Tamagotchi!");
        ventana.show();

    }

    public Scene deathScene(Tamagotchi tamagotchi) {
        String deadText = "ʚ(˳× ‸ ×˳ )ɞ" + "\n" + "\n" +
                          tamagotchi.getCharacter().getBirthday() + " - " + tamagotchi.getCharacter().getDeathday();;

        Label lblDead = new Label(deadText);
        lblDead.setFont(Font.font("Microsoft JhengHei UI", 15));
        lblDead.setTextAlignment(TextAlignment.CENTER);
        lblDead.setAlignment(Pos.CENTER);

        Label lblSalir = new Label("Salir");
        Button btnSalir = new Button(lblSalir.getText());

        BorderPane deathLayout = new BorderPane();
        deathLayout.setPrefSize(400, 300);
        deathLayout.setPadding(new Insets(10));
        deathLayout.setCenter(lblDead);
        deathLayout.setBottom(btnSalir);

        btnSalir.setOnAction(event -> {
            Platform.exit();
        });

        return new Scene(deathLayout);
    }

}
