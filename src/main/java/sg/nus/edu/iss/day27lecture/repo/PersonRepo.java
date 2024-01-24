package sg.nus.edu.iss.day27lecture.repo;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import sg.nus.edu.iss.day27lecture.model.Person;

@Repository
public class PersonRepo {

    private final MongoTemplate mongoTemplate;

    public PersonRepo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    // above two is equal to autowired version

    public Person insertPerson(Person person) {
        Person newPerson = mongoTemplate.insert(person);
        return newPerson;
    }

    public Person savePerson(Person person) {
        Person newPerson = mongoTemplate.save(person);
        return newPerson;
    }

    public List<Person> getAllPerson() {
        return mongoTemplate.findAll(Person.class);
    }

    public List<Person> getPersonsPaginated(int pageNumber, int pageSize) {
        Query query = new Query();
        query.skip(pageNumber*pageSize);
        query.limit(pageSize);

        return mongoTemplate.find(query, Person.class);
    }

    public void findAndDeletePerson(ObjectId id) {
        Query query = new Query(Criteria.where("_id").is(id));
        DeleteResult result = mongoTemplate.remove(query, "persons");

        System.out.printf("Deleted document %d\n", result.getDeletedCount());
    }

    public void deletePerson(Person p) {
        mongoTemplate.remove(p);
    }

    public Person updatePerson(Person p) {
        Person updPerson = mongoTemplate.save(p);
        return updPerson;
    }

    public void findAndUpdatePerson(ObjectId id, Person person) {
        Query query = new Query(Criteria.where("_id").is(id));

        Update updateOperation = new Update()
            .set("name", person.getName())
            .inc("age", 1);

        UpdateResult result = mongoTemplate.updateMulti(query, updateOperation, "persons");

        System.out.printf("Documents Updated %d\n", result.getModifiedCount());
    }
}
