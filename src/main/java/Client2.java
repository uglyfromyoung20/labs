import java.io.*;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class Client2 {
    private static int a;
    private static int b;

    public static void main(String[] args) {


        try (Socket socket = new Socket("localhost", 8080);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите два числа: ");
            String str;
            while (!Objects.equals(str = scanner.next(), "!quit")) {

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
