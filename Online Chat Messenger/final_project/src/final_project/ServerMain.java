/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

/**
 *
 * @author Masud Rana
 */
//import com.sun.corba.se.impl.util.Utility;
import java.io.*;
import java.net.*;
import java.util.*;

public class ServerMain
{
    static HashMap<String, NetworkConnection> map = new HashMap<> ();
    
    static HashMap get_map()
    {
        return map;
    }
    
    public static void main (String[] args)
    {
        try
        {
            ServerSocket server_socket = new ServerSocket (8888);
            new WriteServer (map);

            while (true)
            {
                Socket socket = server_socket.accept ();
                NetworkConnection nc = new NetworkConnection (socket);
                new Client (map, nc);
            }

        } catch (IOException ex)
        {

        }
    }
}
