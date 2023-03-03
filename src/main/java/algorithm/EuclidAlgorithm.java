package algorithm;

public class EuclidAlgorithm {

    public int greatestCommonDivisor(int a, int b) {
        if (b == 0) return a;
        return  greatestCommonDivisor(b, a % b);
    }
}
