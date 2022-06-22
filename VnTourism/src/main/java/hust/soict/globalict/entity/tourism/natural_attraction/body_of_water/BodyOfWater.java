package hust.soict.globalict.entity.tourism.natural_attraction.body_of_water;

import hust.soict.globalict.entity.tourism.natural_attraction.NaturalAttraction;

public class BodyOfWater extends NaturalAttraction {
	private String length;

	public BodyOfWater() {
		super();
		this.length = "?place dbo:length ?length.";
	}

	public String getLength() {
		return this.length;
	}
	
}
