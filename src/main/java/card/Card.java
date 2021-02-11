package card;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_CARD")
public class Card implements Serializable{

	// Properties Region
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String holderName;
	
	@Column(nullable = false, unique = true)
	private String cardNumber;
	
	@Column(nullable = false)
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

	public void setId(Long id) {
		this.id = id;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public void setCardValidity(LocalDate cardValidity) {
		this.cardValidity = cardValidity;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setCardPassword(String cardPassword) {
		this.cardPassword = cardPassword;
	}

	public void setCardBalance(Double cardBalance) {
		this.cardBalance = cardBalance;
	}
	
	
	
	
}
