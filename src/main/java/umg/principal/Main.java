package umg.principal;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import umg.principal.dao.UserDao;
import umg.principal.model.User;
import umg.principal.service.UserService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            // Uncomment these lines if you want to start the Telegram bot
            // TelegramBotsApi chatBot = new TelegramBotsApi(DefaultBotSession.class);
            // chatBot.registerBot(new tareaBot());

            // Test creating a new user
            //testCreateUser();

            // Test updating a user
            testUpdateUser();

            // Test deleting a user
            //testDeleteUser();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   // private static void testCreateUser() {
       // UserService userService = new UserService();
       // User user = new User();

       // user.setCarne("0905-12-12345");
        //user.setNombre("Andrea Lopez");
       // user.setCorreo("ALopez@gmail.com");
       // user.setSeccion("A");
       // user.setTelegramid(1234567890L);
       // user.setActivo("Y");

       // try {
        //    userService.createUser(user);
       //     System.out.println("User created successfully!");
      //  } catch (SQLException e) {
       //     System.out.println("Error creating user: " + e.getMessage());
       //     e.printStackTrace();
    //    }
  //  }

    private static void testUpdateUser() {
        UserService userService = new UserService();

        try {
            User userRetrieved = userService.getIdAndCarneByEmail("cuyeyo@miumg.edu.gt");
            if (userRetrieved != null) {
                System.out.println("Retrieved User: " + userRetrieved.getNombre());
                System.out.println("Retrieved Correo: " + userRetrieved.getCorreo());
                System.out.println("Retrieved ID: " + userRetrieved.getId());

                //userRetrieved.setCarne("0905-12-12345");
               // userRetrieved.setNombre("Andrea Ascoli");
               // userRetrieved.setCorreo("cuyeyo@miumg.edu.gt");
               // userRetrieved.setSeccion("A");
               // userRetrieved.setTelegramid(1234567890L);
               // userRetrieved.setActivo("Y");

                userService.updateUser(userRetrieved);
                System.out.println("User updated successfully!");
            } else {
                System.out.println("User not found");
            }
        } catch (SQLException e) {
            System.out.println("Error updating user: " + e.getMessage());
        }
    }

    //private static void testDeleteUser() {
        //UserService userService = new UserService();
       // try {
            //userService.deleteUserByEmail("cuyeyo@miumg.edu.gt");
            //System.out.println("User deleted successfully!");
       // } catch (SQLException e) {
            //System.out.println("Error deleting user: " + e.getMessage());
    //}
    //}
}