package br.com.magicAPI.projectListMagic.model;

public class CardResponse {
    private String name;
    private Integer qtd;

    CardResponse () {

    }
    

    public CardResponse(String name, Integer qtd) {
        this.name = name;
        this.qtd = qtd;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getQtd() {
        return qtd;
    }
    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    
}
