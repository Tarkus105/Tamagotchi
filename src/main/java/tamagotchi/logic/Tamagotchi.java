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
        this.character.getSaciedad().aumentar(10);
    }

    public void jugar() {
        actualizarTiempo();
        this.character.getDiversion().aumentar(10);
    }

    public void estado() {

        actualizarTiempo();

        System.out.println("Edad: " + this.character.getEdad() + " min");
        System.out.println("Vida: " + this.character.getVida() + "/" + this.character.getMAX());
        System.out.println("Saciedad: " + this.character.getSaciedad());
        System.out.println("Diversion: " + this.character.getDiversion());
    }

    public void actualizarTiempo() {

        int edadAnterior = this.character.getEdad();
        this.character.setEdad(this.timer.getTimeElapsedInMinutes());

        if (this.character.getEdad() - edadAnterior > 0) {
            for (int i = 0; i < this.character.getEdad() - edadAnterior; i++) {
                this.character.getSaciedad().reducir(5);
                this.character.getDiversion().reducir(5);
            }

            if (this.character.isHungry()) {
                this.character.reducirVida(this.character.getEdad() - edadAnterior);
            }

            if (this.character.isBored()) {
                this.character.reducirVida(this.character.getEdad() - edadAnterior);
            }
        }


    }
}
