package com.antonioladeia.prepag.resources;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Random;

// this class is responsible for the 
// business rules of generating a new card
public class CardEmitter {

	private static final String BIN = "544731";

	static LocalDate createDateByString(String stringDate) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/yy");
		YearMonth ym = YearMonth.parse(stringDate, fmt);
		LocalDate dt = ym.atEndOfMonth();
		return dt;
	}
	
	static String generateCardNumber() {
		Long random = new Random().nextLong();
		return BIN + String.valueOf(random).substring(1,11);
	}
	
	static LocalDate getValidity() {
		LocalDate now = LocalDate.now().plusYears(2);
		return 	now;

	}

	static String generatePassword() {
		int password= new Random().nextInt(9999);
		return String.valueOf(password);
	}
}
