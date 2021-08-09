package figurePropertyCalculator;

import figure.Triangle;

public class TrianglePropertyCalculator implements FigurePropertyCalculator{

    Triangle triangle;

    public TrianglePropertyCalculator(Triangle triangle){
        this.triangle = triangle;
    }

    @Override
    public double getPerimeter() {
        double perimeter = triangle.getSide1()+triangle.getSide2()+triangle.getSide3();
        return perimeter;
    }

    @Override
    public double getArea() {
        double halfPerimeter = this.getPerimeter();
        double area = Math.sqrt(
                halfPerimeter*(halfPerimeter-triangle.getSide1())
                        *(halfPerimeter-triangle.getSide2())
                        *(halfPerimeter-triangle.getSide3()));
        return area;
    }
}
