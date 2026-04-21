package model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

@NoArgsConstructor
@Getter
@Setter
public class Inimigo extends Personagem{
    private int xpFornecido;

    public Inimigo(String nome, int vida, int ataque, int defesa, int xpFornecido){
        super(nome, vida, ataque, defesa); // ta chamando os atributos da classe mãe para o construtor
        this.xpFornecido = xpFornecido;
    }

    public void realizarTurno(Personagem heroi) {
        Random dado100 = new Random();
        int dadoLancado = dado100.nextInt(100) + 1;

        if (dadoLancado <= 60) {
            atacar(heroi);
            System.out.println(getNome() + " atacou");

        } else if (dadoLancado <= 95) {

            if (heroi.getVida() >= this.getVida()) {
                defender();
                System.out.println(getNome() + " está se defendendo");
            } else {
                atacar(heroi);
                System.out.println(getNome() + " decidiu atacar");
            }

        } else {

            if (this.getVida() < heroi.getVida()) {
                if (fugir()) {
                    System.out.println(getNome() + " fugiu da batalha!");
                } else {
                    System.out.println(getNome() + " tentou fugir, mas falhou!");
                    atacar(heroi);
                }
            } else {
                atacar(heroi);
            }
        }
    }

}
