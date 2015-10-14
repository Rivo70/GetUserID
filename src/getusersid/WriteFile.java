/**
 *
 * @author Rafael R Rodriguez
 *
 */

package getusersid;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;


public class WriteFile {
    public static void writeFile(ArrayList<UserID> users) {
    FileWriter writer;
    
    try{
        File fileName = new File("c:\\temp\\test.txt");
        writer = new FileWriter(fileName);
        try (BufferedWriter out = new BufferedWriter(writer)) {
            for (UserID usr : users) 
            {
                String output;
                output = usr.getUserID() + " - " + usr.getDecription() + ", " + usr.getStatus() + ", " +
                        usr.getGroup() + ", " + Arrays.toString(usr.getAuthority());
                out.write(output);
                out.newLine();
            }
        }
    
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
}
    

}
