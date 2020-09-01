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

public class reader implements Runnable
{
    Thread thread;
   NetworkConnection Nc;

    reader (NetworkConnection nc)
    {
        this.thread = new Thread (this);
        thread.start ();
        this.Nc = nc;
    }

    public void run ()
    {
        while (true)
        {
            String msg;
            Scanner in = new Scanner(System.in);
            msg = in.nextLine ();
           Nc .write (msg);
        }
    }
}
