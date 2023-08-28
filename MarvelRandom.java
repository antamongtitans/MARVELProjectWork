import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MarvelRandom{

 public static void main(String[] args) {
     
     BufferedReader csvReader = null;
     
     // Used to quickly access a random name
     ArrayList<String> names = new ArrayList<String>();
     
     // map
     Map<String, Set<String>> namesToCostars = new HashMap<>();
     
     try {
         String currentLine;
         csvReader = new BufferedReader(new FileReader("MarvelRearranged.csv"));
         
         while ((currentLine = csvReader.readLine()) != null) {
             
             Set set = new HashSet<String>();
             String[] recordElements = currentLine.split("\\s*,\\s*");
             
             for ( int i = 1; i < recordElements.length; i++) {
                 set.add(recordElements[i]);
             }
             
             names.add(recordElements[0]);
             namesToCostars.put(recordElements[0], set);
             
         }
         
     } catch (IOException e) {
         e.printStackTrace();
     }

     Random rand = new Random();
     int randomElement = rand.nextInt(names.size());

     int j = 0;
     
     String currentName = names.get(randomElement);
     
     while ( j < 100) {
         System.out.println(currentName);
         Set<String> costars = namesToCostars.get(currentName);
         String coStar = costars.stream().skip(new Random().nextInt(costars.size())).findFirst().orElse(null);
         currentName = coStar;
         costars.clear();
         j++;
     }
   }
}