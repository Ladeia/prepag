package prepag.authorization;

import java.io.Serializable;

public class AuthorizationResponse implements Serializable {

	// Properties Region
	private static final long serialVersionUID = 1L;
	
	private String code;
	
	private Double cardBalance;
	
	private String message;
	
	// Constructor Region
	/** Creates an AuthorizationResponse for success prepag.authorization.
	 * @param code Code of prepag.authorization.
	 * @param amount New limit of prepag.card.
	*/
	public AuthorizationResponse(String code, Double amount) {
		this.code = code;
		this.cardBalance = amount;
	}
	
	/** Creates an AuthorizationResponse for failed prepag.authorization.
	 * @param code Code of prepag.authorization.
	 * @param message Message with failed description.
	*/
	public AuthorizationResponse(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	// Methods Region
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public Double getCardBalance() {
		return cardBalance;
	}
	
	public void setCardBalance(Double cardBalance) {
		this.cardBalance = cardBalance;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
}
