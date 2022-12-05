import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class PartOne {

    public static void main(String[] args) throws IOException {
        int priority = 0;

        // Load file input.txt
        File file = new File("input.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        Iterator<String> it = br.lines().iterator();

        // Iterate over all lines in the file
        for (String line = it.next(); true; line = it.next()) {
            String firstCompartment = line.substring(0, line.length()/2);
            String secondCompartment = line.substring(line.length()/2, line.length());

            for(char c : firstCompartment.toCharArray()) {
                if(secondCompartment.contains(String.valueOf(c))) {
                    priority += calculatePriority(c);
                    break;
                }
            }
            if (!it.hasNext())
                break;
        }

        System.out.println(priority);
        br.close();
    }

    public static int calculatePriority(char c) { 
        int val = 0;
        if (c >= 'a' && c <= 'z') {
            val = c - 'a' + 1;
        } else {
            val = c - 'A' + 27;
        }
        return val;
    }
}