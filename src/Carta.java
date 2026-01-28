package Baraja;



public class Carta {
    private int numero;
    private String palo;


    public Carta(int numero, String palo){
        this.numero = numero;
        this.palo = palo;
    }

    public String getPalo() {
        return palo;
    }

    public int getNumero() {
        return numero;
    }




    @Override
    public String toString() {
        return "Número: "+this.numero+"\n"+"Palo: "+this.palo;
    }
}
