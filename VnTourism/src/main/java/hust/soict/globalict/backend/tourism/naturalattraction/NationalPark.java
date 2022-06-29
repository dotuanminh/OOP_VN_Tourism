package hust.soict.globalict.backend.tourism.naturalattraction;

import hust.soict.globalict.backend.rdfconstant.ObjectToCollect;
import hust.soict.globalict.backend.rdfconstant.Prefix;

public class NationalPark extends NaturalAttraction {

    private String areaTotal;
    private String nearestCity;
    private String established;
    private String governingBody;

    public NationalPark() {
        super();
        this.areaTotal = "?place dbo:areaTotal ?areaTotal.";
        this.nearestCity = "?place dbo:nearestCity ?nearestCity.";
        this.established = "?place dbo:established ?established.";
        this.governingBody = "?place dbo:governingBody ?governingBody.";
    }

    public String getAreaTotal() {
        return this.areaTotal;
    } 
    
    public String getNearestCity() {
        return this.nearestCity;
    }

    public String getEstablished() {
        return this.established;
    }

    public String getGoverningBody() {
        return this.governingBody;
    }

    @Override
    public String createSparqlQuery() {
        this.createRawTtlFile(ObjectToCollect.OBJECT_NATIONALPARK);
        return Prefix.PREFIX + "CONSTRUCT{\r\n"
                + "?place dbo:wikiPageWikiLink " + ObjectToCollect.OBJECT_NATIONALPARK + "\r\n"
                + this.getName() + "\r\n"
                + this.getComment() + "\r\n"
                + this.getGeoPoint() + "\r\n"
                + this.getGeoLat() + "\r\n"
                + this.getGeoLong() + "\r\n"
                + this.getLocation() + "\r\n"
                + this.getCountry() + "\r\n"
                + this.getAreaTotal() + "\r\n"
                + this.getNearestCity() + "\r\n"
                + this.getEstablished() + "\r\n"
                + this.getGoverningBody() + "\r\n"
                + "} WHERE{\r\n"
                + "?place dbo:wikiPageWikiLink " + ObjectToCollect.OBJECT_NATIONALPARK + "\r\n"
                + "OPTIONAL {" + this.getName() + "}\r\n"
                + "OPTIONAL {" + this.getComment() + "}\r\n"
                + "OPTIONAL {" + this.getGeoPoint() + "}\r\n"
                + "OPTIONAL {" + this.getGeoLat() + "}\r\n"
                + "OPTIONAL {" + this.getGeoLong() + "}\r\n"
                + "OPTIONAL {" + this.getLocation() + "}\r\n"
                + "OPTIONAL {" + this.getCountry() + "}\r\n"
                + "OPTIONAL {" + this.getAreaTotal() + "}\r\n"
                + "OPTIONAL {" + this.getNearestCity() + "}\r\n"
                + "OPTIONAL {" + this.getEstablished() + "}\r\n"
                + "OPTIONAL {" + this.getGoverningBody() + "}\r\n"
                + "FILTER ( LANG ( ?comment ) = 'en' ).\r\n"
                + "}";
    }
}
