package Baraja;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Creamos el mazo:
        Mazo mazo = new Mazo();
        Scanner sn = new Scanner(System.in);
        boolean checker = false;

        while (!checker) {
            System.out.println("""
                    ****** MENÚ PRINCIPAL ******
                    1. Barajar\s
                    2. Siguiente carta\s
                    3. Ver cuántas cartas disponibles hay\s
                    4. Dar cartas por cantidad\s
                    5. Ver que cartas hay en el montón\s
                    6. Ver que cartas hay en el mazo\s
                    7. Salir
                    ***********************""");
            int eleccion = sn.nextInt();
            switch (eleccion) {
                case 1:
                    mazo.barajar();
                    break;
                case 2:
                    System.out.println(mazo.siguienteCarta());
                    break;
                case 3:
                    System.out.println(mazo.cartasDisponibles());
                    break;
                case 4:
                    System.out.println("Cuantas cartas quieres dar?");
                    int n = sn.nextInt();
                    mazo.darCartas(n);
                    break;
                case 5:
                    mazo.cartasMonton();
                    break;
                case 6:
                    mazo.mostrarBaraja();
                    break;
                case 7:
                    checker = true;
                    System.out.println("******** SALIENDO ********");
                    break;
                default:
                    System.out.println("Elige una opción de la lista");
                    break;

            }
        }
    }

}