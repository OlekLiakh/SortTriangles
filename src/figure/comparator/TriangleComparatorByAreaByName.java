package figure.comparator;

import figure.Triangle;
import figurePropertyCalculator.TrianglePropertyCalculator;

import java.util.Comparator;

public class TriangleComparatorByAreaByName implements Comparator<Triangle> {
    @Override
    public int compare(Triangle triangle1, Triangle triangle2) {
        TrianglePropertyCalculator calculatorTriangle1 = new TrianglePropertyCalculator(triangle1);
        TrianglePropertyCalculator calculatorTriangle2 = new TrianglePropertyCalculator(triangle2);
        int result = Double.compare(calculatorTriangle1.getArea(), calculatorTriangle2.getArea());
        if (result==0){
            result = triangle1.getName().compareTo(triangle2.getName());
        }
        return result;
    }
}
