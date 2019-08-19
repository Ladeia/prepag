package com.antonioladeia.prepag.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TB_AUTHORIZATION")
public class Authorization implements Serializable{

	// Properties Region
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	
	@Column(nullable = false)
	private String store;
	
	@Column(nullable = false)
	private Double sale_value;
	
	@Column(nullable = false)
	private Card card;
	
	@Transient
	private String cardNumber;
	
	@Transient
	private String cardValidity;
	
	@Transient
	private String cardPassword;
	
	@Transient
	private String cvv;
	
	// Methods Region
	public String getStore() {
		return store;
	}
	
	public void setStore(String store) {
		this.store = store;
	}
	
	public Double getSale_value() {
		return sale_value;
	}
	
	public void setSale_value(Double sale_value) {
		this.sale_value = sale_value;
	}
	
	public Card getCard() {
		return card;
	}
	
	public void setCard(Card card) {
		this.card = card;
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
	
	public String getCvv() {
		return cvv;
	}
	
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

}
