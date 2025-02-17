Start Zookeeper 

.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties


Start Kafka 

.\bin\windows\kafka-server-start.bat .\config\server.properties


Create Topics

.\bin\windows\kafka-topics.bat --zookeeper localhost:2181 --create --replication-factor 1 --partitions 1 --topic test


List Topics

.\bin\windows\kafka-topics.bat --zookeeper localhost:2181 --list


Kafka Producer

.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic test


Kafka Consumer 

.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --from-beginning --topic test



--MongoDB 
To List the Database use : 
> show databases

To Create new Database 
> use projectXYZ
To drop Database 
> use project
> db.createCollection(‘data’)
> show databases
> db.dropDatabase()

To drop table from database;
> db.createColletion(‘students’)
> db.createColletion(‘departments’)			
> db.students.drop()
To Insert one record in user table.
> db.user.insertOne({“name”:”Yogesh”,”email”:”test@gmail.com”})

The single purpose aggregation methods aggregate documents from a single collection. The methods are simple but lack the capabilities of an aggregation pipeline. Some method are
db.collection.count()
db.collection.distinct()
db.collection.countDocuments()
db.collection.

To Insert Many record in table.
> db.employees.insertMany( [    {         _id:1,        firstName: "John",        lastName: "King",        email: "john.king@abc.com",        salary: 5000    },    {         _id:2,        firstName: "Sachin",        lastName: "T",        email: "sachin.t@abc.com",        salary: 8000])


To List the record in user table.
> db.user.find()
 	> db.user.findOne()

To List the record in employees table with some conditions.
> db.employees.find({"firstName":"Amitabh"})	
To List the record in employees table with regular expression.
> db.employee.find({"firstName":/^john$/i})

To Update one record in employees table.
> db.employees.updateOne({_id:2}, { $set: {firstName:'Morgan'}})

To Update many record in employees table.
> db.employees.updateMany({salary: {$gt : 7000}},{$set: {"Review": true}})

To Delete one record in user table.
> db.employees.deleteOne({"salary" : { $gt : 7000}})

To Delete Many record in user table.
> db.employees.deleteMany({"salary" : { $eq : 7000}})	

To find records in users table with query Operators.
> db.users.find({ age: { $eq: 25 } })
To find records in users table with Logical Operators.
> db.users.find({ $or: [{ status: "active" }, { age: { $gt: 30 } }] })

To Update records in users table with update Operators.
> db.users.updateOne({ name: “David" }, { $set: { age: 28 } })

To Count the Documents in a Collection.
> db.users.countDocuments()

To Count the result after filter condition or find in a Collection.
	> db.users.find({ age: { $ne: 30 } }).count()

 To get distinct values for given field.
> db.users.distinct(“age”)

To get statistical information about a collection, such as document count, storage 		size, and index usage.
		> db.users.stats()

  List of Aggregation stages in aggregation pipeline.
$match :- Filters the documents based on a condition (similar to find query).

$unwind :- Deconstructs an array field from the input documents to output a document for each element

$group :- stage is to aggregate or summarize data into groups based on specific fields, and perform operations like summing, averaging, counting, etc., on the grouped data.
Group basic structure is:- 
{ 
  $group: { 
    _id: <expression>, 
    <field1>: <aggregation1>, 
    <field2>: <aggregation2>, 
  }
}

The $group stage supports certain expressions (operators) allowing users to perform arithmetic, array, boolean and other operations as part of the aggregation pipeline.

$count :- Calculates the quantity of documents in the given group.
$max :- Displays the maximum value of a document’s field in the collection.
$min :- Displays the minimum value of a document’s field in the collection.
$avg :- Displays the average value of a document’s field in the collection.
$sum :- Sums up the specified values of all documents in the collection.
$push :- Adds extra values into the array of the resulting document.
$sort :- Sorts the documents in ascending or descending order
$sortByCount :- This stage is a shortcut for grouping, counting and then sorting in descending order the number of different values in a field.
Suppose we want to know the number of courses per level, sorted in descending order.
$project :- Allows for reshaping each document in the stream by including, excluding, or adding new fields.
$limit :- Limits the number of documents in the output
$skip :- Skips the first N documents.
$lookup :- Performs a left outer join to a specified collection and adds matching documents to the result
$out :- It is used to write the output of the aggregation pipeline to a specified collection, replacing the entire content of the target collection.



List of Aggregation stages in aggregation pipeline.
$arrayToObject :- Converts an array of key-value pairs into an object.

{ $project: { myObject: { $arrayToObject: "$keyValuePairs" } } }

$objectToArray :- Converts an object into an array of key-value pairs.


{ $project: { keyValuePairs: { $objectToArray: "$myObject" } } }

























