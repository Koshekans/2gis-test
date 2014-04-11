import java.io.*;
import java.nio.charset.Charset;

public class Main {
    public static void main(String args[]) {
        Lion yarrr = new Lion();
        if (args.length != 1) {
            printUsage();
            System.exit(1);
        }
        File inputFile = new File(args[0]);
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(inputFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(inputStream,
                Charset.forName("cp1251")));

        String line = null;
        try {
            while ((line = inputReader.readLine()) != null) {
                yarrr.inputOfGoods(line);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            inputReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printUsage() {
        System.out.println("Usage: [input file]");
    }
}

