package input;

import figure.Triangle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParserStringToTriangle {

    String inputParameters;
    int numberTriangleParameters = 4;
    InputParameters input = new InputParameters();
    Triangle triangle;

    public ParserStringToTriangle(String enteredString) {
        inputParameters = enteredString;
    }

    private Triangle parseEnteredParameters() {
        if(inputParameters==null) {
            System.out.println(Message.WRONG_INPUT_PARAMETERS);
            if (isContinue()) {
                inputParameters = inputTriangleValues();
            }
        }
        List<String> listEnteredParameters = splitInput();
        String triangleName = listEnteredParameters.get(0);
        Double sideOne = validateSide(listEnteredParameters.get(1), 1);
        Double sideTwo = validateSide(listEnteredParameters.get(2), 2);
        Double sideThree = validateSide(listEnteredParameters.get(3), 3);
        triangle = new Triangle(triangleName, sideOne, sideTwo, sideThree);
        return triangle;
    }
    private boolean isContinue() {
        System.out.println(Message.QUESTION);
        String response = input.readLine();
        if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")) {
            System.out.println(Message.ENTER_PARAMETERS);
            System.out.println(Message.INPUT_TEMPLATE);
            return true;
        }
        return false;
    }
    private String inputTriangleValues() {
            String enteredValue = input.readLine();
            return enteredValue;
    }

    private List<String> splitInput() {
        List<String> listEnteredParameters = new ArrayList<>();
        boolean isCorrect = false;
        while(!isCorrect) {
            listEnteredParameters = Stream.of(inputParameters.split(","))
                .map(elem -> new String(elem))
                .map(elem -> elem.trim())
                .collect(Collectors.toList());
            if (listEnteredParameters.size() != numberTriangleParameters) {
                System.out.println(Message.WRONG_INPUT_PARAMETERS);
                if (isContinue()) {
                    inputParameters = inputTriangleValues();
                }
            }
            else isCorrect = true;
        }
        return listEnteredParameters;
    }

    public Double validateSide(String enteredValue, int sideNumber) {
        while (true) {
            try {
                double parsedValue = Double.parseDouble(enteredValue);
                return parsedValue;
            } catch (NumberFormatException nfe) {
                System.out.println(Message.WRONG_SIDE);
                System.out.printf("Entered value: %s for side number %d", enteredValue, sideNumber);
                System.out.println(Message.SIDE_FORMAT_RULE);
                enteredValue = input.readLine();
            }
        }
    }
}