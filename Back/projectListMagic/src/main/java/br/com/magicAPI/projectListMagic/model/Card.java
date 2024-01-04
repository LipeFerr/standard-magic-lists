package br.com.magicAPI.projectListMagic.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 100, nullable = true)
    private Integer id;

    @Column(name = "name", length = 100, nullable = true)
    private String name;
    
    //@OneToMany(mappedBy = "card", cascade = CascadeType.ALL, orphanRemoval = true)
    //private Set<CardListCard> cardListCards = new HashSet<>();

    public Card() {

    }

    public Card(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    
}