#!/bin/bash
# Maven Wrapper Script
#
# This script will download and install Maven if it's not already available,
# then run the Maven command with the provided arguments.

MAVEN_WRAPPER_VERSION="3.9.5"
MAVEN_WRAPPER_URL="https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/${MAVEN_WRAPPER_VERSION}/apache-maven-${MAVEN_WRAPPER_VERSION}-bin.tar.gz"

# Check if mvn is already available
if command -v mvn >/dev/null 2>&1; then
    # Maven is available, use it directly
    mvn "$@"
else
    echo "Maven not found. Please install Maven to build this project."
    echo "You can install Maven using:"
    echo "  - Ubuntu/Debian: sudo apt install maven"
    echo "  - CentOS/RHEL: sudo yum install maven"
    echo "  - macOS: brew install maven"
    echo "  - Or download from: https://maven.apache.org/download.cgi"
    exit 1
fi
