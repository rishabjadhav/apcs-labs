public class ThingyGrid {
    private Thingy[][] grid;

    public ThingyGrid(int i, int j) {
        grid = new Thingy[i][j];
    }

    public void addThingy(Thingy thingy, int i, int j) {
        grid[i][j] = thingy;
    }

    public double findAverage() {
        double sum = 0;
        double k = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += grid[i][j].getValue();
                k++;
            }
        }
        System.out.println(sum);
        System.out.println(k);
        return sum/k;
    }

    public String mostValuableNeighbor(int r, int c) {
        Thingy thisThingy = grid[r][c];
        Thingy leftThingy;
        Thingy rightThingy;

        if (c == 0) {
            leftThingy = new Thingy("", 0);
        } else {
            leftThingy = grid[r][c - 1];
        }

        if (c == 3) {
            rightThingy = new Thingy("", 0);
        } else {
            rightThingy = grid[r][c+1];
        }

        Thingy biggest;



        if (leftThingy.getValue() > rightThingy.getValue()) {
            biggest = leftThingy;
        } else {
            biggest = rightThingy;
        }

        if (thisThingy.getValue()> biggest.getValue()) {
            biggest = thisThingy;
        }

        return biggest.getName();

    }

}
