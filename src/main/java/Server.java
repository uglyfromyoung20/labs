import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Arrays;

public class Server {
    private static int num;
    private static int num1;

    public static void main(String[] args) {
        System.out.println("Сервер запущен!");
try(ServerSocket server = new ServerSocket(8080);) {


    while (true) {
        try (Socket acceptSocket = server.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(acceptSocket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(acceptSocket.getOutputStream()))) {
            System.out.println("Клиент подключился.");

            while (true) {
                num = in.read();
//                    System.out.println("Первое значение: " + num);
                num1 = in.read();
//                    System.out.println("Второе значение: " + num1);
                out.write((delenie(num, num1)) + "\n");
//                    System.out.println("Результат деления : " + delenie(num, num1));
                out.flush();
            }

        } catch (SocketException e) {
            System.out.println("Клиент отключился.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
} catch (IOException e) {
    e.printStackTrace();
}
    }

        public static String delenie ( int a, int b){
            if (b == 0) {
                return "На ноль делить нельзя";
            }
            int[] arr;
            arr = new int[2];
            arr[0] = a / b;
            arr[1] = a % b;
            return Arrays.toString(arr);
        }

}