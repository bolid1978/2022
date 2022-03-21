package MyClient;

import SockeHTTP.SocketHtt;
import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Socket;

public class ClientServer {
    public static final Logger LOGGERSocket =  LoggerFactory.getLogger(ClientServer.class);
    public static void main(String[] args) {
        DOMConfigurator.configure("C:\\Users\\bolid\\IdeaProjects\\Test\\src\\MyClient\\properties\\2.xml");


    }
}
