docker run --name demo-postgres -e POSTGRES_PASSWORD=root -e POSTGRES_USER=postgres -p 5432:5432 -d postgres
docker run -itd --name demo-db2 --privileged=true -p 50000:50000 -e LICENSE=accept -e DB2INST1_PASSWORD=db2-inst1-pwd -e DBNAME=demo ibmcom/db2
