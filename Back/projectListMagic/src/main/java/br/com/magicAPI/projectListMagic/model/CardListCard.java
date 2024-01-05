package br.com.magicAPI.projectListMagic.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;


@Entity(name = "cardlistcard")
public class CardListCard {

    @EmbeddedId
    private CardListCardId id;

    @Column(name = "qtd_card", length = 100, nullable = true)
    private Integer qtdCard;

    @ManyToOne
    @MapsId("id_list_card")
    private ListCard listCard;

    @ManyToOne
    @MapsId("id_card")
    private Card card;

    /*
    @ManyToMany
    @JoinTable(
            name = "card_list_card",
            joinColumns = @JoinColumn(name = "id_list_card"),
            inverseJoinColumns = @JoinColumn(name = "id_card")
    )
    private Set<Card> cards = new HashSet<>();
    */
    public CardListCard() {
    }

    public CardListCard(CardListCardId id, Integer qtdCard) {
        this.id = id;
        this.qtdCard = qtdCard;
    }

    public CardListCardId getId() {
        return id;
    }

    public void setId(CardListCardId id) {
        this.id = id;
    }

    public Integer getQtdCard() {
        return qtdCard;
    }

    public void setQtdCard(Integer qtdCard) {
        this.qtdCard = qtdCard;
    }
    
    public ListCard getListCard() {
        return listCard;
    }

    public void setListCard(ListCard listCard) {
        this.listCard = listCard;
    }

     public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
