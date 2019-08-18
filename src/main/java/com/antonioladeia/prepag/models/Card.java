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
	
	@Column(nullable = false)
	private String cardNumber;
	
	@Column(nullable = false)
	@JsonFormat(pattern = "MM/yy")
	private LocalDate cardValidity;
	
	@Column(nullable = false)
	private String cardPassword;
	
	@Column(nullable = false)
	private Double cardBalance;
	
	@Transient
	private String cvv;
	
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
		this.cvv = generateCvv();
	}
	
	// Methods Region
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public LocalDate getCardValidity() {
		return cardValidity;
	}

	public void setCardValidity(LocalDate cardValidity) {
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

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	/**
	 * Verification code is generated 
	 * First digit is calculated with recursive sum from second sequence of four digits of card + month
	 * Second digit is calculated with recursive sum from third sequence of four digits of card + year
	 * Third digit is calculated with recursive sum from fourth sequence of four digits of card + month + year
	 * @return
	 */
	private String generateCvv() {
		int month = cardValidity.getMonthValue();
		int year = cardValidity.getYear() % 100; // Year with 2 digits ()
		
		String digit01 = cardNumber.substring(4, 8);
		String digit02 = cardNumber.substring(8, 12);
		String digit03 = cardNumber.substring(12, 16);
		
		digit01 = Integer.toString(sumDigits(Integer.parseInt(digit01) + month));
		digit02 = Integer.toString(sumDigits(Integer.parseInt(digit02) + year));
		digit03 = Integer.toString(sumDigits(Integer.parseInt(digit03) + month + year));

		return digit01+digit02+digit03;
	}
	
    private int sumDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }

        sum = (sum <10) ? sum : sumDigits(sum);
        return sum;
    }
	
}
