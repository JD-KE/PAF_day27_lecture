package sg.nus.edu.iss.day27lecture;

import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.BucketOperation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.aggregation.StringOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.client.result.UpdateResult;

import sg.nus.edu.iss.day27lecture.model.Person;
import sg.nus.edu.iss.day27lecture.repo.PersonRepo;

@SpringBootApplication
public class Day27LectureApplication implements CommandLineRunner {

	@Autowired
	PersonRepo personRepo;

	@Autowired
	MongoTemplate mt;

	public static void main(String[] args) {
		SpringApplication.run(Day27LectureApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Person insertedPerson = personRepo.insertPerson(new Person(
		// 	"Someone", 69, "M", Arrays.asList("RC", "Swimming", "Cycling") 
		// ));
		// Person insertedPerson2 = personRepo.insertPerson(new Person(
		// 	"No one", 0, "F", Arrays.asList("Nope", "Nothing", "Nada")
		// ));
		// Person insertedPerson3 = personRepo.insertPerson(new Person(
		// 	"James", 18, "M", Arrays.asList("Swimming", "Running", "Biking")
		// ));
		// Person insertedPerson4 = personRepo.insertPerson(new Person(
		// 	"Emily", 18, "F", Arrays.asList("Running", "Nothing", "Sleeping")
		// ));
		// Person insertedPerson5 = personRepo.insertPerson(new Person(
		// 	"Sam", 24, "M", Arrays.asList("Hobby", "Walking", "Looking at Paint Dry")
		// ));

		// System.out.println("Created Person: " + insertedPerson);

		// List<Person> persons = personRepo.getAllPerson();

		// persons.forEach(System.out::println);

		// ObjectId oid = new ObjectId("65a8a0207d5a6470a70ec0b8");
		// personRepo.findAndUpdatePerson(oid, new Person(
		// 	"65a8a0207d5a6470a70ec0b8","Samuel", 30, "M", Arrays.asList("Hobby", "Walking", "Painting")
		// ));

		// Query query = new Query(Criteria.where("name").is("Emily"));
		// Update updateOps = new Update()
		// 	.set("name", "Emilia")
		// 	.set("age", 21)
		// 	.set("hobbies", List.of("Animation", "Eating"));

		// UpdateResult result = mt.upsert(query, updateOps, "persons");

		// System.out.printf("Documents Updated %d\n", result.getModifiedCount());

		// TextCriteria textCriteria = TextCriteria.forDefaultLanguage()
		// 	.matchingPhrase("jAmeS").caseSensitive(false);

		// TextQuery textQuery = new TextQuery(textCriteria);

		// List<Document> resultTextQuery = mt.find(textQuery, Document.class, "persons" );
		// // can replace Document with Person since Person is annotated with @Document

		// System.out.println(resultTextQuery);

		// TextCriteria textCriteria = TextCriteria.forDefaultLanguage()
		// 	.matchingPhrase("jAmeS").caseSensitive(false);

		// TextQuery textQuery = new TextQuery(textCriteria).includeScore("score");

		// List<Document> resultTextQuery = mt.find(textQuery, Document.class, "persons" );
		// // can replace Document with Person since Person is annotated with @Document

		// System.out.println(resultTextQuery);

		// MatchOperation matchRated = Aggregation.match(Criteria.where("Rated").is("PG"));

		// Aggregation pipeline = Aggregation.newAggregation(matchRated);

		// AggregationResults<Document> results = mt.aggregate(pipeline,"movies", Document.class);

		// List<Document> docs = results.getMappedResults();

		// // System.out.println(docs);

		// MatchOperation matchOperation = Aggregation.match(Criteria.where("Year").is("2009"));

		// ProjectionOperation projectionOperation = Aggregation.project("Title","Year","Rated").andExclude("_id");

		// Aggregation pipeline2 = Aggregation.newAggregation(matchOperation, projectionOperation);

		// AggregationResults<Document> results2 = mt.aggregate(pipeline2, "movies", Document.class);

		// docs = results2.getMappedResults();

		// System.out.println(docs);

		// GroupOperation groupOperation = Aggregation.group("Rated").push("Title").as("titles").count().as("Count");

		// SortOperation sortOperation = Aggregation.sort(Sort.by(Direction.ASC, "count"));

		// Aggregation aggregation = Aggregation.newAggregation(groupOperation, sortOperation);

		// AggregationResults<Document> results3 = mt.aggregate(aggregation, "movies", Document.class);

		// ProjectionOperation projectionOperation = Aggregation.project("_id", "Title").and("Plot").as("summary");

		// ProjectionOperation projectionOperation = Aggregation.project("_id").and("Plot").as("summary").and(StringOperators.Concat.valueOf("Title").concat(" (").concatValueOf("Year").concat(") - ").concatValueOf("Rated")).as("Title");

		// SortOperation sortOperation = Aggregation.sort(Sort.by(Direction.ASC, "Title"));

		// Aggregation pipeline = Aggregation.newAggregation(projectionOperation, sortOperation);

		// AggregationResults<Document> results4 = mt.aggregate(pipeline,"movies", Document.class);

		// AggregationOperation aggregateOperation = Aggregation.unwind("Genre");

		// GroupOperation groupOperation = Aggregation.group("Genre").push("Title").as("titles").count().as("titles_count");

		// SortOperation sortOperation = Aggregation.sort(Sort.by(Direction.DESC,"titles_count"));

		// Aggregation pipeline = Aggregation.newAggregation(aggregateOperation,groupOperation, sortOperation);

		// AggregationResults<Document> results5 = mt.aggregate(pipeline,"movies", Document.class);

		// BucketOperation bucketOperation = Aggregation.bucket("Rated")
		// 	.withBoundaries("N/A", "PG", "R", "TV")
		// 	.withDefaultBucket("TV")
		// 	.andOutputCount().as("Count")
		// 	.andOutput("Title").push().as("titles");

		// Aggregation pipeline = Aggregation.newAggregation(bucketOperation);

		// AggregationResults<Document> results6 = mt.aggregate(pipeline,"movies", Document.class);

		LookupOperation lookupOperation = Aggregation.lookup("reviews", "_id", "movie_id", "reviews");

		Aggregation pipeline = Aggregation.newAggregation(lookupOperation);

		AggregationResults<Document> results7 = mt.aggregate(pipeline,"movies", Document.class);

		List<Document> docs = results7.getMappedResults();

		docs.forEach(System.out::println);

		// Criteria criteria = Criteria.where("name").is("emily");

		// criteria.andOperator(Criteria.where("name").is("emily"), Criteria.where("name").is("emily"));

		
		// document is like map, traditional way to make document object compared to newer way of using model object
		Document createdDocument = new Document();
		createdDocument.put("name", "test");
		System.out.println(createdDocument.toString());
	}
	
}
