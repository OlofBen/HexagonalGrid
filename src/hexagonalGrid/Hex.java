package hexagonalGrid;

public class Hex {
    public static final double SIZE = 10;
    private int x, y;
    private int row, col;
    private Point[] corners;

    public Hex(int x, int y, int row, int col) {
        this.x = x;
        this.y = y;
        this.row = row;
        this.col = col;
        initSides();
    }

    public Hex(double x, double y, int row, int col){
        this((int)x, (int)y, row, col);
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

    // Oversides
    @Override
    public String toString(){
        return "Hex with center: (" + x + ", " + y + ") and index: (" + row + ", " + col + ")";
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null)
            return false;
        if (obj.getClass() != this.getClass())
            return false;
        var other = (Hex) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode(){
        return x + y;
    }


    //Getters

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public Point[] getCorners() {
        return corners;
    }
}

