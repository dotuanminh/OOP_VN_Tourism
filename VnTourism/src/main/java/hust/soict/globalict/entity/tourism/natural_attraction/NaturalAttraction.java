package hust.soict.globalict.entity.tourism.natural_attraction;

import hust.soict.globalict.entity.rdf.Prefix;
import hust.soict.globalict.entity.tourism.TouristAttraction;

public class NaturalAttraction extends TouristAttraction{

	public NaturalAttraction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String createFileName() {
		return "Natural_Attraction";
	}

}
