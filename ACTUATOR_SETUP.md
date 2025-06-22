# Spring Boot Actuator and JMX Configuration

This application includes Spring Boot Actuator for monitoring and management, with JMX enabled.

## Available Endpoints

### HTTP Endpoints

#### Development Profile
When running with `dev` profile, all actuator endpoints are available:

- **Health**: http://localhost:8081/actuator/health
- **Info**: http://localhost:8081/actuator/info  
- **Metrics**: http://localhost:8081/actuator/metrics
- **Environment**: http://localhost:8081/actuator/env
- **Beans**: http://localhost:8081/actuator/beans
- **Configuration Properties**: http://localhost:8081/actuator/configprops
- **All Endpoints**: http://localhost:8081/actuator

#### Production Profile
When running with `prod` profile, only essential endpoints are available:

- **Health**: http://localhost:8081/actuator/health
- **Info**: http://localhost:8081/actuator/info
- **Metrics**: http://localhost:8081/actuator/metrics

### JMX Endpoints

JMX is now enabled with different ports for each profile:

- **Dev Profile**: JMX Port 9999
- **Prod Profile**: JMX Port 9998  
- **H2 Profile**: JMX Port 9997
- **Dev-Fresh Profile**: JMX Port 9996

## Configuration

### JMX Enabled
JMX is now enabled by default for monitoring and management:

- JMX remote access configured for each profile
- No authentication required (development only)
- SSL disabled for simplicity

### Management Port
Actuator runs on a separate port (8081) for security:

- **Application**: http://localhost:8080
- **Management**: http://localhost:8081/actuator

### JMX Ports
Each profile uses a different JMX port to avoid conflicts:

| Profile | JMX Port | Description |
|---------|----------|-------------|
| dev | 9999 | Development with persistent data |
| prod | 9998 | Production |
| h2 | 9997 | H2 in-memory testing |
| dev-fresh | 9996 | Development with fresh data |

### Environment Variables

| Variable | Default | Description |
|----------|---------|-------------|
| `MANAGEMENT_PORT` | 8081 | Port for actuator endpoints |
| `JMX_ENABLED` | true | Enable/disable JMX |
| `JMX_PORT_DEV` | 9999 | JMX port for dev profile |
| `JMX_PORT_PROD` | 9998 | JMX port for prod profile |
| `JMX_PORT_H2` | 9997 | JMX port for h2 profile |
| `JMX_PORT_DEV_FRESH` | 9996 | JMX port for dev-fresh profile |

## Connecting with JMX Tools

### Using JConsole
1. Start your application with desired profile (e.g., Debug Spring Boot App (MySQL Dev - Persistent))
2. Open JConsole (comes with JDK): `jconsole`
3. Connect to: **Remote Process**
4. Enter: `localhost:9999` (for dev profile)
5. Leave username/password empty
6. Click "Connect"

### Using VisualVM
1. Start your application
2. Open VisualVM
3. Right-click "Remote" in the left panel
4. Add JMX Connection: `localhost:9999`
5. Leave credentials empty
6. Browse MBeans and monitor application

### Connection URLs
- **Dev Profile**: `service:jmx:rmi:///jndi/rmi://localhost:9999/jmxrmi`
- **Prod Profile**: `service:jmx:rmi:///jndi/rmi://localhost:9998/jmxrmi`
- **H2 Profile**: `service:jmx:rmi:///jndi/rmi://localhost:9997/jmxrmi`
- **Dev-Fresh Profile**: `service:jmx:rmi:///jndi/rmi://localhost:9996/jmxrmi`

## Troubleshooting

### VSCode Extension JMX Issues

If you get the error: `Failed to refresh live data from process service:jmx:rmi:///jndi/rmi://127.0.0.1:9999/jmxrmi after retries: 10`

**Option 1: Use the No-JMX Configuration (Recommended)**
1. Use the "Debug Spring Boot App (MySQL Dev - No JMX)" configuration
2. Monitor via HTTP actuator endpoints instead: http://localhost:8081/actuator
3. This avoids JMX connectivity issues entirely

**Option 2: Fix JMX Configuration**
1. Ensure Windows Firewall allows Java applications
2. Run the test script: `test-jmx.bat` (Windows) or `test-jmx.sh` (Linux/Mac)
3. Try connecting with JConsole directly: `jconsole localhost:9999`
4. Restart VSCode after application starts

**Option 3: Alternative Monitoring**
Use HTTP endpoints instead of JMX:
- Health: http://localhost:8081/actuator/health
- Metrics: http://localhost:8081/actuator/metrics  
- Beans: http://localhost:8081/actuator/beans
- Environment: http://localhost:8081/actuator/env

### JMX Connection Issues
If you see JMX connection errors:
1. Check if the port is already in use: `netstat -an | findstr 9999`
2. Verify firewall settings
3. Ensure JMX is enabled in configuration
4. Try using 127.0.0.1 instead of localhost

### Port Conflicts
If JMX ports are in use:
1. Change the port numbers in `.env` file
2. Update the launch configuration accordingly
3. Or kill the processes using those ports: `taskkill /f /im java.exe`

## Usage Examples

### Check Application Health
```bash
curl http://localhost:8081/actuator/health
```

### Get Application Info
```bash
curl http://localhost:8081/actuator/info
```

### View Metrics
```bash
curl http://localhost:8081/actuator/metrics
curl http://localhost:8081/actuator/metrics/jvm.memory.used
```
