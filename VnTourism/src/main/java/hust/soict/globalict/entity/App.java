package hust.soict.globalict.entity;

import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.entity.tourism.natural_attraction.body_of_water.Bay;
import hust.soict.globalict.entity.tourism.natural_attraction.body_of_water.Beach;
import hust.soict.globalict.entity.tourism.natural_attraction.body_of_water.BodyOfWater;
import hust.soict.globalict.entity.tourism.natural_attraction.body_of_water.Lake;
import hust.soict.globalict.entity.tourism.natural_attraction.body_of_water.River;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("--------------------------------"); 	
		List<BodyOfWater> bodyofwater = new ArrayList<>();
		bodyofwater.add(new Lake());
		bodyofwater.add(new River());
		bodyofwater.add(new Bay());
		bodyofwater.add(new Beach());
		new BodyOfWater().collectDataFromChildClass(new BodyOfWater(), bodyofwater);
		
	}
}
