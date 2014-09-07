#!/bin/bash

number=0
javac HelloWorld.java
rm helloOutput.txt
touch helloOutput.txt
while [ $number -lt 50 ]; do 
        java HelloWorld >> helloOutput.txt
        echo '---------' >> helloOutput.txt
        number=$((number + 1))
done
        
