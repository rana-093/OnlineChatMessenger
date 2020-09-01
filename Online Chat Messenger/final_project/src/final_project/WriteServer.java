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

import com.sun.corba.se.impl.util.Utility;
import java.io.*;
import java.util.*;

public class WriteServer implements Runnable
{
    Thread thread;
    HashMap<String, NetworkConnection> table;

    WriteServer (HashMap<String, NetworkConnection> map)
    {
        this.thread = new Thread (this);
        this.table = map;
        thread.start ();
    }

   /* WriteServer(HashMap<String, NetworkConnection> map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

   /* WriteServer(HashMap<String, Utility> map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
    public void run ()
    {
        Scanner in = new Scanner (System.in);
        while (true)
        {
            int idx = 0;
            String s;
            String[] arr = new String[2];
            s = in.nextLine ();
            StringTokenizer st = new StringTokenizer (s, ":");
            while (st.hasMoreTokens ())
            {
                arr[idx++] = st.nextToken ();
            }
            NetworkConnection client_utility = table.get (arr[0]);
            if (client_utility != null)
            {
                client_utility.write (arr[1]);
            }
        }
    }
}

