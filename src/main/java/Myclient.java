import javax.xml.crypto.Data;
import java.io.*;
import java.net.Socket;

public class Myclient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 3333);
        System.out.println("Connected");
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        String str = "", str2 = "";
        while (!str.equals("exit connection")) {
            System.out.println("enter message: ");
            str = br.readLine();
            dout.writeUTF(str);
            dout.flush();
            str2 = din.readUTF();
            System.out.println("Server says: " + str2);
        }
        dout.close();
        s.close();
    }
}
