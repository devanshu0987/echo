## Functional Requirement
- User should be able to call an endpoint which returns the payload passed in the body.

## Scope
- `/echo`
  - Only `POST` operation is allowed on the endpoint. 
  - Request body should contain a valid `JSON` payload.
    - Invalid payload will return with `400 Bad Request`
  - Response body will contain the same payload that was passed with `200 OK`
  - Only `application/json` Content type is supported.
    - Any other Content type will return with `415 Unsupported Media Type`

## How to run the server
- Get the codebase
- It is a JAVA based project.
- Dependencies
  - `Java 17 or higher` and `Gradle`
  - Please install them before going forward.
- Building jar
  - Move to the project root & run following command
  - `./gradlew jar`
  - You can locate the generated JAR file in the "build/libs" directory. 
  - It will have a name like `your-project-name-version.jar`
- Running the server via jar
  - Open the directory where the jar file is present
  - Run the following example command
  - `java -jar .\echo-0.0.1-SNAPSHOT.jar --server.port=8082`
  - The server will be available on `http://localhost:8082`

## Example runs

`curl -d '{\"game\":\"Mobile Legends\", \"gamerID\":\"GYUTDTE\", \"points\":20}' -
H 'Content-Type: application/json' -X POST http://localhost:8082/echo`

`{"game":"Mobile Legends","gamerID":"GYUTDTE","points":20}`

