# Java Socket File Transfer 🚀

A simple, robust client-server application built in Java to demonstrate bidirectional text communication and binary file transfer using `java.net.Socket`.

## ✨ Features
* **Text Messaging:** Send and receive real-time console messages.
* **File Transfer:** Send any file type (PDF, Images, etc.) from Client to Server.
* **Automatic Metadata:** Automatically handles filename and file size transmission before streaming.
* **Binary Safe:** Uses `DataInputStream` and `DataOutputStream` to ensure data integrity for non-text files[cite: 1, 2].

## 🛠️ How to Run

### 1. Setup
Ensure you have `Server.java` and `Client.java` in your project structure[cite: 1, 2].

### 2. Start the Server
```bash
javac org/example/Server.java
java org.example.Server
