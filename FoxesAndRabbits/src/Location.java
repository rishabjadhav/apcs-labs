
public class Location
{
    private int row;
    private int col;

    
    public Location(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    
    @Override
    public String toString()
    {
        return "<" + this.row + ", " + this.col + ">";
    }

    @Override
    public boolean equals(Object l) {
    	Location loc = (Location) l;
        if (loc.row == this.row && loc.col == this.col) {
                return true;
        }
        return false;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }



    /**
     * Use the top 16 bits for the row value and the bottom for
     * the column. Except for very big grids, this should give a
     * unique hash code for each (row, col) pair.
     * @return A hashcode for the location.
     */
    @Override
    public int hashCode()
    {
        //don't mess with this
        return (row << 16) + col;
    }
}