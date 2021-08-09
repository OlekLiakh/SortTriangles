package input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParserEnteredParameters {

    String enteredStringParameters;

    public ParserEnteredParameters(String enteredString) {
        enteredStringParameters = enteredString;
    }

    private HashMap<String, List<Double>> parseEnteredParameters() {
        List<String> listEnteredParameters = Stream.of(enteredStringParameters.split(","))
                .map(elem -> new String(elem))
                .map(elem -> elem.trim())
                .collect(Collectors.toList());

        List<Double> sidesOfFigure = new ArrayList<>();
        for (int i = 1; i < listEnteredParameters.size(); i++) {
            sidesOfFigure.add(parseEnteredSide(listEnteredParameters.get(i), i));
        }
        HashMap<String, List<Double>> figureParameters = new HashMap<>();
        figureParameters.put(listEnteredParameters.get(0), sidesOfFigure);
        return figureParameters;

    }

    public Double parseEnteredSide(String enteredSide, int sideNumber) {
        while (true) {
            try {
                double parsedValue = Double.parseDouble(enteredSide);
                return parsedValue;
            } catch (NumberFormatException nfe) {
                System.out.println("Entered value " + enteredSide + " for side " + sideNumber + "is incorrect. \n" +
                        "Enter positive integer or floating-point number");
                InputParameters inputParameters = new InputParameters();
                enteredSide = inputParameters.getParameters();
            }
        }
    }
}
