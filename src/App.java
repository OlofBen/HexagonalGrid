import graphics.HexCanvas;
import graphics.Window;
import hexagonalGrid.HexGrid;

public class App {
    public static void main(String[] args) throws Exception {
        var grid = new HexGrid(40, 30);
        var window = new Window(new HexCanvas(grid));
        System.out.println(grid.getAdjacent(0, 0));
        System.out.println(grid.getAdjacent(5, 5));
    }
}