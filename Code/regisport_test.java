package RegiSport;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.*;
import javafx.scene.shape.Rectangle;
import java.sql.*;
import java.util.*;

public class regisport_test extends Application {
	
	private String football="Football";
	private String hockey="Hockey";
	private String basketball="Basketball";
	
	private Boolean walid1;
	private Boolean tmp;
	private String libelle_C;
	private String id_C;
	private String id_S;
	private LocalDate date_D;
	private LocalDate date_F;
	private String prix;
	private String win;
	private int nb; 
	private String lieu;
	Label valid = new Label("");
	
	private String id_E;
	private String nom_E;
	private int eff = 0;
	private String nom_C;
	private String ville1;
	
	private String ID_E;

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Regisport");
		primaryStage.getIcons().add(new Image("C:\\Users\\Julien\\eclipse-workspace\\regisport\\src\\regisport/icon.png"));
//		primaryStage.setWidth(600);
//		primaryStage.setHeight(600);
		
		
        FlowPane root = new FlowPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
        
        
		Image imagefond = new Image(new FileInputStream("image/logo_gris.png"));
		BackgroundImage fondg = new BackgroundImage(imagefond,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
		Background fondgr = new Background(fondg);
		
		Image imgcompd = new Image(new FileInputStream("image/detail_comp2.png"));
		BackgroundImage fonddtl = new BackgroundImage(imgcompd,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
		Background fonddetail = new Background(fonddtl);
		
		Image imgekipd = new Image(new FileInputStream("image/equipedetails.png"));
		BackgroundImage fonddtl1 = new BackgroundImage(imgekipd,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
		Background fonddetail1 = new Background(fonddtl1);
		
		Image imgadhd = new Image(new FileInputStream("image/Adherentdetails.png"));
		BackgroundImage fonddtl2 = new BackgroundImage(imgadhd,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
		Background fonddetail2 = new Background(fonddtl2);
		
        FlowPane comp1 = new FlowPane();
        comp1.setPadding(new Insets(10));
        comp1.setHgap(10);
        comp1.setVgap(10);
        comp1.setBackground(fondgr);
        GridPane comp2 = new GridPane();
        comp2.setPadding(new Insets(10));
        comp2.setHgap(10);
        comp2.setVgap(10);
        comp2.setBackground(fondgr);
        FlowPane comp15 = new FlowPane();
        comp15.setPadding(new Insets(10));
        comp15.setHgap(10);
        comp15.setVgap(10);
        comp15.setBackground(fondgr);
        FlowPane compd = new FlowPane();
        compd.setPadding(new Insets(10));
        compd.setHgap(10);
        compd.setVgap(10);
        compd.setBackground(fonddetail);
        GridPane competiteur = new GridPane();
        competiteur.setPadding(new Insets(10));
        competiteur.setHgap(10);
        competiteur.setVgap(10);
        competiteur.setBackground(fondgr);
        FlowPane ekip = new FlowPane();
        ekip.setPadding(new Insets(10));
        ekip.setHgap(10);
        ekip.setVgap(10);
        ekip.setBackground(fondgr);
        FlowPane ekipd = new FlowPane();
        ekipd.setPadding(new Insets(10));
        ekipd.setHgap(10);
        ekipd.setVgap(10);
        ekipd.setBackground(fonddetail1);
        GridPane ekipa = new GridPane();
        ekipa.setPadding(new Insets(10));
        ekipa.setHgap(10);
        ekipa.setVgap(10);
        ekipa.setBackground(fondgr);
        FlowPane adha = new FlowPane();
        adha.setPadding(new Insets(10));
        adha.setHgap(10);
        adha.setVgap(10);
        adha.setBackground(fondgr);
        FlowPane adhadt = new FlowPane();
        adhadt.setPadding(new Insets(10));
        adhadt.setHgap(10);
        adhadt.setVgap(10);
        adhadt.setBackground(fonddetail2);
        GridPane adhadd = new GridPane();
        adhadd.setPadding(new Insets(10));
        adhadd.setHgap(10);
        adhadd.setVgap(10);
        adhadd.setBackground(fondgr);
        Scene scene1 = new Scene(comp1, 800, 600);
        Scene sceneCompAdd = new Scene(comp2, 800, 600);
        Scene sceneCompAdd2 = new Scene(comp15, 800, 600);
        Scene sceneCompd = new Scene(compd, 800, 600);
        Scene sceneCompetiteuradd = new Scene(competiteur, 800, 600);
        Scene sceneekip = new Scene(ekip, 800, 600);
        Scene sceneekipd = new Scene(ekipd, 800, 600);
        Scene sceneekipadd = new Scene(ekipa, 800, 600);
        Scene sceneadh = new Scene(adha, 800, 600);
        Scene sceneadhd = new Scene(adhadt, 800, 600);
        Scene sceneadhadd = new Scene(adhadd, 800, 600);
        //scene1.getStylesheets().add("C:\\Users\\Admin\\eclipse-workspace\\regisport\\src\\regisport/style.css");
		
        //___________________________________________________________________________________
        //Image-Accueil
        //___________________________________________________________________________________
        
		Image imagemain = new Image(new FileInputStream("image/Logo.png"));
		BackgroundImage bImg = new BackgroundImage(imagemain,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
		Background fond = new Background(bImg);
		root.setBackground(fond);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        
		//___________________________________________________________________________________
		//Boutons:
		//___________________________________________________________________________________
        
		Button button1 = new Button("Competition");
		button1.setTranslateX(70);
		button1.setTranslateY(100);
		button1.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
		button1.setOnAction(e -> {
			primaryStage.setScene(scene1);
		});	
        button1.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                button1.setStyle("-fx-border-color:transparent; -fx-background-color: grey; -fx-text-fill: white;");;
            }
        });

        button1.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                button1.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");;
            }
        });
		
		
