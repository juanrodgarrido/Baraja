package Baraja;

public class Main {
    
    public static void main(String[] args) {
      
        //Creamos el mazo:
         Mazo mazo = new Mazo();
         //Lo rellenamos:
         mazo.rellenarMazo();
         System.out.println(mazo);

        mazo.barajar();
        System.out.println(mazo);

    }
}
