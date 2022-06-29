 package hust.soict.globalict.backend.dataprocess;

import java.io.FileWriter;
import java.io.IOException;

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
		System.out.println("Collecting data.......");
		System.out.println("---------------------------------------------------------------------------");
		String inputQuery=this.createSparqlQuery();
		Model inModel = RDFDataMgr.loadModel(this.createRawFileName());
		try (QueryExecution qExe = QueryExecution.create(inputQuery, inModel)) {
			Model results = qExe.execConstruct();
			try {
				FileWriter out = new FileWriter(this.createFileName());
				results.write(out, "TURTLE");
				results.write(System.out, "TURTLE");
				System.out.println("---------------------------------------------------------------------------");
				System.out.println("Collecting data successfully...");
				System.out.println("This file has been saved to "+this.createFileName()+" in the project");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
	