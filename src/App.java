import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) throws Exception {

        Account[] accounts = constructAccounts(getStringFromFile("data.txt"),10);
        //Account[] accounts = constructAccounts(test, 10);
        for(Account account: accounts){
            System.out.println(account.getInfoString());
        }
    }

    public static Account[] constructAccounts(String constructionString, int size){
        Account[] myAccounts = new Account[size];
        int accountsIndex = 0;
        char delimiter = '%';
        String constructor = "";
        try{
        for (int i = 0; i < constructionString.length(); i++) {
            if(constructionString.charAt(i) != delimiter){
                constructor += constructionString.charAt(i);
            }
            else{
                myAccounts[accountsIndex] = new Account(constructor);
                accountsIndex++;
                constructor = "";
            }
        }
        return myAccounts;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public static String getStringFromFile(String localFileName){
        try{
            String result = "";
            File file = new File(localFileName);
            Scanner scanner = new Scanner(file);
            
            while(scanner.hasNextLine()) {
                result += scanner.nextLine();
            }
            scanner.close();

            return result;
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
            System.exit(1);
            return null;
        }
    }

    
}
