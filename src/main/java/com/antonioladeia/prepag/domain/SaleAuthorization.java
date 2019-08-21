package com.antonioladeia.prepag.domain;

import com.antonioladeia.prepag.http.AuthorizationResponse;
import com.antonioladeia.prepag.models.Card;

/** This class is responsible for the business rules 
 * of authorizing a sale authorization
*/
public class SaleAuthorization {

	/** Creates an employee with the specified name.
	 * @param card A populated card used in sale.
	 * @param store The name of the store where the sale takes place.
	 * @return An response object wih codes and messages about state of sale.
	*/	
	AuthorizationResponse authorize(Card card, String store, Double sale_value) {
		
		CardValidator validator = new CardValidator();
		AuthorizationResponse authResponse = validator.validate(card);
		
		if(authResponse.getCode() == "00") {
			// TODO Create a auth in db
			// TODO update card balance in DB
			// TODO update card balance in authResponse
		}
		
		return authResponse;
	}
}
