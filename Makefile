docker run --name sqlflite \
           --detach \
           --rm \
           --tty \
           --init \
           --publish 31337:31337 \
           --env TLS_ENABLED="1" \
           --env SQLFLITE_PASSWORD="sqlflite_password" \
           --env PRINT_QUERIES="1" \
           --pull missing \
					 --network=xdb-network \
           voltrondata/sqlflite:latest

jdbc:arrow-flight-sql://localhost:31337?useEncryption=true&user=sqlflite_username&password=sqlflite_password&disableCertificateVerification=true

export MAVEN_OPTS="--add-opens=java.base/java.nio=ALL-UNNAMED"

mvn exec:java -Dexec.mainClass="com.mycompany.app.App" --add-opens=java.base/java.nio=ALL-UNNAMED
