package hust.soict.globalict.entity.tourism;

public class TouristAttraction implements IDataProcess {
	private static String name;
	private static String comment;
	private static String geoPoint;
	private static String geoLat;
	private static String geoLong;
	private static String location;
	private static String country;

	public TouristAttraction() {
		// TODO Auto-generated constructor stub
		this.name = "?place dbp:name ?name.";
		this.comment = "?place rdfs:comment ?comment.";
		this.geoPoint = "?place georss:point ?geoPoint.";
		this.geoLat = "?place geo:lat ?geoLat.";
		this.geoLong = "?place geo:long ?geoLong.";
		this.location = "?place dbo:location ?location.";
		this.country = "?place dbo:country ?country.";
	}

	public static String getName() {
		return name;
	}

	public static String getComment() {
		return comment;
	}

	public static String getGeoPoint() {
		return geoPoint;
	}

	public static String getGeoLat() {
		return geoLat;
	}

	public static String getGeoLong() {
		return geoLong;
	}

	public static String getLocation() {
		return location;
	}

	public static String getCountry() {
		return country;
	}

	@Override
	public String createSparqlQuery() {
		// TODO Auto-generated method stub
		return null;
	}

}
