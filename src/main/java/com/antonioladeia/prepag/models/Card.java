package com.antonioladeia.prepag.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_CARD")
public class Card implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String holderName;
	private String cardNumber;
	private String cardValidity;
	private String cardPassword;
	private Double cardBalance;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardValidity() {
		return cardValidity;
	}
	public void setCardValidity(String cardValidity) {
		this.cardValidity = cardValidity;
	}
	public String getCardPassword() {
		return cardPassword;
	}
	public void setCardPassword(String cardPassword) {
		this.cardPassword = cardPassword;
	}
	public Double getCardBalance() {
		return cardBalance;
	}
	public void setCardBalance(Double cardBalance) {
		this.cardBalance = cardBalance;
	}
}
