CC=javac
RT=java

APACHE_CSV=commons-csv-1.13.0/commons-csv-1.13.0.jar
APACHE_IO=commons-io-2.18.0/commons-io-2.18.0.jar
APACHE_CODEC=commons-codec-1.18.0/commons-codec-1.18.0.jar
APACHE_LIBS=$(APACHE_CSV):$(APACHE_IO):$(APACHE_CODEC)

LIBS=$(APACHE_LIBS)

OPT=-cp .:$(LIBS)

SRC=$(wildcard ./tamk/ohsyte/*.java)

PACKAGE=tamk.ohsyte.Today

build:
	$(CC) $(OPT) $(SRC)

run:
	$(RT) $(OPT) $(PACKAGE)
