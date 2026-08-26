package tamagotchi.domain;

import java.util.HashMap;

public class Character {

    final int MAX = 100;
    private int vida;
    private int edad;
    private Saciedad saciedad;
    private Diversion diversion;
    private HashMap<String, Boolean> estados;
//    private boolean alive;

    public Character() {
        this.vida = 50;
        this.saciedad = new Saciedad(1);
        this.diversion = new Diversion(1);
        this.edad = 0;
//        this.alive = true;
        this.estados = new HashMap<>();

        this.estados.put("Bored", false);
        this.estados.put("Hungry", false);
        this.estados.put("Full", false);
        this.estados.put("Sick", false);
        this.estados.put("Dead", false);

    }

    public int getMAX() {
        return MAX;
    }

    public int getVida() {
        return this.vida;
    }

    public int getEdad() {
        return this.edad;
    }

    public Saciedad getSaciedad() {

        return this.saciedad;
    }

    public Diversion getDiversion() {

        return this.diversion;
    }

    public HashMap<String, Boolean> getEstados() {
        return estados;
    }

    public void setEdad(int minutos) {
        this.edad = minutos;
    }

    public void reducirVida(int reduccion) {
        this.vida = this.vida - reduccion;
    }

    public void aumentarVida(int aumento) {
        this.vida = this.vida + aumento;
    }

    public void actualizarEstados() {

        if (this.saciedad.getCurrentState() == 0) {
            this.estados.put("Hungry", true);
        } else if (this.saciedad.getCurrentState() > 0) {
            this.estados.put("Hungry", false);
        };

        if (this.saciedad.getCurrentState() == 100) {
            this.estados.put("Full", true);
        } else if (this.saciedad.getCurrentState() < 100) {
            this.estados.put("Full", false);
        };

        if (this.diversion.getCurrentState() == 0) {
            this.estados.put("Bored", true);
        } else if (this.diversion.getCurrentState() > 0) {
            this.estados.put("Bored", false);
        };

        if (this.getVida() == 0) {
            this.estados.put("Dead", true);
        };

    }
}
