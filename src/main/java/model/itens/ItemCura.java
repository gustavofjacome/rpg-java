package model.itens;

import lombok.Getter;
import lombok.Setter;
import model.Jogador;

@Getter
@Setter
public class ItemCura extends Item{

    private int valorCura;

    public ItemCura(String nome, int quantiadeItem, int valorCura){
        super(nome, quantiadeItem);
        this.valorCura = valorCura;
    }

    @Override
    public void aplicarEfeito(Jogador jogador){
        int vidaAnterior = jogador.getVida();
        int novaVida = jogador.getVida() + this.valorCura;
        if (novaVida > jogador.getVidaMax()){
            novaVida = jogador.getVidaMax();
        }

        jogador.setVida(novaVida);

        System.out.println("= >>>>> Poção de vida usada! " + this.valorCura + "de vida foi recuperada.");
    }
}
