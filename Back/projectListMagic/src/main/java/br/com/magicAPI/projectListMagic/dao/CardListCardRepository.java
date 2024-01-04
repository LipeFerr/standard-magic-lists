package br.com.magicAPI.projectListMagic.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.magicAPI.projectListMagic.model.CardListCard;
import br.com.magicAPI.projectListMagic.model.CardListCardId;

public interface CardListCardRepository extends JpaRepository<CardListCard, CardListCardId> {
    List<CardListCard> findByListCardId(Integer listCardId);
}
