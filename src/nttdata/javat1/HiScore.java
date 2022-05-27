package nttdata.javat1;

public class HiScore {

    // atributo que guardara las 10 mejores puntuaciones de la sesion
    private int[] leaderboard = {0,0,0,0,0,0,0,0,0,0};

    /**
     * getter generico
     * @return
     * Devuelve el array completo
     */
    public int[] getLeaderboard() {
        return leaderboard;
    }

    /**
     * Metodo que devuelve el dato de una posicion del array
     * @param pos
     * Tiene un parametro de entrada que es la posicion del array
     * @return
     * Devuelve el dato ya mencionado, en caso de que no exista la posicion del array indicada devuelve -1
     */
    public int getLeaderboardPos(int pos) {
        if (pos < leaderboard.length && pos >= 0){
            return leaderboard[pos];
        } else {
            System.err.println("Error, posicion invalida");
            return -1;
        }
    }

    /**
     * Metodo que maneja y se encarga de introducir en el array las 10 mejores puntuaciones
     * @param punt
     * Parametro en el cual está almacenada la puntuacion
     */
    public void enterLeaderboard(int punt) {
        //Si la puntuacion no es mejor que la decima mejor no hace nada
        if (punt > this.leaderboard[0]){
            //Este for se encarga de recorrer el array, junto con el if anidado se encarga de encontrar la posicion de la puntuacion
            for (int i = this.leaderboard.length - 1; i >= 0; i--) {
                if (punt > leaderboard[i]){
                    // Este for junto con el if anidad se encargan de empujar todas las puntuaciones por debajo de la que se quiere
                    // introducir un puesto hacia abajo, luego se introduce la nueva puntuacion
                    for (int j = 0; j <= i; j++){
                        if (j == i){
                            leaderboard[j] = punt;
                        } else {
                            leaderboard[j] = leaderboard[j+1];
                        }
                    }
                    break;
                }
            }
        }
    }


}
