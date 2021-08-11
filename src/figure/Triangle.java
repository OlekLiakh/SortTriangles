package figure;

public class Triangle implements Figure{
    private String name;
    private double side1;
    private double side2;
    private double side3;

    public Triangle(String name, double side1, double side2, double side3){
        this.name = name;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getPerimeter() {
        double perimeter = side1+side2+side3;
        return perimeter;
    }

    public double getArea() {
        double halfPerimeter = this.getPerimeter();
        double area = Math.sqrt(
                halfPerimeter*(halfPerimeter-side1)
                        *(halfPerimeter-side2)
                        *(halfPerimeter-side3));
        return area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }
}
