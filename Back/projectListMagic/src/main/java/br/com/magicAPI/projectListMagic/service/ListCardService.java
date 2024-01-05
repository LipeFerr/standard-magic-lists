package br.com.magicAPI.projectListMagic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.magicAPI.projectListMagic.dao.ListCardRepository;
import br.com.magicAPI.projectListMagic.model.ListCard;

@Service
public class ListCardService {
    @Autowired
    private ListCardRepository listCardRepository;

    public Optional<ListCard> getListCard(@PathVariable Integer CardId) {
        return listCardRepository.findById(CardId);
    }

    public List<ListCard> getListCards() {
        return listCardRepository.findAll();
    }
}
