import model.Inimigo;
import model.itens.ItemCura;
import model.Jogador;
import service.CombateService;

public class Main {
    public static void main(String[] args) {
        Jogador heroi = new Jogador("Gustavo", 100, 25, 10, 100, false, 30);
        Inimigo monstro = new Inimigo("Goblin", 100, 15, 10, 100, 100, false, 55);

        ItemCura vidaBasica = new ItemCura("Poção de vida básico", 3, 20);
        heroi.getItemJogador().add(vidaBasica);

        CombateService combateService = new CombateService();
        combateService.iniciarCombate(heroi, monstro);
    }
}