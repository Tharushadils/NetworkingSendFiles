<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <style>
        @page {
            size: A4;
            margin: 20mm;
            background-color: #ffffff;
        }
        body {
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Helvetica, Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji";
            font-size: 11pt;
            line-height: 1.6;
            color: #24292e;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 100%;
        }
        .header {
            border-bottom: 1px solid #eaecef;
            padding-bottom: 8px;
            margin-bottom: 16px;
        }
        h1 { font-size: 24pt; margin-top: 0; }
        h2 { font-size: 18pt; border-bottom: 1px solid #eaecef; padding-bottom: 4px; margin-top: 24px; }
        h3 { font-size: 14pt; margin-top: 16px; }
        
        .code-block {
            background-color: #f6f8fa;
            border-radius: 6px;
            padding: 16px;
            font-family: "SFMono-Regular", Consolas, "Liberation Mono", Menlo, monospace;
            font-size: 9pt;
            line-height: 1.45;
            overflow: auto;
            margin: 10px 0;
            border: 1px solid #d1d5da;
        }
        
        .badge {
            display: inline-block;
            padding: 3px 10px;
            font-size: 9pt;
            font-weight: 500;
            line-height: 18px;
            border-radius: 2em;
            background-color: #0366d6;
            color: white;
            margin-right: 5px;
        }

        .instruction-box {
            background-color: #fffbdd;
            border: 1px solid #d1d5da;
            padding: 12px;
            border-radius: 6px;
            margin: 15px 0;
        }

        ul { padding-left: 20px; }
        li { margin-bottom: 5px; }
        
        .footer {
            margin-top: 40px;
            font-size: 9pt;
            color: #6a737d;
            text-align: center;
            border-top: 1px solid #eaecef;
            padding-top: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Java Socket File Transfer</h1>
            <span class="badge">Java</span>
            <span class="badge">Networking</span>
            <span class="badge">Socket Programming</span>
        </div>

        <p>A simple client-server application built in Java to demonstrate bidirectional text communication and binary file transfer using <code>java.net.Socket</code>.</p>

        <h2>Features</h2>
        <ul>
            <li><strong>Text Messaging:</strong> Send and receive real-time console messages.</li>
            <li><strong>File Transfer:</strong> Send any file type (PDF, Images, etc.) from Client to Server.</li>
            <li><strong>Automatic Metadata Handling:</strong> Sends filename and size before streaming bytes.</li>
            <li><strong>Binary Safe:</strong> Uses <code>DataInputStream</code> and <code>DataOutputStream</code> for data integrity.</li>
        </ul>

        <h2>How to Run</h2>
        
        <h3>1. Setup</h3>
        <p>Ensure you have two separate files: <code>Server.java</code> and <code>Client.java</code> in your project structure.</p>

        <h3>2. Start the Server</h3>
        <div class="code-block">
            javac org/example/Server.java<br>
            java org.example.Server
        </div>

        <h3>3. Run the Client</h3>
        <div class="code-block">
            javac org/example/Client.java<br>
            java org.example.Client
        </div>

        <h2>How to Transfer Files</h2>
        <div class="instruction-box">
            <strong>Note:</strong> Windows users should use forward slashes <code>/</code> or double backslashes <code>\\</code> in the console input to avoid escape character errors.
        </div>
        <ol>
            <li>Type <code>file</code> in the Client console.</li>
            <li>Provide the full path, e.g., <code>C:/Users/User/Documents/report.pdf</code>.</li>
            <li>The server will save it as <code>received_report.pdf</code> in its root directory.</li>
        </ol>

        <h2>Code Overview</h2>
        <p>The core logic uses a 4KB buffer to stream bytes without overloading memory:</p>
        <div class="code-block">
            byte[] buffer = new byte[4096];<br>
            int bytesRead;<br>
            while ((bytesRead = fileIn.read(buffer)) != -1) {<br>
            &nbsp;&nbsp;&nbsp;&nbsp;out.write(buffer, 0, bytesRead);<br>
            }
        </div>

        <div class="footer">
            Generated for Java Networking Project Documentation
        </div>
    </div>
</body>
</html>
