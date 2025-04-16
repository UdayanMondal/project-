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



NoSQL databases are a category of database management systems designed to handle a variety of format of data that are more flexible and scalable than traditional relational databases.
Key Characteristics:
Schema-less / Flexible Schema: NoSQL databases do not require a predefined schema. This makes them ideal for applications where the data structure might change frequently or is unpredictable.
Horizontal Scaling: NoSQL databases are designed to scale out by distributing the data across multiple servers (nodes), making them capable of handling large amounts of data with ease. 
Data format: These are main type:
	a. Document Store: Stores data in documents (e.g., JSON, XML). 
			Example: MongoDB, CouchDB.
    	b. Key-Value Store: Data is stored as key-value pairs. 
		                   Example: Redis   	
c. Column Store: Data is stored in columns rather than rows, making them well-suited for analytical workloads. 
			Example: Apache Cassandra, Hbase
 	d. Graph Database: Designed to handle relationships between data points using graph structures (nodes and edges). 
			     Example: Neo4j, Amazon Neptune.
4. Index and aggregation framework : Perform advance data transformation and analysis and process  data using multiple pipeline stages .
          
5.  Popular NoSQL Databases: MongoDB, Cassandra, Redis, Couchbase, Amazon DynamoDB


Database
A database in MongoDB is a container for collections. Each MongoDB instance can have multiple databases.
You don't need to predefine a database in MongoDB. A database is created when you first insert a document into a collection.

Collections
A collection in MongoDB is like a table in a relational database. 
A collection holds documents and is where the actual data resides. 
Collections in MongoDB are schema-less, meaning you don't have to pre-define the structure of the documents.
Each document is a key-value pair structure, where each key (or field) can have different data types, including:
       I. Strings
      II. Numbers
      III. Arrays
      IV. Subdocuments (nested documents)
      V. Dates
The _id field is automatically generated by 
MongoDB and serves as a unique Identifier 
for each document

argo documentation - https://argo-cd.readthedocs.io/en/stable/getting_started/

kubernate project -https://github.com/kubekode/DevOps-Projects/tree/React-GKE-pulumi

devop project -https://github.com/iam-veeramalla

Using List of Strings program :
Basics
1. Convert a list of strings to uppercase , sort them and print
2. Get the list of strings where the length of each element is greater than 5 and get the count
3. Remove duplicates from a list
4. Get the list of strings having a particular word 
5. Write a Java program to remove strings that start with a specific word from a list using streams.
6. Find the first element in a list that starts with a particular letter
7. Get the length of each name in a list

Intermediate

8. Sort the list of strings based on their lengths in ascending/descending order.
9. Find the longest word in the list.
10. Get the list of strings having vowels
11. convert a list of strings into a single string, separated by commas, using streams
12. Write a Java program to create a new list of strings, where each string is reversed from the original list, using Java streams.
13. Write a Java program to remove all strings from the list that are empty or null using streams.

Advanced
14. Given a list of strings, group a list of strings by the first letter of each string using streams
15. Given a list of strings, group a list of strings by the length of the string 
16. Given a list of strings, create a map where the key is the first letter of the string, and the value is a list of strings that start with that letter using streams
17. Given a list of strings, group the list of strings with vowels and no vowels into two lists
18. Given a list of strings print only the string elements excluding the digits using streams.
19. Given a list of strings find the first element having the length as 10 if not handle exceptions
20. Reverse the list of strings using streams api

Top 20 coding interview questions in Streams API
Using List of Numbers
Basics
1. Get the even/odd numbers from an array of numbers and list of numbers
2. Get the even/odd numbers between a range 
3. Sort a list of integers in descending/ascending order  
4. Calculate the sum and average of numbers in an array and list of numbers
5. Find the maximum/minimum number in an array/list of numbers 

Intermediate
6. Remove duplicate elements from an array/list of integers
7. Convert a list/array of integers to a list of their squares and print them
8. Find the sum of squares of all the numbers in the array/list.
9. Get the second largest number and second smallest  number in a list/array
10. Get the first number greater than 50 in a list/array

Advanced
11. Get the sum of numbers of a two dimensional array and list of list of integers
12. Convert an array of integers into a map where the key is the number and the value is its square
13. Partition an array of integers into two groups: even and odd using Streams.
14. Calculate the product of all numbers in the array using reduce
15.implement a parallel stream that computes the sum of squares of numbers in an array.
-----------------------------------------------------------------------------------------------------------

What You’ll Learn:
Filtering Strings: How to filter out specific elements from a list using filter().
Transforming Data: Using map() to convert data and modify elements in the list.
Sorting Strings: Sorting a list of strings based on specific criteria.

Finding Elements: Using findFirst() and findAny() to search within a stream.
Reducing Data: Applying reduce() to aggregate or combine elements of a list.




















