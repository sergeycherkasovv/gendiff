build:
	./gradlew clean build
run-install:
	./gradlew clean install
run-dist:
		./build/install/app/bin/app
run:
	./gradlew run
test:
	./gradlew test
report:
	./gradlew jacocoTestReport
lint:
	./gradlew checkstyleMain

run-h:
	./build/install/app/bin/app -h
run-stylish:
	./build/install/app/bin/app file3.json file4.json
run-plain:
	./build/install/app/bin/app -f plain file3.json file4.json
run-json:
	./build/install/app/bin/app -f json file3.json file4.json

.PHONY: build
.PHONY: test
