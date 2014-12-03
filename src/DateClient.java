import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class DateClient 
{
	public static void main(String[] args) throws UnknownHostException, IOException 
	{
		Socket server = new Socket("localhost", 8888);
		PrintWriter out = new PrintWriter(server.getOutputStream());
		out.println("GET_TIME");
		out.flush();
		
		Scanner in = new Scanner(server.getInputStream());
		System.out.println(in.nextLine());
		
		server.close();
	}
}
