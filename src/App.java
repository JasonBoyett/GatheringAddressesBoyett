import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) throws Exception {

        Account[] accounts = constructAccounts(getStringFromFile("src/data.txt"));
        for(Account account: accounts){

            System.out.println(account.getInfoString());

        }
    }

    public static Account[] constructAccounts(String constructionString){
        
        int accountsIndex = 0;
        char objectDelimiter = '%';
        Account[] myAccounts = new Account[findNumberOfObjects(constructionString, objectDelimiter)];
        String constructor = "";
        try{
        for (int i = 0; i < constructionString.length(); i++) {
            if(constructionString.charAt(i) != objectDelimiter){
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

    public static String getStringFromFile(String localFileName) throws Exception{
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

    private static int findNumberOfObjects(String fromFile, char objectDelimiter){
        
        int result = 0;
        for(int i = 0; i < fromFile.length(); i++){

            if(fromFile.charAt(i) == objectDelimiter){
                result ++;
            }

        }

        return result;
    }

    
}
