
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
}
