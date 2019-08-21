package com.antonioladeia.prepag.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antonioladeia.prepag.repository.AuthorizationRepository;
import com.antonioladeia.prepag.repository.CardRepository;
import com.antonioladeia.prepag.domain.CardEmitter;
import com.antonioladeia.prepag.http.CardRequest;
import com.antonioladeia.prepag.models.Authorization;
import com.antonioladeia.prepag.models.Card;

@RestController
@RequestMapping(value="/api")
public class CardController {
	
	@Autowired
	CardRepository cardRepository;
	
	@Autowired
	AuthorizationRepository authorizationRepository;
	
	@GetMapping("/cards")
	public List<Card> listCards() {
		return cardRepository.findAll();
	}
	
	@PostMapping("/card")
	public Card createCard(@RequestBody CardRequest cardRequest) {
		Card card = CardEmitter.cardFactory(cardRequest);
		return cardRepository.save(card);
	}
	
//	@PostMapping("/authorize")
//	public Authorization createAuthorize(@RequestBody Authorization auth) {
//		Card card = new Card();
//		card.setCardNumber(auth.getCardNumber());
//		card.setCardPassword(auth.getCardPassword());
//		card.setCvv(auth.getCvv());
//		
//		LocalDate dt = CardEmitter.createDateByString(auth.getCardValidity());
//		
//		card.setCardValidity(dt);
//		
//		auth.setCard(card);
//		
//		return authorizationRepository.save(auth);
//	}

}
