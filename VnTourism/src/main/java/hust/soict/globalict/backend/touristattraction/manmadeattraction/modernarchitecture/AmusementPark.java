package hust.soict.globalict.backend.touristattraction.manmadeattraction.modernarchitecture;

import hust.soict.globalict.backend.rdfconstant.ObjectToCollect;
import hust.soict.globalict.backend.rdfconstant.Prefix;

public class AmusementPark extends ModernArchitecture {

    private String area;
    private String coasters;

    public AmusementPark() {
        super();

        this.area = "?place dbp:area ?area.";
        this.coasters = "?place dbp:coasters ?coasters.";

    }

    public String getArea() {
        return this.area;
    }

    public String getCoasters() {
        return this.coasters;
    }

    @Override
    public String createSparqlQuery() {
        this.createRawTtlFile(ObjectToCollect.OBJECT_AMUSEMENTPARK);
        return Prefix.PREFIX + "CONSTRUCT{\r\n"
                + "?place dbo:wikiPageWikiLink " + ObjectToCollect.OBJECT_AMUSEMENTPARK + "\r\n"
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
                + "?place dbo:wikiPageWikiLink " + ObjectToCollect.OBJECT_AMUSEMENTPARK + "\r\n"
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
