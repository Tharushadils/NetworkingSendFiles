package lk.ijse;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (Socket socket = new Socket("127.0.0.1", 3000)) {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            while (true) {
                System.out.println("\nOptions: file -- Send a file | exit -- leave");
                System.out.print("Input: ");
                String input = sc.nextLine();

                if (input.equalsIgnoreCase("exit")) {
                    out.writeUTF("exit");
                    break;
                } else if (input.equalsIgnoreCase("file")) {
                    System.out.print("Enter full file path: ");
                    String filePath = sc.nextLine();
                    sendFile(filePath, out);
                } else {
                    out.writeUTF(input);
                    out.flush();
                    System.out.println("Server reply: " + in.readUTF());
                }
            }
        } catch (IOException e) {
            System.err.println("Client Error: " + e.getMessage());
        }
    }

    private static void sendFile(String path, DataOutputStream out) {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("Error: File not found at " + path);
            return;
        }

        try {
            out.writeUTF("SEND_FILE");
            out.writeUTF(file.getName());
            out.writeLong(file.length());

            try (FileInputStream fileIn = new FileInputStream(file)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fileIn.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }
            out.flush();
            System.out.println("File sent successfully!");

        } catch (IOException e) {
            System.err.println("Failed to send file: " + e.getMessage());
        }
    }
}