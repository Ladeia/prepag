package com.antonioladeia.prepag.domain;

import java.time.LocalDate;

import com.antonioladeia.prepag.http.AuthorizationRequest;
import com.antonioladeia.prepag.http.AuthorizationResponse;
import com.antonioladeia.prepag.models.Card;

/** This class is responsible for validate a card
*/
public class CardValidator {
	
	public AuthorizationResponse validate(AuthorizationRequest request, Card card) {
		if(cardNotExpired(request.getValidity(), card)) {
			if(isValidCvv(request.getCvv(), card)) {
				if(isValidPassword(request.getPassword(), card)) {
					if(hasLimit(request.getValue(), card)) {	
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
	}

	private boolean hasLimit(Double requestBalance, Card card) {
		return card.getCardBalance() >= requestBalance;
	}

	private boolean isValidPassword(String requestPassword, Card card) {

		return card.getCardPassword().equals(requestPassword);
	}

	private boolean isValidCvv(String requestCvv, Card card) {
		String cardCvv = CardEmitter.generateCvv(card);
		
		return cardCvv.equals(requestCvv);
	}

	private boolean cardNotExpired(String requestValidity, Card card) {
		LocalDate requestDate = CardEmitter.createDateByString(requestValidity);
		
		LocalDate today = LocalDate.now();
		
		return  (requestDate.getYear() == card.getCardValidity().getYear()) && 
				(requestDate.getMonth() == card.getCardValidity().getMonth()) && 
				(today.isBefore(card.getCardValidity()) ||
				today.isEqual(card.getCardValidity()));
	}
}
