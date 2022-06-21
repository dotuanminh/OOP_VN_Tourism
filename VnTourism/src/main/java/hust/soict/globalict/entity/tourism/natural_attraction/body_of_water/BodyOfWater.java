package hust.soict.globalict.entity.tourism.natural_attraction.body_of_water;

import hust.soict.globalict.entity.tourism.natural_attraction.NaturalAttraction;

public class BodyOfWater extends NaturalAttraction {
	private static String length;

	public BodyOfWater() {
		super();
		// TODO Auto-generated constructor stub
		this.length = "?place dbo:length ?length.";
	}

	public static String getLength() {
		return length;
	}

}
