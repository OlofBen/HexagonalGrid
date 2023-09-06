package hexagonalGrid;
public class Point {
    private int x, y;

    public Point(double x, double y) {
        this((int) Math.round(x), (int) Math.round(y));
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object other){
        if (other instanceof Point){
            Point otherSide = (Point) other;
            return (x == otherSide.x && y==otherSide.y) || (x == otherSide.y && y==otherSide.x);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return x + y;
    }
}
