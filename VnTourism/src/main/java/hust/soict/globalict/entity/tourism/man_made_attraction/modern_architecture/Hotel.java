package hust.soict.globalict.entity.tourism.man_made_attraction.modern_architecture;

import hust.soict.globalict.entity.rdf.Prefix;

public class Hotel extends ModernArchitecture {

    public final String OBJECT_HOTEL = "dbc:Hotels_in_Vietnam.";
    private String numberOfRestaurants;
    private String numberOfRooms;
    private String architect;

    public Hotel() {
        super();

        this.numberOfRestaurants = "?place dbo:numberOfRestaurants ?numberOfRestaurants.";
        this.numberOfRooms = "?place dbo:numberOfRooms ?numberOfRooms.";
        this.architect = "?place dbo:architect ?architect.";
        this.createRawTtlFile(OBJECT_HOTEL);

    }

    public String getNumberOfRestaurants() {
        return this.numberOfRestaurants;
    }

    public String getNumberOfRooms() {
        return this.numberOfRooms;
    }

    public String getArchitect() {
        return this.architect;
    }

    @Override
    public String createSparqlQuery() {
        return Prefix.PREFIX + "CONSTRUCT{\r\n"
                + "?place dbo:wikiPageWikiLink " + OBJECT_HOTEL + "\r\n"
                + this.getName() + "\r\n"
                + this.getComment() + "\r\n"
                + this.getGeoPoint() + "\r\n"
                + this.getGeoLat() + "\r\n"
                + this.getGeoLong() + "\r\n"
                + this.getLocation() + "\r\n"
                + this.getCountry() + "\r\n"
                + this.getNumberOfRestaurants() + "\r\n"
                + this.getNumberOfRooms() + "\r\n"
                + this.getArchitect() + "\r\n"
                + this.getOpeningDate() + "\r\n"
                + this.getOwner() + "\r\n"
                + "} WHERE{\r\n"
                + "?place dbo:wikiPageWikiLink " + OBJECT_HOTEL + "\r\n"
                + "OPTIONAL {" + this.getName() + "}\r\n"
                + "OPTIONAL {" + this.getComment() + "}\r\n"
                + "OPTIONAL {" + this.getGeoPoint() + "}\r\n"
                + "OPTIONAL {" + this.getGeoLat() + "}\r\n"
                + "OPTIONAL {" + this.getGeoLong() + "}\r\n"
                + "OPTIONAL {" + this.getLocation() + "}\r\n"
                + "OPTIONAL {" + this.getCountry() + "}\r\n"
                + "OPTIONAL {" + this.getNumberOfRestaurants() + "}\r\n"
                + "OPTIONAL {" + this.getNumberOfRooms() + "}\r\n"
                + "OPTIONAL {" + this.getArchitect() + "}\r\n"
                + "OPTIONAL {" + this.getOpeningDate() + "}\r\n"
                + "OPTIONAL {" + this.getOwner() + "}\r\n"
                + "FILTER ( LANG ( ?comment ) = 'en' ).\r\n"
                + "}";
    }
}
