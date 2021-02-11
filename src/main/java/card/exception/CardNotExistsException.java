package card.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CardNotExistsException extends RuntimeException {

	private static final long serialVersionUID = -1633774315375654472L;

}
