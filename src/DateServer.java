import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;


public class DateServer 
{
	public static void main(String[] args) throws IOException
	{
		ServerSocket server = new ServerSocket(8888);

		Socket client = server.accept();
		
		Scanner in = new Scanner(client.getInputStream());
		String line = in.nextLine();
		System.out.println(line);
		
		PrintWriter out = new PrintWriter(client.getOutputStream());
		out.print(new Date().toString());		
		out.flush();
		out.close();
		
		client.close();
		server.close();
		System.out.println("Done");
	}
}
