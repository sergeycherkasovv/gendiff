.DEFAULT_GOAL := build-run
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
build-run:
	build run

.PHONY: build
.PHONY: test
