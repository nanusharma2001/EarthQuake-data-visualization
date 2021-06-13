package gui;

import processing.core.PApplet;

public class MyClass extends PApplet {
	
	public void setup()
	{
		size(500,500);
		background(0,0,0);
	}
	
	public void draw()
	{
		fill(255,255,0);
		ellipse(width/2,height/2,490,490);
		fill(0,0,0);
		ellipse(width/4,height/4,50,90);
		ellipse(3*width/4,height/4,50,90);
		arc(width/2,3*height/4,120,90,0,PI);
		fill(255,0,0);
		ellipse(width/2,height/2,100,100);
	}

}
