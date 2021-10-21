public class DaultVoorEECrack {
    //shift the bits to the left (from the right)
    static int rotLeft(int i, int r) { return (i << r) | (i >>> (r - 32)); }
    static void solve(int[] arr) {
        int[] rot = new int[5];
        for(int i = 0; i < 5; i++)
            rot[i] = rotLeft(arr[i], i * 6);
        for(int e : rot) {
            System.out.print((char) ((e & 4278190080L) >> 24));
            System.out.print((char) ((e & 16711680L) >> 16));
            System.out.print((char) ((e & 65280L) >> 8));
            System.out.print((char) (e & 255L));
            System.out.flush();
        }
            
    }
    
    public static void main(String args[]) {
        //hardcode length of 5
        int[] arr = {1832155490, -590512956, 859174627, 1473976589, 892431156};
        solve(arr);
    }
}