//___________________________________________________________________________________
//___________________________________________________________________________________
//___________________________________________________________________________________
//Fenetre compétition:
//___________________________________________________________________________________
//___________________________________________________________________________________
//___________________________________________________________________________________
		
		Image home = new Image(new FileInputStream("image/home.png"));
		ImageView imagehome = new ImageView(home);
		ImageView imagehomeadd = new ImageView(home);
		ImageView imagehome15= new ImageView(home);
		ImageView imagehomed= new ImageView(home);
		ImageView imagehomecompetiteur= new ImageView(home);
		imagehome.setFitHeight(50);
		imagehome.setFitWidth(50);
		imagehome15.setFitHeight(50);
		imagehome15.setFitWidth(50);
		imagehomeadd.setFitHeight(50);
		imagehomeadd.setFitWidth(50);
		imagehomed.setFitHeight(50);
		imagehomed.setFitWidth(50);
		imagehomecompetiteur.setFitHeight(50);
		imagehomecompetiteur.setFitWidth(50);
		Image homew = new Image(new FileInputStream("image/homew.png"));
		ImageView imagehomew = new ImageView(homew);
		ImageView imagehomewadd = new ImageView(homew);
		ImageView imagehomew15 = new ImageView(homew);
		ImageView imagehomewd = new ImageView(homew);
		ImageView imagehomewcompetiteur = new ImageView(homew);
		imagehomew.setFitHeight(50);
		imagehomew.setFitWidth(50);
		imagehomewadd.setFitHeight(50);
		imagehomewadd.setFitWidth(50);
		imagehomew15.setFitHeight(50);
		imagehomew15.setFitWidth(50);
		imagehomewd.setFitHeight(50);
		imagehomewd.setFitWidth(50);
		imagehomewcompetiteur.setFitHeight(50);
		imagehomewcompetiteur.setFitWidth(50);
		
		//bouton retour menu
		Button buttonhome = new Button();
		buttonhome.setGraphic(imagehome);
		buttonhome.setTranslateX(635);
		buttonhome.setTranslateY(0);
		buttonhome.setShape(new Circle(1.5));
		buttonhome.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
        buttonhome.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonhome.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
                buttonhome.setGraphic(imagehomew);
            }
        });

        buttonhome.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonhome.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
                buttonhome.setGraphic(imagehome);
            }
        });
		
		buttonhome.setPrefSize(50, 50);
		buttonhome.setOnAction(e -> {
			primaryStage.setScene(scene);
		});
		
		Image back = new Image(new FileInputStream("image/fleche.png"));
		ImageView imageback = new ImageView(back);
		ImageView imagebackadd = new ImageView(back);
		ImageView imageback15 = new ImageView(back);
		ImageView imagebackcompetiteur = new ImageView(back);
		imageback.setFitHeight(50);
		imageback.setFitWidth(50);
		imagebackadd.setFitHeight(50);
		imagebackadd.setFitWidth(50);
		imageback15.setFitHeight(50);
		imageback15.setFitWidth(50);
		imagebackcompetiteur.setFitHeight(50);
		imagebackcompetiteur.setFitWidth(50);
		Image backw = new Image(new FileInputStream("image/flechew.png"));
		ImageView imagebackw = new ImageView(backw);
		ImageView imagebackwadd = new ImageView(backw);
		ImageView imagebackw15 = new ImageView(backw);
		ImageView imagebackwcompetiteur = new ImageView(backw);
		imagebackw.setFitHeight(50);
		imagebackw.setFitWidth(50);
		imagebackwadd.setFitHeight(50);
		imagebackwadd.setFitWidth(50);
		imagebackw15.setFitHeight(50);
		imagebackw15.setFitWidth(50);
		imagebackwcompetiteur.setFitHeight(50);
		imagebackwcompetiteur.setFitWidth(50);
		
		
		
		//bouton retour fenetre d'avant
		Button buttonback = new Button();
		buttonback.setGraphic(imageback);
		buttonback.setTranslateX(0);
		buttonback.setTranslateY(0);
		buttonback.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
        buttonback.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonback.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
                buttonback.setGraphic(imagebackw);
            }
        });

        buttonback.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonback.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
                buttonback.setGraphic(imageback);
            }
        });
		
		buttonback.setShape(new Circle(1.5));
		buttonback.setPrefSize(50, 50);
		buttonback.setOnAction(e -> {
			primaryStage.setScene(scene);
		});
		
		//bouton détails
		
		Button buttond = new Button("Détails");
		buttond.setTranslateX(-120);
		buttond.setTranslateY(250);
		buttond.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
		buttond.setPrefSize(100, 45);
        buttond.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttond.setStyle("-fx-border-color:transparent; -fx-background-color: grey; -fx-text-fill: white;");;
            }
        });

        buttond.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttond.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");;
            }
        });
		buttond.setOnAction(e -> {
			primaryStage.setScene(sceneCompd);
		});
		
		//bouton ajouter
        
		Button buttona= new Button("Ajouter");
		buttona.setTranslateX(370);
		buttona.setTranslateY(250);
		buttona.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
		buttona.setPrefSize(100, 45);
        buttona.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttona.setStyle("-fx-border-color:transparent; -fx-background-color: grey; -fx-text-fill: white;");;
            }
        });

        buttona.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttona.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");;
            }
        });
		buttona.setOnAction(e -> {
			primaryStage.setScene(sceneCompAdd2);
		});
		
		


//___________________________________________________________________________________
//___________________________________________________________________________________
//Fenetre compétition Détails
//___________________________________________________________________________________
//___________________________________________________________________________________
		
		//bouton retour menu
		Button buttonhomed = new Button();
		buttonhomed.setGraphic(imagehome);
		buttonhomed.setTranslateX(635);
		buttonhomed.setTranslateY(0);
		buttonhomed.setShape(new Circle(1.5));
		buttonhomed.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
        buttonhomed.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonhomed.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
                buttonhomed.setGraphic(imagehomew15);
            }
        });

        buttonhomed.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonhomed.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
                buttonhomed.setGraphic(imagehome15);
            }
        });
		
		buttonhomed.setPrefSize(50, 50);
		buttonhomed.setOnAction(e -> {
			primaryStage.setScene(scene);
		});
		
		//bouton retour fenetre d'avant
		Button buttonbackd = new Button();
		buttonbackd.setGraphic(imageback);
		buttonbackd.setTranslateX(0);
		buttonbackd.setTranslateY(0);
		buttonbackd.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
        buttonbackd.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonbackd.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
                buttonbackd.setGraphic(imagebackw15);
            }
        });

        buttonbackd.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonbackd.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
                buttonbackd.setGraphic(imageback15);
            }
        });
		
		buttonbackd.setShape(new Circle(1.5));
		buttonbackd.setPrefSize(50, 50);
		buttonbackd.setOnAction(e -> {
			primaryStage.setScene(scene1);
		});
		
		
		

		
