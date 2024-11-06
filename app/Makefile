run-dist:
		./build/install/app/bin/app
build:
	./gradlew clean build
	./gradlew clean install
	./gradlew test
	./gradlew jacocoTestReport
report:
	./gradlew jacocoTestReport
lint:
	./gradlew checkstyleMain
run-install:
	./gradlew clean install
run-h:
	./build/install/app/bin/app -h

.PHONY: build
