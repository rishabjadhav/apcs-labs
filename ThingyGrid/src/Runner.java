public class Runner {
    public static void main (String[] args) {
        ThingyGrid tg = new ThingyGrid(3, 4);
        tg.addThingy(new Thingy("acorn", 7), 0, 0);
        tg.addThingy(new Thingy("book", 10), 0, 1);
        tg.addThingy(new Thingy("carrot", 8), 0, 2);
        tg.addThingy(new Thingy("desk", 9), 0, 3);
        tg.addThingy(new Thingy("egg", 5), 1, 0);
        tg.addThingy(new Thingy("flag", 8), 1, 1);
        tg.addThingy(new Thingy("globe", 8), 1, 2);
        tg.addThingy(new Thingy("harp", 9), 1, 3);
        tg.addThingy(new Thingy("island", 7), 2, 0);
        tg.addThingy(new Thingy("jacket", 19), 2, 1);
        tg.addThingy(new Thingy("kale", 8), 2, 2);
        tg.addThingy(new Thingy("lunch", 16), 2, 3);
        System.out.println(tg.findAverage());
        System.out.println(tg.mostValuableNeighbor(0, 2));
        System.out.println(tg.mostValuableNeighbor(1, 1));
        System.out.println(tg.mostValuableNeighbor(2, 0));
        System.out.println(tg.mostValuableNeighbor(2, 3));
    }


}
