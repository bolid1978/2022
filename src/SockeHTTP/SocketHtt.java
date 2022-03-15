package SockeHTTP;
import java.net.*;
import java.io.*;
public class SocketHtt {


    /**
     * This program demonstrates a client socket application that connects to
     * a web server and send a HTTP HEAD request.
     *
     * @author www.codejava.net
     */


        public static void main(String[] args) {

            URL url;

            try {
                url = new URL("http://ya.ru");
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
                return;
            }

            String hostname = url.getHost();
            int port = 80;

            try (Socket socket = new Socket(hostname, port)) {
                System.out.println("create socket");
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                writer.println("GET " + url.getPath() + " HTTP/1.1");
                writer.println("Host: " + hostname);
  //              writer.println("User-Agent: Simple Http Client");
                writer.println("Accept: text/html");
                writer.println("Accept-Language: en-US");
//                writer.println("Connection: close");
                writer.println();
                System.out.println("send out");
                InputStream input = socket.getInputStream();
                System.out.println("Creat IN");
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String line;

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (UnknownHostException ex) {

                System.out.println("Server not found: " + ex.getMessage());

            } catch (IOException ex) {

                System.out.println("I/O error: " + ex.getMessage());
            }
        }
}
