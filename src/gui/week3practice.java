package gui;

//import java.util.ArrayList;
//import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.*;

public class week3practice extends PApplet {
	
	private UnfoldingMap map;
	public void setup(){
	
		size(950,600,OPENGL);
		map=new UnfoldingMap(this,200,50,700,500,new Google.GoogleMapProvider());
		map.zoomToLevel(2);
		MapUtils.createDefaultEventDispatcher(this, map);
		Location loc=new Location(-38.14f,-73.03f);
		PointFeature valfe = new PointFeature(loc);
		valfe.addProperty("title", "Valdivia, Chile");
		valfe.addProperty("magnitude", "9.5");
		valfe.addProperty("date", "May 22, 1960");
		valfe.addProperty("year", "1960");
		//valfe.addProperty("title", "Valdivia, Chile");
	/*	List<PointFeature> bigEqs=new ArrayList<PointFeature>();
		
		bigEqs.add(valfe);
		
		
		List<Marker> markers=new ArrayList<Marker>();
		for(PointFeature eq: bigEqs)
		{
			markers.add(new SimplePointMarker(eq.getLocation(),eq.getProperties()));
		}
		map.addMarkers(markers);
		*/
		Marker val=new SimplePointMarker(loc,valfe.getProperties());
		
		map.addMarker(val);
	}
	public void draw(){
		background(10);
		map.draw();
		//addKey();
	}
}
