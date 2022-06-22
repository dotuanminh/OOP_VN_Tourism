package hust.soict.globalict.entity.tourism.natural_attraction.body_of_water;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.riot.RDFDataMgr;

import hust.soict.globalict.entity.rdf.Prefix;

public class River extends BodyOfWater {
	public final static String OBJECT_RIVER="dbc:Rivers_of_Vietnam.";
	private static String sourceLocation;
	private static String mouthLocation;
	private static String mouthElevation;
	private static String dischargeLocation;
	private static String tributariesLeft;
	private static String tributariesRight;

	public River() {
		super();
		// TODO Auto-generated constructor stub
		this.sourceLocation = "?place dbp:source1Location  ?sourceLocation.";
		this.mouthLocation = "?place dbo:mouthPlace ?mouthLocation.";
		this.mouthElevation = "?place dbo:mouthElevation ?mouthElevation.";
		this.dischargeLocation = "?place dbp:discharge1Location ?dischargeLocation.";
		this.tributariesLeft = "?place dbp:tributariesLeft ?tributariesLeft.";
		this.tributariesRight = "?place dbp:tributariesRight ?tributariesRight.";
		this.createRawTtlFile(OBJECT_RIVER);
	}

	public static String getSourceLocation() {
		return sourceLocation;
	}

	public static String getMouthLocation() {
		return mouthLocation;
	}

	public static String getMouthElevation() {
		return mouthElevation;
	}

	public static String getDischargeLocation() {
		return dischargeLocation;
	}

	public static String getTributariesLeft() {
		return tributariesLeft;
	}

	public static String getTributariesRight() {
		return tributariesRight;
	}
	
	@Override
	public String createSparqlQuery() {
		return Prefix.PREFIX + "CONSTRUCT{\r\n"
				+ "?place dbo:wikiPageWikiLink "+ OBJECT_RIVER + "\r\n"
				+ this.getName()+"\r\n"
				+ this.getComment()+"\r\n"
				+ this.getGeoPoint()+"\r\n"
				+ this.getGeoLat()+"\r\n"
				+ this.getGeoLong()+"\r\n"
				+ this.getLocation()+"\r\n"
				+ this.getCountry()+"\r\n"
				+ this.getLength()+"\r\n"
				+ this.getSourceLocation()+"\r\n"
				+ this.getMouthLocation()+"\r\n"
				+ this.getMouthElevation()+"\r\n"
				+ this.getDischargeLocation()+"\r\n"
				+ this.getTributariesLeft()+"\r\n"
				+ this.getTributariesRight()+"\r\n"
				+ "} WHERE{\r\n"
				+ "?place dbo:wikiPageWikiLink "+ OBJECT_RIVER + "\r\n"
				+ "OPTIONAL {"+ this.getName()+"}\r\n"
				+ "OPTIONAL {"+ this.getComment()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoPoint()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLat()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLong()+"}\r\n"
				+ "OPTIONAL {"+ this.getLocation()+"}\r\n"
				+ "OPTIONAL {"+ this.getCountry()+"}\r\n"
				+ "OPTIONAL {"+ this.getLength()+"}\r\n"
				+ "OPTIONAL {"+ this.getSourceLocation()+"}\r\n"
				+ "OPTIONAL {"+ this.getMouthLocation()+"}\r\n"
				+ "OPTIONAL {"+ this.getMouthElevation()+"}\r\n"
				+ "OPTIONAL {"+ this.getDischargeLocation()+"}\r\n"
				+ "OPTIONAL {"+ this.getTributariesLeft()+"}\r\n"
				+ "OPTIONAL {"+ this.getTributariesRight()+"}\r\n"
				+ "FILTER ( LANG ( ?comment ) = 'en' ).\r\n"
				+ "}";
	}
}
