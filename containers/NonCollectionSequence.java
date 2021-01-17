package containers;

import java.util.*;

public class NonCollectionSequence {
    protected Gerbil[] gerb = new Gerbil[10];

    public NonCollectionSequence(int x) {
        for (int i = 0; i < x; i++) {
            gerb[i] = new Gerbil(i);
        }
    }

    public Iterable<Gerbil> iterator() {
        return new Iterable<Gerbil>() {

            @Override
            public Iterator<Gerbil> iterator() {
                return new Iterator<Gerbil>() {
                    private int index = 0;

                    @Override
                    public boolean hasNext() {
                        return index < gerb.length;
                    }

                    @Override
                    public Gerbil next() {
                        return gerb[index++];
                    }
                };
            }
        };
    }


    public Iterable<Gerbil> reversed() {
        return new Iterable<Gerbil>() {
            @Override
            public Iterator<Gerbil> iterator() {
                return new Iterator<Gerbil>() {
                    private int current = gerb.length - 1;

                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public Gerbil next() {
                        return gerb[current--];
                    }
                };
            }
        };
    }

    public Iterable<Gerbil> randomized() {
        return new Iterable<Gerbil>() {
            public Iterator<Gerbil> iterator() {
                List<Gerbil> shuffled = new ArrayList<>(Arrays.asList(gerb));
                Collections.shuffle(shuffled, new Random(47));
                return shuffled.iterator();
            }
        };
    }

    public static void main(String[] args) {
        NonCollectionSequence nc = new NonCollectionSequence(10);
        for (Gerbil g : nc.iterator()) {
            g.hop();
        }
        for (Gerbil g : nc.reversed()) {
            g.hop();
        }
        for (Gerbil g : nc.randomized()) {
            g.hop();
        }
        int i = 0;
        int a = 5;
        try {
            int b = a/i;
        }catch (ArithmeticException exception) {
            System.out.println("Divided on zero ");
        }
    }

}

