import graphics.HexCanvas;
import graphics.Window;
import hexagonalGrid.HexGrid;

public class App {
    public static void main(String[] args) throws Exception {
        var grid = new HexGrid(40, 30);
        var window = new Window(new HexCanvas(grid));
    }
}