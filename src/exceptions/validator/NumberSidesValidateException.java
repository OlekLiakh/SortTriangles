package exceptions.validator;

public class NumberSidesValidateException extends Exception{
    public NumberSidesValidateException(String errorMessage){
        super(errorMessage);
    }
}
