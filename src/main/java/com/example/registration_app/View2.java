package com.example.registration_app;

import java.io.*;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.w3c.dom.css.Rect;

import javax.lang.model.type.ErrorType;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.Stack;

public class View2 extends Application  {



    LocalDate unknown=LocalDate.of(1945,01,01);

    //TExt
    Text name=new Text("Name");
    Text birthdate =new Text("Date of Birth");
    Text gender =new Text("Gender");
    Text tk =new Text("Technologies Known");
    Text locat=new Text("Location");
    Text note=new Text("Add Notes");


    //DatePicker
    DatePicker dp=new DatePicker();
    LocalDate ld;
    //TextField
    TextField tf=new TextField();
    TextArea notetf=new TextArea();
    //Rdiobutton
    RadioButton rb=new RadioButton("Male");
    RadioButton rb1=new RadioButton("female");
    RadioButton a;
    ToggleGroup rgroup=new ToggleGroup();

    //checkbox
    CheckBox java=new CheckBox("Java");
    CheckBox dotnet=new CheckBox("Dotnet");
    CheckBox python=new CheckBox("Python");
    CheckBox C =new CheckBox("C++");
    CheckBox Csharp =new CheckBox("C#");

    CheckBox[] boxofcheck={java,dotnet,python,C,Csharp};
    TableView tableView = new TableView();



    //menubar
    MenuBar mb=new MenuBar();
    Menu m=new Menu("file");
    Menu b=new Menu("Help");

    MenuItem save=new MenuItem("Save");
    MenuItem  newmenuitem =new MenuItem("New");
    Label showT=new Label();
    Label fvalidity=new Label();
    Button register=new Button("Register");
    ObservableList<Person> listofreg= FXCollections.observableArrayList();
    Stage b2stage=new Stage();





    TextArea path=new TextArea();
    Stack houzma;
    String lin;












    GridPane form =new GridPane();

