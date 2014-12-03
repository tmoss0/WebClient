import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SimpleWebClient 
{
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		String host = "docs.oracle.com";
		int port = 80;
		Socket connection = new Socket(host, port);
		connection.setSoTimeout(1000);
		
		String resource = "/javase/tutorial/networking/sockets/index.html";
		String command = String.format("GET %s HTTP/1.1\nHost: %s\n\n", resource, host);
		
		PrintWriter out = new PrintWriter(connection.getOutputStream());
		out.print(command);
		out.flush();
		
		Scanner in = new Scanner(connection.getInputStream());
		
		while(in.hasNextLine())
		{
			System.out.println(in.nextLine());
		}
		in.close();
		connection.close();
	}
}
