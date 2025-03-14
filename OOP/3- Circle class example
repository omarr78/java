public class Circle {
    private double radius;
    private String color;

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public double getRadius() {
        return this.radius;
    }
    public String getColor() {
        return this.color;
    }
    public double getArea(){
        return this.radius * this.radius * Math.PI;
    }
    public double getCircumference(){
        return this.radius * 2 * Math.PI;
    }
    public String toString(){
        return "Radius: " + this.radius + " Color: " + this.color;
    }
}

public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle();

        c1.setRadius(3.0);
        c1.setColor("Black");
        System.out.println(c1.getArea());

        c2.setRadius(2.0);
        c2.setColor("Blue");
        System.out.println(c2.getCircumference());
        System.out.println(c2.toString());
    }
}
