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
import java.io.*;
import java.net.*;
import java.util.*;

public class NetworkConnection
{
    public Socket socket;
    public ObjectInputStream ois;
    public ObjectOutputStream oos;

    

    NetworkConnection (Socket s)
    {
        try
        {
            this.socket = s;
            oos = new ObjectOutputStream (socket.getOutputStream ());
            ois = new ObjectInputStream (socket.getInputStream ());

        } catch (IOException ex)
        {

        }
    }
    NetworkConnection (String ip, int port)
    {
        try
        {
            this.socket = new Socket (ip, port);
            oos = new ObjectOutputStream (socket.getOutputStream ());
            ois = new ObjectInputStream (socket.getInputStream ());

        } catch (IOException ex)
        {
            ///System.out.prinln("Failed");
        }
    }

    public Object read ()
    {
        Object ob = null;

        try
        {
            ob = ois.readObject ();

        } catch (IOException | ClassNotFoundException ex)
        {

        }
        return ob;
    }

    public void write (Object ob)
    {
        try
        {
            oos.writeObject (ob);

        } catch (IOException ex)
        {

        }
    }
}

