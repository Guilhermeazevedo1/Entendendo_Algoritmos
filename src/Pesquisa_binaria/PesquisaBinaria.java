package Pesquisa_binaria;

// classe principal onde o algoritmo é executado
public class PesquisaBinaria {
    public static void main(String[] args) {
        // cria um array com 1 milhão de elementos (de 0 até 999.999)
        int[] lista = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            lista[i] = i; // Preenche o array com números crescentes
        }

        // chama o metodo de pesquisa binária procurando pelo valor 150000
        // e imprime o índice onde esse valor foi encontrado (ou -1 se não encontrado)
        System.out.println(algoritmoPesquisaBinaria(lista,150000));

    }
    // metodo que implementa a busca binária
    public static int algoritmoPesquisaBinaria(int[] lista, int item){
        int menorIndice = 0; // índice inicial do array
        int maiorIndice = lista.length - 1; // último índice do array
        int indiceMeio = 0; // índice do elemento do meio criado para ser chamado dentro do if
        int passos = 0; // contador para mostrar quantos passos a busca levou
        // enquanto ainda houver elementos no intervalo para buscar
        while(menorIndice <= maiorIndice){
            passos++; // incrementa o contador de passos a cada iteração
            // calcula o índice do meio entre menorIndice e maiorIndice
            indiceMeio = (menorIndice + maiorIndice) / 2;
            // obtém o valor do meio para comparar com o item buscado
            int chute = lista[indiceMeio];
            // se o chute for o item buscado, imprime os passos e retorna o índice
            if(chute == item){
                System.out.println(passos); // mostra quantos passos foram necessários
                return indiceMeio; // retorna a posição onde o item foi encontrado
            }
            // Se o chute for maior que o item, busca nos elementos menores (à esquerda)
            else if(chute > item){
                maiorIndice = indiceMeio - 1;
            }
            // Se o chute for menor, busca nos elementos maiores (à direita)
            else {
                menorIndice = indiceMeio + 1;
            }
        }
        // Se sair do laço, o item não está presente no array
        return -1;
    }
}
