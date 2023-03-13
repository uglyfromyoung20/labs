import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Objects;
import java.util.Scanner;

public class Client {

    private static int a;
    private static int b;

    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 8080);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите два числа: ");
            String str;
            while (!Objects.equals(str = scanner.next(), "exit")) {

                a = Integer.parseInt(str);
                b = scanner.nextInt();

                bufferedWriter.write(a);
                bufferedWriter.write(b);
                bufferedWriter.flush();

                String result = bufferedReader.readLine();
                System.out.println("Результат деления: " + result + "\n");
                System.out.println("Введите два числа: ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}




//    private static Socket clientSocket;
//    private static BufferedReader reader;
//
//    private static BufferedReader in;
//    private static BufferedWriter out;
//
//    public static void main(String[] args) {
//
//            try {
//                try {
//                    clientSocket = new Socket("localhost", 8080);
//                    reader = new BufferedReader(new InputStreamReader(System.in));
//                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
//                    String word = "";
//                    String word1 = "";
//                    while (true) {
//                        System.out.println(" Введите значения : ");
//                        word = String.valueOf((reader.readLine()));
//
//                        System.out.println("Первое значение: " + word);
//                         word1 = String.valueOf((reader.readLine()));
//
//                        System.out.println("Второе значение : " + word1);
//                        out.write(word + "\n");
//                        out.write(word1 + "\n");
//                        out.flush();
//                        String serverWord = in.readLine();
//                        System.out.println(serverWord);
//
//                    }
//                }
//                finally {
//                    System.out.println("Клиент был закрыт...");
//                    clientSocket.close();
//                    in.close();
//                    out.close();
//                }
//            } catch (IOException e) {
//                System.err.println(e);
//            }
//
//        }