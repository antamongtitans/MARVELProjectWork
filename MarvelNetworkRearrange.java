import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
 

public class MarvelNetworkRearrange {
	public static void main(String[] args) {
		
		BufferedReader csvReader = null;
		
		try 
      {
			String newLine;
         ArrayList<ArrayList<String>> B = new ArrayList<ArrayList<String>>();
			csvReader = new BufferedReader(new FileReader("MARVEL P2P.csv"));
         int i = 1;
			
			while ((newLine = csvReader.readLine()) != null) 
         {
            B.add(A(newLine));
			}
         File f = new File("MarvelRearranged.csv");
         PrintWriter printWriter = new PrintWriter(f);
         
         B.get(0).remove(0);
         
         ArrayList<String> x = new ArrayList<String>();
         ArrayList<String> y = new ArrayList<String>();
         x = B.get(0);
         y = B.get(1512);
         System.out.println(y);

         while (i<1513)
         {
            ArrayList<String> a = new ArrayList<String>();
            ArrayList<String> b = new ArrayList<String>();
            ArrayList<String> c = new ArrayList<String>();
            ArrayList<ArrayList<String>> d = new ArrayList<ArrayList<String>>();
            a = B.get(i);
            b.add(a.get(0));
            a.remove(0);
            c = a;
            for (int q = 0; q < 1512; q++)
            { 
               
               if (c.get(q).equals("0"))
               {
               }
               else
               {
                  c.set(q,x.get(q));
               }
   
            }
            c.removeIf(n -> (n.charAt(0) == '0'));
            d.add(b);
            d.add(c);
            printWriter.println(d);
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