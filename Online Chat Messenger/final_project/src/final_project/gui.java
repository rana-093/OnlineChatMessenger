/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.io.File;
import java.io.*;
import java.io.ByteArrayOutputStream;
import java.net.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class gui extends Application
{
    Group group;
    Scene scene;
    NetworkConnection nc;
    HashMap<String, NetworkConnection> table;
    private Window stage;

    public void start (Stage primaryStage) throws Exception
    {

       TextField text_field = new TextField ("Log In");
        text_field.setLayoutX (170.0);
        text_field.setLayoutY (200.0);
        //text_field.setPrefSize (200, 50);
        Button enter = new Button ("Enter");
        enter.setLayoutX (170.0);
        enter.setLayoutY (255.0);
       group = new Group (text_field, enter);
        scene = new Scene (group, 800, 500);
        scene.setFill (Color.CORNFLOWERBLUE);
        primaryStage.setTitle ("Window!!!");
        enter.setOnAction (e ->
        {
            nc= new NetworkConnection ("127.0.0.1", 8888);
           String client_name = text_field.getText ();
            nc.write (client_name);
           chat_screen (primaryStage, client_name);
        });
        primaryStage.setScene (scene);
        primaryStage.show ();
    }

    public static void main (String[] args)
    {
        launch (args);
    }

    void chat_screen (Stage stage, String name)
    {
        TextField message_field = new TextField ();
        message_field.setFont (new Font (20));
        message_field.setLayoutX (10);
        message_field.setLayoutY (375);
        message_field.setPrefSize (400, 50);
        TextArea recieve_message = new TextArea ();
        recieve_message.setEditable (false);
        recieve_message.setFont (new Font (14));
        recieve_message.setLayoutX (10);
        recieve_message.setLayoutY (20);
        recieve_message.setPrefSize (450, 300);
        /*TextArea online = new TextArea ();
        online.setEditable (false);
        online.setFont (new Font (14));
        online.setLayoutX (300);
        online.setLayoutY (20);
        online.setPrefSize (190, 300);*/
        ScrollPane scroll = new ScrollPane ();
        scroll.setContent (recieve_message);
        new reader (nc);
        new TReader (nc, recieve_message);
        Button send = new Button ("Send");
        
       // Button refresh = new Button ("Refresh");
        send.setLayoutX (100);
        send.setLayoutY (450);
        //refresh.setLayoutX (350);
        //refresh.setLayoutY (325);
        Button sendfile = new Button("Send File");
        sendfile.setLayoutX(400);
        sendfile.setLayoutY(450);
        
        Text text = new Text ("Type message:");
        text.setX (50);
        text.setY (350);
        text.setFont (new Font (14));
        Text text2 = new Text ("Messages:");
        text2.setX (50);
        text2.setY (15);
        text2.setFont (new Font (14));
        
        Group root;
        root = new Group (message_field, recieve_message, send, sendfile, text, text2/* text3*/);
        Scene scene = new Scene (root, 500, 500);
        scene.setFill (Color.AQUA);
        stage.setTitle (name);
        
        
        
        sendfile.setOnAction(e ->
        {
            
         FileChooser fc = new FileChooser();
        
        File target_file = fc.showOpenDialog(this.stage);
        
        System.out.println(target_file.toURI().toString());
        
        
            ///FileServer();
            //FileClient();
            
        });
        
        
        
        send.setOnAction (e ->
        {
            String msg = message_field.getText ();
            nc.write (msg);
        });

       
        stage.setScene (scene);
        stage.show ();
    }

   /* private void FileServer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void FileClient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

}


