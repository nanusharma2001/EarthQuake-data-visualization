package gui;

import processing.core.*;

public class sunchanging extends PApplet {

	PImage webImage;
	public void setup()
	{
		size(500,280);
		background(255);
		stroke(0);
		String url="http://cseweb.ucsd.edu/~minnes/palmTrees.jpg";
		webImage = loadImage(url, "png");
		webImage.resize(500,0);
	}
	
	public void draw()
	{
		background(0);
		//webImage.resize(width,0);
		image(webImage, 0, 0);
		int[] color=doi(second());
		fill(color[0],color[1],color[2]);
		ellipse(width/4,height/5,40,40);
	}
	public int[] doi(int sec)
	{
		float diff,ratio;
		
		int[] color=new int[3];
		
		diff=Math.abs(sec-30);
		ratio=diff/30;
		color[0]=(int)(255*ratio);
		color[1]=(int)(255*ratio);
		color[2]=0;
		return color;
	}
}
