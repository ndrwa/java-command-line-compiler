#!/bin/bash

# 1. Configuration
PROJECT_ROOT=$(pwd)
SRC_DIR="src"
LIB_DIR="libs"
TARGET_DIR="target"
JAR_NAME="MyCarApp.jar"
MAIN_CLASS="service.CarService"

echo "--- Starting Build Process ---"

# 2. Cleanup previous builds
echo "Cleaning old files..."
rm -rf $TARGET_DIR
rm -f $JAR_NAME

# 3. Create build directory
mkdir -p $TARGET_DIR

# 4. Compile Source Code
echo "Compiling Java files..."
# We include the libs in the classpath so javac can find Guava
javac -d $TARGET_DIR -cp ".:$LIB_DIR/*" $SRC_DIR/model/*.java $SRC_DIR/service/*.java

if [ $? -ne 0 ]; then
    echo "Compilation failed!"
    exit 1
fi

# 5. Extract Dependencies into Target
echo "Extracting dependencies..."
cd $TARGET_DIR
for jarfile in ../$LIB_DIR/*.jar; do
    jar -xf "$jarfile"
done

# 6. Create the Manifest file
echo "Generating manifest..."
echo "Main-Class: $MAIN_CLASS" > manifest.txt
echo "" >> manifest.txt # The crucial blank line

# 7. Package everything into a Fat JAR
echo "Packaging into $JAR_NAME..."
jar -cfm ../$JAR_NAME manifest.txt .

# 8. Cleanup Target (Optional)
cd ..
# rm -rf $TARGET_DIR # Uncomment if you want to delete target after build

echo "--- Build Complete! ---"
echo "Run your app with: java -jar $JAR_NAME"