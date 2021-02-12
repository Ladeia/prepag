package prepag.card;

import java.io.Serializable;

public class CardRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private Double balance;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	

}
