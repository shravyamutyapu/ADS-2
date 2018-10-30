/**
 * Percolate class.
 */
class Percolation {
    /**
     * @param grid [description]
     */
    private boolean[][] grid;
    /**
     * @param int [description]
     */
    private int size;
    /**
     *
     * @param count [description]
     */
    private int count = 0;
    /**
     * private obj.
     */
    private GraphList glist;

    Percolation(final int size1) {
        this.size = size1;
        glist = new GraphList((size1 * size1) + 2);
        grid = new boolean[size1][size1];
    }

    public int getIndex(final int i, final int j) {
        return (i * size) + j;
    }

    public void open(final int row, final int column) {

            grid[row][column] = true;
            count += 1;
        if (row == 0) {
            glist.addEdge(size * size, getIndex(row, column));
        }
        if (row == size - 1) {
            glist.addEdge((size * size) + 1, getIndex(row, column));
        }
        if (column < size - 1 && grid[row][column + 1]) { //bottom
            glist.addEdge(getIndex(row, column), getIndex(row, column + 1));
        }
        if (column > 0 && grid[row][column - 1]) { // left
            glist.addEdge(getIndex(row, column), getIndex(row, column - 1));
        }
        if (row < size - 1 && grid[row + 1][column]) { //right
            glist.addEdge(getIndex(row, column), getIndex(row + 1, column));
        }
        if (row > 0 && grid[row - 1][column]) { // top
            glist.addEdge(getIndex(row, column), getIndex(row - 1, column));
        }
    }

    public boolean percolates() {
        ConnectedComponent connected = new ConnectedComponent(glist);
        return connected.connected(size * size, (size * size) + 1);
    }
}