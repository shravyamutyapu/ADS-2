/**.
 * Class for percolation.
 */
class Percolation {
    /**.
     * grid.
     */
    private boolean[][] grid;
    /**.
     * size.
     */
    private int size;
    /**.
     * count.
     */
    private int count = 0;
    /**.
     * obj.
     */
    private GraphList glist;
    /**.
     * Constructs the object.
     *
     * @param      size1   The size1
     */
    Percolation(final int size1) {
        this.size = size1;
        glist = new GraphList((size1 * size1) + 2);
        grid = new boolean[size][size];
    }
    /**.
     * Gets the index.
     * time complexity in average case is 1.
     * @param i variable.
     * @param j variable.
     *
     * @return     The index.
     */
    public int getIndex(final int i, final int j) {
        return (i * size) + j;
    }
    /**.
     * { function_description }
     * time complexity in average case is 1.
     * @param r rows.
     * @param c columns.
     */
    public void open(final int r, final int c) {

            grid[r][c] = true;
            count += 1;
        if (r == 0) {
            glist.addEdge(size * size, getIndex(r, c));
        }
        if (r == size - 1) {
            glist.addEdge((size * size) + 1, getIndex(r, c));
        }
        if (c < size - 1 && grid[r][c + 1]) { //bottom
            glist.addEdge(getIndex(r, c), getIndex(r, c + 1));
        }
        if (c > 0 && grid[r][c - 1]) { // left
            glist.addEdge(getIndex(r, c), getIndex(r, c - 1));
        }
        if (r < size - 1 && grid[r + 1][c]) { //right
            glist.addEdge(getIndex(r, c), getIndex(r + 1, c));
        }
        if (r > 0 && grid[r - 1][c]) { // top
            glist.addEdge(getIndex(r, c), getIndex(r - 1, c));
        }
    }
    /**.
     * { function_description }
     * time complexity in average case is 1.
     * @return boolean value.
     */
    public boolean percolates() {
        ConnectedComponent connected = new ConnectedComponent(glist);
        return connected.connected(size * size, (size * size) + 1);
    }
}



