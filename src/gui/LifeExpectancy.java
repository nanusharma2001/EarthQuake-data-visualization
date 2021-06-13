package gui;

import java.util.*;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class LifeExpectancy extends PApplet {
	UnfoldingMap map;
	Map<String,Float> lifeExpByCountry;
	List<Feature> countries;
	List<Marker> countryMarkers;
	private Map <String,Float> loadCsv(String fileName)
	{
		Map <String,Float> lifeExpMap=new HashMap<String,Float>();
		String[] rows=loadStrings(fileName);
		for(String row:rows)
		{
			String[] columns=row.split(",");
			try
			{
				float value=Float.parseFloat(columns[5]);
				lifeExpMap.put(columns[4], value);
			}
			catch(Exception e)
			{
				//do nothing
			}
		}
		
		
		return lifeExpMap;
	}
	private void shadeCountries()
	{
		for(Marker marker:countryMarkers)
		{
			String countryID=marker.getId();
			if(lifeExpByCountry.containsKey(countryID))
			{
				float lifeExp=lifeExpByCountry.get(countryID);
				int colorLevel=(int)map(lifeExp,40,90,10,255);
				marker.setColor(color(255-colorLevel,100,colorLevel));
			}
			else
			{
				marker.setColor(color(150,150,150));
			}
		}
	}
	public void setup()
	{
		size(800,600,OPENGL);
		lifeExpByCountry=loadCsv("LifeExpectancyWorldBank.csv");
		countries=GeoJSONReader.loadData(this, "countries.geo.json");
		
		map=new UnfoldingMap(this,50,50,700,500,new Google.GoogleMapProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
		countryMarkers=MapUtils.createSimpleMarkers(countries);
		map.addMarkers(countryMarkers);		
		shadeCountries();
		
	}
	public void draw()
	{
		map.draw();
	}

}
