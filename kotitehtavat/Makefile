JAVAFX_PATH=~/libs/javafx-sdk-21.0.2/lib/
JAVAFX_MODULES=javafx.controls
CLASS_NAME=FXListView

DISABLE_HW_ACC=-Dprism.order=sw

JAVAFX=--module-path $(JAVAFX_PATH) --add-modules $(JAVAFX_MODULES)

JAVA_FILE=$(CLASS_NAME).java

COMPILE=javac $(JAVAFX) $(JAVA_FILE)
EXECUTE=java $(DISABLE_HW_ACC) $(JAVAFX) $(CLASS_NAME)

all:
	$(COMPILE)
	$(EXECUTE)

run:
	$(EXECUTE)

compile:
	$(COMPILE)

comperr:
	$(COMPILE)
	rm $(CLASS_NAME).class

clean:
	rm $(CLASS_NAME).class
	rm *.log
