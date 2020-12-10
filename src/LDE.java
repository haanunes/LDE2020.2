
public class LDE {

    public Produto cabeca;
    public Produto cauda;
    public int tamanho = 0;

    private void inserirInicio(Produto novo) {
        if (cabeca == null) {// ou this.tamanho==0
            cabeca = novo;
            cauda = novo;
            tamanho++;
        } else {
            novo.proximo = cabeca;
            cabeca.anterior = novo;
            cabeca = novo;
            tamanho++;
        }
    }

    private void inserirFinal(Produto novo) {
        if (cabeca == null) {// ou this.tamanho==0
            cabeca = novo;
            cauda = novo;
            tamanho++;
        } else {
            cauda.proximo = novo;
            novo.anterior = cauda;
            cauda = novo;
            tamanho++;
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    public void inserir(Produto novo, int indice) {
        if (tamanho == 0 || indice <= 0) {
            inserirInicio(novo);
        } else if (indice >= tamanho) {
            inserirFinal(novo);
        } else {
            Produto aux = cabeca;
            //exemplo indice = 3
            for (int i = 0; i < indice - 1; i++) {
                aux = aux.proximo;
            }
            // achei a posição correta do aux. ele parou um indice antes.
            (aux.proximo).anterior = novo;
            novo.proximo = aux.proximo;
            //a troca a seguir ela não pode ser executada antes da anterior
            //pois iria perder a ligação com o elemento que está na posição
            //indiceQueQuerAdicionar+1
            aux.proximo = novo;
            novo.anterior = aux;
            tamanho++;
            /*
            //exemplo da revisão com coca cola do dia 04/12/2020 parte 1
            // desvantagem desse método é: utilizar mais uma variável para ocupar RAM
            Produto coca = aux.proximo;
            aux.proximo=novo;
            novo.anterior=aux;
            coca.anterior=novo;
            novo.proximo=coca;
            tamanho++;
*/
        }
    }
    
    public void imprimir(){
        Produto aux=cabeca;
        for (int i =0; i<tamanho;i++){
            System.out.print("| "+aux.descricao+" R$ "+aux.preco+" |");
            aux=aux.proximo;
        }
        System.out.println("");
    }
    
    public void imprimirIniciandoNaCauda(){
        Produto aux=cauda;
        for (int i =0; i<tamanho;i++){
            System.out.print("| "+aux.descricao+" R$ "+aux.preco+" |");
            aux=aux.anterior;
        }
        System.out.println("");
    }
    
    public Produto removerInicio(){
        if (tamanho==0){
            System.out.println("Lista vazia!");
            return null;
        }
        else if (tamanho ==1){
            Produto removido = cabeca;
            cabeca= null;
            cauda = null;
            tamanho--;
            return removido;
        }
        else{
            Produto removido = cabeca;
            cabeca=cabeca.proximo;
            cabeca.anterior.proximo=null;
            cabeca.anterior=null;
            tamanho--;
            return removido;
        }
    }
    
    public Produto removerFinal(){
         if (tamanho==0){
            System.out.println("Lista vazia!");
            return null;
        }
        else if (tamanho ==1){
            Produto removido = cabeca;
            cabeca= null;
            cauda = null;
            tamanho--;
            return removido;
        }
        else{
            Produto u = cauda; //u de ultimo
            // maneira ruim, pois gasta mais uma variável
            /*
            Produto p = u.anterior;  // p de penultimo
            cauda = p;
            u.anterior = null;
            p.proximo=null;
            tamanho --;
            return u;
            */
            cauda = u.anterior;
            cauda.proximo.anterior=null; //ou ....  u.anterior=null
            cauda.proximo=null;
            tamanho --;
            return u;
        }
    }
    
    public Produto remover(int i){
        if (i<=0){
           return removerInicio();
        }
        else if (i>= tamanho-1){
            return removerFinal();
        }
        else {
            Produto aux = cabeca;
            for (int j =0; j<i-1 ; j++){
                aux = aux.proximo;
            }
            Produto removido = aux.proximo;
            aux.proximo=removido.proximo;
            aux.proximo.anterior=aux;
            removido.proximo=null;
            removido.anterior=null;
            tamanho--;
            return removido;
        }
    }
    public void inserirOrdenadoPeloPreco(Produto novo){
        //tarefinha de casa
    }
    
    public void inserirMelhorComplexidade(Produto novo){
        // para casa
    }
}
