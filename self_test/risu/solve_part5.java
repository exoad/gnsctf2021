import java.math.BigInteger;

public class MyClass {
    static BigInteger uno = new BigInteger("1");
    static BigInteger findD(BigInteger p, BigInteger q, BigInteger e) {
        //  d = e.modInverse(totient)
        return e.modInverse(totient(p, q));
    }
    static BigInteger totient(BigInteger p, BigInteger q) {
        return ((p.subtract(BigInteger.ONE)).multiply((q.subtract(BigInteger.ONE))));
    }
    static boolean checkN(BigInteger p, BigInteger q, BigInteger N) {
        return (p.multiply(q)).equals(N) ? true : false;
    }

    public static void main(String[] args) throws Exception {
        BigInteger e = new BigInteger("65537");
        BigInteger p = new BigInteger("129573185794724353328732173962064510407185905714253215466364105164927649975533470089858514062031419216004651083682368434053190119090683605756915890635183178242202650274010805069336144197498848277033572694994010921867319100877388707122972216684234857369042889044427777953714183679746832964400380349072226560707");
        BigInteger n = new BigInteger("22409902333678780634396349171704874375996011264748935370870001103378796405764583554160902218250028718866407072599288925777830094854098783144112829605926701890563594390880123408640544183138795257118320438217784898175209219145924671131478263565292619847283372559317203108765938560657693521080902789733484857516506094749406101588558894585946990157947819769843020908790689153089503020787264275986808655454784152699927238904358404825275899856294390104357819299858264494871614654576558638200696100726844539194077580911010240662216110858208629015407745368880794560020963689048498514495548492584344163974901799588780045024061");
        BigInteger q = new BigInteger("172951696728222396439145962689725247235411273947619488089884010131421315559445943096331054213052476177240028785449995656197042160446808343832633190707067589436098655328704666395856297455805304375542170636931569567110057559570828445203098546143926804479526710973184243631912395235642833808155990736740439335423");
        
        if(checkN(p, q, n)) {
            BigInteger d = findD(p, q, e);
            //d * e == 1 modulo n
            if((d.multiply(e)).equals(uno.mod(n))) {
                System.out.println("YES");
                System.out.println(d.toString());
                System.out.close();
            } else {
                //a problem if it prints NO
                System.out.println("NO");
            }
        }
    }
}
