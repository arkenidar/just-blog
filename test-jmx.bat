@echo off

rem JMX Connection Test Script for Windows
echo Testing JMX connectivity for Just Blog application...

rem Test if JMX port is listening
echo 1. Testing if JMX port 9999 is listening...
netstat -an | findstr 9999 && echo Port 9999 is listening || echo Port 9999 is not listening

rem Test JMX connection with jconsole
echo 2. Testing JMX connection...
where jconsole >nul 2>&1
if %errorlevel% == 0 (
    echo JConsole found - you can connect manually with:
    echo jconsole localhost:9999
) else (
    echo JConsole not found in PATH
)

rem Alternative connection info
echo 3. JMX Connection URL:
echo service:jmx:rmi:///jndi/rmi://127.0.0.1:9999/jmxrmi

echo.
echo If VSCode extension still fails:
echo 1. Try the 'Debug Spring Boot App (MySQL Dev - No JMX)' configuration
echo 2. Use HTTP actuator endpoints instead: http://localhost:8081/actuator
echo 3. Check Windows Firewall settings
echo 4. Restart VSCode and try again

pause
