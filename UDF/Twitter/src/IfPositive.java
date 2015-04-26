import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.pig.FilterFunc;
import org.apache.pig.data.Tuple;


public class IfPositive extends FilterFunc {

	String pospath;
	ArrayList<String> positivelist=new ArrayList<String>();
	
	@Override
	public Boolean exec(Tuple input) throws IOException {
		
		try
		{
		
			BufferedReader buffer=new BufferedReader(new FileReader(pospath));
			String line;
			
			while((line=buffer.readLine())!=null)
			{
				positivelist.add(line);
				
			}
			buffer.close();
		}
		catch(Exception e)
		{
			System.out.println("Unable to read from positive list");
			e.getMessage();
		}
		
		try
		{
		
			for(int i=0; i<input.size(); i++)
			{
				String in=((String)input.get(i)).toLowerCase();
				
				for(String p:positivelist)
				{
					if(in.contains(p))
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
	
	public IfPositive(String inpos)
	{
		pospath=inpos;
	}

}
