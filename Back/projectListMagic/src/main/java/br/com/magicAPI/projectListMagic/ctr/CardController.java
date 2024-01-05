package br.com.magicAPI.projectListMagic.ctr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magicAPI.projectListMagic.dao.CardRepository;
import br.com.magicAPI.projectListMagic.model.Card;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/cards")
public class CardController {
   

    @Autowired
    private CardRepository cardRepository;

    @GetMapping("/card/{CardId}")
    public Optional<Card> getCardById(@PathVariable Integer CardId) {
        return cardRepository.findById(CardId);
    }   

    @PostMapping("/card")
    public Card insertCard(@RequestBody Card card){
        return cardRepository.save(card);
    }

    
}
