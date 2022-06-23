package hust.soict.globalict.entity.tourism;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.riot.RDFDataMgr;

import hust.soict.globalict.entity.rdf.Prefix;

public interface IDataProcess {
	public String createSparqlQuery();

	public default String createFileName() {
		return this.getClass().getSimpleName() + ".ttl";
	};

	public default String createRawFileName() {
		return "rawRDF_" + this.createFileName();
	};

	public default void createRawTtlFile(String object) {
		String s1 = Prefix.PREFIX + "CONSTRUCT {\r\n" + "    ?s ?p ?o\r\n" + "}\r\n" + "WHERE {\r\n"
				+ "    ?s dbo:wikiPageWikiLink " + object + "\r\n" + "    ?s ?p ?o.\r\n" + "}";
		org.apache.jena.query.Query query = QueryFactory.create(s1);
		QueryExecution qExe = QueryExecution.service("http://dbpedia.org/sparql").query(query).timeout(20000).build();
		Model results = qExe.execConstruct();
		try {
			FileWriter out = new FileWriter(this.createRawFileName());
			results.write(out, "TURTLE");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public default void collectDataToTtlFile() {
		Model inModel = RDFDataMgr.loadModel(this.createRawFileName());
		try (QueryExecution qExe = QueryExecution.create(this.createSparqlQuery(), inModel)) {
			Model results = qExe.execConstruct();
			try {
				FileWriter out = new FileWriter(this.createFileName());
				results.write(out, "TURTLE");
				results.write(System.out, "TURTLE");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public default <T> void collectDataFromChildClass(T parent, List<T> child) {
		try {
			FileWriter out = new FileWriter(((IDataProcess) parent).createFileName());
			for (int i=0;i<child.size();++i) {
				((IDataProcess) child.get(i)).collectDataToTtlFile();
				Model inModel= RDFDataMgr.loadModel(((IDataProcess) child.get(i)).createFileName());
				try(QueryExecution qExe =QueryExecution.create(((IDataProcess) child.get(i)).createSparqlQuery(), inModel)){
					Model results = qExe.execConstruct();
					results.write(out, "TURTLE");;
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
	
