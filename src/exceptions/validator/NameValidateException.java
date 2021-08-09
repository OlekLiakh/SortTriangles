package exceptions.validator;

public class NameValidateException extends Exception{
    public NameValidateException (String errorMessage){
        super(errorMessage);
    }
}