//___________________________________________________________________________________
//___________________________________________________________________________________
//Fenetre compétition Ajouter
//___________________________________________________________________________________
//___________________________________________________________________________________
		
		//bouton retour menu
				Button buttonhome15 = new Button();
				buttonhome15.setGraphic(imagehome);
				buttonhome15.setTranslateX(635);
				buttonhome15.setTranslateY(0);
				buttonhome15.setShape(new Circle(1.5));
				buttonhome15.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
		        buttonhome15.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent e) {
		                buttonhome15.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
		                buttonhome15.setGraphic(imagehomew15);
		            }
		        });

		        buttonhome15.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent e) {
		                buttonhome15.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
		                buttonhome15.setGraphic(imagehome15);
		            }
		        });
				
				buttonhome15.setPrefSize(50, 50);
				buttonhome15.setOnAction(e -> {
					primaryStage.setScene(scene);
				});
				
				//bouton retour fenetre d'avant
				Button buttonback15 = new Button();
				buttonback15.setGraphic(imageback);
				buttonback15.setTranslateX(0);
				buttonback15.setTranslateY(0);
				buttonback15.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
		        buttonback15.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent e) {
		                buttonback15.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
		                buttonback15.setGraphic(imagebackw15);
		            }
		        });

		        buttonback15.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent e) {
		                buttonback15.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
		                buttonback15.setGraphic(imageback15);
		            }
		        });
				
				buttonback15.setShape(new Circle(1.5));
				buttonback15.setPrefSize(50, 50);
				buttonback15.setOnAction(e -> {
					primaryStage.setScene(scene1);
				});
		
				//bouton détails
				
				Button buttond15 = new Button("Ajouter un Compétiteur");
				buttond15.setTranslateX(-120);
				buttond15.setTranslateY(250);
				buttond15.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
				buttond15.setPrefSize(150, 45);
		        buttond15.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent e) {
		                buttond15.setStyle("-fx-border-color:transparent; -fx-background-color: grey; -fx-text-fill: white;");;
		            }
		        });

		        buttond15.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent e) {
		                buttond15.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");;
		            }
		        });
		        buttond15.setOnAction(e -> {
					primaryStage.setScene(sceneCompetiteuradd);
				});
				
				//bouton ajouter
		        
				Button buttona15= new Button("Ajouter une Compétition");
				buttona15.setTranslateX(270);
				buttona15.setTranslateY(250);
				buttona15.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
				buttona15.setPrefSize(150, 45);
		        buttona15.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent e) {
		                buttona15.setStyle("-fx-border-color:transparent; -fx-background-color: grey; -fx-text-fill: white;");;
		            }
		        });

		        buttona15.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent e) {
		                buttona15.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");;
		            }
		        });
				buttona15.setOnAction(e -> {
					primaryStage.setScene(sceneCompAdd);
				});
				
//___________________________________________________________________________________
//___________________________________________________________________________________
//Fenetre compétition Ajouter un compétiteur
//___________________________________________________________________________________
//___________________________________________________________________________________
				
				//bouton retour menu
				Button buttonhomecompetiteur = new Button();
				buttonhomecompetiteur.setGraphic(imagehome);
				buttonhomecompetiteur.setTranslateX(711);
				buttonhomecompetiteur.setTranslateY(0);
				buttonhomecompetiteur.setShape(new Circle(1.5));
				buttonhomecompetiteur.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
		        buttonhomecompetiteur.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent e) {
		                buttonhomecompetiteur.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
		                buttonhomecompetiteur.setGraphic(imagehomewcompetiteur);
		            }
		        });

		        buttonhomecompetiteur.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent e) {
		                buttonhomecompetiteur.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
		                buttonhomecompetiteur.setGraphic(imagehomecompetiteur);
		            }
		        });
				
				buttonhomecompetiteur.setPrefSize(50, 50);
				buttonhomecompetiteur.setOnAction(e -> {
					primaryStage.setScene(scene);
				});
				
				//bouton retour fenetre d'avant
				Button buttonbackcompetiteur = new Button();
				buttonbackcompetiteur.setGraphic(imageback);
				buttonbackcompetiteur.setTranslateX(0);
				buttonbackcompetiteur.setTranslateY(0);
				buttonbackcompetiteur.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
		        buttonbackcompetiteur.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent e) {
		                buttonbackcompetiteur.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
		                buttonbackcompetiteur.setGraphic(imagebackwcompetiteur);
		            }
		        });

		        buttonbackcompetiteur.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent e) {
		                buttonbackcompetiteur.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
		                buttonbackcompetiteur.setGraphic(imagebackcompetiteur);
		            }
		        });
				
				buttonbackcompetiteur.setShape(new Circle(1.5));
				buttonbackcompetiteur.setPrefSize(50, 50);
				buttonbackcompetiteur.setOnAction(e -> {
					primaryStage.setScene(sceneCompAdd2);
				});
				
				//Formulaire d'ajout
				
				
				
				Label userName = new Label("Numéro de sportif");
				competiteur.add(userName, 0, 6);
				
				TextField Nomcompt = new TextField();
				competiteur.add(Nomcompt, 1, 6);
			     
				String competitions1="Competitions 1";
			
			    ObservableList compoto //
		        = FXCollections.observableArrayList(competitions1);
			     
			    Label competitiont = new Label("Competition:");
			    competiteur.add(competitiont, 7, 6);
			    ChoiceBox choiceBox3 = new ChoiceBox(compoto);
			    competiteur.add(choiceBox3, 8, 6);
			    
			    Button buttonvalidc = new Button("Ajouter la Compétition");
			    buttonvalidc.setPrefSize(200, 50);
			    buttonvalidc.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
		        buttonvalidc.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent e) {
		                buttonvalidc.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
		            }
		        });

		        buttonvalidc.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent e) {
		                buttonvalidc.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
		            }
		        });
			    competiteur.add(buttonvalidc, 3,17);
			    
			    

		
