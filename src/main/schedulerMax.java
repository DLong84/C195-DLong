package main;

import DAO.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;


/**
 * TODO!!!!!
 * @author David Long
 */
public class schedulerMax extends Application {

    /**
     * This method creates a ResourceBundle object from the "languages" package, then loads the stage and scene for the
     * first GUI form while utilizing said object for internationalization of certain form elements. This will load the
     * "Main Form" GUI after the main() method is called.
     * @param mainStage name of the stage for the GUI
     * @throws IOException thrown by FXMLLoader.load() if the .fxml file URL is not input correctly
     */
    @Override
    public void start(Stage mainStage) throws IOException {
        // ResourceBundle object
        ResourceBundle rb_languages = ResourceBundle.getBundle("languages.loginRB");

        mainStage.setResizable(false);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LoginForm.fxml"), rb_languages); //FIXME??
        Parent root = loader.load();
        mainStage.setTitle(rb_languages.getString("loginFormHeader"));
        mainStage.setScene(new Scene(root, 600, 449));
        mainStage.show();


    }


    /**
     * This is the main method, it is the first method that is called when the program starts. It opens the connection
     * to the database and starts the JavaFX application with the Launch() method.
     * @param args Command-line arguments for the scene. Not utilized.
     */
    public static void main(String[] args) {

        Locale.setDefault(new Locale("en"));


        //Locale.setDefault(new Locale("en"));

        /*try {
            ResourceBundle rb_french = ResourceBundle.getBundle("main.loginRB_fr_CA", Locale.getDefault());

            if (Locale.getDefault().getLanguage().equals("fr")) {
                System.out.println("Language set to French");
                System.out.println(rb_french.getString("Login"));
                //Login.loginUserLbl FIXME
            } else {
                System.out.println("Language not loaded");
            }
        }
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }*/

        JDBC.openConnection();

        launch(args);



    }


}