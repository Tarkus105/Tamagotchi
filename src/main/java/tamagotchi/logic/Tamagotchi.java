package tamagotchi.logic;

import tamagotchi.domain.Character;
import tamagotchi.domain.Timer;


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
        actualizarTiempo();
        this.character.aumentarVida(20);
    }

    public void estado() {

        actualizarTiempo();

        System.out.println("Edad: " + this.character.getEdad() + " min");
        System.out.println("Vida: " + this.character.getVida() + "/" + this.character.getMAX());
        System.out.println("Saciedad: " + this.character.getSaciedad() + "/" + this.character.getMAX());
        System.out.println("Diversión: " + this.character.getDiversion() + "/" + this.character.getMAX());
        System.out.println("\n");
    }

    public void actualizarTiempo() {

        int edadAnterior = this.character.getEdad();

        this.character.setEdad(this.timer.getTimeElapsedInMinutes());

        if (this.character.getEdad() - edadAnterior > 0) {
            this.character.reducirVida(this.character.getEdad() - edadAnterior);
        }

//        this.character.reducirSaciedad(5);
//        this.character.reducirDiversion(5);


    }
}
