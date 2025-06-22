#!/bin/bash
# Run script for Just Blog application

echo "🚀 Starting Just Blog application..."

# Check if Maven is available
if command -v mvn >/dev/null 2>&1; then
    echo "✅ Using system Maven"
    mvn spring-boot:run
elif [ -f "./mvnw" ]; then
    echo "✅ Using Maven wrapper"
    ./mvnw spring-boot:run
else
    echo "❌ Maven not found!"
    echo "Please install Maven first or run the build script"
    exit 1
fi
