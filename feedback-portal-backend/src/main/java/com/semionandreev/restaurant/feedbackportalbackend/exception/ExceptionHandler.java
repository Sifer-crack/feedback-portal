import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


public class ExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class ReviewAlreadySubmittedException extends RuntimeException {
        public ReviewAlreadySubmittedException(String message) {
            super(message);
        }
    }
}