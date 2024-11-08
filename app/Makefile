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
	reports { xml.required.set(true) }
lint:
	./gradlew checkstyleMain
run-h:
	./build/install/app/bin/app -h

.PHONY: build
.PHONY: test
