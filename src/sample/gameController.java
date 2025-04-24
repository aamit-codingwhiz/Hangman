package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class gameController {
    @FXML
    ImageView myImageView;
    @FXML
    Label guessWord;
    @FXML
    TextField typeChar;
    @FXML
    Label lives;
    @FXML
    Label txt; //show guesses
    @FXML
    Label txt2; //shows if you are wrong or right
    @FXML
    Label points;
    private String s, t;
    private static int setLives = 0;
    private static int p = 0;
    Image myImage1 = new Image(getClass().getResourceAsStream("Drawing1.png"));
    Image myImage2 = new Image(getClass().getResourceAsStream("Drawing2.png"));
    Image myImage3 = new Image(getClass().getResourceAsStream("Drawing3.png"));
    Image myImage4 = new Image(getClass().getResourceAsStream("Drawing4.png"));
    Image myImage5 = new Image(getClass().getResourceAsStream("Drawing5.png"));
    Image myImage6 = new Image(getClass().getResourceAsStream("Drawing6.png"));
    Image myImage7 = new Image(getClass().getResourceAsStream("Drawing7.png"));
    Image myImage8 = new Image(getClass().getResourceAsStream("Drawing8.png"));
    public void displayImage(int i) {
        if (i == 6)
            myImageView.setImage(myImage2);
        if (i == 5)
            myImageView.setImage(myImage3);
        if (i == 4)
            myImageView.setImage(myImage4);
        if (i == 3)
            myImageView.setImage(myImage5);
        if (i == 2)
            myImageView.setImage(myImage6);
        if (i == 1)
            myImageView.setImage(myImage7);
        if (i == 0)
            myImageView.setImage(myImage8);
    }
    public static int check = 0;
    @FXML
    public void New() {
        check = 1;
        callNew();
    }
    private void callNew() {
        if (check == 1) {
            p = 0;
            points.setText(p + "");
            setLives = 7;
            lives.setText("" + setLives);
            myImageView.setImage(myImage1);
        }
        if(check == 2) {
            p++;
            points.setText(p + "");
        }
        s = generateWord();
        System.out.println(s);
        t = "";
        for (int i = 0; i < s.length(); i++) {
            t = t + "*";
        }
        System.out.println(t);
        guessWord.setText(t);
        txt.setText(" ");
        txt2.setText("-----");
    }
    String generateWord() {
        return (new word()).getRandomWord();
    }
    @FXML
    public void save() {
        if(check == 0)
            New();
        if (setLives == 0) {
            typeChar.setText("");
            return;
        }
        if(typeChar.getText().isEmpty())
            return;
        String x = typeChar.getText().charAt(0) + "";
// System.out.println("txt.getText() --> " + txt.getText());
        txt.setText(txt.getText() + " " + x);
        int f = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) + "").equalsIgnoreCase(x)) {
                f = 1;
                t = t.substring(0, i) + x + t.substring(i + 1, s.length());
                txt2.setText("RIGHT");
            }
        }
        if (f == 0) {
            txt2.setText("WRONG");
            setLives--;
            displayImage(setLives);
            if (setLives == 0) {
                lives.setText(setLives + "");
                txt2.setText("WRONG -- YOU LOSE");
                return;
            }
            lives.setText(setLives + "");
        }
        guessWord.setText(t);
        typeChar.setText("");
        if(checkStar()==1) {
            check = 2;
            callNew();
        }
    }
    private int checkStar(){
        for(int i=0 ; i<t.length() ; i++){
            if(t.charAt(i) == '*')
                return -1;
        }
        return 1;
    }
}