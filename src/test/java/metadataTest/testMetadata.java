package metadataTest;


import org.junit.Test;
import suggestion.metadata.MetadataSuggestions;
import suggestion.metadata.MetadataSuggestor;

import static org.junit.Assert.assertNotNull;


public class testMetadata {
    @Test
    public void test1()
    {
        MetadataSuggestor m = new MetadataSuggestor();
        MetadataSuggestions s=m.getMetadataSuggestions("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n" +
                "PREFIX onto: <http://dbpedia.org/ontology/>\n" +
                "SELECT DISTINCT ?uri\n" +
                "WHERE{?film rdf:type onto:TelevisionShow .\n" +
                "?film rdfs:label 'Charmed'@en .\n" +
                "?film onto:starring ?actors .\n" +
                "?actors foaf:homepage ?uri .\n" +
                "}", "http://dbpedia.org/sparql",true);
        assertNotNull(s);
    }
    @Test
    public void test2()
    {
        MetadataSuggestor m = new MetadataSuggestor();
        MetadataSuggestions s=m.getMetadataSuggestions("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n" +
                "PREFIX dbo: <http://dbpedia.org/ontology/>\n" +
                "PREFIX dbr: <http://dbpedia.org/resource/>\n" +
                "select distinct ?dt where {\n"+
                "dbr:Barack_Obama dbo:birthDate  ?dt\n"+
                "} LIMIT 100", "http://dbpedia.org/sparql",true);
        assertNotNull(s);
    }
}
