package figureBuilder;

import exceptions.validator.FigureExistValidateException;
import exceptions.validator.NameValidateException;
import exceptions.validator.SideValidateException;
import figure.Triangle;
import figureBuilder.validator.ValidatorForTriangle;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class TriangleBuilder implements FigureBuilder {

    private Triangle triangle;
    ValidatorForTriangle validator;

    public TriangleBuilder(ValidatorForTriangle validator) {
        this.validator = validator;
        buildFigure();
    }

    //--------------------------------TODO -------------------------------
    private void buildFigure() {
        boolean isCorrect = true;
        while (isCorrect)
            try {
                HashMap<String, List<Double>> mapTriangleParameters = validator.getValidatedParameters();
                isCorrect = false;
            } catch (NumberFormatException e) {
                e.getMessage("sdfasd");
            } catch (NameValidateException e) {
                e.getMessage("a");
            } catch (SideValidateException e) {
                e.getMessage();
            } catch (FigureExistValidateException e) {
                e.getMessage("sdf");
            }
        String nameOfTriangle = "";
        mapTriangleParameters = enteredParameters.getParameters();
        Set<String> setNames = mapTriangleParameters.keySet();
        for (String elem : setNames) {
            nameOfTriangle = elem;
        }
        List<Double> sides = mapTriangleParameters.get(nameOfTriangle);
        triangle = new Triangle(nameOfTriangle, sides.get(0), sides.get(1), sides.get(2));
    }

    @Override
    public Triangle getFigure() {
        return triangle;
    }

}
