package graphics;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import hexagonalGrid.Hex;
import hexagonalGrid.HexGrid;

public class HexCanvas extends Canvas{
    private HexGridRenderer gird;

    public HexCanvas(HexGrid hexGrid) {
        this.gird = new HexGridRenderer(hexGrid);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        gird.draw(g);
    }

    public void setFillColor(int row, int col, Color fillColor) {
        gird.setFillColor(row, col, fillColor);
    }
}
