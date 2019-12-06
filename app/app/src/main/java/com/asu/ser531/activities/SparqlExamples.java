package com.asu.ser531.activities;


import android.util.Log;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.Syntax;

import org.openjena.atlas.json.JsonArray;

import java.util.List;


public class SparqlExamples {

    public String queryRemoteSparqlEndpoint() {
        /**
         * Use the SPARQL engine and report the results
         *
         * @return The number of resulting rows
         */





        // Set the query
//        String queryString = "SELECT ?dataType ?data "
//                + "WHERE {"
//                + "<http://nasa.dataincubator.org/launch/1961-012> "
//                + "?dataType ?data."
//                + "}";

        // Set the SPARQL endpoint URI
//        String sparqlEndpointUri = "http://api.talis.com/stores/space/services/sparql";

        String liteEnd  ="http:/3.135.209.188:3030/newTriple1/query";


        String ultraLite = "SELECT *"
                + " WHERE {"
                + " ?sub ?pred ?obj } "
                + " LIMIT 25 ";



        String liteQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "			 PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "			 PREFIX prefix1: <http://www.semanticweb.org/sarvanshprasher/ontologies/2019/10/untitled-ontology-23>\n" +
                "			 PREFIX tr1: <http://127.0.0.1:3333/>\n" +
                "			 SELECT ?subtopic\n" +
                "			 WHERE{\n" +
                "			   <http://127.0.0.1:3333/General+aspects> <http://www.semanticweb.org/sarvanshprasher/ontologies/2019/10/untitled-ontology-23#contains> ?subtopic\n" +
                "			 }";




        // Create a Query instance
        Query query = QueryFactory.create(liteQuery, Syntax.syntaxARQ);

        // Limit the number of results returned
        // Setting the limit is optional - default is unlimited
        query.setLimit(50);

        // Set the starting record for results returned
        // Setting the limit is optional - default is 1 (and it is 1-based)
        query.setOffset(1);

        // Query uses an external SPARQL endpoint for processing
        // This is the syntax for that type of query

        Log.d("QERET", "queryRemoteSparqlEndpoint: Chal Raha hai");

        QueryExecution qe = QueryExecutionFactory.sparqlService(liteEnd, query);

        String url = qe.toString();


        Log.d("QERET", "queryRemoteSparqlEndpoint: "+qe.toString());

        // Execute the query and obtain results



        ResultSet resultSet = resultSet = qe.execSelect();




//        Log.d("QERET1", "Result: "+resultSet.toString());


        // Setup a place to house results for output
        StringBuffer results = new StringBuffer();

        Log.d("QERET2", "Result2: "+results);

        // Get the column names (the aliases supplied in the SELECT clause)
        List<String> columnNames = resultSet.getResultVars();

        Log.d("QERET3", "Result2: "+columnNames.toString());

        // Iterate through all resulting rows
        while (resultSet.hasNext()) {
            // Get the next result row
            QuerySolution solution = resultSet.next();


            // Iterate through the columns
            for (String var : columnNames) {
                // Add the column label to the StringBuffer




                results.append(var + ": ");

                // Add the returned row/column data to the StringBuffer

                // Data value will be null if optional and not present
                if (solution.get(var) == null) {
                    results.append("{null}");
                    // Test whether the returned value is a literal value
                } else if (solution.get(var).isLiteral()) {
                    results.append(solution.getLiteral(var).toString());
                    // Otherwise the returned value is a URI
                } else {
                    results.append(solution.getResource(var).getURI());
                }
                results.append('\n');
            }
            results.append("-----------------\n");
        }

        // Important - free up resources used running the query
        qe.close();

        // Return the results as a String
        return results.toString();

    }

}
