package prepag.card;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class CardController {

	CardRepository cardRepository;
	
	@Autowired
	public CardController(CardRepository cardRepository) {
		this.cardRepository = cardRepository;
	}
	
	@GetMapping("/cards")
	public ResponseEntity listCards() {

		return ResponseEntity.ok().body(cardRepository.findAll());
	}
	
	@PostMapping("/cards")
	public CardResponse createCard(@RequestBody CardRequest cardRequest) {
		Card card = CardEmitter.cardFactory(cardRequest);
		cardRepository.save(card);
		CardResponse response = new CardResponse();
		
		return response.generateResponse(card);
	}

}
