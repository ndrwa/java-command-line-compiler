for libs: https://repo1.maven.org/maven2/com/google/guava/guava/31.1-jre/guava-31.1-jre.jar

javac -classpath ".:libs/_" -d target -sourcepath . service/CarService.java model/_.java \
java -classpath ".:target:libs/\*" service/CarService \
