package com.antonioladeia.prepag.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TB_CARD")
public class Card implements Serializable{

	// Properties Region
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	
	@Column(nullable = false)
	private String holderName;
	
	@Column(nullable = false, unique = true)
	private String cardNumber;
	
	@Column(nullable = false)
	@JsonFormat(pattern = "MM/yy")
	private LocalDate cardValidity;
	
	@Column(nullable = false)
	private String cardPassword;
	
	@Column(nullable = false)
	private Double cardBalance;
	
	// Constructors Region
	public Card() {
		super();
	}
	
	public Card(String holderName, String cardNumber, LocalDate cardValidity, String cardPassword, Double cardBalance) {
		super();
		this.holderName = holderName;
		this.cardNumber = cardNumber;
		this.cardValidity = cardValidity;
		this.cardPassword = cardPassword;
		this.cardBalance = cardBalance;
	}
	
	// Methods Region
	public Long getId() {
		return id;
	}

	public String getHolderName() {
		return holderName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public LocalDate getCardValidity() {
		return cardValidity;
	}

	public String getCardPassword() {
		return cardPassword;
	}

	public Double getCardBalance() {
		return cardBalance;
	}
	
}
