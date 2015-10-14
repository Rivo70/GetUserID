/**
 *
 * @author Rafael R Rodriguez
 * 
 */
package getusersid;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400SecurityException;
import com.ibm.as400.access.ErrorCompletingRequestException;
import com.ibm.as400.access.ObjectDoesNotExistException;
import com.ibm.as400.access.RequestNotSupportedException;
import com.ibm.as400.access.User;
import com.ibm.as400.access.UserList;
import static getusersid.WriteFile.writeFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;


public class GetUsersID {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ErrorCompletingRequestException, InterruptedException, ObjectDoesNotExistException, RequestNotSupportedException {
        
       
        
        //AS400 connection and command object
        AS400 system400 = new AS400("10.10.2.38", "rafael", "jackme01");
       
        
        try
        {
            UserList userList = new UserList(system400);
            Enumeration list = userList.getUsers();
            //UserID user = new UserID();
            ArrayList<UserID> usersList = new ArrayList();
            
            
            while (list.hasMoreElements())
            {
                User usr = (User) list.nextElement();
                UserID user = new UserID();
                
                //user.setUserID(Long.toString(usr.getUserID()));
                user.setUserID(usr.getUserProfileName());
                user.setDecription(usr.getDescription());
                user.setGroup(usr.getGroupAuthority());
                user.setAuthority(usr.getSpecialAuthority());
                user.setStatus(usr.getStatus());
                
                usersList.add(user);
                
            }
            
            writeFile(usersList);
                        
        }catch (AS400SecurityException | IOException e)
        {
            System.out.println(e.getMessage());
        }
               
        
    }//end of main
    
       
}
