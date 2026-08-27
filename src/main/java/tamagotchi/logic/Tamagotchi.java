package tamagotchi.logic;

import tamagotchi.domain.Character;
import tamagotchi.domain.Timer;

import java.util.Map;
import java.util.Random;


public class Tamagotchi {
    private Character character;
    private Timer timer;

    public Tamagotchi() {
        this.character = new Character();
        this.timer = new Timer();
    }

    public Character getCharacter() {
        return this.character;
    }

    public void alimentar() {
        if (this.character.getEstados().get("Full")) {
            this.character.reducirVida(5);
        }

        this.character.getSaciedad().aumentar(10);
    }

    public void jugar() {
        this.character.getDiversion().aumentar(10);
    }

    public void limpiar() {
        if (this.character.isPooped()) {
            this.character.setPooped(false, 0);
        }
    }

    public void curar() {
        if (this.character.getEstados().get("Sick")) {
            this.character.getEstados().put("Sick", false);
        }
    }

    public String estado() {

        return "Edad: " + this.character.getEdad() + " min" + "\n" +
                "Vida: " + this.character.getVida() + "/" + this.character.getMAX() + "\n" +
                "Saciedad: " + this.character.getSaciedad() + "\n" +
                "Diversion: " + this.character.getDiversion() + "\n" + "\n" +
                showFace();
    }

    private String showFace() {

        String face = "(｡◕‿‿◕｡)";

        for (Map.Entry<String, Boolean> par : this.character.getEstados().entrySet()) {

            if (par.getValue() == true) {
                switch (par.getKey()) {
                    case "Bored":
                    case "Hungry":
                        face = "ᕙ(⇀‸↼‶)ᕗ";
                        break;

                    case "Sick": {
                        face = "(ಥ﹏ಥ)";
                        break;
                    }

                    case "Dead": {
                        // Cambiar vista de pantalla
                        face = ">_>";
                        break;
                    }
                }
            }
            ;


        }
        return face;
    }

    public void actualizarTiempo() {

        this.character.actualizarEstados();

        Random rnd = new Random();

        int edadAnterior = this.character.getEdad();
        this.character.setEdad(this.timer.getTimeElapsedInMinutes());

        if (this.character.getEdad() - edadAnterior > 0) {

            for (int i = 0; i < this.character.getEdad() - edadAnterior; i++) {
                this.character.getSaciedad().reducir(5);
                this.character.getDiversion().reducir(5);

                int number = rnd.nextInt(2);
                if (number == 1) {
                    if (!this.character.isPooped()) {
                        this.character.setPooped(true, this.character.getEdad());

                    }
                }

            }

            for (Map.Entry<String, Boolean> par : this.character.getEstados().entrySet()) {
                if (par.getValue() == true) {
                    switch (par.getKey()) {
                        case "Bored": {
                            this.character.reducirVida(this.character.getEdad() - edadAnterior);
                            break;
                        }
                        case "Hungry": {
                            this.character.reducirVida(this.character.getEdad() - edadAnterior);
                            break;
                        }

                        case "Full": {
                            // Se encarga la acción de Alimentar
                            break;
                        }

                        case "Dirty": {
                            break;
                        }

                        case "Sick": {
                            this.character.reducirVida((this.character.getEdad() - edadAnterior) * 5);
                            break;
                        }

                        case "Dead": {
                            // Cambiar vista de pantalla
                            break;
                        }
                    }
                }
                ;

            }

        }

        //TEST
        System.out.println(this.character.getEdad());
        System.out.println("Caca:" + this.character.isPooped() + " " + this.character.getPoopTime() + " mins");
        for (Map.Entry<String, Boolean> par : this.character.getEstados().entrySet()) {
            System.out.println(par);

        }
    }
}
