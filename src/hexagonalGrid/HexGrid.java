package hexagonalGrid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import util.Pair;

public class HexGrid {
    public static final double SPACING_COL = Hex.SIZE * Math.sqrt(3);
    public static final double SPACING_ROW = Hex.SIZE * 3 / 2;

    private final int xOffset = 10;
    private final int yOffset = 10;

    private int rows, cols;
    private Hex[][] grid;
    private Map<Hex, Pair<Integer>> indexOfHex = new HashMap<>();

    public HexGrid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new Hex[rows][cols];
        forallIndex((row, col) -> {
            var offset = (row % 2) * SPACING_COL / 2;
            var hex = new Hex(
                    col * SPACING_COL + xOffset + offset,
                    row * SPACING_ROW + yOffset,
                    row,
                    col);
            set(hex, row, col);
        });
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

    public List<Hex> getAdjacent(Hex hex) {
        var index = indexOfHex.get(hex);
        var row = index.getFirst();
        var col = index.getSecond();
        return getAdjacent(row, col);
    }

    public List<Hex> getAdjacent(int row, int col) {
        var isOddRow = row % 2 == 1;
        var adjacent = new ArrayList<Optional<Hex>>();
        adjacent.add(getOptional(row, col - 1));
        adjacent.add(getOptional(row, col + 1));
        adjacent.add(getOptional(row - 1, col));
        adjacent.add(getOptional(row + 1, col));

        if (isOddRow) {
            adjacent.add(getOptional(row - 1, col + 1));
            adjacent.add(getOptional(row + 1, col + 1));
        } else {
            adjacent.add(getOptional(row - 1, col - 1));
            adjacent.add(getOptional(row + 1, col - 1));
        }
        return adjacent.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private Optional<Hex> getOptional(int row, int col) {
        if (contains(row, col))
            return Optional.of(get(row, col));
        return Optional.empty();
    }

    private boolean contains(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    private void set(Hex hex, int row, int col) {
        grid[row][col] = hex;
        indexOfHex.put(hex, new Pair<Integer>(row, col));
    }

    // Getters

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Hex get(int row, int col) {
        return grid[row][col];
    }
}
