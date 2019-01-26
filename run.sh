#!/bin/bash

mkdir -p bin/de/unihildesheim/iis/jadedemo && javac -classpath .:lib/jade.jar src/de/unihildesheim/iis/jadedemo/* && mv src/de/unihildesheim/iis/jadedemo/*.class bin/de/unihildesheim/iis/jadedemo && java -classpath .:lib/jade.jar:bin de.unihildesheim.iis.jadedemo.ContainerController