    @Override
    public void start( Stage bstage) throws FileNotFoundException {








        //add both radio button to a groupe
        rb.setToggleGroup(rgroup);
        rb1.setToggleGroup(rgroup);





        b2stage=bstage;











        TableColumn<Person, String> column1 = new TableColumn<>("Full Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("fullname"));

        TableColumn<Person,LocalDate> column2 = new TableColumn<>("Date of Birth");
        column2.setCellValueFactory(new PropertyValueFactory<>("borndate"));

        TableColumn<Person,String> column3 = new TableColumn<>("Gender");
        column3.setCellValueFactory(new PropertyValueFactory<>("gender"));
        TableColumn<Person,String> column4 = new TableColumn<>("Note");
        column4.setCellValueFactory(new PropertyValueFactory<>("remark"));
        TableColumn<Person,String> column5 = new TableColumn<>("Tecknologies Known");
        column5.setCellValueFactory(new PropertyValueFactory<>("technologieskn"));


        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);




        tableView.setPlaceholder(new Label("No Person Registred Yet"));
        newmenuitem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tableView.getItems().clear();


            }
        });
        save.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Stage b=new Stage();
                Scene d;
                Label title=new Label("Please insert your Path : ");

                AnchorPane savebox=new AnchorPane();
                Button getpath=new Button("Save");

                savebox.getChildren().addAll(title,path,getpath);



                //title
                title.setAlignment(Pos.TOP_CENTER);
                AnchorPane.setTopAnchor(title,30.);
                AnchorPane.setLeftAnchor(title,65.);


                //butoon
                getpath.setAlignment(Pos.BOTTOM_CENTER);
                AnchorPane.setTopAnchor(getpath,180.);
                AnchorPane.setLeftAnchor(getpath,130.);


                //textarea
                path.setMaxWidth(200);
                path.setMaxHeight(100);

                AnchorPane.setTopAnchor(path,60.);
                AnchorPane.setLeftAnchor(path,70.);


                d=new Scene(savebox,400,250);

                b.setScene(d);
                b.setResizable(false);


                b.show();

                getpath.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        houzma=new Stack();

                        String ink="";
                        int a=92;


                        String input=path.getText();
                        char[] arroflink=input.toCharArray();
                        for(int i=0;i<arroflink.length;i++){

                            if(arroflink[i]==(char)a ){  //C:\Users\mehdi\Desktop\hawhaw
                                houzma.push((char)a);
                            }
                            houzma.push(arroflink[i]);



                        }
                        for (int j = 0; j < houzma.size(); j++) {

                            ink += houzma.get(j);

                        }

                        ink=ink+(char)a+(char)a+"newlist.txt";
                        System.out.println("link is = "+ink);
                        path.setText("");

                        if(!ink.isEmpty()) {
                            try {
                                File c = new File(ink);


                                FileOutputStream fb = new FileOutputStream(c);
                                PrintWriter pb = new PrintWriter(fb);
                                for (Person p : listofreg) {
                                    pb.write(" Fullname = "+p.getFullname() + "; Gender = "+p.getGender()+"; Technologies Known = "+p.getTechnologieskn()+"; BornDate = "+p.getBorndate().toString()+"\n");

                                }
                                pb.close();
                                b.close();



                            } catch (Exception e) {
                                Alert erorr =new Alert(Alert.AlertType.ERROR,"Directory path cant be found ");

                                erorr.setTitle("Wrong Path");
                                erorr.setHeaderText("Please use An directory path in Desktop");

                                erorr.show();





                            }
                        }



                    }

                });







            }
        });




        register.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String checkednames="";

                if(rgroup.getSelectedToggle()!=null) {

                    a = (RadioButton) rgroup.getSelectedToggle();
                }else{
                    a=new RadioButton("ok");

                }

                ArrayList<String> chekednames= namesofcheckedbox(boxofcheck);
                for(String c:chekednames){
                    checkednames +=c+" ";

                }


                if (tf.getText().isEmpty() || a.getText().equalsIgnoreCase("ok") || notetf.getText().isEmpty()) {

                    Alert erorr =new Alert(Alert.AlertType.ERROR,"Registration is not Allowed");

                    erorr.setTitle("Empty Input !!");
                    erorr.setHeaderText("An Input is  Missing ");

                    erorr.show();






                } else {





                    tableView.setItems(addpersontolist(create(tf.getText(), ld, a.getText(), notetf.getText(),checkednames)));// create object of type person and add it to list
                    tf.setText("");
                    notetf.setText(" ");
                    notetf.setText("");




                }
            }
        });

        dp.setEditable(false);
        dp.setOnAction(new EventHandler<ActionEvent>() {

            @Override

            public void handle(ActionEvent event) {

                ld=dp.getValue();





            }
        });

        ImageView im1=new ImageView(new Image("file:\\C:\\Users\\mehdi\\IdeaProjects\\Studentregistration\\src\\sample\\mehdi.jpg"));
        im1.setFitHeight(400);
        im1.setFitWidth(300);






        m.getItems().add(save);
        m.getItems().add(newmenuitem);
        mb.getMenus().addAll(m,b);
        HBox h1=new HBox(40,im1,form);
        VBox vb=new VBox(mb,h1,showT,fvalidity,tableView);
        vb.setSpacing(30);
        BackgroundFill b=new BackgroundFill(Color.GRAY,new CornerRadii(0.1,true),null);
        Background b1=new Background(b);
        vb.setBackground(b1);


        form.setAlignment(Pos.CENTER);
        form.setHgap(20);
        form.setVgap(20);



        form.add(name,0,0);form.add(tf,1,0);
        form.add(birthdate,0,1);form.add(dp,1,1);
        form.add(gender,0,2);form.add(rb,1,2);
        form.add(rb1,2,2);

        form.add(tk,0,3 );
        form.add(java,1,3);
        form.add(dotnet,2,3);
        form.add(python,3,3);
        form.add(C,4,3);
        form.add(Csharp,5,3);
        form.add(note,0,4);
        form.add(notetf,1,4);

        form.add(register,0,5);


        gender.setStyle("-fx-font: normal bold 20px 'serif' ");
        name.setStyle("-fx-font: normal bold 20px 'serif' ");
        birthdate.setStyle("-fx-font: normal bold 20px 'serif' ");
        tk.setStyle("-fx-font: normal bold 20px 'serif' ");
        note.setStyle("-fx-font: normal bold 20px 'serif' ");













        b2stage.setTitle("Student Registration");
        b2stage.getIcons().add(new Image("C:\\Users\\w111361\\IdeaProjects\\registration_app\\src\\main\\java\\com\\example\\registration_app\\htwgicon.jpg"));

        Scene sce=new Scene(vb, 600, 600);




        b2stage.setScene(sce);
        b2stage.setMaximized(true);
        b2stage.show();
    }












    public Person create(String name,LocalDate borndate,String gender,String Note,String tecknologiesknown){

        Person a =new Person(name,borndate,gender,Note,tecknologiesknown);

        return a;

    }
    public ObservableList<Person>  addpersontolist(Person b){

        listofreg.add(b);

        return listofreg;


    }






    private ArrayList<String> namesofcheckedbox(CheckBox[] b) {
        ArrayList<String> namesclicked = new ArrayList<>();
        for (CheckBox a : b) {
            if (a.isSelected()) {
                namesclicked.add(a.getText());
            } else {
                continue;
            }
        }


        return namesclicked;


    }





    public class Person {
        private LocalDate borndate;
        private String fullname;
        private String gender;
        private String remark;
        private String technologieskn;

        public Person( String name, LocalDate borndate,String gender,String Note,String tknow){
            this.fullname=name;
            this.borndate=borndate;
            this.gender=gender;
            this.remark=Note;
            this.technologieskn=tknow;


        }

        public String getTechnologieskn() {
            return technologieskn;
        }

        public void setTechnologieskn(String technologieskn) {
            this.technologieskn = technologieskn;
        }

        public LocalDate getAge() {
            return borndate;
        }

        public void setBorndate(LocalDate borndate) {
            this.borndate = borndate;
        }

        public LocalDate getBorndate() {
            return borndate;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }


        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }








}
