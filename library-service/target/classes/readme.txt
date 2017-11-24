1. Start project : library-parent/library-service
  	mvn spring-boot:run
        
    Build project under library-parent
	man clean install


2. Use HQ2 for Unit test of repository class, and my sql for integration test and run:
	alter table test.LibraryConfig modify column id int NOT NULL AUTO_INCREMENT;

	ALTER TABLE `test`.`LibraryConfig` 
	ADD UNIQUE INDEX `access_cat_name_UNIQUE` (`accessLevel` ASC,`category` ASC,`name` ASC);

3.  Client pass value as string, plus valueType(Double or Int or Boolean, by default it's string), db save value in the column of value, with the column intValue if valueType is int. It's more convenient to run the operation of range/aggregation if needed.

4. Test Cases
	curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"category":"General","name":"BusinessName","accessLevel":"","value":"Olis Library","valueType":"String"}' http://localhost:8080/api/create
	
	curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"category":"Rental","name":"MaxRentalPrice","accessLevel”:”San Jose”,”value":"19999.45","valueType":"Double"}' http://localhost:8080/api/create
	
	curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"category":"Rental","name":"MaxRentalPrice","accessLevel":"","value":"12300.45","valueType":"Double"}' http://localhost:8080/api/create
	
	curl http://localhost:8080/api/findall?branch=San%20Jose
	
	curl http://localhost:8080/api/findall
	
	curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"category":"Rental","name":"MaxRentalPrice","accessLevel":"San Jose","value":"199","valueType":"Int"}' http://localhost:8080/api/update
	
	curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"category":"Rental","name":"MaxRentalPrice","accessLevel":"San Jose","value":"199","valueType":"Int"}' http://localhost:8080/api/delete
