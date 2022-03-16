package SockeHTTP;

import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

public class SocketHtt {
   
    

     public static final Logger LOGGERSocket = (Logger) LoggerFactory.getLogger(SocketHtt.class);

    /**
     * This program demonstrates a client socket application that connects to
     * a web server and send a HTTP HEAD request.
     *
     * @author www.codejava.net
     */


        public static void main(String[] args) {

            DOMConfigurator.configure("C:\\Users\\bolid\\IdeaProjects\\Test\\src\\log\\2.xml");
            URL url;

            try {
                url = new URL("http://google.com");
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
                return;
            }

            String hostname = url.getHost();
            int port = 80;

            try (Socket socket = new Socket(hostname, port)) {
                //Logger.infa("create socket");
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                writer.println("GET " + url.getPath() + " HTTP/1.1");
                writer.println("Host: " + hostname);
                writer.println("User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36");
                writer.println("Accept: text/html");
    //            writer.println("Accept-Language: en-US");
//                writer.println("Connection: close");
                writer.println();
                LOGGERSocket.info("send out");
                InputStream input = socket.getInputStream();
                LOGGERSocket.info("Creat IN");
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String line;

                while ((line = reader.readLine()) != null) {
                    LOGGERSocket.info(line);
                }
            } catch (UnknownHostException ex) {

                LOGGERSocket.info("Server not found: " + ex.getMessage());

            } catch (IOException ex) {

                LOGGERSocket.info("I/O error: " + ex.getMessage());
            }
        }
}
