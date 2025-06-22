#!/bin/bash

# VSCode Java Development Setup Script
echo "Installing VSCode Extensions for Java Spring Boot Development..."

# Core Java Extensions
code --install-extension vscjava.vscode-java-pack
code --install-extension redhat.java

# Spring Boot Extensions
code --install-extension vmware.vscode-spring-boot
code --install-extension vscjava.vscode-spring-initializr
code --install-extension vscjava.vscode-spring-boot-dashboard

# Additional useful extensions
code --install-extension ms-vscode.vscode-json
code --install-extension redhat.vscode-xml
code --install-extension ms-azuretools.vscode-docker

echo "✓ VSCode Extensions installed successfully!"
echo ""
echo "Next steps:"
echo "1. Restart VSCode"
echo "2. Open the project folder"
echo "3. Press F5 to start debugging or use Ctrl+Shift+P > 'Tasks: Run Task'"
echo "4. Configure your database credentials in .env file"
