package com.antonioladeia.prepag.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import org.junit.Test;

import prepag.authorization.AuthorizationRequest;
import prepag.authorization.AuthorizationResponse;
import prepag.card.Card;
import prepag.card.CardValidator;

public class CardValidatorTest {

	private CardValidator validator;
	private Card card;
	
	public CardValidatorTest() {
		validator = new CardValidator();
		card = new Card(
				"Layne Stanley", 
				"5447317302648239", 
				LocalDate.parse("2021-08-31"), 
				"1234", 
				200.0
		);
	}

	@Test
	public void cardIsValidTest() {
		AuthorizationRequest request = new AuthorizationRequest();
		request.setValidity("08/21");
		request.setCard("5447317302648239");
		request.setCvv("466");
		request.setStore("Americanas");
		request.setValue(100.0);
		request.setPassword("1234");
		
		AuthorizationResponse response = new AuthorizationResponse("00", 100.0);
		
		assertThat(response.getCode(), is(validator.validate(request, card).getCode()));	
		assertThat(response.getCardBalance(), is(card.getCardBalance() - request.getValue()));	

	}
	
	@Test
	public void cardExpiredTest() {
		AuthorizationRequest request = new AuthorizationRequest();
		request.setValidity("08/22");
		request.setCard("5447317302648239");
		request.setCvv("466");
		request.setStore("Americanas");
		request.setValue(100.0);
		request.setPassword("1234");
		
		AuthorizationResponse response = new AuthorizationResponse("02", 100.0);
		response.setMessage("Card expired");

		assertThat(response.getCode(), is(validator.validate(request, card).getCode()));	
		assertThat(response.getCardBalance(), is(card.getCardBalance() - request.getValue()));	

	}
	
	@Test
	public void invalidCvvTest() {
		AuthorizationRequest request = new AuthorizationRequest();
		request.setValidity("08/21");
		request.setCard("5447317302648239");
		request.setCvv("444");
		request.setStore("Americanas");
		request.setValue(100.0);
		request.setPassword("1234");
		
		AuthorizationResponse response = new AuthorizationResponse("03", 0.0);
		response.setMessage("Invalid Cvv");
		
		assertThat(response.getCode(), is(validator.validate(request, card).getCode()));
		assertThat(response.getMessage(), is(validator.validate(request, card).getMessage()));
	}
	
	@Test
	public void invalidPasswordTest() {
		AuthorizationRequest request = new AuthorizationRequest();
		request.setValidity("08/21");
		request.setCard("5447317302648239");
		request.setCvv("466");
		request.setStore("Americanas");
		request.setValue(100.0);
		request.setPassword("4321");
		
		AuthorizationResponse response = new AuthorizationResponse("04", 0.0);
		response.setMessage("Invalid password");
		
		assertThat(response.getCode(), is(validator.validate(request, card).getCode()));
		assertThat(response.getMessage(), is(validator.validate(request, card).getMessage()));
	}
	
	@Test
	public void hasNoLimitTest() {
		AuthorizationRequest request = new AuthorizationRequest();
		request.setValidity("08/21");
		request.setCard("5447317302648239");
		request.setCvv("466");
		request.setStore("Americanas");
		request.setValue(500.0);
		request.setPassword("1234");
		
		AuthorizationResponse response = new AuthorizationResponse("05", 0.0);
		response.setMessage("Your prepag.card has no limit");
		
		assertThat(response.getCode(), is(validator.validate(request, card).getCode()));
		assertThat(response.getMessage(), is(validator.validate(request, card).getMessage()));
	}
	
	
}
