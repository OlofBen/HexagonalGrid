package hexagonalGrid;

public class Hex {
    public static final double SIZE = 10;
    private int x, y;
    private Point[] corners;

    public Hex(int x, int y) {
        this.x = x;
        this.y = y;
        initSides();
    }

    public Hex(double x, double y){
        this((int)x, (int)y);
    }

    private void initSides() {
        corners = new Point[6];
        for (int i = 0; i < corners.length; i++) {
            var angle_deg = 60 * i - 30;
            var angle_rad = Math.PI / 180 * angle_deg;
            var xOfPoint = x + SIZE * Math.cos(angle_rad);
            var yOfPoint = y + SIZE * Math.sin(angle_rad);
            corners[i] = new Point(xOfPoint, yOfPoint);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point[] getCorners() {
        return corners;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Hex with center: (" + x + ", " + y + ") and corners:" );
        for (int i = 0; i < corners.length; i++) {
            var point = corners[i];
            sb.append("(" + point.getX() + ", " + point.getY() + ") ");
        }
        return sb.toString();
    }
}

