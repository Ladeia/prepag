package prepag.card;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CardResponse implements Serializable {

	// Properties Region
	private static final long serialVersionUID = 1L;

	private String name;
	
	private String number;
	
	@JsonFormat(pattern = "MM/yy")
	private LocalDate validity;
	
	private String password;
	
	private Double balance;
	
	private String cvv;
	
	public CardResponse generateResponse(Card card) {
		this.name = card.getHolderName();
		this.number = card.getCardNumber();
		this.validity = card.getCardValidity();
		this.password = card.getCardPassword();
		this.balance = card.getCardBalance();
		this.cvv = CardEmitter.generateCvv(card);
		
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public LocalDate getValidity() {
		return validity;
	}

	public void setValidity(LocalDate validity) {
		this.validity = validity;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	

}
