/*
 * Jason Boyett - jaboye2448
 * CIT 4423 01
 * Oct 16, 2022
 * mac OS 12
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class testApp {
    
    @Test
    public void testRead(){
        try{
            String testString = App.getStringFromFile("test.txt");
            assertEquals(null, "hello", testString);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
    }
}