//___________________________________________________________________________________
//___________________________________________________________________________________
//Fenetre compétition Ajouter une compétition
//___________________________________________________________________________________
//___________________________________________________________________________________
		
		Button buttonhomeAdd = new Button();
		buttonhomeAdd.setGraphic(imagehomeadd);
		buttonhomeAdd.setTranslateX(711);
		buttonhomeAdd.setTranslateY(0);
		buttonhomeAdd.setShape(new Circle(1.5));
		buttonhomeAdd.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
        buttonhomeAdd.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonhomeAdd.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
                buttonhomeAdd.setGraphic(imagehomewadd);
            }
        });

        buttonhomeAdd.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonhomeAdd.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
                buttonhomeAdd.setGraphic(imagehomeadd);
            }
        });
		
		buttonhomeAdd.setPrefSize(50, 50);
		buttonhomeAdd.setOnAction(e -> {
			primaryStage.setScene(scene);
		});
		
		//bouton retour fenetre d'avant
		Button buttonbackAdd = new Button();
		buttonbackAdd.setGraphic(imagebackadd);
		buttonbackAdd.setTranslateX(0);
		buttonbackAdd.setTranslateY(0);
		buttonbackAdd.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
        buttonbackAdd.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonbackAdd.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
                buttonbackAdd.setGraphic(imagebackwadd);
            }
        });

        buttonbackAdd.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonbackAdd.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
                buttonbackAdd.setGraphic(imagebackadd);
            }
        });
		buttonbackAdd.setShape(new Circle(1.5));
		buttonbackAdd.setPrefSize(50, 50);
		buttonbackAdd.setOnAction(e -> {
			primaryStage.setScene(sceneCompAdd2);
		});
		
		//Formulaire d'ajout
		
		Label compName = new Label("Nom de la compétition:");
		comp2.add(compName, 0, 6);
		
		TextField Nomcomp = new TextField();
		libelle_C=Nomcomp.getText();
		comp2.add(Nomcomp, 1, 6);
		
		Label datedebut = new Label("Date de début de la compétition:");
		comp2.add(datedebut, 0, 7);
		DatePicker datePicker = new DatePicker(); 
	    datePicker.setValue(LocalDate.now()); 
	    comp2.add(datePicker, 1, 7);
	    
		Label datefin = new Label("Date de fin de la compétition:");
		comp2.add(datefin, 0, 8);
		DatePicker datePicker1 = new DatePicker(); 
	    datePicker1.setValue(LocalDate.now()); 
	    comp2.add(datePicker1, 1, 8); 
	    
	    Label compid = new Label("Numéro de la Compétition:");
		comp2.add(compid, 0, 9);
		
		TextField Idcomp = new TextField();
		libelle_C=Idcomp.getText();
		comp2.add(Idcomp, 1, 9);
	    
	    // ObservableList payso //
         //= FXCollections.observableArrayList("France", "Angleterre", "Allemagne");
	     
	     //Label pays = new Label("Pays:");
	     //comp2.add(pays, 0, 9);
	     //ChoiceBox choiceBox = new ChoiceBox(payso);
	    // comp2.add(choiceBox, 1, 9);
	    
	    Label prixw = new Label("Récompense:");
		comp2.add(prixw, 6, 7);
		TextField prixc = new TextField();
		prix=prixc.getText();
		comp2.add(prixc, 7, 7);
		
		Label ville = new Label("Ville:");
		comp2.add(ville, 6, 9);
		TextField villec = new TextField();
		lieu=villec.getText();
		comp2.add(villec, 7, 9);
		
	    ObservableList sporto //
        = FXCollections.observableArrayList(basketball, football, hockey);
	     
	    Label sport = new Label("Sport:");
	    comp2.add(sport, 6, 6);
	    ChoiceBox choiceBox2 = new ChoiceBox(sporto);
	    comp2.add(choiceBox2, 7, 6);
	    
	    
	    Label nbr = new Label("Nombre d'équipe/participant");
	    comp2.add(nbr, 6,8);
	    final Spinner<Integer> spinner2 = new Spinner<Integer>();
	    
	     final int initialValue1 = 3;

	        // Value factory.
	     SpinnerValueFactory<Integer> valueFactory1 = //
	            new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 25, initialValue1);

	     spinner2.setValueFactory(valueFactory1);
	    comp2.add(spinner2, 7,8);

	    	    
		
	    Button buttonvalid = new Button("Ajouter la Compétition");
	    buttonvalid.setPrefSize(200, 50);
	    buttonvalid.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
        buttonvalid.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonvalid.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
            }
        });

        buttonvalid.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonvalid.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
            }
        });
        
        //___________________________________________________________________________________
        //___________________________________________________________________________________
        //Pop up de validation	
        //___________________________________________________________________________________
        //___________________________________________________________________________________
        
        GridPane walid1 = new GridPane();
  		Scene valide = new Scene(walid1, 230,50);
  		Stage Validation = new Stage();
  		Validation.setTitle("Regisport");
  		Validation.getIcons().add(new Image("C:\\Users\\Julien\\eclipse-workspace\\regisport\\src\\regisport/icon.png"));
  		Validation.setScene(valide);
  		Validation.setResizable(false);
  		Label nom1 = new Label("			etes-vous sûr?");
		walid1.add(nom1, 2, 1);
  		Button conf1= new Button("Confirmer");
  		conf1.setOnAction(new EventHandler <ActionEvent>() {
	    	   @Override
	    	   public void handle(ActionEvent event) {
	    		   Validation.show();
	    		   libelle_C=Nomcomp.getText();
	    		   nb=spinner2.getValue();
	    		   lieu=villec.getText();
	    		   prix=prixc.getText();
	    		   date_F=datePicker1.getValue();
	    		   date_D=datePicker.getValue();
	    		   date_D=datePicker.getValue();
	    		   libelle_C=Nomcomp.getText();
	    		   String t=(String) choiceBox2.getValue();
	    		   //System.out.println(t);
	    		   if(t.equals(basketball)) {
	    			   id_S="3";
	    		   }
	    		   if(t.equals(football)) {
	    			   id_S="2";
	    		   }
	    		   if(t.equals(hockey)) {
	    			   id_S="1";
	    		   }
	    		   id_C=Idcomp.getText();
	    		   win=null;
	    		   
	    		   String url= "jdbc:mysql://127.0.0.1:3306/regisport";
	    			String login = "root";
	    			String passwd="";
	    			java.sql.Connection cn = null;
	    			java.sql.Statement st = null;
	    			int rs = 0;
	    			java.sql.ResultSet rs1 = null;
	    			
	    			try
	    			{
	    				//Chargement du Driver
	    				Class.forName("com.mysql.jdbc.Driver");
	    				
	    				//Connexion
	    				cn = DriverManager.getConnection(url,login,passwd);
	    				/*DriverManager.getConnection(url,login,passwd);*/
	    				
	    				//Statement
	    				st = cn.createStatement();
	    				//String sql23 ="SELECT MAX('id_C') FROM competition";
	    				//rs1=st.executeQuery(sql23);
	    				//String wk = rs1.getObject(initialValue1).toString();
	    				//int wki= Integer.parseInt(wk);
	    				//id_C=wki+1;
	    		   
	    				String sql11 = "INSERT INTO competition VALUES("+id_C+", "+id_S+", '"+libelle_C+"', '"+date_D+"', '"+date_F+"', '"+prix+"', "+win+", "+nb+", '"+lieu+"');";
	    				rs = st.executeUpdate(sql11);
	    			}
	    			catch (SQLException e)
	    			{
	    			e.printStackTrace();
	    			}
	    			catch (ClassNotFoundException e)
	    			{
	    				e.printStackTrace();
	    			}
	    			finally
	    			{
	    				try
	    				{
	    					cn.close();
	    					st.close();
	    					Validation.hide();
	    				}
	    				catch(SQLException e)
	    				{
	    					e.printStackTrace();
	    				}
	    				
	    			}
	    		}
	    	   
	        });
  		Button Annu1= new Button("Annuler");
  		Annu1.setOnAction(e -> {
			Validation.hide();
		});
        buttonvalid.setOnAction(new EventHandler <ActionEvent>() {
	    	   @Override
	    	   public void handle(ActionEvent event) {
	    		   Validation.show();
	    		}
	        });
        walid1.add(conf1,2, 2);
  		walid1.add(Annu1, 3, 2);
	    comp2.add(buttonvalid, 3,17);
	     
	     
	    //MenuItem menuItemFR = new MenuItem("France");
	    //MenuItem menuItemEN = new MenuItem("Angleterre");
	    //MenuItem menuItemAL = new MenuItem("Allemagne");
	    //MenuItem menuItemIT = new MenuItem("Itali");
	    //MenuItem menuItemES = new MenuItem("Espagne");

	    //MenuButton menuButton = new MenuButton("Pays", null,menuItemFR, menuItemEN, menuItemAL, menuItemIT, menuItemES);
		//menuButton.setTranslateX(711);
		//menuButton.setTranslateY(0);
