import java.io.IOException;

public class WinSize {
  /*
      /bin/stty -echo; /bin/stty -icanon; /bin/stty min 1; java WinSize; /bin/stty echo; /bin/stty icanon;
     */
  public static void main(String... args) throws IOException, InterruptedException {
    System.out.println("\033[H\033[2J");
    System.out.print("\033[5B");
    
    String[] search = {
      "Dog System",
      "Cat Pim",
      "Lion What",
      "Po"
    };

    String[] cmd = {"/bin/sh", "-c", "stty raw </dev/tty"};
    Runtime.getRuntime().exec(cmd).waitFor();

    // String[] signals = new String[] {
    //   "\u001b[s",            // save cursor position
    //   "\u001b[5000;5000H",   // move to col 5000 row 5000
    //   "\u001b[6n",           // request cursor position
    //   "\u001b[u",            // restore cursor position
    // };
    // for (String s : signals) {
    //   System.out.print(s);
    // }
    int read = -1;
    StringBuilder sb = new StringBuilder();
    byte[] buff = new byte[1];
    while ((read = System.in.read(buff, 0, 1)) != -1) {
      if (127 == (int) buff[0]) {
        if(sb.length() > 0 ) {
          sb.setLength(sb.length() - 1 );
          System.out.print("\033[3D   \033[3D");
        } else {
          System.out.print("\033[2D  \033[2D");
        }
      } else if (13 == (int) buff[0]) {
        System.out.print("\033[2D  ");
        break;
      } else {
        sb.append((char) buff[0]);
      }


      System.out.print("\033[s");
      System.out.print("\033[H");
      for (int i = 0; i < search.length; i++) {
        System.out.print("\033[2K");
        System.out.print("\033[1B");
      }
      System.out.print("\033[H");

      if (sb.toString().length() < 1) {
        System.out.print("\033[u");
        continue;
      }

      String[] toSearch = sb.toString().toLowerCase().split(" ");


      for (String text : search) {
        boolean found = true;
        for (String word : toSearch) {
          if (!text.toLowerCase().contains(word)) {
            found = false;
          }
        }
        if (found) {
          System.out.println(text);
        }
      }
      System.out.print("\033[u");
    }

    System.out.println();
    System.out.println(sb);
    // String size = sb.toString();
    // int rows = Integer.parseInt(size.substring(size.indexOf("\u001b[") + 2, size.indexOf(';')));
    // int cols = Integer.parseInt(size.substring(size.indexOf(';') + 1, size.indexOf('R')));
    // System.err.printf("rows = %s, cols = %s%n", rows, cols);
    Runtime.getRuntime().exec("stty cooked < /dev/tty").waitFor();
  }
}
