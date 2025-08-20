package Q17;
import java.util.Scanner;
import java.util.Vector;
import java.util.Collections;

public class  Coding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

     
        System.out.print("Enter number of participating coders: ");   // Read number of participating coders
        int n = sc.nextInt();

        // Vector to store the scores
        Vector<Integer> scores = new Vector<>();

        System.out.println("Enter the final scores (out of 100) for each coder:");
        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            scores.add(score);
        }

        // Vector to store the top three scores
        Vector<Integer> topThree = new Vector<>();

        //  i am Defindiing how many top scores we can fetch (in case there are less than 3 scores)
        int count = Math.min(3, scores.size());
        for (int i = 0; i < count; i++) {
            // Use Collections.max() to find the maximum score in the current scores vector
            int maxScore = Collections.max(scores);
            topThree.add(maxScore);
            // Remove the maximum score to find the next highest in subsequent iterations.
            scores.remove(Integer.valueOf(maxScore)); 
        }

        // Output the top three scores
        System.out.println("Top three scorers (scores):");
        for (Integer score : topThree) {
            System.out.println(score);
        }

        sc.close();
    }
}
