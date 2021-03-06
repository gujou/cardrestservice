package org.hackathon.packapp.cardrestservice.service.impl;

import java.util.Collection;

import org.hackathon.packapp.cardrestservice.model.Card;
import org.hackathon.packapp.cardrestservice.model.CardType;
import org.hackathon.packapp.cardrestservice.repository.CardRepository;
import org.hackathon.packapp.cardrestservice.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
	
    @Override
    @Transactional(readOnly = true)
    public Collection<CardType> findCardTypes() throws DataAccessException {
        return cardRepository.findCardTypes();
    }


    @Override
    @Transactional(readOnly = true)
    public Card findCardById(int id) throws DataAccessException {
        return cardRepository.findById(id);
    }

    @Override
    @Transactional
    public void saveCard(Card card) throws DataAccessException {
        cardRepository.save(card);
    }
}
