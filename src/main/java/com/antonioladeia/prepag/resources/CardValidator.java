package com.antonioladeia.prepag.resources;

import com.antonioladeia.prepag.models.AuthorizationResponse;
import com.antonioladeia.prepag.models.Card;

/** This class is responsible for validate a card
*/
public class CardValidator {
	
	AuthorizationResponse validate(Card card) {
		if(cardExists(card)) {
			if(cardNotExpired(card)) {
				if(isValidCvv(card)) {
					if(isValidPassword(card)) {
						if(hasLimit(card)) {
							
							return new AuthorizationResponse("00", 0.0);

							
						} else {
							return new AuthorizationResponse("05", "Your card has no limit");
						}
						
					} else {
						return new AuthorizationResponse("04", "Invalid password");

					}
					
				} else {
					return new AuthorizationResponse("03", "Invalid Cvv");
				}
				
			} else {
				return new AuthorizationResponse("02", "Card expired");
			}
			
		} else {
			return new AuthorizationResponse("01", "Card not exists");
		}
	}

	private boolean hasLimit(Card card) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isValidPassword(Card card) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isValidCvv(Card card) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean cardNotExpired(Card card) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean cardExists(Card card) {
		// TODO Auto-generated method stub
		return false;
	}
}
