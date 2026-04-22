package model;

import lombok.*;
import model.itens.Item;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Jogador extends Personagem{
    private double xpAtual;
    private long nivel;
    private List<Item> itemJogador = new ArrayList<>();

    public Jogador(String nome, int vida, int ataque, int defesa, int vidaMax, boolean defesaUsada, int agilidade) {
        super(nome, vida, ataque, defesa, vidaMax, defesaUsada, agilidade);
        this.xpAtual = 0; // 0 de XP
        this.nivel = 1;   // level
    }



    public void subirNivel(){
        while (xpAtual >= 100){
            this.nivel += 1;
            this.xpAtual -= 100;
            this.setVida(this.getVidaMax());

            this.setAtaque(this.getAtaque() + 5);
            this.setDefesa(this.getDefesa() + 2);
            this.setVida(this.getVida() + 20);
        }
    }

    public void listarItens(){
        int idx = 1;
        for (Item item: itemJogador){
            System.out.println("= " + idx + " -> "  + item.getNomeItem() + " |  Qtd: " + item.getQuantidadeItem());
            idx++;
        }
    }
}
