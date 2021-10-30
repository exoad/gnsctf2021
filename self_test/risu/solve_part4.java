import java.math.BigInteger;

public class MyClass {
    static BigInteger lcm(BigInteger a, BigInteger b) {
        if (a.signum() == 0 || b.signum() == 0)
            return BigInteger.ZERO;
        return a.divide(a.gcd(b)).multiply(b).abs();
    }
    public static void main(String[] args) throws Exception {
        BigInteger p = new BigInteger("1000000000000066600000000000001");
        BigInteger q = new BigInteger("31415926535897932384626433832795028841");
        BigInteger lambda;
        //λ(n)=LCM(p−1, q−1)
        lambda = new BigInteger((lcm(p.subtract(BigInteger.ONE), q.subtract(BigInteger.ONE))).toString());
        System.out.println(lambda.toString());
    }
}
