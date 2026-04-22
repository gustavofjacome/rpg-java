package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Personagem {

    private String nome;
    private int vida;
    private int ataque;
    private int defesa;
    private int vidaMax;
    private boolean defesaUsada;
    private int agilidade;

    public void atacar(Personagem alvo) {
        int dano = this.getAtaque() - alvo.getDefesa();
        if (dano < 0) {
            dano = 0;
        }
        alvo.receberDano(dano);
    }

    public boolean isVivo() {
        return this.vida > 0;
    }

    public void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0;
        }
    }

    public void defender() {
        this.defesa += 5;
        defesaUsada = true;
    }

    public boolean fugir() {
        Random dado = new Random();
        int chance = dado.nextInt(100) + 1;

        return chance <= 50;
    }

    public boolean conseguiuEsquivar(int agilidadeAtacante) {
        Random random = new Random();
        int chanceFinal = 10 + (this.getAgilidade() - agilidadeAtacante);

        chanceFinal = Math.max(5, Math.min(chanceFinal, 70));

        return (random.nextInt(100) + 1) <= chanceFinal;
    }

}
