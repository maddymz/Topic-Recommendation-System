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
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.sparql.core.DatasetImpl;

import java.util.ArrayList;
import java.util.List;

public class AppQuery {

    private static String subtopicEndPoint  ="http:/3.135.209.188:3030/newTriple1/query";



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

                } else {

                    subtopicName = solution.getResource(var).getURI();

                }


                subtopicName = AppUtility.getCleanSubtoipc(subtopicName);

                subtopiclist.add(subtopicName);
            }

        }

        qe.close();


        return subtopiclist;

    }

    public static void getSubTopicDetail(String subtopicName){


        String fedquery =" PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX tr1: <http://127.0.0.1:3333/>\n" +
                "PREFIX prefix1: <http://www.semanticweb.org/sarvanshprasher/ontologies/2019/10/untitled-ontology-23>\n" +
                "select ?description ?video ?researchLink ?prereq where {\n" +
                "  SERVICE <http://3.135.209.188:3030/newTriple1/query>\n" +
                "    {	SELECT ?description\n" +
                "	WHERE{\n" +
                "  <http://127.0.0.1:3333/Probability>\n" +
                "	<http://www.semanticweb.org/sarvanshprasher/ontologies/2019/10/untitled-ontology-23#hasDescription>\n" +
                "   ?description\n" +
                "}\n" +
                "}\n" +
                "SERVICE <http://3.17.64.65:3030/serTriple4/query>{	\n" +
                "SELECT ?prereq\n" +
                "WHERE{\n" +
                "<http://127.0.0.1:3333/Probability>\n" +
                "<http://www.semanticweb.org/sarvanshprasher/ontologies/2019/10/untitled-ontology-28#hasPreRequisite>\n" +
                "?prereq\n" +
                "}\n" +
                "}\n" +
                "SERVICE <http://18.217.171.143:3030/serTriple3/query>{	\n" +
                "SELECT ?researchLink\n" +
                "WHERE{\n" +
                "<http://127.0.0.1:3333/Probability>\n" +
                "<http://www.semanticweb.org/sarvanshprasher/ontologies/2019/10/untitled-ontology-27#hasResearchLink>\n" +
                "?researchLink\n" +
                "}\n" +
                "}\n" +
                "SERVICE <http://18.217.171.143:3030/serTriple3/query>{	\n" +
                "SELECT ?video\n" +
                "WHERE{\n" +
                "<http://127.0.0.1:3333/Probability>\n" +
                "<http://www.semanticweb.org/sarvanshprasher/ontologies/2019/10/untitled-ontology-27#hasVideo>\n" +
                "?video\n" +
                "}\n" +
                "}\n" +
                " }";


        Query query = QueryFactory.create(fedquery, Syntax.syntaxARQ);

        // Limit the number of results returned
        // Setting the limit is optional - default is unlimited
        query.setLimit(5);

        // Set the starting record for results returned
        // Setting the limit is optional - default is 1 (and it is 1-based)
        query.setOffset(1);

        // Query uses an external SPARQL endpoint for processing
        // This is the syntax for that type of query

        Log.d("QERET", "queryRemoteSparqlEndpoint: Chal Raha hai");

//        QueryExecution qe = QueryExecutionFactory.sparqlService(liteEnd, query);

        QueryExecution qe = QueryExecutionFactory.create(QueryFactory.create(query), new
                DatasetImpl(ModelFactory.createDefaultModel()));


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



                String topicdetailString = null;


                // Add the returned row/column data to the StringBuffer

                // Data value will be null if optional and not present
                if (solution.get(var) == null) {

                    topicdetailString = "{null}";

                    // Test whether the returned value is a literal value
                } else if (solution.get(var).isLiteral()) {

                    topicdetailString = solution.getLiteral(var).toString();
//                    results.append(solution.getLiteral(var).toString());
                    // Otherwise the returned value is a URI
                } else {
                    topicdetailString = solution.getResource(var).getURI();
//                    results.append(solution.getResource(var).getURI());
                }

                Log.d("DETAIL", topicdetailString);

            }

        }

        // Important - free up resources used running the query
        qe.close();

        // Return the results as a String

    }



    public static List<String> getAllTopics(){

        String topicQuery= "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX tr1: <http://127.0.0.1:3333/>\n" +
                "PREFIX prefix1: <http://www.semanticweb.org/sarvanshprasher/ontologies/2019/10/untitled-ontology-23>\n" +
                "SELECT ?topic WHERE {\n" +
                "?topic rdf:type <http://www.semanticweb.org/sarvanshprasher/ontologies/2019/10/untitled-ontology-23#Topic>\n" +
                "}";

        Log.d("CHECKQUESRY", topicQuery);


        Query query = QueryFactory.create(topicQuery, Syntax.syntaxARQ);

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

                } else {

                    subtopicName = solution.getResource(var).getURI();

                }


                subtopicName = AppUtility.getCleanSubtoipc(subtopicName);

                subtopiclist.add(subtopicName);
            }

        }

        qe.close();

        return subtopiclist;


    }




}


