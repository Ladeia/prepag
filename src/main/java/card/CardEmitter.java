package card;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/** This class is responsible for the
 * business rules of generating a new card
*/
public class CardEmitter {

	private static final String BIN = "544731";

	public static LocalDate createDateByString(String stringDate) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/yy");
		YearMonth ym = YearMonth.parse(stringDate, fmt);
		LocalDate dt = ym.atEndOfMonth();
		return dt;
	}
	
	public static String generateCardNumber() {
		Long random = new Random().nextLong();
		return BIN + String.valueOf(random).substring(1,11);
	}
	
	public static LocalDate getValidity() {
		LocalDate now = LocalDate.now().plusYears(2);
		return 	now;

	}

	public static String generatePassword() {
		int password= new Random().nextInt(9999);
		return String.valueOf(password);
	}
	
	/**
	* Verification code is generated 
	 * First digit is calculated with recursive sum from second sequence of four digits of card + month
	 * Second digit is calculated with recursive sum from third sequence of four digits of card + year
	 * Third digit is calculated with recursive sum from fourth sequence of four digits of card + month + year
	 * @return CVV String
	 */
	public static String generateCvv(Card card) {
		int month = card.getCardValidity().getMonthValue();
		int year = card.getCardValidity().getYear() % 100; // Year with 2 digits
		
		String digit01 = card.getCardNumber().substring(4, 8);
		String digit02 = card.getCardNumber().substring(8, 12);
		String digit03 = card.getCardNumber().substring(12, 16);
		
		digit01 = Integer.toString(sumDigits(Integer.parseInt(digit01) + month));
		digit02 = Integer.toString(sumDigits(Integer.parseInt(digit02) + year));
		digit03 = Integer.toString(sumDigits(Integer.parseInt(digit03) + month + year));

		return digit01 + digit02 + digit03;
	}
	
    private static int sumDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }

        sum = (sum <10) ? sum : sumDigits(sum);
        return sum;
    }

	/** Factory method to create card.
	 * @param card A card request params.
	 * @return A full populated card.
	*/	
	public static Card cardFactory(CardRequest cardRequest) {
		Card card = new Card(
				cardRequest.getName(), 
				CardEmitter.generateCardNumber(),
				CardEmitter.getValidity(),
				CardEmitter.generatePassword(),
				cardRequest.getBalance()
		);
		
		return card;
	}
}
