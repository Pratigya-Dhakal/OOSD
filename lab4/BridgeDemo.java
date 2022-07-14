

interface DrawApi {
    public void drawCircle(int radius);
}

class RedCircle implements DrawApi {
    @Override
    public void drawCircle(int radius) {
        System.out.println("Draw Red circle: Radius - ["+radius+"]");
    }
}

class GreenCircle implements DrawApi {
    @Override
    public void drawCircle(int radius) {
        System.out.println("Draw Green Circle: Radius - ["+radius+"]");
    }
}

abstract class Shape {
    protected DrawApi drawApi;

    protected Shape(DrawApi drawApi){
        this.drawApi = drawApi;
    }

    public abstract void draw();
}

class Circle extends Shape {
    private int radius;

    public Circle(int radius, DrawApi drawApi) {
        super(drawApi);
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawApi.drawCircle(radius);
    }
}

public class BridgeDemo {
    public static void main(String[] args) {
        Shape red = new Circle(20, new RedCircle());
        Shape green = new Circle(30, new GreenCircle());

        green.draw();
        red.draw();

        /*
         * Output:
         * 
         * -------------
Draw Green Circle: Radius - [30]
Draw Red circle: Radius - [20]
         */
    }
}
