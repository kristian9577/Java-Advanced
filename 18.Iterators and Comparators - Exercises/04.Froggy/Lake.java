package Froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {
    private int[] stones;

    public Lake(int[] stones) {
        this.stones = stones;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index = 0;

            private int lastEvenIndex = (stones.length - 1) % 2 == 0
                    ? stones.length - 1
                    : stones.length - 2;

            @Override
            public boolean hasNext() {
                return this.index < stones.length;
            }

            @Override
            public Integer next() {
                int stone = stones[this.index];
                if (index == lastEvenIndex) {
                    index = 1;
                    return stone;
                }
                this.index += 2;
                return stone;
            }
        };
    }
}
