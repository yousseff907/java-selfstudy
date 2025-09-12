# Basic Makefile for Java Calculator

# Default target
all:
	javac ex01/*.java

# Clean compiled files  
clean:
	rm -f ex01/*.class

# Full clean
fclean: clean

# Rebuild
re: fclean all

# Run with arguments
run:
	java ex01.Calculator $(ARGS)

.PHONY: all clean fclean re run