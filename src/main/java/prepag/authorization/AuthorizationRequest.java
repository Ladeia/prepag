package prepag.authorization;

import java.io.Serializable;

public class AuthorizationRequest implements Serializable {

	// Properties Region
	private static final long serialVersionUID = 1L;

	private String card;
	
	private String validity;
	
	private String cvv;
	
	private String store;
	
	private Double value;
	
	private String password;

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
