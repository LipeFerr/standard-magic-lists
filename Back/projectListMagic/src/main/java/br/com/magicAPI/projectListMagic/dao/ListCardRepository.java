package br.com.magicAPI.projectListMagic.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import br.com.magicAPI.projectListMagic.model.ListCard;


public interface ListCardRepository extends JpaRepository<ListCard, Integer> {

}