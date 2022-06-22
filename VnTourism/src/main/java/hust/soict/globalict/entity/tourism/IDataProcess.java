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
	public default String createFileName() {
		return this.getClass().getSimpleName()+".ttl";
	};
	public default String createRawFileName() {
		return "rawRDF_"+this.createFileName();
	};
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
		try {
			FileWriter out = new FileWriter(this.createRawFileName());
			results.write(out, "TURTLE");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// TODO Auto-generated method stub
		
	}
	public default void collectDataToTtlFile() {
		// TODO Auto-generated method stub
		Model inModel= RDFDataMgr.loadModel(this.createRawFileName());
		try(QueryExecution qExe =QueryExecution.create(this.createSparqlQuery(), inModel)){
			Model results = qExe.execConstruct();
			try {
				FileWriter out = new FileWriter(this.createFileName());
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
