package graphics;
import java.awt.Canvas;
import java.awt.Graphics;

import hexagonalGrid.HexGrid;

public class HexCanvas extends Canvas{
    private HexGrid gird;

    public HexCanvas(HexGrid gird) {
        this.gird = gird;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        gird.draw(g);
    }
}
