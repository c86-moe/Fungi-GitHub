javac -cp .:junit-platform-console-standalone.jar --source-path ./src/ ./test/cards/*.java ./test/board/*.java -d ./bin/test/
java -jar junit-platform-console-standalone.jar  --class-path ./bin/test/cards/ --scan-class-path --fail-if-no-tests
java -jar junit-platform-console-standalone.jar  --class-path ./bin/test/board/ --scan-class-path --fail-if-no-tests