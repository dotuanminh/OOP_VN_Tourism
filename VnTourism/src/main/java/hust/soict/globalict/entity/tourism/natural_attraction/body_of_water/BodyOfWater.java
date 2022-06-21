package hust.soict.globalict.entity.tourism.natural_attraction.body_of_water;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.rdf.model.Model;

import hust.soict.globalict.entity.rdf.Prefix;
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

	@Override
	public String createFileName() {
		return "Bodies_of_water";
	}

}
