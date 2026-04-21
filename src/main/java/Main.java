import model.Inimigo;
import model.Jogador;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Jogador heroi = new Jogador("Gustavo", 100, 25, 10);

        Inimigo monstro = new Inimigo("Goblin", 100, 15, 10, 100);

        System.out.println("Um " + monstro.getNome() + " apareceu!");


        while (heroi.isVivo() && monstro.isVivo()) {

            System.out.println("\n=== NOVO TURNO ===");
            System.out.println(heroi.getNome() + " [Vida: " + heroi.getVida() + "]");
            System.out.println(monstro.getNome() + " [Vida: " + monstro.getVida() + "]");
            System.out.println("Escolha sua ação: [1] Atacar  [2] Defender");

            int escolha = scanner.nextInt();


            if (escolha == 1) {
                heroi.atacar(monstro);
                System.out.println("Você atacou o " + monstro.getNome() + "!");
            } else if (escolha == 2) {
                heroi.defender();
                System.out.println("Você assumiu postura de defesa!");
            } else {
                System.out.println("Ação inválida. Você tropeçou e perdeu o turno!");
            }


            if (monstro.isVivo()) {
                System.out.println("\nTurno do inimigo...");
                monstro.realizarTurno(heroi);
            }
        }

        System.out.println("\n=== FIM DE COMBATE ===");
        if (heroi.isVivo()) {
            System.out.println("Você venceu a batalha!");
            System.out.println("Você ganhou " + monstro.getXpFornecido() + " de XP!");
            heroi.setXpAtual(heroi.getXpAtual() + monstro.getXpFornecido());
            heroi.subirNivel();

        } else {
            System.out.println("Você foi derrotado... Game Over.");
        }

        scanner.close();
    }
}