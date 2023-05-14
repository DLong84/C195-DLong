package utlities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * This class manages scene-change methods.
 * @author David Long
 */
public class SceneUtils {

    /**
     * This method changes the scene to the "MainForm" GUI.
     * @param clickedButton Variable used from the current scene to set the stage
     * @throws IOException thrown by FXMLLoader.load() if the .fxml file URL is not input correctly
     */
    public static void toMainForm (Button clickedButton) throws IOException {
        Parent root = FXMLLoader.load(SceneUtils.class.getResource("/view/MainForm.fxml"));
        Stage stage = (Stage) clickedButton.getScene().getWindow();
        Scene scene = new Scene(root, 1292, 906);
        stage.setTitle("SchedulerMax");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method changes the scene to the "LoginForm" GUI.
     * @param clickedButton Variable used from the current scene to set the stage
     * @throws IOException thrown by FXMLLoader.load() if the .fxml file URL is not input correctly
     */
    public static void toLoginForm (Button clickedButton) throws IOException {
        ResourceBundle rb_languages = ResourceBundle.getBundle("languages.loginRB");

        Stage mainStage = (Stage) clickedButton.getScene().getWindow();
        mainStage.setResizable(false);
        FXMLLoader loader = new FXMLLoader(SceneUtils.class.getResource("/view/LoginForm.fxml"), rb_languages); //FIXME??
        Parent root = loader.load();
        mainStage.setTitle(rb_languages.getString("loginFormHeader"));
        mainStage.setScene(new Scene(root, 600, 449));
        mainStage.show();
    }

}