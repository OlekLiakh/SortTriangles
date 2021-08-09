import figure.Triangle;
import figure.comparator.TriangleComparatorByAreaByName;
import figureBuilder.TriangleBuilder;

import input.InputParametersForTriangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ---------------Class MAIN will be changed -------------------------
public class Main {
    public static void main(String[] args) {

        List<Triangle> figures = new ArrayList<>();
        boolean isContinue = true;

        while (isContinue) {
            InputParametersForTriangle inputParameters = new InputParametersForTriangle();
            TriangleBuilder builder = new TriangleBuilder(inputParameters);
            Triangle triangle = builder.getFigure();
            figures.add(triangle);
            isContinue=false;
            System.out.println("If you want to add one more triangle enter <y> or <yes>");
            Scanner scanner = new Scanner(System.in);
            String response = "";
            if(scanner.hasNext()){
                response = scanner.next();
            }

            if (response.toLowerCase().equals("y")||response.toLowerCase().equals("yes"))
                isContinue = true;
        }
        figures.sort(new TriangleComparatorByAreaByName());
        for(int i=1; i<=figures.size();i++){
            System.out.printf("%d. [%s]: %.2f cm\n", i,figures.get(i-1).getName(),figures.get(i-1).getArea());
        }
    }

}
