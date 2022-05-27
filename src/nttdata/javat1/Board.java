package nttdata.javat1;

public class Board extends Throw{
    //atributos que van a elegir el multiplicador y el puntuador correspondientes
    private int multiplicador;
    private int puntuador;

    /**
     * Getter generico, funciona a traves del propio setter
     * @return
     * Devuelve un numero entre 1 y 5 dependiendo de la fuerza
     */
    public int getMultiplicador() {
        setMultiplicador();
        return multiplicador;
    }

    /**
     * Getter generico, funciona a traves del propio setter
     * @return
     * Devuelve un numero entre 1 y 5 dependiendo de la direccion
     */
    public int getPuntuador() {
        setPuntuador();
        return puntuador;
    }

    /**
     * Setter del multiplicador, depende de la fuerza, si es 80 o mas, devuelve entre x3 y x5, si es 60 o mas, devuelve entre x2 y x5, si es 40 o mas, devuelve entre x1 y x4,
     * si es 20 o mas, devuelve entre x1 y x3, si es 20 o menos, devuelve entre x1 y x2
     */
    public void setMultiplicador() {
        if (getStrenght() > 80) {
            this.multiplicador = (int)(Math.random()*(3)+3);
        } else if (getStrenght() > 60){
            this.multiplicador = (int)(Math.random()*(4)+2);
        } else if (getStrenght() > 40){
            this.multiplicador = (int)(Math.random()*(4)+1);
        } else if (getStrenght() > 20){
            this.multiplicador = (int)(Math.random()*(3)+1);
        } else {
            this.multiplicador = (int)(Math.random()*(2)+1);
        }
    }

    /**
     * Setter del puntuador, depende de la direccion, entre 100 y 81 es el 1, entre 80 y 61 es el 2, entre 60 y 41, es el 3, entre 40 y 21, es el 4 y 20 o menos es el 5
     */
    public void setPuntuador() {
        if (getDirection() > 80) {
            this.puntuador = 1;
        } else if (getDirection() > 60){
            this.puntuador = 2;
        } else if (getDirection() > 40){
            this.puntuador = 3;
        } else if (getDirection() > 20){
            this.puntuador = 4;
        } else {
            this.puntuador = 5;
        }
    }

    /**
     * Constructor heredado de Throw
     * @param strenght
     * Fuerza
     * @param direction
     * Direccion
     */
    public Board(int strenght, int direction) {
        super(strenght, direction);
    }

}
