#!/bin/bash

mvn clean package
java -jar ./target/swingy.jar $1