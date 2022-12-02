import java.io.BufferedWriter;
import java.io.FileWriter;

class Consumer extends Thread {
    buffer q;
    String fileName;

    public Consumer(buffer q, String fileName) {
        this.q = q;
        this.fileName = fileName;
    }

    public void run() {
        while(true) {
            try {
                FileWriter fstream = new FileWriter(this.fileName, true);
                BufferedWriter out = new BufferedWriter(fstream);
                out.write(this.q.consume());
                out.write(",");
                out.close();
            } catch (Exception var3) {
                System.err.println("Error while writing to file: " + var3.getMessage());
            }
        }
    }
}