//___________________________________________________________________________________
//___________________________________________________________________________________
//___________________________________________________________________________________
//Fenetre Équipes
//___________________________________________________________________________________
//___________________________________________________________________________________
//___________________________________________________________________________________

		
		Button button2 = new Button("Équipes");
		button2.setTranslateX(245);
		button2.setTranslateY(100);
		button2.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
        button2.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                button2.setStyle("-fx-border-color:transparent; -fx-background-color: grey; -fx-text-fill: white;");;
            }
        });

        button2.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                button2.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");;
            }
        });
		button2.setOnAction(e -> {
			primaryStage.setScene(sceneekip);
		});
        
//___________________________________________________________________________________
//___________________________________________________________________________________
//Fenetre Équipes- n°1
//___________________________________________________________________________________
//___________________________________________________________________________________
        
		
		//bouton retour menu
		Button buttonhomee = new Button();
		buttonhomee.setGraphic(imagehome);
		buttonhomee.setTranslateX(635);
		buttonhomee.setTranslateY(0);
		buttonhomee.setShape(new Circle(1.5));
		buttonhomee.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
        buttonhomee.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonhomee.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
                buttonhomee.setGraphic(imagehomewcompetiteur);
            }
        });

        buttonhomee.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonhomee.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
                buttonhomee.setGraphic(imagehomecompetiteur);
            }
        });
		
		buttonhomee.setPrefSize(50, 50);
		buttonhomee.setOnAction(e -> {
			primaryStage.setScene(scene);
		});
        
		//bouton retour fenetre d'avant
		Button buttonbacke = new Button();
		buttonbacke.setGraphic(imageback);
		buttonbacke.setTranslateX(0);
		buttonbacke.setTranslateY(0);
		buttonbacke.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
        buttonbacke.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonbacke.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
                buttonbacke.setGraphic(imagebackw);
            }
        });

        buttonbacke.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonbacke.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
                buttonbacke.setGraphic(imageback);
            }
        });
		
		buttonbacke.setShape(new Circle(1.5));
		buttonbacke.setPrefSize(50, 50);
		buttonbacke.setOnAction(e -> {
			primaryStage.setScene(scene);
		});
		
		//bouton détails
		
		Button buttonde = new Button("Détails");
		buttonde.setTranslateX(-120);
		buttonde.setTranslateY(250);
		buttonde.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
		buttonde.setPrefSize(100, 45);
        buttonde.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonde.setStyle("-fx-border-color:transparent; -fx-background-color: grey; -fx-text-fill: white;");;
            }
        });

        buttonde.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonde.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");;
            }
        });
		buttonde.setOnAction(e -> {
			primaryStage.setScene(sceneekipd);
		});
		
		//bouton ajouter
        
		Button buttonae= new Button("Ajouter");
		buttonae.setTranslateX(370);
		buttonae.setTranslateY(250);
		buttonae.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
		buttonae.setPrefSize(100, 45);
        buttonae.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonae.setStyle("-fx-border-color:transparent; -fx-background-color: grey; -fx-text-fill: white;");;
            }
        });

        buttonae.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonae.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");;
            }
        });
		buttonae.setOnAction(e -> {
			primaryStage.setScene(sceneekipadd);
		});
		
		
//___________________________________________________________________________________
//___________________________________________________________________________________
//Fenetre Équipe Détails
//___________________________________________________________________________________
//___________________________________________________________________________________
				
				//bouton retour menu
				Button buttonhomeed = new Button();
				buttonhomeed.setGraphic(imagehome);
				buttonhomeed.setTranslateX(635);
				buttonhomeed.setTranslateY(0);
				buttonhomeed.setShape(new Circle(1.5));
				buttonhomeed.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
		        buttonhomeed.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent e) {
		            	buttonhomeed.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
		                buttonhomeed.setGraphic(imagehomew15);
		            }
		        });

		        buttonhomeed.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent e) {
		            	buttonhomeed.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
		                buttonhomeed.setGraphic(imagehome15);
		            }
		        });
				
		        buttonhomeed.setPrefSize(50, 50);
				buttonhomeed.setOnAction(e -> {
					primaryStage.setScene(scene);
				});
				
				//bouton retour fenetre d'avant
				Button buttonbacked = new Button();
				buttonbacked.setGraphic(imageback);
				buttonbacked.setTranslateX(0);
				buttonbacked.setTranslateY(0);
				buttonbacked.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
		        buttonbacked.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent e) {
		                buttonbacked.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
		                buttonbacked.setGraphic(imagebackw15);
		            }
		        });

		        buttonbacked.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent e) {
		                buttonbacked.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
		                buttonbacked.setGraphic(imageback15);
		            }
		        });
				
				buttonbacked.setShape(new Circle(1.5));
				buttonbacked.setPrefSize(50, 50);
				buttonbacked.setOnAction(e -> {
					primaryStage.setScene(sceneekip);
				});
        
