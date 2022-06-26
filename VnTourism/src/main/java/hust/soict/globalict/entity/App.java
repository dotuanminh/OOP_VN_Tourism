package hust.soict.globalict.entity;

import hust.soict.globalict.entity.tourism.natural_attraction.body_of_water.BodyOfWater;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("--------------------------------"); 	
		(new BodyOfWater()).collectDataToTtlFile();
//		(new ModernArchitecture()).collectDataToTtlFile();
//		(new NaturalAttraction()).collectDataToTtlFile();
//		(new ManmadeAttraction()).collectDataToTtlFile();
//		(new TouristAttraction()).collectDataToTtlFile();
		
	}
}
