package com.antonioladeia.prepag.domain;

import java.time.LocalDate;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.core.Is.is;

import com.antonioladeia.prepag.http.CardRequest;
import com.antonioladeia.prepag.models.Card;

public class CardEmitterTest {

	private CardEmitter emitter = new CardEmitter();

	@Test
	public void generateCvvTest() {
		Card card = new Card(
				"Layne Stanley", 
				"5447317302648239", 
				LocalDate.now(), 
				"1234", 
				200.0
		);
		String cvv = emitter.generateCvv(card);
		
		assertThat(cvv, is("444"));
	}
	
	@Test
	public void generateCvvTest2() {
		Card card = new Card(
				"Layne Stanley", 
				"5447310000000000", 
				LocalDate.now(), 
				"1234", 
				200.0
		);
		String cvv = emitter.generateCvv(card);
		
		assertThat(cvv, is("319"));
	}

	@Test
	public void createDateByStringTest() {
		LocalDate date = CardEmitter.createDateByString("08/19");
		
		assertThat(date, is(LocalDate.parse("2019-08-31")));
	}
	
	@Test
	public void generateCardNumberTest() {
		String bin = CardEmitter.generateCardNumber().substring(0, 6);
		
		assertThat(bin, is("544731"));
	}
	
	@Test
	public void getValidityTest() {
		LocalDate futureDate = CardEmitter.getValidity();
		
		assertThat(futureDate, is(LocalDate.now().plusYears(2)));
	}
	
	@Test
	public void cardFactoryTest() {
		CardRequest request = new CardRequest();
		request.setName("Jerry Cantrell");
		request.setBalance(200.0);
		
		Card card = CardEmitter.cardFactory(request);
		
		assertThat(card.getHolderName(), is("Jerry Cantrell"));
		assertThat(card.getCardBalance(), is(200.0));
		assertThat(card.getCardValidity(), is(LocalDate.now().plusYears(2)));
		assertTrue(card.getCardNumber().contains("544731"));
		assertTrue(card.getCardPassword() != null);
	}
}
