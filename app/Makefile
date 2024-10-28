run-dist:
		./build/install/app/bin/app

build:
	./gradlew clean build
	./gradlew clean install
	./gradlew test
	./gradlew jacocoTestReport
	./gradlew checkstyleMain

.PHONY: build