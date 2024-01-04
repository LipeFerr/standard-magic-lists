package br.com.magicAPI.projectListMagic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity(name = "listcard")
public class ListCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 100, nullable = true)
    private String name;

    @Column(name = "color", length = 100, nullable = true)
    private String color;
    
    //@OneToMany(mappedBy = "listCard", cascade = CascadeType.ALL, orphanRemoval = true)
    //private Set<CardListCard> cardListCards = new HashSet<>();


    public ListCard() {

    }

    public ListCard(Integer id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    /*
    public void setCardListCards(Set<CardListCard> cardListCards) {
        this.cardListCards = cardListCards;
    }

    public Set<CardListCard> getCardListCards() {
        return cardListCards;
    }
    */
}