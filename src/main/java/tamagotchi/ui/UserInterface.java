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

            System.out.println("Elige una opción del menú: ");
            System.out.println("1 - Ver estado");
            System.out.println("2 - Alimentar");
            System.out.println("3 - Jugar");
            System.out.println("X - Salir");

            String input = this.scanner.nextLine();

            if (!tamagotchi.getCharacter().isAlive()) {
                while (true) {
                    System.out.println("La criatura ha fallecido.");
                    System.out.println("X - Salir");

                    input = scanner.nextLine();

                    if (input.equals("X")) {
                        break;
                    }
                }
            }


            if (input.equals("X")) {
                break;
            }

            if (input.equals("1")) {
                tamagotchi.estado();
                System.out.println();
            }

            if (input.equals("2")) {
                tamagotchi.alimentar();
                System.out.println();
            }

            if (input.equals("3")) {
                tamagotchi.jugar();
                System.out.println();
            }
        }
    }

}
