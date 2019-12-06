package com.asu.ser531.sparqlQueries;

import android.util.Log;

import com.asu.ser531.utilities.AppUtility;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.Syntax;

import java.util.ArrayList;
import java.util.List;

public class AppQuery {

    private static String subtopicEndPoint  ="http:/3.135.209.188:3030/newTriple1/query";

    //SELECT ?"+subTopicName+"\n" +
    public static List<String> getAllSubtopics(String subTopicName, int limit, int offset){

        String subtoicquery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "			 PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "			 PREFIX prefix1: <http://www.semanticweb.org/sarvanshprasher/ontologies/2019/10/untitled-ontology-23>\n" +
                "			 PREFIX tr1: <http://127.0.0.1:3333/>\n" +
                "			 SELECT ?subtopic\n" +
                "			 WHERE{\n" +
                "			   <http://127.0.0.1:3333/"+subTopicName+"> <http://www.semanticweb.org/sarvanshprasher/ontologies/2019/10/untitled-ontology-23#contains> ?subtopic\n" +
                "			 }";

        Log.d("Final", "getAllSubtopics: "+subtoicquery);

        Query query = QueryFactory.create(subtoicquery, Syntax.syntaxARQ);
        query.setLimit(limit);
        query.setOffset(offset);

        QueryExecution qe = QueryExecutionFactory.sparqlService(subtopicEndPoint, query);

        ResultSet resultSet = resultSet = qe.execSelect();


        StringBuffer results = new StringBuffer();

        List<String> columnNames = resultSet.getResultVars();

        List<String> subtopiclist = new ArrayList<>();


        // Iterate through all resulting rows
        while (resultSet.hasNext()) {
            // Get the next result row
            QuerySolution solution = resultSet.next();


            // Iterate through the columns
            for (String var : columnNames) {


                // Add the column label to the StringBuffer




//                results.append(var + ": ");
//
//                // Add the returned row/column data to the StringBuffer
//
//                // Data value will be null if optional and not present
                String subtopicName = null;


                if (solution.get(var) == null) {

                    subtopicName = "{null}";

                    // Test whether the returned value is a literal value
                } else if (solution.get(var).isLiteral()) {

                    subtopicName = solution.getLiteral(var).toString();


                    // Otherwise the returned value is a URI
                } else {

                    subtopicName = solution.getResource(var).getURI();

                }


                subtopicName = AppUtility.getCleanSubtoipc(subtopicName);

                subtopiclist.add(subtopicName);
//                results.append('\n');
            }

        }

        // Important - free up resources used running the query
        qe.close();

        // Return the results as a String
        return subtopiclist;

    }




}
