if ! test -d classes; then
	mkdir -p classes
fi

javac src/galeshapely/*.java -d classes

java -cp classes galeshapely.Main
