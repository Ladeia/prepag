package com.antonioladeia.prepag.resources;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antonioladeia.prepag.repository.CardRepository;
import com.antonioladeia.prepag.models.Card;

@RestController
@RequestMapping(value="/api")
public class CardResource {
	
	private static final String BIN = "544731";
	private Random random = new Random();

	@Autowired
	CardRepository cardRepository;
	
	@GetMapping("/cards")
	public List<Card> listCards() {
		return cardRepository.findAll();
	}
	
	@PostMapping("/card")
	public Card createCard(@RequestBody Card card) {
		card.setCardNumber(generateCardNumber());
		card.setCardValidity(getValidity());
		card.setCardPassword(generatePassword());
		return cardRepository.save(card);
	}
	
	private String generateCardNumber() {
		Long random = new Random().nextLong();
		return BIN + String.valueOf(random).substring(1,11);
	}
	
	private LocalDate getValidity() {
		LocalDate now = LocalDate.now().plusYears(2);
		return 	now;

	}

	private String generatePassword() {
		int password= new Random().nextInt(9999);
		return String.valueOf(password);
	}
}
