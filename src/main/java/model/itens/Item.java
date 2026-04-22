package model.itens;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Jogador;

@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class Item {

    private String nomeItem;
    private int quantidadeItem;

    public abstract void aplicarEfeito(Jogador jogador);

    public void usarItem(Jogador jogador){
        if (this.quantidadeItem > 0){
            aplicarEfeito(jogador);
            this.quantidadeItem--;
            System.out.println("= >>>>> " + this.nomeItem + ". Restam " + this.quantidadeItem);
        }


    }


}
