package persistance.files;

import java.util.Iterator;
import java.util.Scanner;

public class IteratorReader implements Iterable<String>{
   private final Scanner scanner;

    public IteratorReader(Scanner scanner) {
        this.scanner = scanner;
    }
    
    @Override
    public Iterator<String> iterator(){
        return new Iterator<String>() {
            String currentLine = this.readLine();
            @Override
            public boolean hasNext() {
                return currentLine != null;
            }

            @Override
            public String next() {
                String result = currentLine;
                currentLine = this.readLine();
                return result;
            }
            
             public String readLine(){
                return scanner.nextLine();
            }
        };   
    } 
}