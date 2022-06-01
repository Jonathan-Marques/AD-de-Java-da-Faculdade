import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import java.io.*;

class Elemento {
    int num;
    int qtas_vezes;
    Elemento prox;

    public Elemento(int num) {
        this.num = num;
        qtas_vezes = 1;
        prox = null;
    }

    public String toString() {
        return num + " (" + qtas_vezes + ")\n";
    }
}
class Lista {
    Elemento primeiro;
    Lista() {
        primeiro = null;
    }
    void inserir(int num) {
        Elemento novo = new Elemento(num);
        if (primeiro == null) {
            primeiro = novo;
        } else {
            Elemento pri = primeiro;

            while (pri != null) {
                if (num == 0) {
                    return;
                }
                pri = pri.prox;
            }
            novo.prox = primeiro;
            primeiro = novo;
        }
    }
}
public class APX2_Q2 {
    public static void main(String[] args) throws IOException {
        String path ="C:\\Users\\dota-\\IdeaProjects\\AD2\\src\\Arq1.txt"; // endereço onde esta o arquivo da entrada de dados
        String path2 ="C:\\Users\\dota-\\IdeaProjects\\AD2\\src\\Arq3.txt"; // endereço onde esta o arquivo da entrada de dados
        BufferedReader arquivo1 = new BufferedReader(new FileReader(path));
        BufferedReader arquivo2 = new BufferedReader(new FileReader(path2));
        String seq;

        Lista list1 = new Lista();
        Lista list2 = new Lista();

        try {
            while ((seq = arquivo1.readLine()) != null) {
                String[] verseq = seq.split("");
                list1.inserir(Integer.parseInt(verseq[0].trim()));
        }
            while ((seq = arquivo2.readLine()) != null) {
                String[] verseq = seq.split("");
                list2.inserir(Integer.parseInt(verseq[0].trim()));
        }

        }catch (IOException err){
            System.out.println("Error: " + err.getMessage());
        }
        CompareDoisArquivos(list1, list2);
    }
    private static void CompareDoisArquivos(@NotNull Lista list1, Lista list2) {
        if (list1.primeiro != null) {
            boolean resposta = false;
            for (Elemento p = list1.primeiro; p != null; p = p.prox) {
                for (Elemento q = list2.primeiro; q != null; q = q.prox) {
                    resposta = eIgual(p, q);
                }
            }
            System.out.println(resposta);
        }
    }
    @Contract(pure = true)
    private static boolean eIgual(@NotNull Elemento p, @NotNull Elemento q) {
        return (p.num) == (q.num);
    }
}



