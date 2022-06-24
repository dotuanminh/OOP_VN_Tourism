package hust.soict.globalict.entity.tourism.natural_attraction;
import hust.soict.globalict.entity.rdf.ObjectToCollect;
import hust.soict.globalict.entity.rdf.Prefix;

public class Zoo extends NaturalAttraction {

    public Zoo() {
		super();
	}

    @Override
    public String createSparqlQuery() {
		this.createRawTtlFile(ObjectToCollect.OBJECT_ZOO);
		return Prefix.PREFIX + "CONSTRUCT{\r\n"
				+ "?place dbo:wikiPageWikiLink "+ ObjectToCollect.OBJECT_ZOO + "\r\n"
				+ this.getName()+"\r\n"
				+ this.getComment()+"\r\n"
				+ this.getGeoPoint()+"\r\n"
				+ this.getGeoLat()+"\r\n"
				+ this.getGeoLong()+"\r\n"
				+ this.getLocation()+"\r\n"
				+ this.getCountry()+"\r\n"
				+ "} WHERE{\r\n"
				+ "?place dbo:wikiPageWikiLink "+ ObjectToCollect.OBJECT_ZOO + "\r\n"
				+ "OPTIONAL {"+ this.getName()+"}\r\n"
				+ "OPTIONAL {"+ this.getComment()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoPoint()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLat()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLong()+"}\r\n"
				+ "OPTIONAL {"+ this.getLocation()+"}\r\n"
				+ "OPTIONAL {"+ this.getCountry()+"}\r\n"
				+ "FILTER ( LANG ( ?comment ) = 'en' ).\r\n"
				+ "}";
	}
}
