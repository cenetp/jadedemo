#!/bin/bash

mkdir -p bin/de/unihildesheim/iis/jadedemo && rm -rf src/de/unihildesheim/iis/jadedemo/*.class && javac -classpath .:lib/jade.jar src/de/unihildesheim/iis/jadedemo/* && cp src/de/unihildesheim/iis/jadedemo/*.class bin/de/unihildesheim/iis/jadedemo && java -classpath .:lib/jade.jar:bin de.unihildesheim.iis.jadedemo.ContainerController
