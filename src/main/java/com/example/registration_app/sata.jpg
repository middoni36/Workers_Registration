package sample;

import javafx.animation.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;

import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Path;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;

public class View1 extends Application {
    view2 v2=new view2();
    Tooltip hint =new Tooltip("Enter Admin ");
     volatile boolean   done = false;

    Circle c9  =new Circle();
    boolean keypress=false;

    view1logic v1logic=new view1logic();
    Scene s1;
    AnchorPane a1=new AnchorPane();;
    GridPane g1=new GridPane();

    Text signin=new Text("Sign-In");
    Button confirm=new Button("Submit");

    TextField tf =new TextField();
    PasswordField userpass =new PasswordField();
    private Rectangle r1=new Rectangle(0,-10,1000,200);
    private Rectangle r2=new Rectangle(0,600,900,200);
    private Rectangle r3=new Rectangle(180,350,500,250);
    //circles
    Circle c1 = new Circle( 20, Color.BLUE);
    Circle c2 = new Circle( 20, Color.YELLOW);
    Circle c3 = new Circle( 20, Color.RED);
    Circle c4 = new Circle( 20, Color.GREEN);
    Circle c5 = new Circle( 20, Color.CHOCOLATE);
    Circle wb1 = new Circle( 10, Color.WHITE);
    Circle wb2 = new Circle( 10, Color.BLACK);
    Circle wb3= new Circle( 10, Color.WHITE);
    Circle wb4= new Circle( 10, Color.BLACK);
    Circle wb5=new Circle(10,Color.WHITE);
    //Text
    Text welcome =new Text("Welcome");
     AnchorPane a2=new AnchorPane();
     Stage stage2=new Stage();



    @Override
    public void start( Stage primaryStage) throws Exception {

stage2=primaryStage;

        //setting of welcome Text
        textsetting2(welcome,createLingrad(Color.GREENYELLOW,Color.RED,Color.BLUE));

//add balls to the HBox
        HBox ballbox =new HBox(twoballs(c1,wb1),twoballs(c2,wb2),twoballs(c3,wb3),twoballs(c4,wb4),twoballs(c5,wb5));


        welcome.setLayoutX(180);
        welcome.setLayoutY(160);
        ballbox.setLayoutX(220);
        ballbox.setLayoutY(180);
        ballbox.setSpacing(60);


       a2.getChildren().addAll(ballbox,welcome);



     r1.setFill(createLingradwithrgb(Color.web("#d9ace8"),Color.web("#c1edf5")));

     r2.setFill(createLingrad(Color.web("#d9ace8"),Color.web("#91f8fa"),Color.web("#ccfbfc")));


   r3.setFill(Color.WHITE);
   r3.setOpacity(0.5);

        movingballs().play();


         g1.setLayoutX(180);
         g1.setLayoutY(350);
         signin.setLayoutX(190);
         signin.setLayoutY(330);
//confirmation button with edit method
         confirm.setLayoutX(400);
         confirm.setLayoutY(540);
         //confrimation button editing
         editButton(confirm);

         // edit text
         textsetting(signin,createLingradwithrgb(Color.WHITE,Color.ALICEBLUE));
         //give gridpane name as variable  and add  buttonsto the gridpane
         setpane(g1);
         view1logic v1log=new view1logic();
         v1log.run();





//add component to anchorpane

        a1.getChildren().addAll(r1,r2,r3,g1,signin,confirm,a2,c9);
        setBackground(a1);

//scene stage
        s1=new Scene(a1,800,800);

  s1.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
      @Override
      public void handle( MouseEvent event) {


          c9.setCenterX(event.getX()+5);
          c9.setCenterY(event.getY()+5);
          c9.setRadius(20);
          c9.setOpacity(0.5);
          c9.setDisable(true);





      }
  });




        s1.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode()==KeyCode.ENTER){
                    keypress=true;
                    v1logic.login(confirm,userpass,tf,keypress);



                }

            }
        });










        stage2.setResizable(false);

        stage2.setScene(s1);
        stage2.getIcons().add(new Image(getClass().getResourceAsStream("htwgicon.jpg")));
        stage2.show();

    }


    public void setBackground( Pane a){




        BackgroundImage myBI= new BackgroundImage(new Image("file:\\C:\\Users\\mehdi\\IdeaProjects\\JavaAbgabe\\src\\sample\\back.jpg",800,800,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
//then you set to your node
        a.setBackground(new Background(myBI));






    }

    public LinearGradient createLingrad(Color firC,Color secC,Color thirc){
        Stop[] stops = new Stop[] { new Stop(0.2, firC), new Stop(0.4, secC),new Stop(0.3, thirc)};
        LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.REFLECT, stops);




        return lg1;
    }
    public LinearGradient createLingradwithrgb(Color rgb,Color rgb2){

        LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.REFLECT, new Stop(0.5,rgb),new Stop(0.2,rgb2));




        return lg1;
    }
    public Transition movetra(Node c , javafx.util.Duration time,int cyclecount,int toy){
        TranslateTransition tr1=new TranslateTransition(time,c);
        tr1.setAutoReverse(true);
        tr1.setCycleCount(cyclecount);


        tr1.setToY(toy);
        tr1.play();










        return tr1;
    }


    public void  textsetting(Text t,LinearGradient c) {
        DropShadow tshadow = new DropShadow();
        t.setEffect(tshadow);
        tshadow.setBlurType(BlurType.ONE_PASS_BOX);
        tshadow.setOffsetX(10);
        tshadow.setOffsetY(10);
        tshadow.setColor(Color.BLACK);







        t.setStroke(c);

        t.setStyle(
                "       -fx-font-size: 60px;" +
                        "-fx-font-weight:bold;" +
                        "-fx-font-family:Arial Narrow;"



        );





    }


    public void setpane(GridPane a){
        Text password =new Text("Password : ");
        Text tex=new Text("User ID :");




        a.add(tex,0,0);

        a.add(tf,0,1);


        a.add(password,0,3);
        a.add(userpass,0,4);
        a.setVgap(20);
        a.setPadding(new Insets(2,0,2,30));

        a.setMaxHeight(10);

        a.getColumnConstraints().add(new ColumnConstraints(130));


        tex.setStyle(
                "       -fx-font-size:20px;" +
                        "-fx-font-weight:bold;" +
                        "-fx-font-family:Akhbar MT;"



        );
        password.setStyle(
                "       -fx-font-size:20px;" +
                        "-fx-font-weight:bold;" +
                        "-fx-font-family:Akhbar MT;"



        );
        tex.setOpacity(0.8);
        password.setOpacity(0.8);
        tf.setBackground(new Background(new BackgroundFill(Color.gray(0.4,0.4),new CornerRadii(0.3,true),null)));
        userpass.setBackground(new Background(new BackgroundFill(Color.gray(0.4,0.4),new CornerRadii(0.3,true),null)));










    }
    public void  editButton(Button b){

b.setBackground(new Background(new BackgroundFill(Color.BLUE,new CornerRadii(0.3,true),null)));
b.setMaxWidth(300);
b.setOpacity(0.8);
b.setTextFill(Color.WHITE);
b.setStyle("-fx-font-size: 20px;"+
        "-fx-font-family:Algerian;");

Image i1=new Image(getClass().getResourceAsStream("next.png"));
ImageView next=new ImageView(i1);
next.setFitWidth(30);
next.setFitHeight(30);
b.setGraphic(next);









    }


    public ParallelTransition movingballs(){

Transition t1 ,t2,t3,t4,t5,t6,t7;

      t1=movetra(c1,Duration.seconds(1), Animation.INDEFINITE,20);
       t2= movetra(c2,Duration.seconds(0.7),Animation.INDEFINITE,30);
     t3=  movetra(c3,Duration.seconds(0.5),Animation.INDEFINITE,20);
       t4= movetra(c4,Duration.seconds(0.6),Animation.INDEFINITE,20);
    t5=  movetra(c5, Duration.seconds(0.8),Animation.INDEFINITE,30);
       t6= movetra(r1,Duration.seconds(12),1,-140);
        t7=movetra(r2,Duration.seconds(15),1,200);
        ParallelTransition paralel1=new ParallelTransition(t1,t2,t3,t4,t5,t6,t7);

        return paralel1;

    }

    // add the cirlces into group so that i can insert them inside Hbox
    public Group twoballs(Node up, Node down){

        Group gr1=new Group();
        gr1.getChildren().add(up);
        gr1.getChildren().add(down);







        return gr1;

    }

    //setting of welcome Text
    public void  textsetting2(Text t,LinearGradient c) {
        DropShadow tshadow = new DropShadow();
        t.setEffect(tshadow);
        tshadow.setBlurType(BlurType.ONE_PASS_BOX);
        tshadow.setOffsetX(10);
        tshadow.setOffsetY(10);
        tshadow.setColor(Color.BLACK);







        t.setStroke(c);

        t.setStyle(
                "       -fx-font-size: 120px;" +
                        "-fx-font-weight:bolder;" +
                        "-fx-font-family:serif;"



        );

    }


