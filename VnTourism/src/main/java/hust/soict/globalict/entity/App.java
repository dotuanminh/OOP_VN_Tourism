package hust.soict.globalict.entity;

import hust.soict.globalict.entity.tourism.natural_attraction.NationalPark;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("--------------------------------");
		NationalPark l1 = new NationalPark();
		l1.collectDataToTtlFile();
	}
}
