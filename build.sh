#!/bin/bash
# Build script for Just Blog application

echo "🚀 Building Just Blog application..."

# Check if Maven is available
if command -v mvn >/dev/null 2>&1; then
    echo "✅ Using system Maven"
    mvn clean install
elif [ -f "./mvnw" ]; then
    echo "✅ Using Maven wrapper"
    ./mvnw clean install
else
    echo "❌ Maven not found!"
    echo "Please install Maven:"
    echo "  - Ubuntu/Debian: sudo apt install maven"
    echo "  - CentOS/RHEL: sudo yum install maven"
    echo "  - macOS: brew install maven"
    exit 1
fi

echo "✅ Build completed!"
echo ""
echo "To run the application:"
echo "  mvn spring-boot:run"
echo "  or"
echo "  ./mvnw spring-boot:run"
echo ""
echo "Then open: http://localhost:8080"
