package application;



import java.awt.event.MouseEvent;
import java.util.Random;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.TriangleMesh;


public class SampleController {
	
	@FXML
	private Button btn;
	
	
	private Circle c;
	
	private Polygon p;
	private int cont;
	
	public void initialize() {
		cont = 2;
		c = new Circle(40);
		p = new Polygon();
		p.getPoints().addAll(new Double[]{ 
			    150.0, 25.0,  
			    225.0, 75.0,  
			    150.0, 125.0, 
			    75.0, 75.0   
			});
		c.setFill(Color.LIGHTGREEN);
		p.setFill(Color.LIGHTGREEN);
		btn.setGraphic(c);
		btn.setStyle("-fx-background-color: transparent;");
		
		
		//btn.setTextFill(Color.BLACK);
		//btn.setTextAlignment(TextAlignment.LEFT);
		//btn.setText("PRUEBA");
		efecto();
	}
	
	
	
	@FXML
	public void pulsar() {
		
		Random r = new Random();
		int r1 = r.nextInt(255);

		int r2 = r.nextInt(255);

		int r3 = r.nextInt(255);
		
		
		btn.setGraphic(null);
		
		
	    
	    if(cont % 2 == 0) {
	    	//System.out.println("ENTRA");
	    	btn.setGraphic(p);
	    	p.setFill(Color.rgb(r1,r2,r3));
	    	
	    	
	    }else {
	    	btn.setGraphic(c);
	    	c.setFill(Color.rgb(r1,r2,r3));
	    }	
		
		double g = r.nextDouble();
		Glow glow = new Glow();
		glow.setLevel(g);
		
		btn.setEffect(glow);
		
		DropShadow ds = new DropShadow(); 
		ds.setOffsetY(r.nextDouble() * 10 - 5);
		ds.setOffsetX(r.nextDouble() * 10 - 5);
	    ds.setColor(Color.BLACK);
	        
	    btn.setEffect(ds);
	    
		System.out.println(cont);
		cont++;
	}
	
	
	public void efecto() {
		//System.out.println("ENTRA EN efecto()");
		Reflection ref = new Reflection();
		ref.setBottomOpacity(0.0); 
	      
		ref.setTopOpacity(0.7); 
	      
		ref.setTopOffset(0.2);
	      
		ref.setFraction(0.9); 
		
		//btn.setEffect(ref);
		
		btn.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> btn.setEffect(ref));
		btn.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_EXITED, e -> btn.setEffect(null));
	}
	public void BotonSetVisible() {
		if(btn.isVisible()) {
			btn.setVisible(false);
		}else {
			btn.setVisible(true);
		}
	}
	
	public void CambiarColorBoton(Color col) {
		p.setFill(col);
		c.setFill(col);
	}
	
}
