package graphics;

import java.awt.Color;
import java.awt.Graphics;

import hexagonalGrid.Hex;

public class HexRenderer {
    private Hex hex;
    private Color outlineColor = Color.BLACK;
    private Color fillColor = Color.WHITE;

    private int[] xCorners;
    private int[] yCorners;

    public HexRenderer(Hex hex) {
        this.hex = hex;
        var corners = hex.getCorners();
        xCorners = new int[corners.length];
        yCorners = new int[corners.length];
        for (int i = 0; i < corners.length; i++) {
            xCorners[i] = corners[i].getX();
            yCorners[i] = corners[i].getY();
        }
    }

    public void draw(Graphics g) {
        
        var corners = hex.getCorners();
        g.setColor(fillColor);
        g.fillPolygon(xCorners, yCorners, corners.length);
        g.setColor(outlineColor);
        for (int indexOne = 0; indexOne < corners.length; indexOne++) {
            var indexTwo = (indexOne + 1) % corners.length;
            g.drawLine(xCorners[indexOne], yCorners[indexOne], xCorners[indexTwo], yCorners[indexTwo]);
        }
        
       
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }
    
}
