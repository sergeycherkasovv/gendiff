run-dist:
		./build/install/app/bin/app

build:
	./gradlew clean build
	./gradlew clean install
	./gradlew test
	./gradlew jacocoTestReport
report:
	./gradlew checkstyleMain

.PHONY: build
