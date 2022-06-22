package hust.soict.globalict.entity;

import hust.soict.globalict.entity.tourism.natural_attraction.body_of_water.Lake;
import hust.soict.globalict.entity.tourism.natural_attraction.body_of_water.River;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("--------------------------------");
		Lake l1 = new Lake();
		l1.collectDataToTtlFile();


		River r1 = new River();
		r1.collectDataToTtlFile();
			
//
//		Bay b1 = new Bay();
//		b1.collectDataToTtlFile();
//
//		Beach b2 = new Beach();
//		b2.collectDataToTtlFile();
//		
//		Island i1 = new Island();
//		i1.collectDataToTtlFile();
//		
//		Cave c1 = new Cave();
//		c1.collectDataToTtlFile();
//
//		Mountain m1 = new Mountain();
//		m1.collectDataToTtlFile();

//		BotanicalGarden zoo= new BotanicalGarden();
//		zoo.collectDataToTtlFile();
		
	}
}
