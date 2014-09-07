#!/bin/bash

echo 'Running Counting.java'
number=0
javac Counting.java
touch countingOutput.txt 
touch countingByteCode.txt

while [ $number -lt 50 ]; do
	java Counting >> countingOutput.txt
	javap -c -classpath . Counting >> countingByteCode.txt
	echo '---------' >> countingOutput.txt
	echo '---------' >> countingByteCode.txt
	number=$((number + 1))
done
