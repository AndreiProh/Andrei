

public class ArrayTest {
    public static BerylliumSphere[] makeArray(int i) {
        BerylliumSphere[] b = new BerylliumSphere[i];
        for (int x = 0; x < i; x++) {
            b[x] = new BerylliumSphere();
        }
        return b;
    }
    public static double[][] makeDoubleArray(int sizeA, int sizeB, double low, double high) {
        double[][] x = new double[sizeA][sizeB];
        Random rand = new Random();
        for (int i = 0; i < sizeA; i++) {
            for (int  j = 0; j < sizeB ; j++) {
                x[i][j] = low + (high - low) * rand.nextDouble();
            }
        }
        return x;
    }
    public static <T> void lookArray(T[][] i) {
        for (int x = 0; x < i.length; x++) {
            System.out.println(Arrays.toString(i[x]));
        }
    }
    public static double[][][] makeDoubleArray(int sizeA, int sizeB,int sizeC,
                                             double low, double high) {
        double[][][] x = new double[sizeA][sizeB][sizeC];
        Random rand = new Random();
        for (int i = 0; i < sizeA; i++) {
            for (int j = 0; j < sizeB; j++) {
                for (int k = 0; k < sizeC; k++) {
                    x[i][j][k] = low + (high - low) * rand.nextDouble();
                }
            }
        }
        return x;
    }
    public static void lookArray(double[][][] i) {
        for (int x = 0; x < i.length; x++) {
            for (int y = 0; y < i[x].length; y++) {
                System.out.println(Arrays.toString(i[x][y]));
            }
        }
    }
    public static BerylliumSphere[][] getArray(int a, int b) {
        BerylliumSphere[][] spheres = new BerylliumSphere[a][b];
        for (int i = 0; i < spheres.length; i++) {
            for (int j = 0; j < spheres[i].length; j++) {
                spheres[i][j] = new BerylliumSphere();
            }
        }
        return spheres;
    }
    public static void main(String[] args) {
        double[] dob = ConvertTo.primitive(Generated.array(Double.class,
                new CountingGenerator.Double(), 15));
        System.out.println(Arrays.toString(dob));
        String str = new String(ConvertTo.primitive(Generated.array(Character.class, new CountingGenerator.Character(),
                10)));
        System.out.println(str);
        boolean[] b = ConvertTo.primitive(Generated.array(Boolean.class,
                new RandomGenerator.Boolean(), 10));
        int[] i = ConvertTo.primitive(Generated.array(Integer.class,
                new RandomGenerator.Integer(), 15));
        float[] f = ConvertTo.primitive(Generated.array(Float.class,
                new CountingGenerator.Float(), 10));
        char[] ch = ConvertTo.primitive(Generated.array(Character.class,
                new RandomGenerator.Character(), 10));
        long[] l = ConvertTo.primitive(Generated.array(Long.class,
                new RandomGenerator.Long(), 15));
        byte[] bytes = ConvertTo.primitive(Generated.array(Byte.class,
                new SkipGenerator.Byte((byte) 10),10));
        BigDecimal[] big = Generated.array(BigDecimal.class,
                new CountingGenerator.BigDecimal(), 10);
        //System.out.println(Arrays.toString(dob));
        //System.out.println(Arrays.toString(b));
        //System.out.println(Arrays.toString(i));
        //System.out.println(Arrays.toString(f));
        //System.out.println(Arrays.toString(big));
        int[] i1 = ConvertTo.primitive(Generated.array(new Integer[20],
                new RandomGenerator.Integer()));
        System.out.println(Arrays.toString(i1));
        System.out.println(Arrays.binarySearch(i1,7242));

    }

}
