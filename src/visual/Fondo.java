package visual;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondo extends JPanel  {

	ImageIcon imagen;
	String nombre;
	JPanel panel;
	
	public Fondo () {
		
	
	}
	@Override
	public void paint(Graphics g) {
	      
		  	
					
	    	imagen = new ImageIcon("Fondos/fondo7.jpg");
							
	   
	    	
	    	g.drawImage(imagen.getImage(),0,0, 1400,750,null );
	   
	    	
	    	super.paint(g);

	    	setOpaque(false);
	    	
	    	
	    	
	    }
	    
}
