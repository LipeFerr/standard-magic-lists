package br.com.magicAPI.projectListMagic.ctr;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magicAPI.projectListMagic.dao.CardListCardRepository;
import br.com.magicAPI.projectListMagic.model.Card;
import br.com.magicAPI.projectListMagic.model.CardListCard;
import br.com.magicAPI.projectListMagic.model.ListCard;

@RestController
@RequestMapping("/CardListCard")
public class CardListCardController {
     @Autowired
    private CardListCardRepository cardListCardRepository;

    @GetMapping
    public List<CardListCard> getCardsAll() {
        return cardListCardRepository.findAll();
    }

    @GetMapping("/{listCardId}")
    public List<CardListCard> getCardsByListCardId(@PathVariable Integer listCardId) {
        List<CardListCard> cardListCards = cardListCardRepository.findByListCardId(listCardId);
        return cardListCards;
    }

    @GetMapping("/infoTxt/{listCardId}")
    public Object getBtnPage(@PathVariable Integer listCardId) {

        ListCardController ctrListCard = new ListCardController();
        CardController ctrCard = new CardController();

        Optional<ListCard> listCard = ctrListCard.getListCard(listCardId);
        List<Card> cards = new ArrayList<>();

        List<CardListCard> listCards = getCardsByListCardId(listCard.get().getId());

        for (CardListCard cardListCard : listCards) {
            Integer cardId = cardListCard.getId().getId_card();
            Optional<Card> optionalCard = ctrCard.getCardById(cardId);

            optionalCard.ifPresent(cards::add);
        }

        StringBuilder jsonBuilder = new StringBuilder();

        jsonBuilder.append("{");
        jsonBuilder.append("\"Color\":").append(listCard.get().getColor()).append(",");
        jsonBuilder.append("\"Name\":").append(listCard.get().getName()).append(",");
        jsonBuilder.append("\"Cards\":[").append("\"");

        for (Card card : cards) {
            
            Integer qtd = listCards.stream()
                .filter(x -> x.getId().getId_card() == card.getId())
                .mapToInt(arg0 -> arg0.getQtdCard()) // Obtenha o valor de qtd_card
                .sum();
                          

            jsonBuilder.append("{");
            jsonBuilder.append("\"Name\":").append(card.getName()).append(",");
            jsonBuilder.append("\"Qtd\":").append(qtd).append("\"");
            jsonBuilder.append("},");
            
        }

        // Remova a vírgula extra após o último objeto
        if (!cards.isEmpty()) {
            jsonBuilder.deleteCharAt(jsonBuilder.length() - 1);
        }

        jsonBuilder.append("]}");
        

        

        return jsonBuilder.toString();
    }
    
}
