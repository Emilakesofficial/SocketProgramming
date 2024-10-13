import javax.sound.midi.Soundbank;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(3333);
        System.out.println("Server Running");
        Socket s = ss.accept();
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "", str2 = "";
        while (!str.equals("stop")) {
            str = dis.readUTF();
            System.out.println("client says: " + str);
            System.out.println("enter message: ");
            str2 = br.readLine();
            dout.writeUTF(str2);
            dout.flush();
        }
        dis.close();
        s.close();
        ss.close();

    }
}
