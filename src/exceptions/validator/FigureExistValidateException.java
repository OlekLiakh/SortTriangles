package exceptions.validator;

public class FigureExistValidateException extends Exception{
    public FigureExistValidateException(String errorMessage){
        super(errorMessage);
    }
}
