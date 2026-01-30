package Baraja;

import java.util.Random;

public class Mazo {
    private Carta mazo[];
    private int contadorSalidas;
    private static String[] opcionesPalo = { "Picas", "Oros", "Diamantes", "Bastos" };
    private static Random rnd = new Random();

    public Mazo() {
        this.mazo = new Carta[40];
        rellenarMazo();
    }

    private void rellenarMazo() {
        int i = 0;
        for (String p : opcionesPalo) {
            for (int z = 1; z < 11; z++) {
                if (z >= 8) {
                    mazo[i] = new Carta((z + 2), p); // Aquí llenamos el mazo de cartas
                } else {
                    mazo[i] = new Carta(z, p);
                }
                i++;
            }
        }
    }

    public void barajar() {
        Carta auxiliar; // aqui guardaremos la carta que cambiaremos
        int random = 0;
        for (int i = 0; i < mazo.length; i++) {
            random = rnd.nextInt(40);
            auxiliar = mazo[random];
            mazo[random] = mazo[i];
            mazo[i] = auxiliar;
        }
        System.out.println("El mazo ha sido barajado \n");
    }

    public String siguienteCarta() {
        if (contadorSalidas >= mazo.length) {
            return "No quedan cartas";
        }

        Carta siguienteCarta = mazo[contadorSalidas]; // Guardamos la carta

        this.contadorSalidas++;
        return siguienteCarta.toString();

    }

    public String cartasDisponibles() {
        return "Quedan " + (this.mazo.length - this.contadorSalidas) + " cartas disponibles";

    }

    public void darCartas(int cantidad) {
        if (this.mazo.length - this.contadorSalidas >= cantidad) {
            for (int i = 0; i < cantidad; i++) {
                System.out.println(mazo[this.contadorSalidas]);
                this.contadorSalidas++;
            }
        } else {
            System.out.println("No quedan suficientes cartas");
        }
    }

    public void cartasMonton() {
        if (contadorSalidas > 0) {
            System.out.println("Cartas en el montón: ");
            for (int i = 0; i < contadorSalidas; i++) {
                System.out.println(mazo[i]);
            }
        } else {
            System.out.println("No ha salido ninguna carta!");
        }
    }

    public void mostrarBaraja() {
        if (contadorSalidas < this.mazo.length) {
            System.out.println("Cartas aún en el mazo:");
            for (int i = contadorSalidas; i < this.mazo.length; i++) {
                System.out.println(mazo[i]);
            }
        } else {
            System.out.println("No quedan cartas en el mazo");
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

    /*
     * METODO PARA CREAR UNA SOLA CARTA AL AZAR (NO UTIL EN ESTE CASO)
     * public static Carta generarCarta(){
     * int num = rnd.nextInt((12 ) + 1);
     * String palo = opcionesPalo[rnd.nextInt(opcionesPalo.length)];
     * 
     * return new Carta(num, palo);
     * }
     */
}