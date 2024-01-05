package br.com.magicAPI.projectListMagic.ctr;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magicAPI.projectListMagic.dao.CardListCardRepository;
import br.com.magicAPI.projectListMagic.model.BtnPageResponse;
import br.com.magicAPI.projectListMagic.model.Card;
import br.com.magicAPI.projectListMagic.model.CardListCard;
import br.com.magicAPI.projectListMagic.model.CardResponse;
import br.com.magicAPI.projectListMagic.model.ListCard;
import br.com.magicAPI.projectListMagic.service.CardService;
import br.com.magicAPI.projectListMagic.service.ListCardService;

@CrossOrigin
@RestController
@RequestMapping("/CardListCard")
public class CardListCardController {
     @Autowired
    private CardListCardRepository cardListCardRepository;

    @Autowired
    private CardService cardService;

    @Autowired
    private ListCardService listCardService;

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
    public ResponseEntity<BtnPageResponse> getBtnPage(@PathVariable Integer listCardId) {
        Optional<ListCard> listCard = listCardService.getListCard(listCardId);
        List<Card> cards = new ArrayList<>();
        List<CardListCard> listCards = getCardsByListCardId(listCard.get().getId());

        for (CardListCard cardListCard : listCards) {
            Integer cardId = cardListCard.getId().getId_card();
            Optional<Card> optionalCard = cardService.getCardById(cardId);

            optionalCard.ifPresent(cards::add);
        }

        List<CardResponse> cardResponses = new ArrayList<>();

        for (Card card : cards) {
            Integer qtd = listCards.stream()
                .filter(x -> x.getId().getId_card() == card.getId())
                .mapToInt(CardListCard::getQtdCard)
                .sum();

            cardResponses.add(new CardResponse(card.getName(), qtd));
        }

        BtnPageResponse response = new BtnPageResponse();
        response.setColor(listCard.get().getColor());
        response.setName(listCard.get().getName());
        response.setCards(cardResponses);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public CardListCard insertCardListCard(@RequestBody CardListCard cardListCard){

        Card card = cardService.getCardById(cardListCard.getId().getId_card()).orElse(null);
        ListCard listCard = listCardService.getListCard(cardListCard.getId().getId_list_card()).orElse(null);

        cardListCard.setCard(card);
        cardListCard.setListCard(listCard);

        return cardListCardRepository.save(cardListCard);
    }
}
