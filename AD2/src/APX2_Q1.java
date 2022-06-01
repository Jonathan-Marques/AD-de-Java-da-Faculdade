import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Objects;

class Filme {
    String nome;
    Tema tema;
    ArrayList<String> artistas = new ArrayList<>();
    public Filme(String nomeFilme, Tema genero) {
        this.nome = nomeFilme;
        this.tema = genero;
    }
    public void adicionaArtista(@NotNull Artista string) {
            artistas.add(string.toString());
        }
}
class Tema {
    String tema;
    public Tema(String genero) {
        this.tema = genero;
    }
    public String toString(){
        return this.tema;
    }
}
class Artista {
    String artista;
    public Artista(String nomeArtista) {
        this.artista = nomeArtista;
    }
    public String toString(){
        return this.artista;
    }
}
class Catalogo {
    ArrayList<Filme> films = new ArrayList<>();
    ArrayList<Serie> series = new ArrayList<>();
    public Catalogo adiciona(Filme filme) {
        this.films.add(filme);
        return  this;
    }
    public void adiciona(Serie serie) {
        this.series.add(serie);
    }
    public String toString(){
        StringBuilder catalogo = new StringBuilder();
        for (Filme filme : films){
            catalogo.append("Titulo: ").append(filme.nome).append(", Tema: ").append(filme.tema).append("\n");
        }
        for (Serie serie : series){
            catalogo.append("Titulo: ").append(serie.nome).append(", Tema: ").append(serie.tema).append("\n");
        }
         return String.valueOf(catalogo);
    }

    public StringBuilder filtra(String nomeArtista) {
        StringBuilder catalogo = new StringBuilder();
        for (Filme filme : films){
            if(filme.nome.equals(nomeArtista))
                catalogo.append("Titulo: ").append(filme.nome).append(", Tema: ").append(filme.tema).append("\n");
            else if(Objects.equals(filme.tema.toString(), nomeArtista))
                catalogo.append("Titulo: ").append(filme.nome).append(", Tema: ").append(filme.tema).append("\n");
            else{
                for (String art : filme.artistas){
                    String []nomes= art.split(" ");
                    for (String arti : nomes){
                        if(arti.equals(nomeArtista)){
                            catalogo.append("Titulo: ").append(filme.nome).append(", Tema: ").append(filme.tema).append("\n");
                        }
                    }
                }
            }
        }
        for (Serie serie : series){
            if(Objects.equals(serie.nome, nomeArtista))
                catalogo.append("Titulo: ").append(serie.nome).append(", Tema: ").append(serie.tema).append("\n");
            else if(serie.tema.toString().equals(nomeArtista))
                catalogo.append("Titulo: ").append(serie.nome).append(", Tema: ").append(serie.tema).append("\n");
            else{
                for (String art : serie.artistas){
                    String []nomes= art.split(" ");
                    for (String arti : nomes){
                        if(arti.equals(nomeArtista)){
                            catalogo.append("Titulo: ").append(serie.nome).append(", Tema: ").append(serie.tema).append("\n");
                        }
                    }
                }
            }
        }
        return new StringBuilder(catalogo.toString());
    }
 }
 class Serie {
    String nome;
    Tema tema;
    int temporada;
    int episodio;
    String titulo;
    ArrayList<String> artistas = new ArrayList<>();
    public Serie(String nomeSerie, Tema genero, int temporada, int episodio, String nomeEpisodio) {
        this.nome = nomeSerie;
        this.titulo = nomeEpisodio;
        this.tema = genero;
        this.temporada = temporada;
        this.episodio = episodio;
    }
    public void adicionaArtista(@NotNull Artista string) {
        artistas.add(string.toString());
    }
}
public class APX2_Q1 {
    public static  void main (String[] args){
        Filme mp = new Filme("Medida Provisoria", new Tema("Ficcao"));
        Filme cd = new Filme("Cidade de Deus", new Tema("Drama"));
        Filme ac = new Filme("Auto da Compadecida", new Tema("Aventura"));
        Serie ir = new Serie("Irmandade", new Tema("Drama"), 1, 1, "O Certo e o Certo");
        Artista tais = new Artista("Tais Araujo");
        Artista jorge = new Artista("Seu Jorge");
        Artista selton = new Artista("Selton Mello");
        mp.adicionaArtista(tais);
        mp.adicionaArtista(jorge);
        ac.adicionaArtista(selton);
        cd.adicionaArtista(jorge);
        ir.adicionaArtista(jorge);
        Catalogo catalogo = new Catalogo();
        catalogo.adiciona(mp).adiciona(cd).adiciona(ac).adiciona(ir);
        System.out.println("Catalogo completo:");
        System.out.println(catalogo);
        System.out.println("Filmes e Series com Seu Jorge:");
        System.out.println(catalogo.filtra("Jorge"));
        System.out.println("Dramas:");
        System.out.println(catalogo.filtra("Drama"));
        System.out.println("Filmes e Series com Tais Araujo e Selton Mello juntos:");
        //(catalogo.filtra("Tais").filtra("Mello"));
        System.out.println("Filmes e Series com Tais Araujo unidos com os do Selton Mello:");
        //System.out.println(catalogo.filtra("Tais").uniao(catalogo.filtra("Mello")));
    }
}