//___________________________________________________________________________________
//___________________________________________________________________________________
//Fenetre Équipes- Ajouté
//___________________________________________________________________________________
//___________________________________________________________________________________	
		
		//bouton retour menu
		Button buttonhomeea = new Button();
		buttonhomeea.setGraphic(imagehome);
		buttonhomeea.setTranslateX(711);
		buttonhomeea.setTranslateY(0);
		buttonhomeea.setShape(new Circle(1.5));
		buttonhomeea.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
        buttonhomeea.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonhomeea.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
                buttonhomeea.setGraphic(imagehomewcompetiteur);
            }
        });

        buttonhomeea.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonhomeea.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
                buttonhomeea.setGraphic(imagehomecompetiteur);
            }
        });
		
		buttonhomeea.setPrefSize(50, 50);
		buttonhomeea.setOnAction(e -> {
			primaryStage.setScene(scene);
		});
        
		//bouton retour fenetre d'avant
		Button buttonbackea = new Button();
		buttonbackea.setGraphic(imageback);
		buttonbackea.setTranslateX(0);
		buttonbackea.setTranslateY(0);
		buttonbackea.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
        buttonbackea.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonbackea.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
                buttonbackea.setGraphic(imagebackw);
            }
        });

        buttonbackea.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonbackea.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
                buttonbackea.setGraphic(imageback);
            }
        });
		
		buttonbackea.setShape(new Circle(1.5));
		buttonbackea.setPrefSize(50, 50);
		buttonbackea.setOnAction(e -> {
			primaryStage.setScene(sceneekip);
		});
		
		Label ekipName = new Label("Nom d'équipe:");
		ekipa.add(ekipName, 0, 6);
		
		TextField Nomekip = new TextField();
		ekipa.add(Nomekip, 1, 6);
		
		
		Label ekipville = new Label("Ville:");
		ekipa.add(ekipville, 0, 7);
		
		TextField Nomville = new TextField();
		ekipa.add(Nomville, 1, 7);
		
		Label ekipid = new Label("Numéro de l'équipe:");
		ekipa.add(ekipid, 0, 8);
		
		TextField Nomide = new TextField();
		ekipa.add(Nomide, 1, 8);
	     
	     Label ekipsport = new Label("Nom du Coach:");
	     ekipa.add(ekipsport, 6, 6);
	     TextField Coach = new TextField();
	     ekipa.add(Coach, 7, 6);
	     
		 Label nbr1 = new Label("Nombre de sportif");
		 ekipa.add(nbr1, 6,7);
		 final Spinner<Integer> spinner1 = new Spinner<Integer>();
		    
		  final int initialValue = 3;

		        // Value factory.
		  SpinnerValueFactory<Integer> valueFactory = //
		         new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 22, initialValue);

		 spinner1.setValueFactory(valueFactory);
		ekipa.add(spinner1, 7,7);
		
	    Button buttonvalide = new Button("Ajouter l'équipe");
	    buttonvalide.setPrefSize(200, 50);
	    buttonvalide.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
        buttonvalide.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonvalide.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
            }
        });

        buttonvalide.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                buttonvalide.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
            }
        });
        
      //___________________________________________________________________________________
      //___________________________________________________________________________________
      //Pop up de validation	
      //___________________________________________________________________________________
      //___________________________________________________________________________________
      		
      		GridPane walid = new GridPane();
      		Scene valid = new Scene(walid, 230,50);
      		Stage Validation1 = new Stage();
      		Validation1.setTitle("Regisport");
      		Validation1.getIcons().add(new Image("C:\\Users\\Julien\\eclipse-workspace\\regisport\\src\\regisport/icon.png"));
      		Validation1.setScene(valid);
      		Validation1.setResizable(false);
      		Label nom = new Label("			etes-vous sûr?");
    		walid.add(nom, 2, 1);
      		Button conf= new Button("Confirmer");
      		Button Annu= new Button("Annuler");
      		conf.setOnAction(new EventHandler <ActionEvent>() {
     	    	   @Override
     	    	   public void handle(ActionEvent event) {
     	    		   
     	    		   Validation1.show();
  
     	    			   id_E=Nomide.getText();
     	    			   nom_E=Nomekip.getText();
     	    			   nom_C=Coach.getText();
     	    			   ville1=Nomville.getText();	
     	    			   eff=spinner1.getValue();
     	    		   
     	    			   String url= "jdbc:mysql://127.0.0.1:3306/regisport";
     	    			   String login = "root";
     	    			   String passwd="";
     	    			   java.sql.Connection cn = null;
     	    			   java.sql.Statement st = null;
     	    			   int rs = 0;
     	    			   java.sql.ResultSet rs1 = null;
     	    			
     	    			   try
     	    			   {
     	    				   //Chargement du Driver
     	    				   Class.forName("com.mysql.jdbc.Driver");
     	    				
     	    				   //Connexion
     	    				   cn = DriverManager.getConnection(url,login,passwd);
     	    				   /*DriverManager.getConnection(url,login,passwd);*/
     	    				
     	    				   //Statement
     	    				   st = cn.createStatement();
     	    				   String sql23 ="SELECT MAX('id_E') FROM equipe";
     	    				   rs1=st.executeQuery(sql23);
     	    				   System.out.println(rs1);
     	    				
     	    		   
     	    				   String sql21 = "INSERT INTO equipe VALUES("+id_E+", '"+nom_E+"', "+eff+", '"+nom_C+"', '"+ville1+"');";
     	    					rs = st.executeUpdate(sql21);
     	    			   }
     	    			catch (SQLException e)
     	    			{
     	    			e.printStackTrace();
     	    			}
     	    			catch (ClassNotFoundException e)
     	    			{
     	    				e.printStackTrace();
     	    			}
     	    			finally
     	    			{
     	    				try
     	    				{
     	    					cn.close();
     	    					st.close();
     	    					tmp=false;
     	    				}
     	    				catch(SQLException e)
     	    				{
     	    					e.printStackTrace();
     	    				}
     	    				
     	    			}
     	    			  Validation1.hide();
     	    	   }
     	       });
      		Annu.setOnAction(e -> {
      			Validation1.hide();
      		});
      		walid.add(conf,2, 2);
      		walid.add(Annu, 3, 2);
      //___________________________________________________________________________________
      //___________________________________________________________________________________
            		
        buttonvalide.setOnAction(new EventHandler <ActionEvent>() {
	    	   @Override
	    	   public void handle(ActionEvent event) {
	    		   
	    		   Validation1.show();
	    	   }
	       });
	    ekipa.add(buttonvalide, 3,17);
		
//___________________________________________________________________________________
//___________________________________________________________________________________
//___________________________________________________________________________________
//Fenetre Adhérents:
//___________________________________________________________________________________
//___________________________________________________________________________________
//___________________________________________________________________________________
		
		
		Button button3 = new Button("Adhérents");
		button3.setTranslateX(435);
		button3.setTranslateY(100);
		button3.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
        button3.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                button3.setStyle("-fx-border-color:transparent; -fx-background-color: grey; -fx-text-fill: white;");;
            }
        });

        button3.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                button3.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");;
            }
        }); 
        button3.setOnAction(e -> {
        	primaryStage.setScene(sceneadh);
        });
		
//___________________________________________________________________________________
//___________________________________________________________________________________
//___________________________________________________________________________________
//Fenetre Adhérents - Menu1
//___________________________________________________________________________________
//___________________________________________________________________________________
//___________________________________________________________________________________
        
      //bouton retour menu
      		Button buttonhomea = new Button();
      		buttonhomea.setGraphic(imagehome);
      		buttonhomea.setTranslateX(635);
      		buttonhomea.setTranslateY(0);
      		buttonhomea.setShape(new Circle(1.5));
      		buttonhomea.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
              buttonhomea.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                  @Override
                  public void handle(MouseEvent e) {
                      buttonhomea.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
                      buttonhomea.setGraphic(imagehomewcompetiteur);
                  }
              });

              buttonhomea.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
                  @Override
                  public void handle(MouseEvent e) {
                      buttonhomea.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
                      buttonhomea.setGraphic(imagehomecompetiteur);
                  }
              });
      		
      		buttonhomea.setPrefSize(50, 50);
      		buttonhomea.setOnAction(e -> {
      			primaryStage.setScene(scene);
      		});
              
      		//bouton retour fenetre d'avant
      		Button buttonbacka = new Button();
      		buttonbacka.setGraphic(imageback);
      		buttonbacka.setTranslateX(0);
      		buttonbacka.setTranslateY(0);
      		buttonbacka.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
              buttonbacka.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                  @Override
                  public void handle(MouseEvent e) {
                      buttonbacka.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
                      buttonbacka.setGraphic(imagebackw);
                  }
              });

              buttonbacka.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
                  @Override
                  public void handle(MouseEvent e) {
                      buttonbacka.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
                      buttonbacka.setGraphic(imageback);
                  }
              });
      		
      		buttonbacka.setShape(new Circle(1.5));
      		buttonbacka.setPrefSize(50, 50);
      		buttonbacka.setOnAction(e -> {
      			primaryStage.setScene(scene);
      		});
      		
      		//bouton détails
      		
      		Button buttonda = new Button("Détails");
      		buttonda.setTranslateX(-120);
      		buttonda.setTranslateY(250);
      		buttonda.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
      		buttonda.setPrefSize(100, 45);
              buttonda.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                  @Override
                  public void handle(MouseEvent e) {
                      buttonda.setStyle("-fx-border-color:transparent; -fx-background-color: grey; -fx-text-fill: white;");;
                  }
              });

              buttonda.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
                  @Override
                  public void handle(MouseEvent e) {
                      buttonda.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");;
                  }
              });
      		buttonda.setOnAction(e -> {
      			primaryStage.setScene(sceneadhd);
      		});
      		
      		//bouton ajouter
              
      		Button buttonaa= new Button("Ajouter");
      		buttonaa.setTranslateX(370);
      		buttonaa.setTranslateY(250);
      		buttonaa.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
      		buttonaa.setPrefSize(100, 45);
              buttonaa.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                  @Override
                  public void handle(MouseEvent e) {
                      buttonae.setStyle("-fx-border-color:transparent; -fx-background-color: grey; -fx-text-fill: white;");;
                  }
              });

              buttonaa.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
                  @Override
                  public void handle(MouseEvent e) {
                      buttonae.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");;
                  }
              });
      		buttonaa.setOnAction(e -> {
      			primaryStage.setScene(sceneadhadd);
      		});
        
