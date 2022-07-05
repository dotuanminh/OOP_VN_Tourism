 package hust.soict.globalict.backend.dataprocess;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.riot.RDFDataMgr;

import hust.soict.globalict.backend.rdfconstant.Prefix;

public interface IDataProcess {
	public String createSparqlQuery();

	public default String createFileName() {
		return this.getClass().getSimpleName() + ".ttl";
	};

	public default String createRawFileName() {
		return "rawRDF_" + this.createFileName();
	};

	public default void createRawTtlFile(String...object) {
		try {
			FileWriter out = new FileWriter(this.createRawFileName());
			for (String i:object) {
				String s1 = Prefix.PREFIX + "CONSTRUCT {\r\n" + "    ?s ?p ?o\r\n" + "}\r\n" + "WHERE {\r\n"
						+ "    ?s dbo:wikiPageWikiLink " + i + "\r\n" + "    ?s ?p ?o.\r\n" + "}";
				org.apache.jena.query.Query query = QueryFactory.create(s1);
				QueryExecution qExe = QueryExecution.service("http://dbpedia.org/sparql").query(query).timeout(50000).build();
				Model results = qExe.execConstruct();
				results.write(out, "TURTLE");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public default void collectDataToTtlFile() {
		String inputQuery=this.createSparqlQuery();
		Model inModel = RDFDataMgr.loadModel(this.createRawFileName());
		try (QueryExecution qExe = QueryExecution.create(inputQuery, inModel)) {
			Model results = qExe.execConstruct();
			try {
				FileWriter out = new FileWriter(this.createFileName());
				results.write(out, "TURTLE");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public default void collectDataToTtlFile(OutputStream stream){
		String inputQuery=this.createSparqlQuery();
		Model inModel = RDFDataMgr.loadModel(this.createRawFileName());
		try (QueryExecution qExe = QueryExecution.create(inputQuery, inModel)) {
			Model results = qExe.execConstruct();
			try {
				FileWriter out = new FileWriter(this.createFileName());
				results.write(out, "TURTLE");
				results.write(stream, "TURTLE");
			} catch (IOException e) {
				e.printStackTrace(new PrintStream(stream));
			}

		} catch (Exception e) {
			e.printStackTrace(new PrintStream(stream));
		}
	}
	
//	public default String returnCollectedDataAsAString() {
//		String outputString=null;
//		// Creating a path choosing file from local
//        // directory by creating an object of Path class
//        Path fileName
//            = Path.of(this.createFileName());
// 
//        // Now calling Files.readString() method to
//        // read the file
//        try {
//        	outputString = Files.readString(fileName);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			outputString=e.getMessage();
//		}
//        if(outputString.equals(null)) System.out.println("There is something wrong.....Try Again");
//        return outputString;
//	}
}
	
