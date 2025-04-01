
import java.io.*;
import java.net.*;


public class server {
    public static void main(String[] args) {
        int port = 12332;

        try (ServerSocket serverSocket = new ServerSocket()) {
            serverSocket.setReuseAddress(true);
            serverSocket.bind(new InetSocketAddress("172.20.10.5", port));
            System.out.println("Server đang chạy trên cổng " + port + "...");

            while (true) {
            	System.out.println("Server đang chạy và chờ kết nối...");
                Socket socket = serverSocket.accept();
                System.out.println("Client đã kết nối: " + socket.getInetAddress());
                
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                
                while (true) {
                    String choiceStr = in.readLine();
                    if (choiceStr == null) break;

                    int choice = Integer.parseInt(choiceStr);

                    switch (choice) {
                    case 1:
                        int n = Integer.parseInt(in.readLine());
                        out.println(n + (BaiTapJava.isPrime(n) ? " là số nguyên tố" : " không phải số nguyên tố"));
                        out.println(n + (BaiTapJava.isSquare(n) ? " là số chính phương" : " không phải số chính phương"));
                        out.println(n + (BaiTapJava.isPerfect(n) ? " là số hoàn hảo" : " không phải số hoàn hảo"));
                        out.println(n + (BaiTapJava.isArmstrong(n) ? " là số Armstrong" : " không phải số Armstrong"));
                        break;

                    case 2:
                        int m = Integer.parseInt(in.readLine());
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        PrintStream ps = new PrintStream(baos);
                        PrintStream oldOut = System.out;
                        System.setOut(ps);
                        BaiTapJava.sumAndProductOfDigits(m);
                        System.out.flush();
                        System.setOut(oldOut);
                        out.print(baos.toString());
                        break;

                    case 3:
                        int a = Integer.parseInt(in.readLine());
                        int b = Integer.parseInt(in.readLine());

                        baos = new ByteArrayOutputStream();
                        ps = new PrintStream(baos);
                        oldOut = System.out;
                        System.setOut(ps);
                        BaiTapJava.gcdAndLcm(a, b);
                        System.out.flush();
                        System.setOut(oldOut);
                        out.print(baos.toString());
                        break;

                    case 4:
                        String str = in.readLine();
                        out.println("Chuỗi đảo ngược: " + BaiTapJava.reverseString(str));
                        break;

                    case 5:
                        String inputStr = in.readLine();
                        out.println("Chuỗi đảo ngược: " + BaiTapJava.reverseString(inputStr));
                        out.println("Chữ hoa: " + inputStr.toUpperCase());
                        out.println("Chữ thường: " + inputStr.toLowerCase());
                        out.println("Đổi hoa-thường: " + BaiTapJava.swapCase(inputStr));
                        out.println("Số từ: " + BaiTapJava.countWords(inputStr));
                        out.println("Nguyên âm: " + BaiTapJava.extractVowels(inputStr));
                        break;

                    case 6:
                        String freqStr = in.readLine();
                        out.println("Từng từ trên mỗi dòng:");

                        baos = new ByteArrayOutputStream();
                        ps = new PrintStream(baos);
                        oldOut = System.out;
                        System.setOut(ps);
                        BaiTapJava.printWords(freqStr);
                        System.out.flush();
                        System.setOut(oldOut);
                        out.print(baos.toString());

                        baos = new ByteArrayOutputStream();
                        ps = new PrintStream(baos);
                        oldOut = System.out;
                        System.setOut(ps);
                        BaiTapJava.printCharacterFrequency(freqStr);
                        System.out.flush();
                        System.setOut(oldOut);
                        out.print(baos.toString());
                        break;

                    case 7:
                        out.println("END");
                        socket.close();
                        return;

                    default:
                        out.println("Lựa chọn không hợp lệ!");
                }

                out.println("END");

                }
            }

        } catch (IOException e) {
            System.err.println("Lỗi khởi động server: " + e.getMessage());
        }
    }

}
