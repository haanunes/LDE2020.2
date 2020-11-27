
public class LDE {

    public Produto cabeca;
    public Produto cauda;
    public int tamanho=0;

    public void inserirInicio(Produto novo) {
        if (cabeca == null) {// ou this.tamanho==0
            cabeca = novo;
            cauda = novo;
            tamanho++;
        }
        else{
            novo.proximo=cabeca;
            cabeca.anterior=novo;
            cabeca=novo;
            tamanho++;
        }
    }
    
    public void inserirFinal(Produto novo){
         if (cabeca == null) {// ou this.tamanho==0
            cabeca = novo;
            cauda = novo;
            tamanho++;
        }
         else {
             cauda.proximo=novo;
             novo.anterior=cauda;
             cauda=novo;
             tamanho++;
         }
    }
    
    public int getTamanho(){
        return tamanho;
    }
}
