package NotValidException;

public class NotValidPhoneNumberException extends NotValidCommandException{
    public NotValidPhoneNumberException(String s) {
        super(s);
    }
}
