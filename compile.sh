#!/bin/bash

find -name *.java > sources.txt
javac @sources.txt
java game.Runtime $1