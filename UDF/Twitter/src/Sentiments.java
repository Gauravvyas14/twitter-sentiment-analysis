import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.pig.FilterFunc;
import org.apache.pig.data.Tuple;


public class Sentiments extends FilterFunc {

	String path;
	ArrayList<String> sentimentList= new ArrayList<String>();
	
	public Boolean exec(Tuple input) throws IOException {
		
			BufferedReader buffer=new BufferedReader(new FileReader(path));
			String line;
			
			while((line=buffer.readLine())!=null)
			{
				sentimentList.add(line);
			}
			buffer.close();		
		
	try
	{
		for(int i=0; i<input.size(); i++)
  	  {
  	   
         String str = ((String)input.get(i)).toLowerCase();
         
         
         for(String s:sentimentList)
         {
        	if(str.contains(s)) 
        	{
        		return true;
        	}
         }
      }
	}
	catch(Exception e)
	{
		e.getMessage();
	}		
		return false;
	}
	
	public Sentiments(String in)
	{
		path=in;
	}
	
}
