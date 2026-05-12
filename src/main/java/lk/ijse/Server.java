package lk.ijse;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(3000)) {
            System.out.println("Server Started. Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client Connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String command = in.readUTF();

                if (command.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected.");
                    break;
                } else if (command.equals("SEND_FILE")) {
                    receiveFile(in);
                } else {
                    System.out.println("Client says: " + command);
                    out.writeUTF("Server received your message: " + command);
                    out.flush();
                }
            }
            socket.close();
        } catch (IOException e) {
            System.err.println("Server Error: " + e.getMessage());
        }
    }

    private static void receiveFile(DataInputStream in) throws IOException {
        String fileName = in.readUTF();
        long fileSize = in.readLong();
        System.out.println("Receiving file: " + fileName + " (" + fileSize + " bytes)");

        try (FileOutputStream fileOut = new FileOutputStream("received_" + fileName)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            long totalRead = 0;

            while (totalRead < fileSize && (bytesRead = in.read(buffer, 0, (int) Math.min(buffer.length, fileSize - totalRead))) != -1) {
                fileOut.write(buffer, 0, bytesRead);
                totalRead += bytesRead;
            }
            System.out.println("File saved successfully as: received_" + fileName);
        }
    }
}