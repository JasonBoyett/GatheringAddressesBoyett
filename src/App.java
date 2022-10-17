/*
 * Jason Boyett - jaboye2448
 * CIT 4423 01
 * Oct 16, 2022
 * mac OS 12
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) throws Exception {//memory hook

        Account[] accounts = constructAccounts(getStringFromFile("src/data.txt"));
        for(Account account: accounts){

            System.out.println(account.getInfoString());

        }
    }

    public static Account[] constructAccounts(String constructionString){//creates account objects from the given string and stores them in an array that is then returned 
        
        int accountsIndex = 0;//used to indicate the constructed objects position in the array
        char objectDelimiter = '%';
        Account[] myAccounts = new Account[findNumberOfObjects(constructionString, objectDelimiter)];//sets the size of the array based on the method that finds the number of objects
        String constructor = "";
        try{//breaks up the constructionString into constructors for individual account objects and builds those objects once it hits the object delimiter
        for (int i = 0; i < constructionString.length(); i++) {//loops through the constructionString
            if(constructionString.charAt(i) != objectDelimiter){//passes the constructor once it hits the object delimiter
                constructor += constructionString.charAt(i);
            }
            else{//once the object delimiter is hit then the constructor string is passed to the Account constructor method and the holder string is reset
                myAccounts[accountsIndex] = new Account(constructor);
                accountsIndex++;//array position is incremented
                constructor = "";
            }
        }
        return myAccounts;//returns the array
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public static String getStringFromFile(String localFileName) throws Exception{//reads in a file and returns the contents as a string
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

    private static int findNumberOfObjects(String fromFile, char objectDelimiter){//finds the number of objects in file using the number of object delimiters

        int result = 0;
        for(int i = 0; i < fromFile.length(); i++){

            if(fromFile.charAt(i) == objectDelimiter){
                result ++;
            }

        }

        return result;
    }

    
}
