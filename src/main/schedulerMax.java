package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import static java.util.ResourceBundle.clearCache;

/**
 * @author David Long
 */
public class schedulerMax extends Application {

    /**
     *
     * @param mainStage
     * @throws Exception
     */
    @Override
    public void start(Stage mainStage) throws Exception {

        ResourceBundle rb_languages = ResourceBundle.getBundle("languages.loginRB");

        mainStage.setResizable(false);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LoginForm.fxml"), rb_languages); //FIXME??
        Parent root = loader.load();
        mainStage.setTitle(rb_languages.getString("loginFormHeader")); //TODO ...add "Welcome" and "to" to locale file
        mainStage.setScene(new Scene(root, 600, 449));
        mainStage.show();


    }


    /**
     *
     * @param args
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

        //JDBC.openConnection();

        launch(args);


        //Close the connection
        //JDBC.closeConnection();
    }


}