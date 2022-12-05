import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class PartTwo {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        Iterator<String> it = br.lines().iterator();

        int priority = 0;

        while(it.hasNext()) {
            String firstSack = it.next();
            String secondSack = it.next();
            String thirdSack = it.next();

            for(char c : firstSack.toCharArray()) {
                if(secondSack.contains(String.valueOf(c)) && thirdSack.contains(String.valueOf(c))) {
                    priority += PartOne.calculatePriority(c);
                    break;
                }
            }
        }

        System.out.println(priority);
        br.close();
    }
}
