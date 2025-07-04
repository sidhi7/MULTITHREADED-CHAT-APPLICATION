import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 1234;

        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Connected to server on " + hostname + ":" + port);

            new ReadThread(socket).start();
            new WriteThread(socket).start();

        } catch (ConnectException ce) {
            System.out.println("Cannot connect to server: " + ce.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class ReadThread extends Thread {
    private BufferedReader in;

    public ReadThread(Socket socket) throws IOException {
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void run() {
        try {
            String response;
            while ((response = in.readLine()) != null) {
                System.out.println("[Server]: " + response);
            }
            System.out.println("Server closed connection.");

        } catch (SocketException se) {
            System.out.println("Connection closed by server.");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("ReadThread ending.");
        }
    }
}

class WriteThread extends Thread {
    private PrintWriter out;
    private BufferedReader console;

    public WriteThread(Socket socket) throws IOException {
        out = new PrintWriter(socket.getOutputStream(), true);
        console = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() {
        try {
            String text;
            while ((text = console.readLine()) != null) {
                if (text.trim().isEmpty()) continue; // skip empty lines
                System.out.println("Sending: " + text);
                out.println(text);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("WriteThread ending.");
        }
    }
}
