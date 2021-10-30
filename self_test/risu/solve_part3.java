import java.math.BigInteger;

public class MyClass {
    public static void main(String[] args) {
        BigInteger p = new BigInteger("1000000000000066600000000000001");
        BigInteger q = new BigInteger("31415926535897932384626433832795028841");
        BigInteger phi;
        // phi = (p-1)(q-1)
        phi = new BigInteger(((p.subtract(BigInteger.ONE)).multiply((q.subtract(BigInteger.ONE)))).toString());
        
        System.out.println(phi.toString());
    }
}
