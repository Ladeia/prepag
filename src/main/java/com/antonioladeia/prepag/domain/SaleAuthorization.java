package com.antonioladeia.prepag.domain;

import com.antonioladeia.prepag.http.AuthorizationRequest;
import com.antonioladeia.prepag.http.AuthorizationResponse;
import com.antonioladeia.prepag.models.Card;
import com.antonioladeia.prepag.repository.CardRepository;

/** This class is responsible for the business rules 
 * of authorizing a sale authorization
*/
public class SaleAuthorization {

	CardRepository cardRepository;

	public SaleAuthorization(CardRepository cardRepository) {
		this.cardRepository = cardRepository;
	}
	
	public AuthorizationResponse authorize(AuthorizationRequest request) {
		
		AuthorizationResponse authResponse;
		
		Card card = cardRepository.findByCardNumber(request.getCard());
		if(card != null) {
			CardValidator validator = new CardValidator();
			authResponse = validator.validate(request, card);
			
			if(authResponse.getCode() == "00") {
				Double balance = card.getCardBalance()-request.getValue();
				// TODO Create a auth in db
				
				// TODO update card balance in DB
				card.setCardBalance(balance);
				cardRepository.save(card);
				authResponse.setCardBalance(balance);
			}
		} else {
			authResponse = new AuthorizationResponse("01", "Card not exists");
		}
		
		return authResponse;
	}
}
