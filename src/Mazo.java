package Baraja;

import java.util.Random;

public class Mazo {
    private Carta mazo[];
    private static String[] opcionesPalo = {"Picas", "Oros", "Diamantes", "Bastos"};
    private static Random rnd = new Random();

    public Mazo() {
        this.mazo = new Carta[40]; //Creamos un array de tipo Carta con 40 huecos para cartas
        rellenarMazo();

    }

    private void rellenarMazo() {
        int i = 0;
        for (String p : opcionesPalo) {
            for (int z = 1; z < 11; z++) {
                if (z >= 8) {
                    mazo[i] = new Carta((z + 2), p); //Aquí llenamos el mazo de cartas
                } else {
                    mazo[i] = new Carta(z, p);
                }
                i++;
            }
        }
    }


    public void barajar(){
    Carta auxiliar; 
    int random = 0;
        for(int i = 0; i < mazo.length; i++){
            random = rnd.nextInt(40);
            auxiliar = mazo[random];
            mazo[random] = mazo[i];
            mazo[i] = auxiliar;
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Mazo:\n");
        for (Carta carta : mazo) {
            sb.append("Num: ").append(carta.getNumero())
                    .append(" - Palo: ").append(carta.getPalo()).append("\n");
        }
        return sb.toString();
    }








    /* METODO PARA CREAR UNA SOLA CARTA AL AZAR (NO UTIL EN ESTE CASO)
    public static Carta generarCarta(){
        int num = rnd.nextInt((12  ) + 1);
        String palo = opcionesPalo[rnd.nextInt(opcionesPalo.length)];

        return new Carta(num, palo);
    } */
}