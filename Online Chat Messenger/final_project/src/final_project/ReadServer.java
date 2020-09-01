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
import java.util.*;

public class ReadServer implements Runnable
{
    Thread thread;
    NetworkConnection nc;
    HashMap<String, NetworkConnection> table;
    String client_name;

    ReadServer (NetworkConnection nc, HashMap<String, NetworkConnection> table, String name)
    {
        this.thread = new Thread (this);
        thread.start ();
        this.table = table;
        client_name = name;
        this.nc = nc;
    }

    public void run ()
    {
        while (true)
        {
            int idx = 0;
            String s = (String) nc.read ();
            String[] arr = new String[2];
            StringTokenizer st = new StringTokenizer (s, ":");
            while (st.hasMoreTokens ())
            {
                arr[idx++] = st.nextToken ();
            }
            NetworkConnection Nc = table.get (arr[0]);
            Nc.write ( client_name + "Says -> " + arr[1]);
        }
    }
}

