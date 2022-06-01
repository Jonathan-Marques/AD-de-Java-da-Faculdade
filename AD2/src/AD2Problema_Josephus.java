//Jonathan Santiago Marques
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class No {
    public int iD;
    public No proximo;
    public No(int x) {
        iD = x;
    }
    public void displayNo() {
        System.out.print(iD + " ");

    }

}

class ListaCircular {
    private No primeiro;
    private No ultimo;
    private No atual;
    private int count; // itens totais da lista

    public ListaCircular() {
        primeiro = null;
        ultimo = null;
        atual = null;
        count = 0;
    }

    public boolean EstaVazio() {
        return primeiro == null;
    }

    public void Passo() {
        atual = atual.proximo;
    }

    public No getPrimeiro() {
        return primeiro;
    }

    public void Inserir(int x) {
        No novoNo = new No(x);

        if (EstaVazio()) {
            primeiro = novoNo;
            atual = primeiro;
        } else {
            atual.proximo = novoNo;
        }

        novoNo.proximo = primeiro;
        ultimo = novoNo;
        Passo();
        count++;
    }

    public boolean Procurar(int x) {
        No Procurar = primeiro;
        int y = 0;

        while (Procurar.iD != x && y < count) {
            Procurar = Procurar.proximo;
            y++;
        }

        if (Procurar.iD == x) {
            System.out.println("Encontrei o valor: " + Procurar.iD);
            return true;
        } else {
            System.out.println("Valor não encontrado na lista:");
            return false;
        }

    }

    public void delete(int x) {
        No anterior = primeiro;
        No atua1 = primeiro.proximo;

        while (atua1.iD != x) {
            anterior = atua1;
            atua1 = atua1.proximo;

        }

        if (count == 1) {
            primeiro = null;
            count--;
        } else if (atua1 == primeiro) {
            anterior.proximo = atua1.proximo;
            primeiro = atua1.proximo;
            count--;
        } else {
            anterior.proximo = atua1.proximo;
            count--;
        }

    }

    public void ListaTela() {
        int x = 0;
        No printer = primeiro;

        while (x < count) {
            printer.displayNo();
            printer = printer.proximo;
            x++;
        }
        System.out.println("");

    }

}

class Josephus {

    private int numPessoas; // número de pessoas no círculo
    private int countNum; // número usado para contar
    private No topo;
    private No baixo;
    ListaCircular circulo;

    public Josephus() {
        circulo = new ListaCircular();
        numPessoas = 0;
        countNum = 0;

    }

    public void setNumPessoas(int x) {
        numPessoas = x;

    }

    public void setCountNum(int x) {
        countNum = x;
    }

    public void addPessoas() {
        for (int i = 1; i < numPessoas; i++) {
            circulo.Inserir(i);
        }
    }

    public void mover() {

        for (int i = 0; i < countNum; i++) {
            baixo = topo;
            topo = topo.proximo;
        }
       System.out.println("Foi Morto o: " + topo.iD);

    }

    public void executar() {
        baixo = null;
        topo = circulo.getPrimeiro();
        while (numPessoas != 2) {

            mover();
            circulo.delete(topo.iD);
            baixo = baixo.proximo;
            topo = topo.proximo;
            numPessoas--;
            tela();
        }

    }

    public void tela() {
        System.out.print("Sobreviveu:  ");
        circulo.ListaTela();
    }

}

// metodo da entrada de dados lembra de mudar o endereço do arquivo antes de executalo
class LeArquivo{
    public int pessoa = + 1;
    public int posicao = + 1;
    public LeArquivo() {

        String path = "C:\\Users\\dota-\\IdeaProjects\\AD2\\src\\Entrada.txt";// endereço onde esta o arquivo da entrada de dados
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while (!"FIM".equals(line) && line != null){
               pessoa = pessoa + 1;
               //System.out.println(line);
               line = br.readLine();
            }
            while ((line = br.readLine()) != null && line.length() > 0 ){
                posicao = Integer.parseInt(line);
                //System.out.println(posicao);

            }
        }catch (IOException err){
            System.out.println("Error: " + err.getMessage());
        }
    }
}


//programa principal
public class AD2Problema_Josephus{

    public static void main(String[] args) {
        Josephus suicidio = new Josephus();
        LeArquivo entrada = new LeArquivo();

        suicidio.setNumPessoas(entrada.pessoa);// entrada das quantidas de pessoas
        suicidio.addPessoas();
        suicidio.tela();

        suicidio.setCountNum(entrada.posicao);// posição inicial
        suicidio.executar();

    }

}

