/*
 * Jason Boyett - jaboye2448
 * CIT 4423 01
 * Oct 16, 2022
 * mac OS 12
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

public class Account implements Serializable{

    String id = "";
    String name = "";
    String address = "";
    String state = "";
    String city = "";
    String zipCode = "";
    String phone = "";
    String timeToContact = "";
    String comment = "";
    private static final String ASK_FOR_COMMENT = "Do you want to add a comment to this account?"; 
    LocalDateTime timeCreated;
    int balance = 0;//saved as an integer value of cents

    public Account(String constructor){//object constructor

        parseConstructorString(this, constructor);//this function parses the constructor string into the data fields of the constructed object
        String nameIDAndComment = "Account ID : " + this.id + "\n" +"Name: "+ this.name + "\n" + ASK_FOR_COMMENT;
        this.timeCreated = LocalDateTime.now();//shows the time the object was created
        this.comment = JOptionPane.showInputDialog(null, nameIDAndComment);//adds a comment to the account
        if(this.comment.equals(null) || this.comment.equals("")){//if the user doesn't add a comment the comment will be "no comment added"
            this.comment = "No comment added.";
        }
        serializeAccount();//account object is serialized

    }

    public String getInfoString(){//returns the attributes of the object in a string

        String info = "Id: " + this.id + "\n";
        info += "Name: " + this.name + "\n";
        info += "Address: " + this.address + "\n";
        info += "Phone: " + this.phone + "\n";
        info += "State: " + this.state + "\n";
        info += "City: " + this.city + "\n";
        info += "Zip: " + this.zipCode + "\n";
        info += "Phone: " + this.phone + "\n";
        info += "Best time to contact: " + this.timeToContact + "\n";
        info += String.format("Balance: $%,.2f \n", (((double)this.balance)/100));
        info += "Comment: " + this.comment + "\n";
        info += "Last update: " + this.timeCreated + "\n";

        return info;
    }

    private void parseConstructorString(Account account, String constructor){//parses the constructor string into the object attributes

        int i = 0;//the current index of the constructor string
        int stop = 0;//the end point of the last loop ran used to pull a substring from the constructor string
        char attributeDelimiter = '$';

        while(constructor.charAt(i) != attributeDelimiter){//runs till the object delimiter is reached and sets the the attribute to the substring between the precious end point and the current position

            account.id = constructor.substring(stop,i+1);
            i++;

        }
        i++;//increments the current position
        stop = i;//sets the previous end position
        while(constructor.charAt(i) != attributeDelimiter){

            account.name = constructor.substring(stop,i+1);
            i++;

        }
        i++;
        stop = i;
        while(constructor.charAt(i) != attributeDelimiter){

            account.address = constructor.substring(stop,i+1);
            i++;

        }
        i++;
        stop = i;
        while(constructor.charAt(i) != attributeDelimiter){

            account.state = constructor.substring(stop,i+1);
            i++;

        }
        i++;
        stop = i;
        while(constructor.charAt(i) != attributeDelimiter){

            account.city = constructor.substring(stop,i+1);
            i++;

        }
        i++;
        stop = i;
        while(constructor.charAt(i) != attributeDelimiter){

            account.zipCode = constructor.substring(stop,i+1);
            i++;

        }
        i++;
        stop = i;
        while(constructor.charAt(i) != attributeDelimiter){

            account.phone = constructor.substring(stop,i+1);
            i++;

        }
        i++;
        stop = i;
        while(constructor.charAt(i) != attributeDelimiter){

            account.timeToContact = constructor.substring(stop,i+1);
            i++;

        }
        i++;
        stop = i;
        while(constructor.charAt(i) != attributeDelimiter){
            account.balance = (Integer.valueOf(constructor.substring(stop,i+1)));
            i++;
        }

    }

    private void serializeAccount(){//stores the account in a persistent file
        try {

            FileOutputStream fileOut = new FileOutputStream("stored_accounts.cer");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(this);
            objOut.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

}