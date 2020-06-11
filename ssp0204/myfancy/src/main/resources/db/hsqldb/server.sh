cd `dirname $0`
mvn -e -Ddb.file=./myfancy exec:java
