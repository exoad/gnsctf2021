import java.io.InputStreamReader;

public class OpenIO {
  public static void main(String[] args) throws Exception {
    InputStreamReader isr = new InputStreamReader(System.in);
    while(true) {
      isr.read();
      if(isr.equals("EXIT_ERROR")) {
        isr.close();
        break;
      }
    }
  }
}
