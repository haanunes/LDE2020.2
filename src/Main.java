
public class Main {
    public static void main (String [] args){
        LDE lista = new LDE();
        lista.inserir(new Produto("Coca-cola 2L", 6.0),0);
        lista.inserir(new Produto("A�ucar 1 Kg", 4.0),0);
        lista.inserir(new Produto("Feij�o 2 Kg", 5.0),1);
        
        lista.imprimir();
        
    }
}
