// import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;



public class App {
    
    private static String words_file = "src/hard_words.txt"; //file with the game words
    private static int tries = 6;

    
    public static List<String> words_reader() { //reads the words from the file
            try {
                List<String> ls = Files.readAllLines(Paths.get(words_file));
                return ls;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

    public static String word_gen() { //generates a randow word
        List<String> words = words_reader();
        return words.get((int) (Math.random() * words.size()));
    }

    public static String ask_word() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose a word: \n");
        String word = scanner.next();
        // scanner.close(); 
        return word;
    }



    public static String game() { 
        String goal = word_gen();
        String answer ="You lose! \n The word was: " + goal;
        String word = "";
        String result = "XXXXX";
        // System.out.println(goal);

        for (int i = 0 ; i <= tries && !answer.equals("You win!") ; i++) {
            word = ask_word();
            result = "XXXXX";

            for (int c = 0 ; c < result.length() ; c++) {
                if (word.substring(c, c+1).equals(goal.substring(c, c+1))) {
                    result = result.substring(0, c) + "B" + result.substring(c+1);
                }

                else if (goal.contains(word.substring(c, c+1))){
                    result = result.substring(0, c) + "O" + result.substring(c+1);
                }
            }

            System.out.println(result);
            if (result.equals("BBBBB")) {
                answer = "You win!";
                break;
            }

        }
        
        System.out.println(answer);
        return null;
    }




    
    
        public static void main(String[] args) throws Exception {
        game();
    }
}
