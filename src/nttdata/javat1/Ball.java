package nttdata.javat1;

public class Ball extends Board{

    // Aqui tenemos los atributos rebote y tiro, los cuales se encargaran de mantener la puntuacion corriendo
    private boolean rebote = true;
    private boolean tiro = true;
    // Atributo puntuacion en el que se almacenara los puntos de la tirada
    private int puntuacion;

    /**
     *
     * @return
     * Getter generico, devuelve el rebote
     */
    public boolean getRebote() {
        return rebote;
    }

    /**
     *
     * @return
     * Getter generico, devuelve el tiro
     */
    public boolean getTiro() {
        return tiro;
    }

    /**
     *
     * @return
     * Getter generico, devuelve la puntuacion
     */
    public int getPuntuacion() {
        return puntuacion;
    }

    /**
     * Metodo encargado de dar una puntuacion al tiro, dependiendo de la fuerza y la direccion proporcionada
     * @throws InterruptedException
     * Implementado ya que se quiere dejar un tiempo entre informaciones para que el usuario lea las puntuaciones que va obteniendo
     */
    public void setPuntuacion() throws InterruptedException {
        //Switch case que elige el puntuador, dependiendo de la direccion que se haya elegido, para balancearlo,
        //el puntuador 1 es el que mas puntos te da (5000), pero es donde mas dificil es que rebote (20%), el 2 es el 2 con mas puntos(4000), pero tambien es relativamente dificil el rebote (40%),
        //el puntuador 3 es el equilibrado, 3000 puntos y un 50% de probabilidades de rebote, el puntuador 4 son 2000 puntos y un 70% de probabilidades de rebote,
        // y el 5 son 1000 puntos y un 80% de probabilidades de rebote, todo esto multiplicado con un multiplicador que se calcula segun la fuerza proporcionada
        switch (getPuntuador()){
            //puntuador 1
            case 1:
                 do {
                     int mul = getMultiplicador();
                     puntuacion += 5000 * mul;
                     System.out.println("5000 puntos en el puntuador 1 con un multiplicador " + mul + " = " + 5000 * mul + " puntos");
                     int r = (int) (Math.random() * 10);
                     if (r < 8) {
                        rebote = false;
                        setTiro();
                        break;
                     }
                     System.out.println("La bola ha rebotado en el puntuador");
                     Thread.sleep(1000);
                } while (rebote);
                rebote = true;
                break;
                //puntuador 2
            case 2:
                do {
                    int mul = getMultiplicador();
                    puntuacion += 4000 * mul;
                    System.out.println("4000 puntos en el puntuador 2 con un multiplicador " + mul + " = " + 4000 * mul + " puntos");
                    int r = (int) (Math.random() * 10);
                    if (r < 6) {
                        rebote = false;
                        setTiro();
                        break;
                    }
                    System.out.println("La bola ha rebotado en el puntuador");
                    Thread.sleep(1000);
                } while (rebote);
                rebote = true;
                break;
                //puntuador 3
            case 3:
                do {
                    int mul = getMultiplicador();
                    puntuacion += 3000 * mul;
                    System.out.println("3000 puntos en el puntuador 3 con un multiplicador " + mul + " = " + 3000 * mul + " puntos");
                    int r = (int) (Math.random() * 10);
                    if (r < 5) {
                        rebote = false;
                        setTiro();
                        break;
                    }
                    System.out.println("La bola ha rebotado en el puntuador");
                    Thread.sleep(1000);
                } while (rebote);
                rebote = true;
                break;
                //puntuador 4
            case 4:
                do {
                    int mul = getMultiplicador();
                    puntuacion += 2000 * mul;
                    System.out.println("2000 puntos en el puntuador 4 con un multiplicador " + mul + " = " + 2000 * mul + " puntos");
                    int r = (int) (Math.random() * 10);
                    if (r < 3) {
                        rebote = false;
                        setTiro();
                        break;
                    }
                    System.out.println("La bola ha rebotado en el puntuador");
                    Thread.sleep(1000);
                } while (rebote);
                rebote = true;
                break;
                //puntuador 5
            case 5:
                do {
                    int mul = getMultiplicador();
                    puntuacion += 1000 * mul;
                    System.out.println("1000 puntos en el puntuador 5 con un multiplicador " + mul + " = " + 1000 * mul + " puntos");
                    int r = (int) (Math.random() * 10);
                    if (r < 2) {
                        rebote = false;
                        setTiro();
                        break;
                    }
                    System.out.println("La bola ha rebotado en el puntuador");
                    Thread.sleep(1000);
                } while (rebote);
                rebote = true;
                break;
            default:
                System.err.println("Error");
                break;
        }
    }

    /**
     *
     * Setter de Tiro, un numero aleatorio de 1 a 10 es 1 o 2, este se convierte en falso
     */
    public void setTiro() {
        if((int) (Math.random() * 10) < 2){
            tiro = false;
        }
    }

    /**
     * Constructor de Ball, heredado de Throw
     * @param strenght
     * Fuerza
     * @param direction
     * Direccion
     */
    public Ball(int strenght, int direction) {
        super(strenght, direction);
    }


}
