package hust.soict.globalict.entity.tourism.natural_attraction.body_of_water;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.rdf.model.Model;

import hust.soict.globalict.entity.rdf.Prefix;

public class Lake extends BodyOfWater {
	public final static String OBJECT_LAKE="dbc:Lakes_of_Vietnam.";
	private static String lakeType;

	public Lake() {
		super();
		this.lakeType = "?place dbo:type ?lakeType.";
		this.createRawTtlFile(OBJECT_LAKE);
	}

	public static String getLakeType() {
		return lakeType;
	}

	@Override
	public String createSparqlQuery() {
		return Prefix.PREFIX + "CONSTRUCT{\r\n"
				+ "?place dbo:wikiPageWikiLink "+OBJECT_LAKE+"\r\n"
				+ this.getName()+"\r\n"
				+ this.getComment()+"\r\n"
				+ this.getGeoPoint()+"\r\n"
				+ this.getGeoLat()+"\r\n"
				+ this.getGeoLong()+"\r\n"
				+ this.getLocation()+"\r\n"
				+ this.getCountry()+"\r\n"
				+ this.getLength()+"\r\n"
				+ this.getLakeType()+"\r\n"
				+ "} WHERE{\r\n"
				+ "?place dbo:wikiPageWikiLink "+OBJECT_LAKE+"\r\n"
				+ "OPTIONAL {"+ this.getName()+"}\r\n"
				+ "OPTIONAL {"+ this.getComment()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoPoint()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLat()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLong()+"}\r\n"
				+ "OPTIONAL {"+ this.getLocation()+"}\r\n"
				+ "OPTIONAL {"+ this.getCountry()+"}\r\n"
				+ "OPTIONAL {"+ this.getLength()+"}\r\n"
				+ "OPTIONAL {"+ this.getLakeType()+"}\r\n"
				+ "FILTER ( LANG ( ?comment ) = 'en' )\r\n"
				+ "}";
	}

	@Override
	public String createFileName() {
		return "Lake";
	}

}
