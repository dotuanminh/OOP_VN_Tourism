package hust.soict.globalict.entity.tourism.man_made_attraction;

import hust.soict.globalict.entity.rdf.Prefix;

public class Temple extends ManmadeAttraction{

    public final String OBJECT_TEMPLE = "dbc:Buddhist_temples_in_Hanoi.";

    private String religiousAffiliation;
    private String deity;
    private String architecture;

    public Temple() {
        this.religiousAffiliation = "?place dbp:religiousAffiliation ?religiousAffiliation.";
        this.deity = "?place dbp:deity ?deity.";
        this.architecture = "?place dbp:architecture ?architecture.";

		this.createRawTtlFile(OBJECT_TEMPLE);
    }

    public String getReligiousAffiliation() {
        return this.religiousAffiliation;
    }

    public String getDeity() {
        return this.deity;
    }

    public String getArchitecture() {
        return this.architecture;
    }

    @Override
	public String createSparqlQuery() {
		return Prefix.PREFIX + "CONSTRUCT{\r\n"
				+ "?place dbo:wikiPageWikiLink " + OBJECT_TEMPLE + "\r\n"
				+ this.getName() + "\r\n"
				+ this.getComment() + "\r\n"
				+ this.getGeoPoint() + "\r\n"
				+ this.getGeoLat() + "\r\n"
				+ this.getGeoLong() + "\r\n"
				+ this.getLocation() + "\r\n"
				+ this.getCountry() + "\r\n"
				+ this.getReligiousAffiliation() + "\r\n"
				+ this.getDeity() + "\r\n"
				+ this.getArchitecture() + "\r\n"
				+ "} WHERE{\r\n"
				+ "?place dbo:wikiPageWikiLink " + OBJECT_TEMPLE + "\r\n"
				+ "OPTIONAL {" + this.getName() + "}\r\n"
				+ "OPTIONAL {" + this.getComment() + "}\r\n"
				+ "OPTIONAL {" + this.getGeoPoint() + "}\r\n"
				+ "OPTIONAL {" + this.getGeoLat() + "}\r\n"
				+ "OPTIONAL {" + this.getGeoLong() + "}\r\n"
				+ "OPTIONAL {" + this.getLocation() + "}\r\n"
				+ "OPTIONAL {" + this.getCountry() + "}\r\n"
				+ "OPTIONAL {" + this.getReligiousAffiliation() + "}\r\n"
				+ "OPTIONAL {" + this.getDeity() + "}\r\n"
				+ "OPTIONAL {" + this.getArchitecture() + "}\r\n"
				+ "FILTER ( LANG ( ?comment ) = 'en' ).\r\n"
				+ "}";
	}
//	dbp:religiousAffiliation
//	dbp:deity
//	dbp:architecture
//	
//	xem trong 
//	https://dbpedia.org/page/Perfume_Pagoda
}
