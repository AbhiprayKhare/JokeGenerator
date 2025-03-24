import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
public class Joker 
{
    public static String setup = "";
    public static String delivery = "";
	public static void main(String args[])
	{
		try
		{
			Scanner sc=new Scanner(System.in);
			char s;
			do
			{
				System.out.println("Should I tell A joke? Y/y-Yes N/n-No: ");
				s=sc.next().charAt(0);
				if(s=='n'||s=='N')
				{
					System.out.println("Ugggh Bummer!!!!");
					break;
				}
				getjoke();
				
			}while(s!='n'||s!='N');
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void getjoke()
	{
		String url="https://v2.jokeapi.dev/joke/Dark";
		try
		{
			HttpURLConnection apiconnection = fetchapi(url);
			if(apiconnection.getResponseCode()!=200)
			{
				System.out.println("Could not establish connection to api");
				
			}
			String jsonResponse=readApiResponse(apiconnection);
			
			JSONParser parser=new JSONParser();
			JSONObject resultsJsonObj=(JSONObject) parser.parse(jsonResponse);
			
			 setup=(String)resultsJsonObj.get("setup");
			 delivery=(String)resultsJsonObj.get("delivery");
			
			System.out.println(setup);
			System.out.println(delivery);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private static String readApiResponse(HttpURLConnection apiconnection)
	{
		try
		{
			StringBuilder resultJson=new StringBuilder();
			Scanner sc=new Scanner(apiconnection.getInputStream());
			while(sc.hasNext())
			{
				resultJson.append(sc.nextLine());
			}
			return resultJson.toString();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	private static HttpURLConnection fetchapi(String urlstring)
	{
		try
		{
			URL url=new URL(urlstring);
			HttpURLConnection conn=(HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");
			return conn;
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
