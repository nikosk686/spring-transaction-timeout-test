A small Proof of Concept for proving that Spring's `@Transactional` timeout property does not cause query timeout on DB2 by default, while it does for Postgres

Run the `docker-dbs.sh` script to create the DB containers.
Then uncomment the correct line from `application.properties` to activate a database profile.

For postgres, `@Transactional`'s timeout causes a query timeout.

For DB2, `@Transactional`'s does not cause timeout by default see the connection 
string on `application-db2.properties` and uncomment accordingly.

On each repository there is a method that causes DB sleep for 30 seconds.
The service method that calls the above method has a transaction timeout configuration on 15 seconds.
* Postgers flow timeouts on 15 seconds.
* DB2 flow **without** `queryTimeoutInterruptProcessingMode=2` timeouts on 30 secs (after DB sleep has finished)
DB2 flow **with** `queryTimeoutInterruptProcessingMode=2` timeouts on 15 secs (as per the service's configuration)