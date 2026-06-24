#!/usr/bin/env bash

mvn install:install-file -Dfile=libs/ms.simrs.kripto-2.0.jar -DpomFile=libs/ms.simrs.kripto-2.0.pom
mvn install:install-file -Dfile=libs/itext-2.1.7.js6.jar -DpomFile=libs/itext-2.1.7.js6.pom
mvn install:install-file -Dfile=libs/jasperreports-6.8.0.jar -DpomFile=libs/jasperreports-6.8.0.pom

mvn install:install-file -Dfile=libs/javafx.swing-25.0.jar \
    -DgroupId=javafx \
    -DartifactId=javafx-swing \
    -Dversion=25 \
    -Dpackaging=jar

mvn install:install-file -Dfile=libs/UsuLibrary.jar \
    -DgroupId=usu \
    -DartifactId=usulibrary \
    -Dversion=1.0 \
    -Dpackaging=jar

mvn install:install-file -Dfile=libs/calendar.jar \
    -DgroupId=uz.ncipro \
    -DartifactId=calendar \
    -Dversion=1.0 \
    -Dpackaging=jar

mvn install:install-file -Dfile=libs/smslib-3.4.6.jar \
    -DgroupId=org.smslib \
    -DartifactId=smslib \
    -Dversion=3.5.4 \
    -Dpackaging=jar
