// import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;



public class App {

    
    public static List<String> words_reader() {
            try {
                List<String> ls = Files.readAllLines(Paths.get("src/palabras_iniciales.txt"));
                return ls;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }






    
    
        public static void main(String[] args) throws Exception {
            // List<String> word = words_reader();
            // String chosen_words = word.get((int) (Math.random() * word.size()));

            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce un número: ");
            String intento = scanner.next();
            System.out.println("palabra introducido: " + intento);
            scanner.close(); // Cerrar el Scanner

    }
}
