import java.math.BigInteger;
// PLAINTEXT = CIPHER^d mod n
public class MyClass {
    //helper variable START
    static BigInteger uno = new BigInteger("1");
    //helper variables END
    //-------------------------------------------------------------------------
    //helper methods START
    static BigInteger lcm(BigInteger a, BigInteger b) {
        if (a.signum() == 0 || b.signum() == 0)
            return BigInteger.ZERO;
        return a.divide(a.gcd(b)).multiply(b).abs();
    }
    
    static boolean checkN(BigInteger p, BigInteger q, BigInteger N) {
        return (p.multiply(q)).equals(N);
    }
    
    static BigInteger carmichael(BigInteger p, BigInteger q) {
        return lcm(p.subtract(uno), q.subtract(uno));
    } 
    
    static BigInteger totient(BigInteger p, BigInteger q) {
        return new BigInteger(((p.subtract(BigInteger.ONE)).multiply((q.subtract(BigInteger.ONE)))).toString());
    }
    
    static void print_prime_factors(BigInteger a) {
        for(BigInteger i = new BigInteger("2"); i.compareTo(a) < 0; i = i.add(uno)) {
            System.out.println("Calculating Result: " + i.toString())
            while((a.mod(i)).equals(BigInteger.ZERO)) {
            System.out.println(i.toString()+" ");
            a = a.divide(i);
         }
      }
      if(a.compareTo(new BigInteger("2")) > 0) {
         System.out.println(a.toString());
      }
    }
    //helper methods END
    

    static BigInteger cipher = new BigInteger("297836003176507934399394361452412015145619912915832657638304737602710563303814448593913022674431141535516243910051705575042538897493532918599036101392615742669806883173198279226718573113039010116667844179493175613725115204265980253071572631760315906547442794504600077313878966562227932298792920941420140153331714632606191306962873666439559992374567640190383446822433027234639408939314045963172075909818553422684147401799107140169349417227034531435490075779581817951165677147913755780127789824846844730797689612943092641583563154815367772483463801182779285812318430268333470060925549716559819144866488774620084632162800415719572125960023144607413811275002930983423539288284102248933287990173547914738975253186556379701635187639715257278156187014809046922022055600471354112251548164089213997886216425574866038149045993823581558971764403141519679374736977559888208899794476819436172553652653065056809215090489882080794266524182346719837363455071933601382077382359335623808156063913971037608570246720550825707133880202687225468973757698893211727025605240027239736655768821379267749221732086987220938454590554552421728495058681877213043390902751657641445926721564755658042947255136491972957682539775896319708692954232031311716691917916401");
    static BigInteger n = new BigInteger("795786651118913268588564664562334211031377832913056263828914964668488325323567657035504232040488744231159793437700872485582894876488994756644680296669652339893547057707947155823810267639366657467519480210942458392387746804327108867399505761269626756236809865832397975027274512822971253761398893972239764822273999397719320567245381680381621301062551498090825582238216682383639915801601318214484590554278328423612261523997910618039791713279662147010696678571427494357056617306310651488938411795619831077909490629428604245279960667754423827228550778301143060987580572406685885017064198038347682463101050290192969831412522534673824508674719840924784915836925553196969818694712431205663381204972204466779508749767555709784361648757773940070400003459043576755006405982201466478291665834158239940428331471311401593181992078742827945332018347173552808476937823345289375412714225841131157967165761844854097026900355269957931744153308152049387933239909305597053568195816538201617457233104231815925631139918423827521671242790357561424069343551360393014188650079032231862900255788938116573854337126795721899296220031241068956423993392718610959375330110005084349074850993231362354304960672449144227919675331054392739251205562400393942564630155097");
    static BigInteger e = new BigInteger("65537");
    static BigInteger p = new BigInteger("26419291637044727616247358326289619144786080255147017516936156450410370621112630860952213686288609353037653334857406435175177346436726121919580324760550696611859848322168205895106138210813143492122010678779290378201199742635724220074349549106073317209666955532935166649861719999462459506200602088204248654658730607936142053570621177784378274734001663106789099207750664354164322146775888473632025058023025867169793730824412673884700377812345356184647008821068457318209257009286832325432552541395205859058670914236467786718815538857531883011607015372457266712554808357953470270381892732546582612360831716590188795862367");
    static BigInteger q = new BigInteger("146672029255473087820363051373628382017030739759709219876660446479170845472954868390303613793516259235391979408697940132385041243304348806890483510676556983536748118712542353304769887215769164196143792463230955224798774820278323766410075648854193907409437786576395842775729418049735251905314110784833548420793"); // another script found this idk
    static BigInteger d;
    
    static void findD(BigInteger q, BigInteger p, BigInteger e) {
        d = e.modInverse(carmichael(p, q));
    }
    
    static void SOLVE(BigInteger cipher, BigInteger n) {
        findD(q, p, e); // make sure the value of d is calculated
        BigInteger plain = new BigInteger((cipher.modPow(d, n)).toString());
        System.out.println(plain.toString());
    }
    public static void main(String[] args) throws Exception {
        print_prime_factors(n);
    }
}
