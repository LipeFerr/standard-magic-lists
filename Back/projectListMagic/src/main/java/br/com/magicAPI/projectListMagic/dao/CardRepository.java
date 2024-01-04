package br.com.magicAPI.projectListMagic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magicAPI.projectListMagic.model.Card;

public interface CardRepository extends JpaRepository<Card, Integer> {
}