//___________________________________________________________________________________
//___________________________________________________________________________________
//Fenetre Adherent Détails
//___________________________________________________________________________________
//___________________________________________________________________________________
      					
      					//bouton retour menu
      					Button buttonhomaad = new Button();
      					buttonhomaad.setGraphic(imagehome);
      					buttonhomaad.setTranslateX(635);
      					buttonhomaad.setTranslateY(0);
      					buttonhomaad.setShape(new Circle(1.5));
      					buttonhomaad.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
      			        buttonhomaad.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
      			            @Override
      			            public void handle(MouseEvent e) {
      			            	buttonhomaad.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
      			                buttonhomaad.setGraphic(imagehomew15);
      			            }
      			        });

      			        buttonhomaad.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
      			            @Override
      			            public void handle(MouseEvent e) {
      			            	buttonhomaad.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
      			                buttonhomaad.setGraphic(imagehome15);
      			            }
      			        });
      					
      			        buttonhomaad.setPrefSize(50, 50);
      					buttonhomaad.setOnAction(e -> {
      						primaryStage.setScene(scene);
      					});
      					
      					//bouton retour fenetre d'avant
      					Button buttonbackad = new Button();
      					buttonbackad.setGraphic(imageback);
      					buttonbackad.setTranslateX(0);
      					buttonbackad.setTranslateY(0);
      					buttonbackad.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
      			        buttonbackad.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
      			            @Override
      			            public void handle(MouseEvent e) {
      			                buttonbackad.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
      			                buttonbackad.setGraphic(imagebackw15);
      			            }
      			        });

      			        buttonbackad.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
      			            @Override
      			            public void handle(MouseEvent e) {
      			                buttonbackad.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
      			                buttonbackad.setGraphic(imageback15);
      			            }
      			        });
      					
      					buttonbackad.setShape(new Circle(1.5));
      					buttonbackad.setPrefSize(50, 50);
      					buttonbackad.setOnAction(e -> {
      						primaryStage.setScene(sceneadh);
      					});      		
      		
