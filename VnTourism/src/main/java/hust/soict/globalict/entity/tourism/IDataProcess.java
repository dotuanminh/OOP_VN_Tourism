package hust.soict.globalict.entity.tourism;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.riot.RDFDataMgr;

import hust.soict.globalict.entity.rdf.Prefix;

public interface IDataProcess {
	public String createSparqlQuery() ;
	public String createFileName();
	public default void createRawTtlFile(String object) {
		String s1=Prefix.PREFIX + "CONSTRUCT {\r\n"
				+ "    ?s ?p ?o\r\n"
				+ "}\r\n"
				+ "WHERE {\r\n"
				+ "    ?s dbo:wikiPageWikiLink "+object+"\r\n"
				+ "    ?s ?p ?o.\r\n"
				+ "}";
		org.apache.jena.query.Query query = QueryFactory.create(s1);
		QueryExecution qExe =QueryExecution.service("http://dbpedia.org/sparql").query(query).timeout(20000).build();
		Model results = qExe.execConstruct();
		String fullFileName = "rawRDF_"+this.createFileName()+".ttl";
		try {
			FileWriter out = new FileWriter(fullFileName);
			results.write(out, "TURTLE");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// TODO Auto-generated method stub
		
	}
	public default void printTurtleFormat(String sparqlQuery, String fileName) {
		// TODO Auto-generated method stub
		Model inModel= RDFDataMgr.loadModel("rawRDF_"+fileName+".ttl");
		try(QueryExecution qExe =QueryExecution.create(this.createSparqlQuery(), inModel)){
			Model results = qExe.execConstruct();
			String fullFileName = fileName+".ttl";
			try {
				FileWriter out = new FileWriter(fullFileName);
				results.write(out, "TURTLE");
				results.write(System.out, "TURTLE");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// TODO Auto-generated catch block
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
				
	}
}
