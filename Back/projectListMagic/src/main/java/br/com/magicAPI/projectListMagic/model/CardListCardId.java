package br.com.magicAPI.projectListMagic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CardListCardId implements Serializable {

    @Column(name = "id_list_card")
    private Integer id_list_card;

    @Column(name = "id_card")
    private Integer id_card;

    public CardListCardId() {
    }

    public CardListCardId(Integer id_list_card, Integer id_card) {
        this.id_list_card = id_list_card;
        this.id_card = id_card;
    }

    public Integer getId_list_card() {
        return id_list_card;
    }

    public void setId_list_card(Integer id_list_card) {
        this.id_list_card = id_list_card;
    }

    public Integer getId_card() {
        return id_card;
    }

    public void setId_card(Integer id_card) {
        this.id_card = id_card;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_list_card == null) ? 0 : id_list_card.hashCode());
        result = prime * result + ((id_card == null) ? 0 : id_card.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CardListCardId other = (CardListCardId) obj;
        if (id_list_card == null) {
            if (other.id_list_card != null)
                return false;
        } else if (!id_list_card.equals(other.id_list_card))
            return false;
        if (id_card == null) {
            if (other.id_card != null)
                return false;
        } else if (!id_card.equals(other.id_card))
            return false;
        return true;
    }

    
    
}
