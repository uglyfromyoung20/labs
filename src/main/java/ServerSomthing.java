import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class ServerSomthing extends Thread {

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private static int number;
    private  static int number1;


    public ServerSomthing(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }
    @Override
    public void run() {
        try {
            try {

                while (true) {
                    number = in.read();
                    number1 = in.read();
                    {
                        out.write((delenie(number , number1)) + "\n");
                        out.flush();
                    }

                }
            } finally {
                socket.close();
                in.close();
                out.close();
            }

        } catch (IOException e) {
            System.out.println("Пользователь отключился");
        }
    }
    public static  String delenie(int a , int b){
        if(b==0){
            return "На ноль делить нельзя";
        }
        int[] arr;
        arr = new int[2];
        arr[0] = a/b;
        arr[1] = a%b;
        return Arrays.toString(arr);
    }

}