// second class LOgic class
public class view1logic extends Application  implements Runnable{
    Alert ero1 = new Alert(Alert.AlertType.WARNING);


        Boolean succed=false;

        view2 v2=new view2();

    @Override
    public void start(Stage secondaryStage) {



        run();





    }

    @Override
    public void run() {



        login(confirm,userpass,tf,keypress);














    }

    public void  login (Button b1,PasswordField p1,TextField t1,boolean keypressed){

        if(keypressed){
            keypressed=false;
            if((p1.getText().equalsIgnoreCase("admin")&& t1.getText().equalsIgnoreCase("admin"))){


                try {
                    v2.start(v2.b2stage);
                    stage2.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }


                succed=true;
                p1.setText("");
                t1.setText("");






            } else if (p1.getText().equalsIgnoreCase("admin")==false || t1.getText().equalsIgnoreCase("admin")==false ) {
                succed = false;
                ero1.setContentText("False Input -> Please Check Your Input");
                ero1.show();

            }
            if(!succed) {
                if (p1.getText().equalsIgnoreCase("") || t1.getText().equalsIgnoreCase("")) {



                    ero1.setContentText("Missing Input -> Please Add Your Input");
                    ero1.show();


                }


            }









        }



        b1.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if((p1.getText().equalsIgnoreCase("admin")&& t1.getText().equalsIgnoreCase("admin"))){


                    try {
                        v2.start(v2.b2stage);
                        stage2.close();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }


                    succed=true;
                    p1.setText("");
                    t1.setText("");

                    System.out.println(succed);





                } else if (p1.getText().equalsIgnoreCase("admin")==false || t1.getText().equalsIgnoreCase("admin")==false ) {
                    succed = false;
                    ero1.setContentText("False Input -> Please Check Your Input");
                    ero1.show();

                }
             if(!succed) {
                 if (p1.getText().equalsIgnoreCase("") || t1.getText().equalsIgnoreCase("")) {



                     ero1.setContentText("Missing Input -> Please Add Your Input");
                     ero1.show();


                 }


             }














            }










        });








    }









}








}
