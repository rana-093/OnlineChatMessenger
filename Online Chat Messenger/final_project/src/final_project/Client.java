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
import java.util.*;

public class Client implements Runnable
{
    Thread thread;
    HashMap<String, NetworkConnection> table;
    NetworkConnection nc;
    String client_name;

    Client (HashMap<String, NetworkConnection> map, NetworkConnection nc)
    {
        thread = new Thread (this);
        this.table = map;
        this.nc = nc;
        thread.start ();
    }

    /*Client(HashMap<String, Utility> map, NetworkConnection nc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
   /* Client(HashMap<String, NetworkConnection> map, NetworkConnection nc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public void run ()
    {
        client_name = (String) nc.read ();
        table.put (client_name, nc);
        System.out.println ( client_name + " - > Entered");
        new ReadServer (nc, table, client_name);
    }
}
