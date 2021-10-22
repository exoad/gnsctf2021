public class DaultVoorEECrack {
    // shift the bits to the left (from the right)
    static int rotLeft(int i, int r) {
        return (i << r) | (i >>> (32 - r));
    }

    static void solve(int[] arr) {
        int[] rot = new int[arr.length];
        for (int i = 0; i < 5; i++)
            rot[i] = rotLeft(arr[i], i * 6);

        // this definitely correct in order to convert int by back to bytes
        for (int i = 0; i < rot.length; i++) {
            System.out.print((char) ((rot[i] & 4278190080L) >> 24));
            System.out.print((char) ((rot[i] & 16711680L) >> 16));
            System.out.print((char) ((rot[i] & 65280L) >> 8));
            System.out.print((char) (rot[i] & 255L));
        }
    }
    static void forEach(int[] s) {
        for(int e : s) {
            System.out.print(e + " ");
        }
    }

    public static void main(String[] args) {
        // hardcode length of 5 of int concatenations from bytes
        int[] arr = { 1832155490, -590512956, 859174627, 1473976589, 892431156 };
        solve(arr);
        System.out.println();
        forEach(arr);
    }
}
