
package example;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import org.apache.commons.lang.WordUtils;
import com.opencsv.*;
import java.util.*;

public class Hello {
    public static void main(String[] args) {
        String  message = "hello ivy !";
        System.out.println("standard message : " + message);
        System.out.println("capitalized by " + WordUtils.class.getName() 
                                + " : " + WordUtils.capitalizeFully(message));
        int unMax = 0;
        try{
            CSVReader reader = new CSVReader(new FileReader("data.csv"));
            try{
                List<String[]> myEntries = reader.readAll();
                for (String[] strings : myEntries) {
                    System.out.println(Arrays.toString(strings));
                    for(String nb : strings)
                    {
                        unMax = max(unMax, Integer.parseInt(nb));
                    }
                }
                System.out.println("Max : "+ unMax);
            }catch (IOException e){
                System.out.println("standard message: IOE");
            }
        }catch(FileNotFoundException e){
            System.out.println("standard message :FNFE ");
        }
    }
    public static int max(int a, int b)
    {
            return a > b ? a : b;
            //return a; //le stagiaire est par la
    }
}
        
