import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalTime;

public class Account implements Serializable{

    String id = "";
    String name = "";
    String address = "";
    String state = "";
    String city = "";
    String zipCode = "";
    String phone = "";
    String timeToContact = "";
    LocalTime timeCreated;
    int balance = 0;//saved as an integer value of cents

    public Account(String fromFile){
        int i = 0;
        int stop = 0;
        char delimiter = '$';
        while(fromFile.charAt(i) != delimiter){
            this.id = fromFile.substring(stop,i+1);
            i++;
        }
        i++;
        stop = i;
        while(fromFile.charAt(i) != delimiter){
            this.name = fromFile.substring(stop,i+1);
            i++;
        }
        i++;
        stop = i;
        while(fromFile.charAt(i) != delimiter){
            this.address = fromFile.substring(stop,i+1);
            i++;
        }
        i++;
        stop = i;
        while(fromFile.charAt(i) != delimiter){
            this.state = fromFile.substring(stop,i+1);
            i++;
        }
        i++;
        stop = i;
        while(fromFile.charAt(i) != delimiter){
            this.city = fromFile.substring(stop,i+1);
            i++;
        }
        i++;
        stop = i;
        while(fromFile.charAt(i) != delimiter){
            this.zipCode = fromFile.substring(stop,i+1);
            i++;
        }
        i++;
        stop = i;
        while(fromFile.charAt(i) != delimiter){
            this.phone = fromFile.substring(stop,i+1);
            i++;
        }
        i++;
        stop = i;
        while(fromFile.charAt(i) != delimiter){
            this.timeToContact = fromFile.substring(stop,i+1);
            i++;
        }
        i++;
        stop = i;
        while(fromFile.charAt(i) != delimiter){
            this.balance = (Integer.valueOf(fromFile.substring(stop,i+1)));
            i++;
        }

        this.timeCreated = LocalTime.now();

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
        info += "Last update: " + this.timeCreated + "\n";

        return info;
    }

    private void serializeAccount(){
        try {
            FileOutputStream fileOut = new FileOutputStream("Accounts.cer");
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
