package graphics;

import java.awt.Graphics;

import hexagonalGrid.HexGrid;

public class HexGridRenderer {

    private HexGrid grid;
    private HexRenderer[][] renderers;

    public HexGridRenderer(HexGrid grid) {
        this.grid = grid;
        renderers = new HexRenderer[grid.getRows()][grid.getCols()];
    }

    public void draw(Graphics g){
        grid.forallIndex((row, col) -> {
            var hex = get(row, col);
            hex.draw(g);
        });
    }

    private HexRenderer get(int row, int col) {
        if (renderers[row][col] == null)
            renderers[row][col] = createRenderer(row, col);
        return renderers[row][col];
        
    }

    private HexRenderer createRenderer(int row, int col) {
        return new HexRenderer(grid.get(row, col));
    }

    public void setFillColor(int row, int col, java.awt.Color fillColor) {
        get(row, col).setFillColor(fillColor);
    }
    
}
