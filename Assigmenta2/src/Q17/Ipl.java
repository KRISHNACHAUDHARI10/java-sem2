package Q17;


import java.util.Vector;

public class Ipl {
    public static void main(String[] args) {
        // i Create and initialize the batting lineup for KKR using a Vector.
        Vector<String> kkrLineup = new Vector<>();
        kkrLineup.add("Sunil Narine");
        kkrLineup.add("Venkatesh Iyer");
        kkrLineup.add("QuintonDeKock");
        kkrLineup.add("Shreyas Iyer");
        kkrLineup.add("Nitish Rana");
        kkrLineup.add("Andre Russell");
        kkrLineup.add("Rinku Singh");
        kkrLineup.add("Shardul Thakur");
        kkrLineup.add("Lockie Ferguson");
        kkrLineup.add("Umesh Yadav");
        kkrLineup.add("Varun Chakaravarthy");

        // Create and initialize the batting lineup for Mumbai Indians.
        Vector<String> mumbaiLineup = new Vector<>();
        mumbaiLineup.add("Rohit Sharma");
        mumbaiLineup.add("Ishan Kishan");
        mumbaiLineup.add("Suryakumar Yadav");
        mumbaiLineup.add("Tilak Varma");
        mumbaiLineup.add("Hardik Pandya");
        mumbaiLineup.add("Tim David");
        mumbaiLineup.add("Nehal Wadhera");
        mumbaiLineup.add("Piyush Chawla");
        mumbaiLineup.add("Jasprit Bumrah");
        mumbaiLineup.add("Gerald Coetzee");
        mumbaiLineup.add("Akash Madhwal");

        
        System.out.println("Initial KKR Batting Lineup:");
        for (int i = 0; i < kkrLineup.size(); i++) {
            System.out.println((i + 1) + ". " + kkrLineup.get(i));
        }
        
      
        System.out.println("\nOh no! There's a last-minute change in the KKR batting order.");
        System.out.println("QuintonDeKock is out, and Anukul Roy will be batting at two down (3rd position).");

        
        int index = kkrLineup.indexOf("QuintonDeKock");
        if (index != -1) {
            
            kkrLineup.remove(index);
         
            kkrLineup.insertElementAt("Anukul Roy", 2);
        } else {
            System.out.println("Error: QuintonDeKock is not found in the KKR lineup.");
        }

      
        System.out.println("\nUpdated KKR Batting Lineup:");  // i am Display the updated KKR batting lineup.
        for (int i = 0; i < kkrLineup.size(); i++) {
            System.out.println((i + 1) + ". " + kkrLineup.get(i));
        }

        //i am Display the Mumbai Indians lineup (no changes).
        System.out.println("\nMumbai Indians Batting Lineup (No Changes):");
        for (int i = 0; i < mumbaiLineup.size(); i++) {
            System.out.println((i + 1) + ". " + mumbaiLineup.get(i));
        }

        System.out.println("\nGet ready for the match! It's going to be exciting!");
    }
}
