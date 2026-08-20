package tamagotchi;

import javafx.application.Application;
import tamagotchi.ui.UserInterface;
import tamagotchi.ui.UserInterfaceText;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        UserInterfaceText ui = new UserInterfaceText(scanner);
//
//        ui.start();

        Application.launch(UserInterface.class);
    }
}