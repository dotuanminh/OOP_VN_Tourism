package hust.soict.globalict.entity.tourism;

public class TouristAttraction implements IDataProcess{
	private String name;
	private String comment;
	private String geoPoint;
	private String geoLat;
	private String geoLong;
	private String location;
	private String country;

	public TouristAttraction() {
		this.name = "?place dbp:name ?name.";
		this.comment = "?place rdfs:comment ?comment.";
		this.geoPoint = "?place georss:point ?geoPoint.";
		this.geoLat = "?place geo:lat ?geoLat.";
		this.geoLong = "?place geo:long ?geoLong.";
		this.location = "?place dbo:location ?location.";
		this.country = "?place dbo:country ?country.";
	}

	public String getName() {
		return this.name;
	}

	public String getComment() {
		return this.comment;
	}

	public String getGeoPoint() {
		return this.geoPoint;
	}

	public String getGeoLat() {
		return this.geoLat;
	}

	public String getGeoLong() {
		return this.geoLong;
	}

	public String getLocation() {
		return this.location;
	}

	public String getCountry() {
		return this.country;
	}

	@Override
	public String createSparqlQuery() {
		return null;
	}

}
