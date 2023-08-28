import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;
 

public class MarvelNetworkRandomWalks {
	public static void main(String[] args) {
		
		BufferedReader csvReader = null;
		
		try 
      {
			String newLine;
         ArrayList<ArrayList<String>> B = new ArrayList<ArrayList<String>>();
			csvReader = new BufferedReader(new FileReader("MarvelRearranged.csv"));
         
			
			while ((newLine = csvReader.readLine()) != null) 
         {
            B.add(A(newLine));
			}
         
         Random rand = new Random();
         int rand1 = rand.nextInt(B.size());
         
         
         File f = new File("TraversalPath.txt");
         PrintWriter printWriter = new PrintWriter(f);
         
         ArrayList<String> a = new ArrayList<String>();
         a = B.get(rand1);
         Integer p = null;
         int i = 1;
         
         while(i <= 100)
         {
            printWriter.println(a.get(0));
            ArrayList<String> b = new ArrayList<String>(a.subList(1,a.size()));
            int rand2 = rand.nextInt(b.size());
            
            for (int q = 0; q < B.size(); q++)
            {
               while (p == null)
               {
                  if (B.get(q).get(0).equals(b.get(rand2)))
                  {
                     p = q;
                  }
               }
               a = B.get(p);
            }
            i++;
         }
         printWriter.close();
         
      } 
      catch (IOException e) 
      {
			e.printStackTrace();
		} 
      finally 
      {
			try 
         {
				if (csvReader != null) csvReader.close();
			} 
         catch (IOException newException) 
         {
				newException.printStackTrace();
			}
		}
	}
	public static ArrayList<String> A(String fromCSV) {
		ArrayList<String> csvResult = new ArrayList<String>();
		
		if (fromCSV != null) 
      {
			String[] splitData = fromCSV.split("\\s*,\\s*");
			for (int i = 0; i < splitData.length; i++) 
         {
				if (!(splitData[i] == null) || !(splitData[i].length() == 0)) 
            {
					csvResult.add(splitData[i].trim());
				}
			}
		}
		return csvResult;
	}
	
}