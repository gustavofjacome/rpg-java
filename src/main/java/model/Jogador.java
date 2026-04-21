package model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Jogador extends Personagem{
    private double xpAtual;
    private long nivel;
    private List<Item> itemJogador = new ArrayList<>();

    public Jogador(String nome, int vida, int ataque, int defesa) {
        super(nome, vida, ataque, defesa);
        this.xpAtual = 0; // 0 de XP
        this.nivel = 1;   // level
    }



    public void subirNivel(){
        while (xpAtual >= 100){
            this.nivel += 1;
            this.xpAtual -= 100;

            this.setAtaque(this.getAtaque() + 5);
            this.setDefesa(this.getDefesa() + 2);
            this.setVida(this.getVida() + 20);
        }
    }
}
