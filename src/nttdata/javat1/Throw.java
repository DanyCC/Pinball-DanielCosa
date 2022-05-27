package nttdata.javat1;

import java.util.InputMismatchException;

public class Throw {

    // Atributos de fuerza, direccion y sincronizacion, determinaran varias cosas sobre la tirada
    private int strenght;
    private int direction;
    private int timing;


    /**
     * Getter generico
     * @return
     * Devuelve Strenght
     */
    public int getStrenght(){
        return this.strenght;
    }

    /**
     * Getter generico
     * @return
     * Devuelve Direction
     */
    public int getDirection(){
        return this.direction;
    }

    /**
     * Getter generico
     * @return
     * Devuelve Timing
     */
    public int getTiming(){
        setTiming();
        return this.timing;
    }

    /**
     * setter de Strenght, devuelve un valor introducido por el usuario con un margen de error de 40 para ser utilizado en la tirada
     * @param val
     * Parametro en el cual se introduce el valor del usuario
     */
    public void setStrenght(int val) {
        if (validarStrDirTim(val)){
            int r = randomizador();
            if (val + r < 0){
                this.strenght = 0;
            } else if (val + r > 100){
                this.strenght = 100;
            } else {
                this.strenght = val + r;
            }
        }
    }

    /**
     * setter de Direction, devuelve un valor introducido por el usuario con un margen de error de 40 para ser utilizado en la tirada
     * @param val
     * Parametro en el cual se introduce el valor del usuario
     */
    public void setDirection(int val){
        if (validarStrDirTim(val)){
            int r = randomizador();
            if (val + r < 0){
                this.direction = 0;
            } else if (val + r > 100){
                this.direction = 100;
            } else {
                this.direction = val + r;
            }
        }
    }

    /**
     * Setter de timing, es un valor completamente aleatorio entre 0 y 100
     */
    public void setTiming(){
        this.timing = (int)(Math.random()*(100));
    }

    /**
     * Constructor de throw, se le pide al usuaro unos valores de fuerza y direccion entre 0 y 100
     * @param strenght
     * Fuerza
     * @param direction
     * Direccion
     */
    public Throw(int strenght, int direction) {
        setStrenght(strenght);
        setDirection(direction);
    }

    /**
     * Validacion de los valores introducidos por el usuario
     * @param val
     * Valores introducidos por el usuario
     * @return
     * Devuelve true si el valor esta entre 0 y 100, en caso contrario devuelve false;
     */
    private boolean validarStrDirTim(int val){
        try {
            if (val < 0 || val > 100) {
                System.out.println("Elija un valor comprendido entre 0 y 100");
                return false;
            }
            return true;
        } catch (InputMismatchException e) {
            System.out.println("Input invalido, elija un valor numerico entre 0 y 100");
            return false;
        }
    }

    /**
     * Metodo para darle un margen de error a los valores introducidos por el usuario
     * @return
     * Devuelve un numero aleatorio entre 40 y -40
     */
    private int randomizador() {
        return (int)(Math.random()*(81)-40);
    }

}
