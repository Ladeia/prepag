package com.antonioladeia.prepag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antonioladeia.prepag.repository.CardRepository;
import com.antonioladeia.prepag.domain.CardEmitter;
import com.antonioladeia.prepag.domain.SaleAuthorization;
import com.antonioladeia.prepag.http.AuthorizationRequest;
import com.antonioladeia.prepag.http.AuthorizationResponse;
import com.antonioladeia.prepag.http.CardRequest;
import com.antonioladeia.prepag.http.CardResponse;
import com.antonioladeia.prepag.models.Card;

@RestController
@RequestMapping(value="/api")
public class CardController {

	@Autowired
	CardRepository cardRepository;
	
	@GetMapping("/cards")
	public List<Card> listCards() {
		return cardRepository.findAll();
	}
	
	@PostMapping("/cards")
	public CardResponse createCard(@RequestBody CardRequest cardRequest) {
		Card card = CardEmitter.cardFactory(cardRequest);
		cardRepository.save(card);
		CardResponse response = new CardResponse();
		
		return response.generateResponse(card);
	}
	
	@PostMapping("/authorizations")
	public AuthorizationResponse createAuthorize(@RequestBody AuthorizationRequest request) {
		SaleAuthorization authorization = new SaleAuthorization(cardRepository);
		AuthorizationResponse response = authorization.authorize(request);
		
		return response;
	}

}
