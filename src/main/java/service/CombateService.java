package service;

import model.Inimigo;
import model.Jogador;
import model.itens.Item;

import java.util.Scanner;

public class CombateService {

    public void iniciarCombate(Jogador jogador, Inimigo inimigo){

        Scanner scanner = new Scanner(System.in);
        int turno = 1;

        System.out.println("> > Um " + inimigo.getNome() + " apareceu! < <");

        while (jogador.isVivo() && inimigo.isVivo()){

            System.out.println("\n=== " + turno + "° TURNO ===");
            System.out.println("= " + jogador.getNome() + ": [ Vida: " + jogador.getVida() + " ]");
            System.out.println("= " + inimigo.getNome() + ": [ Vida:" + inimigo.getVida() + " ]");
            System.out.println("=================");

            System.out.println("= AÇÕES: ");
            System.out.println("= [ 1 ] Atacar\n= [ 2 ] Defender\n= [ 3 ] Item");
            System.out.println("=================");
            System.out.printf("= >>>>> Escolha sua opção: ");
            int escolha = scanner.nextInt();

            System.out.println("\n=== REGISTRO DO TURNO ===");
            switch (escolha){
                case 1:
                    if (inimigo.conseguiuEsquivar(jogador.getAgilidade())) {
                        System.out.println("= >>>>> O " + inimigo.getNome() + " foi rápido demais e ESQUIVOU do seu ataque!");
                    } else {
                        jogador.atacar(inimigo);
                        System.out.println("= >>>>> Você atacou o " + inimigo.getNome() + "!");
                    }
                    break;
                case 2:
                    jogador.defender();
                    System.out.println("= >>>>> Você assumiu a postura de defesa!");
                    break;
                case 3:
                    jogador.listarItens();
                    if (!jogador.getItemJogador().isEmpty()) {
                        System.out.print("= Digite o número do item para usar (ou 0 para voltar): ");
                        int indice = scanner.nextInt();

                        if (indice > 0 && indice <= jogador.getItemJogador().size()) {
                            Item itemEscolhido = jogador.getItemJogador().get(indice - 1);
                            itemEscolhido.usarItem(jogador);
                            if (itemEscolhido.getQuantidadeItem() <= 0) {
                                jogador.getItemJogador().remove(itemEscolhido);
                            }
                        }
                    } else {
                        System.out.println("= >>>>> Sua mochila está vazia!");
                    }
                    break;
                default:
                    System.out.println("= Ação inválida. Você tropeçou e perdeu o turno!");
            }

            if (inimigo.isVivo()){
                System.out.println("= Turno do inimigo...");
                if (jogador.conseguiuEsquivar(inimigo.getAgilidade())) {
                    System.out.println("= >>>>> VOCÊ ESQUIVOU! O ataque do " + inimigo.getNome() + " passou raspando!");
                } else {
                    inimigo.realizarTurno(jogador);
                }
            }
            System.out.println("=================");

            if (jogador.isDefesaUsada()){
                jogador.setDefesaUsada(false);
                jogador.setDefesa(jogador.getDefesa()-5);
            }
            if (inimigo.isDefesaUsada()){
                inimigo.setDefesaUsada(false);
                inimigo.setDefesa(inimigo.getDefesa()-5);
            }

            turno += 1;
        }

        System.out.println("\n=== FIM DE COMBATE ===");
        if (jogador.isVivo()){
            System.out.println("= Você venceu a batalha!");
            System.out.println("= Você ganhou " + inimigo.getXpFornecido() + " de XP!");
            jogador.setXpAtual(jogador.getXpAtual() + inimigo.getXpFornecido());
            jogador.subirNivel();
        } else {
            System.out.println("= Você foi derrotado... Game Over.");
        }
        System.out.println("=================");

        scanner.close();

    }

}
