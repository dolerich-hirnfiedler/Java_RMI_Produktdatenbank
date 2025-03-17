
# Define variables
JAVAC = javac
JAVA = java
SOURCE_DIR = src
CLASS_DIR = classes
CLIENT_MAIN_CLASS = de.eldecker.produktdatenbank.client.ProduktdatenClient
SERVER_MAIN_CLASS = de.eldecker.produktdatenbank.server.ProduktDbServer

# Default target (what happens when you just type 'make')
all: compile

# Compile target
compile:
	@mkdir -p $(CLASS_DIR)  # Create the classes directory if it doesn't exist
	$(JAVAC) -d $(CLASS_DIR) -sourcepath $(SOURCE_DIR) $(SOURCE_DIR)/de/eldecker/produktdatenbank/**/*.java

# Run server target
server: compile
	$(JAVA) -cp $(CLASS_DIR) $(SERVER_MAIN_CLASS)

# Run client target
client: compile
	$(JAVA) -cp $(CLASS_DIR) $(CLIENT_MAIN_CLASS)

# Clean target - removes compiled classes
clean:
	rm -rf $(CLASS_DIR)

.PHONY: all compile server client clean
