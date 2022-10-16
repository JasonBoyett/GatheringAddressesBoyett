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

    public Account(String constructor){

        parseConstructorString(this, constructor);
        this.timeCreated = LocalDateTime.now();
        this.comment = JOptionPane.showInputDialog(null, "Account ID :" + this.id + "\n" + ASK_FOR_COMMENT);
        if(this.comment.equals(null) || this.comment.equals("")){
            this.comment = "No comment added.";
        }
        serializeAccount();

    }

    public String getInfoString(){

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

    private void parseConstructorString(Account account, String constructor){

        int i = 0;
        int stop = 0;
        char attributeDelimiter = '$';

        while(constructor.charAt(i) != attributeDelimiter){

            account.id = constructor.substring(stop,i+1);
            i++;

        }
        i++;
        stop = i;
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

    private void serializeAccount(){
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