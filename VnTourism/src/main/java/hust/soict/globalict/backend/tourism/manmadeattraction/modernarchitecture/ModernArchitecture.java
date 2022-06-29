package hust.soict.globalict.backend.tourism.manmadeattraction.modernarchitecture;

import hust.soict.globalict.backend.rdfconstant.ObjectToCollect;
import hust.soict.globalict.backend.rdfconstant.Prefix;
import hust.soict.globalict.backend.tourism.manmadeattraction.ManmadeAttraction;

public class ModernArchitecture extends ManmadeAttraction {

	private String openingDate;
	private String owner;

	public ModernArchitecture() {
		super();

		this.openingDate = "?place dbp:openingDate ?openingDate.";
		this.owner = "?place dbp:owner ?owner.";
	}

	public String getOpeningDate() {
		return this.openingDate;
	}

	public String getOwner() {
		return this.owner;
	}
	@Override
	public String createSparqlQuery() {
		this.createRawTtlFile(ObjectToCollect.OBJECT_MODERN_ARCHITECTURE);
		String unionQuery="";
		int size= ObjectToCollect.OBJECT_MODERN_ARCHITECTURE.length;
		for (int i=0;i<size;++i) {
			if(i==0)unionQuery= unionQuery+ "{?place dbo:wikiPageWikiLink "+ObjectToCollect.OBJECT_MODERN_ARCHITECTURE[i]+"}\r\n";
			else unionQuery= unionQuery+ "UNION \r\n"
					+ "{?place dbo:wikiPageWikiLink "+ObjectToCollect.OBJECT_MODERN_ARCHITECTURE[i]+"}\r\n";
		}
		return Prefix.PREFIX + "CONSTRUCT{\r\n"
				+ this.getName() + "\r\n"
		        + this.getComment() + "\r\n"
		        + this.getGeoPoint() + "\r\n"
		        + this.getGeoLat() + "\r\n"
		        + this.getGeoLong() + "\r\n"
		        + this.getLocation() + "\r\n"
		        + this.getCountry() + "\r\n"
		        + this.getOpeningDate() + "\r\n"
		        + this.getOwner() + "\r\n"
				+ "} WHERE{\r\n"
				+unionQuery
				+ "OPTIONAL {" + this.getName() + "}\r\n"
                + "OPTIONAL {" + this.getComment() + "}\r\n"
                + "OPTIONAL {" + this.getGeoPoint() + "}\r\n"
                + "OPTIONAL {" + this.getGeoLat() + "}\r\n"
                + "OPTIONAL {" + this.getGeoLong() + "}\r\n"
                + "OPTIONAL {" + this.getLocation() + "}\r\n"
                + "OPTIONAL {" + this.getCountry() + "}\r\n"
                + "OPTIONAL {" + this.getOpeningDate() + "}\r\n"
                + "OPTIONAL {" + this.getOwner() + "}\r\n"
                + "FILTER ( LANG ( ?comment ) = 'en' ).\r\n"
				+ "}";
	}
}
