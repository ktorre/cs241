FILES = DelatorreKp3.java Graph.java Vertex.java Edge.java

DelatorreKp3.class : $(FILES)
	@echo -n Compiling project...
	@javac -nowarn DelatorreKP3.java
	@echo Done
run :
	@echo -n -e Executing program...\n
	@java DelatorreKp3
	@echo -n -e \nFinished\n

clean :
	@echo -n Cleaning...
	@rm -rf *.class
	@echo Done

crun :
	@make -s 	# -s silences make
	@make -s run

crunc :
	@make -s
	@make -s run
	@make -s clean


