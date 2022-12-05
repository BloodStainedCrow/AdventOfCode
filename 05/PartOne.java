import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class PartOne {
    public static void main(String[] args) throws FileNotFoundException {
        // Load input.txt
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);

        LinkedList<String> stackLines = new LinkedList<String>();
        String lastLine = "";
        String currentLine;

        while((currentLine = scanner.nextLine()) != "") {
            lastLine = currentLine;
            stackLines.add(currentLine);
        }


        int numStacks = lastLine.length()/4;

        Stack<Character> stacks[] = new Stack[numStacks + 1];

        // fill the stacks
        for(int i = 0; i < stacks.length; i++) {
            stacks[i] = new Stack<Character>();
            for(int j = stackLines.size() - 1; j >= 0; j--) {
                char stackChar = stackLines.get(j).charAt(i*4 + 1);
                if(stackChar != ' ') {
                    stacks[i].push(stackChar);
                }
            }
        }


        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            printStacks(stacks);
            System.out.println();
            System.out.println();

            String[] split = currentLine.split(" ");
            int num = Integer.parseInt(split[1]);
            int fromIndex = Integer.parseInt(split[3]) - 1;
            int toIndex = Integer.parseInt(split[5]) - 1;

            for(int i = 0; i < num; i++) {
                try {
                    stacks[toIndex].push(stacks[fromIndex].pop());
                } catch (Exception e) {
                    System.out.println("Illegal move. Try again.");
                    System.out.println("Move " + num + " from " + (fromIndex + 1) + " to " + (toIndex + 1));
                    System.out.println(stacks[toIndex]);
                }
            }
        }

        String result = "";
        for (int i = 0; i < stacks.length; i++) {
            result += stacks[i].pop();
        }

        System.out.println(result);
        scanner.close();
    }

    public static void printStacks(Stack<Character>[] stacks) {
        for (int i = 0; i < stacks.length; i++) {
            System.out.println(stacks[i]);
        }
    }
}