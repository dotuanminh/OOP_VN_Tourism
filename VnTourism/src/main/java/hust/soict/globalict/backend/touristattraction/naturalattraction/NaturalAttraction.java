package hust.soict.globalict.backend.touristattraction.naturalattraction;

import hust.soict.globalict.backend.rdfconstant.ObjectToCollect;
import hust.soict.globalict.backend.rdfconstant.Prefix;
import hust.soict.globalict.backend.touristattraction.TouristAttraction;

public class NaturalAttraction extends TouristAttraction{

	public NaturalAttraction() {
		super();
	}
	@Override
	public String createSparqlQuery() {
		this.createRawTtlFile(ObjectToCollect.OBJECT_NATURAL_ATTRACTION);
		String unionQuery="";
		int size= ObjectToCollect.OBJECT_NATURAL_ATTRACTION.length;
		for (int i=0;i<size;++i) {
			if(i==0)unionQuery= unionQuery+ "{?place dbo:wikiPageWikiLink "+ObjectToCollect.OBJECT_NATURAL_ATTRACTION[i]+"}\r\n";
			else unionQuery= unionQuery+ "UNION \r\n"
					+ "{?place dbo:wikiPageWikiLink "+ObjectToCollect.OBJECT_NATURAL_ATTRACTION[i]+"}\r\n";
		}
		return Prefix.PREFIX + "CONSTRUCT{\r\n"
				+ this.getName()+"\r\n"
				+ this.getComment()+"\r\n"
				+ this.getGeoPoint()+"\r\n"
				+ this.getGeoLat()+"\r\n"
				+ this.getGeoLong()+"\r\n"
				+ this.getLocation()+"\r\n"
				+ this.getCountry()+"\r\n"
				+ "} WHERE{\r\n"
				+unionQuery
				+ "OPTIONAL {"+ this.getName()+"}\r\n"
				+ "OPTIONAL {"+ this.getComment()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoPoint()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLat()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLong()+"}\r\n"
				+ "OPTIONAL {"+ this.getLocation()+"}\r\n"
				+ "OPTIONAL {"+ this.getCountry()+"}\r\n"
				+ "FILTER ( LANG ( ?comment ) = 'en' )\r\n"
				+ "}";
	}
}
