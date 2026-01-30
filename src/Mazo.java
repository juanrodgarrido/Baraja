package Baraja;

import java.util.ArrayList;
import java.util.Random;

public class Mazo {
    private ArrayList<Carta> mazo;
    private ArrayList<Carta> mazoSalido;
    private int contadorSalidas;
    private static String[] opcionesPalo = {"Picas", "Oros", "Diamantes", "Bastos"};
    private static Random rnd = new Random();

    public Mazo() {
        this.mazo = new ArrayList<>(40); //Le doy una capacidad inicial para que Java no tenga que redimensionar 40 veces (rendimiento)
        this.mazoSalido = new ArrayList<>(40);
        rellenarMazo();
    }


    private void rellenarMazo() {
        int i = 0;
        for (String p : opcionesPalo) {
            for (int z = 1; z < 11; z++) {
                if (z >= 8) {
                    mazo.add(new Carta((z + 2), p)); //Aquí llenamos el mazo de cartas

                } else {
                    mazo.add(new Carta(z, p));
                }
                i++;
            }
        }
    }


    public void barajar() {
        Carta auxiliar; //aqui guardaremos la carta que cambiaremos
        int random = 0;
        if (mazo.size() <= 1) {
            System.out.println("No quedan suficientes cartas para barajar");
        } else {
            for (int i = 0; i < mazo.size(); i++) {
                random = rnd.nextInt(mazo.size());
                auxiliar = mazo.get(random);
                mazo.set(random, mazo.get(i));
                mazo.set(i, auxiliar);
            }
            System.out.println("El mazo ha sido barajado \n");
        }
    }

    public String siguienteCarta() {
        if (contadorSalidas >= mazo.size()) {
            return "No quedan cartas";
        }

        Carta siguienteCarta = mazo.get(contadorSalidas); //Guardamos la carta
        mazoSalido.add(siguienteCarta);
        mazo.remove(siguienteCarta);
        this.contadorSalidas++;
        return siguienteCarta.toString();

    }

    public String cartasDisponibles() {
        return "Quedan " + (this.mazo.size()) + " cartas disponibles";

    }

    public void darCartas(int cantidad) {
        if (this.mazo.size() >= cantidad) {
            for (int i = 0; i < cantidad; i++) {
                System.out.println(mazo.getFirst());
                mazoSalido.add(mazo.getFirst());
                mazo.removeFirst();
                this.contadorSalidas++;
            }
        } else {
            System.out.println("No quedan suficientes cartas");
        }
    }

    public void cartasMonton(){
        if(contadorSalidas > 0){
        System.out.println("Cartas en el montón: ");
        for(int i = 0; i<mazoSalido.size(); i++) {
            System.out.println(mazoSalido.get(i));
        }
        }else{
            System.out.println("No ha salido ninguna carta!");
        }
    }

    public void mostrarBaraja(){
        if(!mazo.isEmpty()){
            System.out.println("Cartas aún en el mazo:");
            for(int i = 0; i<this.mazo.size();i++){
                System.out.println(mazo.get(i));
            }
        }else{
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


    /* METODO PARA CREAR UNA SOLA CARTA AL AZAR (NO UTIL EN ESTE CASO)
    public static Carta generarCarta(){
        int num = rnd.nextInt((12) + 1);
        String palo = opcionesPalo[rnd.nextInt(opcionesPalo.length)];

        return new Carta(num, palo);
    } */
}