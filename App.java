import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        try (//getting 'n' from the user:
        Scanner myObj = new Scanner(System.in)) {
          System.out.println("Enter number: ");
          int n = myObj.nextInt();

          buffer q = new buffer();
          //int n = 100;
          String fileName = "meme.txt";
          Producer p = new Producer(n, q);
          Consumer c = new Consumer(q, fileName);
          p.start();
          c.start();
        }


    }
}