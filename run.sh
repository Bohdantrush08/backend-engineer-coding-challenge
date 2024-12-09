#!/usr/bin/env sh

# This file will be included as a Docker ENTRYPOINT in our automated testing environment.

echo %JAVA_HOME%

# Build the project
mvn clean install

# Run the application
java -jar target/backend-engineer-coding-challenge-1.0.0.jar

# Inform the user and wait for a key press

echo "Press any key to stop the server..."
read -r -n 1  # Reads a single character from the user

# Optionally, stop the application (if it's running in the background)
kill $!  # Terminates the last background process (the application)

exit 0