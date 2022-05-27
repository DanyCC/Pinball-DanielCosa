package nttdata.javat1;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Game {

    /**
     *
     * @param args
     * Metodo main desde donde se lanza la aplicacion
     * @throws InterruptedException
     * Implementado ya que es utilizado por el metodo launchAndStart()
     *
     */
    public static void main(String[] args) throws InterruptedException {
        launchAndStart();
    }

    /**
     * Desde este metodo se realizan los parametros principales para que el juego funcione con normalidad
     * @throws InterruptedException
     * Implementado ya que es utilizado por el metodo Ball.setPuntuacion()
     */
    public static void launchAndStart() throws InterruptedException {
        // Se crea una instancia de la clase Ball fuera del do while que se encarga de mantener el juego, y otra de HiScore que guarda las 10 mejores puntuaciones mientras la aplicacion funcione
        Ball tirada;
        HiScore lb = new HiScore();
        Scanner scan = new Scanner(System.in);
        // Boolean encargado de mantener el programa en caso de que se quiera seguir jugando incluso después de haber terminado un juego
        boolean keep = true;
        // int encargado de la sincronizacion con la que se golpea a la bola, si es menor de 20 se pierde la partida actual debido a que se ha pulsado la pala demasiado pronto/tarde
        int timing;
        // boolean encargado de decidir si la bola se va entre las 2 palas o no, en base a un valor aleatorio
        boolean tiro;
        // while encargado de lo mismo que hace el boolean keep, por eso mismo es utilizado por este
        while (keep) {
            // int encargado de contar la puntuacion total de una partida
            int punt = 0;
            // hay dos posibilidades para que el juego acabe, que la bola por mala suerte se vaya entre las dos palas (Ball.getTiro()), o la de la sincronizacion ya mencionada, por lo tanto
            // mientras esto no pase habrá un do while encargado de preguntar la fuerza y direccion del tiro las veces que sea necesario
            do {
                //metodo throwBall() encargado de preguntar al usuario por la fuerza y direccion que desea
                tirada = throwBall();
                // un par de sysos informando al jugador de la fuerza, la direccion y el puntuador en el que ha caido la bola
                System.out.println("Fuerza: " + tirada.getStrenght());
                System.out.println("Direccion: " + tirada.getDirection() + ", puntuador: " + tirada.getPuntuador());
                // se le da un valor a la sincronizacion (timing)
                timing = tirada.getTiming();
                // Si la sincronizacion es mayor que 20 se le informara al usuario, de lo contrario se le informara y la partida actual terminara
                if (timing > 20) {
                    System.out.println("Sincronizacion: " + timing);
                } else {
                    System.out.println("Mala sincronizacion: " + timing + ", no has conseguido darle a la bola a tiempo");
                    break;
                }
                //metodo encargado de dar una puntuacion en base a unos valores aleatorios basados en la fuerza y direccion del tiro
                tirada.setPuntuacion();
                //se le da un valor al boolean tiro a traves de un metodo con un valor aleatrio
                tiro = tirada.getTiro();
                // si tiro es verdadero, se informa al usario que puede volver a tirar, de lo contrario, se informa y acaba el juego actual
                if (tiro) {
                    System.out.println("Tienes la oportunidad de golpear la bola de nuevo");
                } else {
                    System.out.println("Mala suerte, la pelota ha caido directa entre las dos palas, fin del juego");
                }
                // se suma la puntuacion de la tirada al computo global de la partida
                punt += tirada.getPuntuacion();
            } while ((tiro && timing > 20));
            // se comunica al usuario la puntuacion final de la partida
            System.out.println("Puntuacion final: " + punt);
            // se comprueba si la puntuacion entra en la tabla de las 10 mejores y si es asi se introduce
            lb.enterLeaderboard(punt);
            int rank = lb.getLeaderboard().length;
            //bucle encargado de imprimir el ranking
            for (int i = 0; i < lb.getLeaderboard().length; i++, rank--) {
                System.out.println(rank + ". " + lb.getLeaderboardPos(i));
            }

            System.out.println("Quieres hechar otra partida? (S/N): ");
            String r = scan.nextLine();
            // encargado de evaluar si el usuario quiere otra partida, si la cadena es nula o no es S, se tomara como que no, por lo tanto keep pasara a ser falso y termina la aplicacion
            if (r == null){
                System.out.println("Input invalido, finalizando juego...");
                keep = false;
            } else {
                switch (r.toUpperCase(Locale.ROOT).charAt(0)) {
                    case 'S':
                        keep = true;
                        break;
                    case 'N':
                        System.out.println("Finalizando juego...");
                        keep = false;
                        break;
                    default:
                        System.out.println("Input invalido, finalizando juego...");
                        keep = false;
                        break;
                }
            }
        }
    }

    /**
     * Es el metodo que inicia el juego, pide unos parametros inciales y a partir de ahi el juego empieza a ejecutarse
     * @return
     * Devuelve una clase Ball que es utilizada por launchAndStart para el funcionamiento del juego
     */
    public static Ball throwBall(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Elija la fuerza y la direccion: ");
        try {
            Ball tirada = new Ball(scan.nextInt(), scan.nextInt());
            return tirada;
        } catch (InputMismatchException e){
            Ball tirada = new Ball(-1, -1);
            return tirada;
        }

    }

}
