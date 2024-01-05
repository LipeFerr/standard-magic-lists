package br.com.magicAPI.projectListMagic.model;

import java.util.List;

public class BtnPageResponse {
    private String color;
    private String name;
    private List<CardResponse> cards;

    public BtnPageResponse(){

    }

    public BtnPageResponse(String color, String name, List<CardResponse> cards) {
        this.color = color;
        this.name = name;
        this.cards = cards;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CardResponse> getCards() {
        return cards;
    }

    public void setCards(List<CardResponse> cards) {
        this.cards = cards;
    }

}
