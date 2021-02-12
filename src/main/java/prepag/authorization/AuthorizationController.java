package prepag.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import prepag.card.CardRepository;

@RestController
@RequestMapping(value="/api")
public class AuthorizationController {

	CardRepository cardRepository;
	
	@Autowired
	public AuthorizationController(CardRepository cardRepository) {
		this.cardRepository = cardRepository;
	}
	
	@PostMapping("/authorizations")
	public AuthorizationResponse createAuthorize(@RequestBody AuthorizationRequest request) {
		SaleAuthorization authorization = new SaleAuthorization(cardRepository);
		AuthorizationResponse response = authorization.authorize(request);
		
		return response;
	}

}