//___________________________________________________________________________________
//___________________________________________________________________________________
//___________________________________________________________________________________
//Fenetre Adhérents - Ajouter
//___________________________________________________________________________________
//___________________________________________________________________________________
//___________________________________________________________________________________
        
            //bouton retour menu
      		Button buttonhomeaa = new Button();
      		buttonhomeaa.setGraphic(imagehome);
      		buttonhomeaa.setTranslateX(711);
      		buttonhomeaa.setTranslateY(0);
      		buttonhomeaa.setShape(new Circle(1.5));
      		buttonhomeaa.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
              buttonhomeaa.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                  @Override
                  public void handle(MouseEvent e) {
                      buttonhomeaa.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
                      buttonhomeaa.setGraphic(imagehomewcompetiteur);
                  }
              });

              buttonhomeaa.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
                  @Override
                  public void handle(MouseEvent e) {
                      buttonhomeaa.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
                      buttonhomeaa.setGraphic(imagehomecompetiteur);
                  }
              });
      		
      		buttonhomeaa.setPrefSize(50, 50);
      		buttonhomeaa.setOnAction(e -> {
      			primaryStage.setScene(scene);
      		});
              
      		//bouton retour fenetre d'avant
      		Button buttonbackaa = new Button();
      		buttonbackaa.setGraphic(imageback);
      		buttonbackaa.setTranslateX(0);
      		buttonbackaa.setTranslateY(0);
      		buttonbackaa.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
              buttonbackaa.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                  @Override
                  public void handle(MouseEvent e) {
                      buttonbackaa.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
                      buttonbackaa.setGraphic(imagebackw);
                  }
              });

              buttonbackaa.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
                  @Override
                  public void handle(MouseEvent e) {
                      buttonbackaa.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
                      buttonbackaa.setGraphic(imageback);
                  }
              });
      		
      		buttonbackaa.setShape(new Circle(1.5));
      		buttonbackaa.setPrefSize(50, 50);
      		buttonbackaa.setOnAction(e -> {
      			primaryStage.setScene(sceneadh);
      		});
      		
      		
    		Label adhName = new Label("Nom:");
    		adhadd.add(adhName, 0, 6);
    		
    		TextField adhkip = new TextField();
    		adhadd.add(adhkip, 1, 6);
    		
    		Label adhpName = new Label("Prénom:");
    		adhadd.add(adhpName, 0, 7);
    		
    		TextField adhpkip = new TextField();
    		adhadd.add(adhpkip, 1, 7);
    		
    		Label adhville = new Label("Numéro de l'équipe:");
    		adhadd.add(adhville, 0, 8);
    		
    		TextField Nomadhville = new TextField();
    		adhadd.add(Nomadhville, 1, 8);
    		
    		Label adhage = new Label("Âge:");
    		adhadd.add(adhage, 4, 6);
    		
    		TextField adhkipa = new TextField();
    		adhadd.add(adhkipa, 5, 6);
    		
    		Label datenais = new Label("Date de Naissance:");
    		adhadd.add(datenais, 4, 7);
    		DatePicker datePickeradh = new DatePicker(); 
    	    datePickeradh.setValue(LocalDate.now()); 
    	    adhadd.add(datePickeradh, 5, 7);
    	    
    	    Label adhnum = new Label("Numéro d'Adhérent:");
    		adhadd.add(adhnum, 4, 8);
    		
    		TextField adhknum = new TextField();
    		adhadd.add(adhknum, 5, 8);
     
    	    Button buttonvalideadh = new Button("Ajouter l'adhérent");
    	    buttonvalideadh.setPrefSize(200, 50);
    	    buttonvalideadh.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
            buttonvalideadh.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    buttonvalideadh.setStyle("-fx-border-color: transparent; -fx-background-color: grey;");
                }
            });

            buttonvalideadh.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    buttonvalideadh.setStyle("-fx-border-color: transparent; -fx-background-color: #D6D6D6;");
                }
            });
            
            
            //___________________________________________________________________________________
            //___________________________________________________________________________________
            //Pop up de validation	
            //___________________________________________________________________________________
            //___________________________________________________________________________________
            

            GridPane walid2 = new GridPane();
      		Scene valide2 = new Scene(walid2, 230,50);
      		Stage Validation2 = new Stage();
      		Validation2.setTitle("Regisport");
      		Validation2.getIcons().add(new Image("C:\\Users\\Julien\\eclipse-workspace\\regisport\\src\\regisport/icon.png"));
      		Validation2.setScene(valide2);
      		Validation2.setResizable(false);
      		Label nom2 = new Label("			etes-vous sûr?");
    		walid2.add(nom2, 2, 1);
      		Button conf2= new Button("Confirmer");
      		conf2.setOnAction(new EventHandler <ActionEvent>() {
    	    	   @Override
    	    	   public void handle(ActionEvent event) {
    	    		   Validation2.show();
    	    		   String url= "jdbc:mysql://127.0.0.1:3306/regisport";
    	    			String login = "root";
    	    			String passwd="";
    	    			java.sql.Connection cn = null;
    	    			java.sql.Statement st = null;
    	    			int rs = 0;
    	    			java.sql.ResultSet rs1 = null;
    	    			
    	    			try
    	    			{
    	    				//Chargement du Driver
    	    				Class.forName("com.mysql.jdbc.Driver");
    	    				
    	    				//Connexion
    	    				cn = DriverManager.getConnection(url,login,passwd);
    	    				/*DriverManager.getConnection(url,login,passwd);*/
    	    				
    	    				//Statement
    	    				st = cn.createStatement();
    	    				String ID_P = adhknum.getText();
    	    				String nom_P = adhpkip.getText();
    	    				String prenom = adhkip.getText();
    	    				String age = adhkipa.getText();
    	    				LocalDate date_N = datePickeradh.getValue();
    	    				if (Nomadhville.getText().trim().isEmpty()) {
    	    					Object ID_Es=null;
    	    					String sql28 = "INSERT INTO personne VALUES("+ID_P+", '"+ID_Es+"', '"+nom_P+"', '"+prenom+"', '"+age+"' ,'"+date_N+"');";
    	    					rs = st.executeUpdate(sql28);
    	    				}
    	    				else {
    	    					ID_E = Nomadhville.getText();
    	    					String sql28 = "INSERT INTO personne VALUES("+ID_P+", '"+ID_E+"', '"+nom_P+"', '"+prenom+"', '"+age+"' ,'"+date_N+"');";
    	    					rs = st.executeUpdate(sql28);
    	    				}

    	    			}
    	    			catch (SQLException e)
    	    			{
    	    			e.printStackTrace();
    	    			}
    	    			catch (ClassNotFoundException e)
    	    			{
    	    				e.printStackTrace();
    	    			}
    	    			finally
    	    			{
    	    				try
    	    				{
    	    					cn.close();
    	    					st.close();

    	    				}
    	    				catch(SQLException e)
    	    				{
    	    					e.printStackTrace();
    	    				}
    	    				
    	    			}
    	    			Validation2.hide();
    	    		}
    	    	   
    	        });
      		Button Annu2= new Button("Annuler");
      		Annu2.setOnAction(e -> {
    			Validation2.hide();
    		});
            walid2.add(conf2, 2, 2);
      		walid2.add(Annu2, 3, 2);
    	    adhadd.add(buttonvalideadh, 3,17);
            buttonvalideadh.setOnAction(e -> {
      			Validation2.show();
      		});
        
//___________________________________________________________________________________
//___________________________________________________________________________________
//___________________________________________________________________________________ 				
//___________________________________________________________________________________
//___________________________________________________________________________________
//___________________________________________________________________________________
      				
		
        root.getChildren().addAll(button1,button2,button3);
        comp1.getChildren().addAll(buttonback, buttonhome, buttond, buttona);
        comp15.getChildren().addAll(buttonback15, buttonhome15, buttond15, buttona15);
        comp2.getChildren().addAll(buttonbackAdd, buttonhomeAdd);
        compd.getChildren().addAll(buttonbackd, buttonhomed);
        competiteur.getChildren().addAll(buttonbackcompetiteur, buttonhomecompetiteur);
        ekip.getChildren().addAll(buttonbacke,buttonhomee,buttonde,buttonae);
        ekipd.getChildren().addAll(buttonbacked,buttonhomeed);
        ekipa.getChildren().addAll(buttonbackea, buttonhomeea);
        adha.getChildren().addAll(buttonbacka, buttonhomea, buttonaa, buttonda);
        adhadt.getChildren().addAll( buttonhomaad,  buttonbackad);
        adhadd.getChildren().addAll(buttonbackaa,buttonhomeaa);
        
		primaryStage.hide();
		primaryStage.centerOnScreen();


//___________________________________________________________________________________
//___________________________________________________________________________________
//___________________________________________________________________________________
//Ecran de chargement
//___________________________________________________________________________________
//___________________________________________________________________________________
//___________________________________________________________________________________
				
		
		
		Image image = new Image(new FileInputStream("C:\\Users\\Julien\\eclipse-workspace\\regisport\\src\\regisport/Logo Blanco.gif"));
		ImageView imageview = new ImageView(image);
	    imageview.setFitWidth(800);  
	    imageview.setFitHeight(600); 
	    imageview.setPreserveRatio(true); 
		Group charge = new Group(imageview);
		Scene img = new Scene(charge,800,600);
		
		if (image != null) {
            double w = 0;
            double h = 0;

            double ratioX = imageview.getFitWidth() / image.getWidth();
            double ratioY = imageview.getFitHeight() / image.getHeight();

            double reducCoeff = 0;
            if(ratioX >= ratioY) {
                reducCoeff = ratioY;
            } else {
                reducCoeff = ratioX;
            }

            w = image.getWidth() * reducCoeff;
            h = image.getHeight() * reducCoeff;

            imageview.setX((imageview.getFitWidth() - w) / 2);
            imageview.setY((imageview.getFitHeight() - h) / 2);

        }
		
		Stage chargement = new Stage();
		chargement.setTitle("Regisport");
		chargement.getIcons().add(new Image("C:\\Users\\Julien\\eclipse-workspace\\regisport\\src\\regisport/icon.png"));
		chargement.setScene(img);
		chargement.setResizable(false);
		chargement.show();
		chargement.centerOnScreen();
		
		new Thread(() ->{
				try {
					Thread.sleep(3000);
					Platform.runLater(()->chargement.hide());
					Platform.runLater(()->primaryStage.show());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
	}
	
	
    public static void main(String[] args) {
        Application.launch(args);
        
        // Requête SQL:
        
     // Préparation et Accès à la base de données
	
    }
}