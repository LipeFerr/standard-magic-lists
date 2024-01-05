package br.com.magicAPI.projectListMagic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magicAPI.projectListMagic.dao.CardRepository;
import br.com.magicAPI.projectListMagic.model.Card;

@Service
public class CardService {
     @Autowired
    private CardRepository cardRepository;

    public Optional<Card> getCardById(Integer cardId) {
        return cardRepository.findById(cardId);
    }
}
