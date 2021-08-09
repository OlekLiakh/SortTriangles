package figureBuilder.validator;

import exceptions.validator.FigureExistValidateException;
import exceptions.validator.NameValidateException;
import exceptions.validator.NumberSidesValidateException;
import exceptions.validator.SideValidateException;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ValidatorForTriangle {
    private int numberOfSides = 3;
    private HashMap<String, List<Double>> triangleParameters;

    public ValidatorForTriangle(HashMap<String, List<Double>> triangleParameters) {
        this.triangleParameters = triangleParameters;
    }

    public HashMap<String, List<Double>> getValidatedParameters()
            throws NameValidateException, NumberSidesValidateException,
            SideValidateException, FigureExistValidateException {
        String nameOfTriangle = "";
        Set<String> setNames = triangleParameters.keySet();
        List<Double> triangleSides = triangleParameters.get(nameOfTriangle);

        validateName(setNames);
        validateSides(triangleSides);
        return triangleParameters;
    }

    private void validateName(Set<String> setNames) throws NameValidateException {
        String nameOfTriangle;
        for (String elem : setNames) {
            nameOfTriangle = elem;
            if (nameOfTriangle == null) {
                throw new NameValidateException("Name of triangle can't be empty or null");
            }
        }
    }

    private void validateSides(List<Double> triangleSides)
            throws NumberSidesValidateException, SideValidateException, FigureExistValidateException {
        if (triangleSides.size() < numberOfSides) {
            throw new NumberSidesValidateException("Entered less than three sides or input format is incorrect");
        }
        if (triangleSides.size() > numberOfSides) {
            throw new NumberSidesValidateException("Entered more than three sides or input format is incorrect");
        }
        for (double elem : triangleSides) {
            if (elem <= 0) {
                throw new SideValidateException("Side can't be less or equals zero");
            }
        }
        if (!(triangleSides.get(1) + triangleSides.get(2) > triangleSides.get(0)
                && triangleSides.get(0) + triangleSides.get(2) > triangleSides.get(1)
                && triangleSides.get(0) + triangleSides.get(1) > triangleSides.get(2))) {
            throw new FigureExistValidateException("Triangle with entered sides can't exist");
        }
    }
}