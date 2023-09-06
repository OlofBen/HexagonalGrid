package graphics;

import java.awt.Color;
import java.awt.Graphics;

import hexagonalGrid.Hex;

public class HexRenderer {
    private Hex hex;

    public HexRenderer(Hex hex) {
        this.hex = hex;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        var corners = hex.getCorners();
        for (int i = 0; i < corners.length; i++) {
            var pointOne = corners[i];
            var pointTwo = corners[(i + 1) % corners.length];
            g.drawLine(pointOne.getX(), pointOne.getY(), pointTwo.getX(), pointTwo.getY());
        }
    }
    
}
