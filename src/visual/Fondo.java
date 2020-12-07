package visual;

import java.awt.Graphics;


import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondo extends JPanel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ImageIcon imagen;
	ImageIcon imagen2;
	String nombre;
	JPanel panel;
	String url1;
	String url2;
	
	public Fondo (String url1, String url2) {
		
	this.url1 = url1;
	this.url2 = url2;
	
	}
	@Override
	public void paint(Graphics g) {
	      
	    	imagen = new ImageIcon(url1);
	    	imagen2 = new ImageIcon(url2);
							
	    	g.drawImage(imagen.getImage(),0,0, 1400,750,null );
	    	g.drawImage(imagen2.getImage(),1150,50, 150,150,null );

	    	setOpaque(false);

	    	super.paint(g);
	    	
	    }
	    
}
