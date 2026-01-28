package Baraja;

public class Main {
    
    public static void main(String[] args) {
      
        //Creamos el mazo:
        Mazo mazo = new Mazo();
        //Como vemos aquí está ordenado:
         System.out.println(mazo);
        //Lo barajamos:
        mazo.barajar();
        //Comprobamos:
        System.out.println(mazo);

    }
}
