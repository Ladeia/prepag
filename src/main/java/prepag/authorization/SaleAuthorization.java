package prepag.authorization;

import prepag.card.Card;
import prepag.card.CardRepository;
import prepag.card.CardValidator;
import prepag.card.exception.CardNotExistsException;

/** This class is responsible for the business rules 
 * of authorizing a sale prepag.authorization
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
				
				card.setCardBalance(balance);
				cardRepository.save(card);
				authResponse.setCardBalance(balance);
			}
		} else {
			throw new CardNotExistsException();
		}
		
		return authResponse;
	}
}
