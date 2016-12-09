FILES = program3Modular.java Graph.java Vertex.java Edge.java

program3Modular.class : $(FILES)
	@echo -n Compiling project...
	@javac -nowarn program3Modular.java
	@echo Done
run :
	@echo -n -e Executing program...\n
	@java program3Modular
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


