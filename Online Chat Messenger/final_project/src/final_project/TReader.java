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
import javafx.scene.control.TextArea;

public class TReader implements Runnable
{
    Thread thread;
    NetworkConnection nc;
    TextArea txt_area;

    TReader (NetworkConnection nc, TextArea area)
    {
        this.thread = new Thread (this);
        thread.start ();
        this.nc = nc;
        txt_area = area;
    }

    public void run ()
    {
        while (true)
        {
            String msg = (String) nc.read ();
            txt_area.appendText(msg+"\n");
        }
    }
}
