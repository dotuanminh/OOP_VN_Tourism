package hust.soict.globalict.entity.tourism.natural_attraction;

import hust.soict.globalict.entity.rdf.ObjectToCollect;
import hust.soict.globalict.entity.rdf.Prefix;

public class Island extends NaturalAttraction{
	private String area;
	private String population;
	private String populationDensity;
	public Island() {
		super();
		this.area="?place dbo:areaTotal ?area.";
		this.population="?place dbp:population ?population.";
		this.populationDensity="?place dbp:densityKm ?populationDensity.";
	}
	public String getArea() {
		return area;
	}
	public String getPopulation() {
		return population;
	}
	public String getPopulationDensity() {
		return populationDensity;
	}
	@Override
	public String createSparqlQuery() {
		this.createRawTtlFile(ObjectToCollect.OBJECT_ISLAND);
		return Prefix.PREFIX + "CONSTRUCT{\r\n"
				+ "?place dbo:wikiPageWikiLink "+ ObjectToCollect.OBJECT_ISLAND + "\r\n"
				+ this.getName()+"\r\n"
				+ this.getComment()+"\r\n"
				+ this.getGeoPoint()+"\r\n"
				+ this.getGeoLat()+"\r\n"
				+ this.getGeoLong()+"\r\n"
				+ this.getLocation()+"\r\n"
				+ this.getCountry()+"\r\n"
				+ this.getArea()+"\r\n"
				+ this.getPopulation()+"\r\n"
				+ this.getPopulationDensity()+"\r\n"
				+ "} WHERE{\r\n"
				+ "?place dbo:wikiPageWikiLink "+ ObjectToCollect.OBJECT_ISLAND + "\r\n"
				+ "OPTIONAL {"+ this.getName()+"}\r\n"
				+ "OPTIONAL {"+ this.getComment()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoPoint()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLat()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLong()+"}\r\n"
				+ "OPTIONAL {"+ this.getLocation()+"}\r\n"
				+ "OPTIONAL {"+ this.getCountry()+"}\r\n"
				+ "OPTIONAL {"+ this.getArea()+"}\r\n"
				+ "OPTIONAL {"+ this.getPopulation()+"}\r\n"
				+ "OPTIONAL {"+ this.getPopulationDensity()+"}\r\n"
				+ "FILTER ( LANG ( ?comment ) = 'en' ).\r\n"
				+ "}";
	}

}
