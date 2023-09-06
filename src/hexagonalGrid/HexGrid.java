package hexagonalGrid;

public class HexGrid {
    public static final double SPACING_COL = Hex.SIZE * Math.sqrt(3);
    public static final double SPACING_ROW = Hex.SIZE * 3 / 2;

    private final int xOffset = 10;
    private final int yOffset = 10;

    private int rows, cols;
    private Hex[][] grid;

    public HexGrid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new Hex[rows][cols];
        forallIndex((row, col) -> {
                var offset = (row % 2) * SPACING_COL / 2;
                var hex = new Hex(col * SPACING_COL + xOffset + offset, row * SPACING_ROW + yOffset);
                set(hex, row, col);
                //System.out.println(hex.toString());
            }
        );
    }

    public Hex get(int row, int col) {
        return grid[row][col];
    }

    private void set(Hex hex, int row, int col) {
        grid[row][col] = hex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Grid of size: rows" + rows + ", cols" + cols + " and points: ");
        forallIndex((row, col) -> {
            var hex = get(row, col);
            sb.append("(x:" + hex.getX() + ", y:" + hex.getY() + ")");
        });
        return sb.toString();
    }

    public void forallIndex(IndexOperation operation) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                operation.execute(row, col);
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
