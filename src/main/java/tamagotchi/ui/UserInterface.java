package tamagotchi.ui;

import java.util.Scanner;

import tamagotchi.logic.Tamagotchi;

public class UserInterface {

    private Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {

        Tamagotchi tamagotchi = new Tamagotchi();


        while (true) {
            String input = this.scanner.nextLine();

            if (!tamagotchi.getCharacter().isAlive()) {
                while (true) {
                    System.out.println("La criatura ha fallecido.");
                    System.out.println("X - Salir");

                    if (input.equals("X")) {
                        break;
                    }
                }
            }

            System.out.println("Elige una opción del menú: ");
            System.out.println("1 - Ver estado");
            System.out.println("2 - Alimentar");
            System.out.println("X - Salir");


            if (input.equals("X")) {
                break;
            }

            if (input.equals("1")) {
                tamagotchi.estado();
            }

            if (input.equals("2")) {
                tamagotchi.alimentar();
            }
        }
    }

}
