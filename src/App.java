import java.awt.Color;

import graphics.HexCanvas;
import graphics.Window;
import hexagonalGrid.HexGrid;

public class App {
    public static void main(String[] args) throws Exception {
        var grid = new HexGrid(40, 30);
        var window = new Window(new HexCanvas(grid));  
        
        window.setFillColor(10, 10, Color.BLUE);
        var adjacent = grid.getAdjacent(10, 10);
        for (var hex : adjacent) {
            window.setFillColor(hex, Color.RED);
        }
    }
}