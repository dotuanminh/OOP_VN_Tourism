package hust.soict.globalict.entity.tourism.man_made_attraction.modern_architecture;

import hust.soict.globalict.entity.rdf.Prefix;

public class AmusementPark extends ModernArchitecture {

    public final String OBJECT_AMUSEMENTPARK = "dbc:Amusement_parks_in_Vietnam.";

    private String area;
    private String coasters;

    public AmusementPark() {
        super();

        this.area = "?place dbp:area ?area.";
        this.coasters = "?place dbp:coasters ?coasters.";

        this.createRawTtlFile(OBJECT_AMUSEMENTPARK);
    }

    public String getArea() {
        return this.area;
    }

    public String getCoasters() {
        return this.coasters;
    }

    @Override
    public String createSparqlQuery() {
        return Prefix.PREFIX + "CONSTRUCT{\r\n"
                + "?place dbo:wikiPageWikiLink " + OBJECT_AMUSEMENTPARK + "\r\n"
                + this.getName() + "\r\n"
                + this.getComment() + "\r\n"
                + this.getGeoPoint() + "\r\n"
                + this.getGeoLat() + "\r\n"
                + this.getGeoLong() + "\r\n"
                + this.getLocation() + "\r\n"
                + this.getCountry() + "\r\n"
                + this.getArea() + "\r\n"
                + this.getCoasters() + "\r\n"
                + this.getOpeningDate() + "\r\n"
                + this.getOwner() + "\r\n"
                + "} WHERE{\r\n"
                + "?place dbo:wikiPageWikiLink " + OBJECT_AMUSEMENTPARK + "\r\n"
                + "OPTIONAL {" + this.getName() + "}\r\n"
                + "OPTIONAL {" + this.getComment() + "}\r\n"
                + "OPTIONAL {" + this.getGeoPoint() + "}\r\n"
                + "OPTIONAL {" + this.getGeoLat() + "}\r\n"
                + "OPTIONAL {" + this.getGeoLong() + "}\r\n"
                + "OPTIONAL {" + this.getLocation() + "}\r\n"
                + "OPTIONAL {" + this.getCountry() + "}\r\n"
                + "OPTIONAL {" + this.getArea() + "}\r\n"
                + "OPTIONAL {" + this.getCoasters() + "}\r\n"
                + "OPTIONAL {" + this.getOpeningDate() + "}\r\n"
                + "OPTIONAL {" + this.getOwner() + "}\r\n"
                + "FILTER ( LANG ( ?comment ) = 'en' ).\r\n"
                + "}";
    }
}
