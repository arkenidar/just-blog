# VSCode Development Setup

This guide explains how to run and debug the Just Blog Spring Boot application in VSCode.

## Prerequisites

1. **Java 17** or later
2. **Maven** (or use the included Maven wrapper)
3. **VSCode** with Java extensions
4. **MySQL** (or Docker for MySQL)

## Quick Setup

### 1. Install Extensions (Windows)
```bash
setup-vscode.bat
```

### 2. Install Extensions (Linux/Mac)
```bash
chmod +x setup-vscode.sh
./setup-vscode.sh
```

### 3. Manual Extension Installation
Install these essential extensions:
- Extension Pack for Java (vscjava.vscode-java-pack)
- Spring Boot Extension Pack (vmware.vscode-spring-boot)
- Spring Boot Dashboard (vscjava.vscode-spring-boot-dashboard)

## Running the Application

### Method 1: Using Debug Configuration (Recommended)
1. Press `F5` or go to Run & Debug view (`Ctrl+Shift+D`)
2. Select one of these configurations:
   - **"Debug Spring Boot App (MySQL Dev - Persistent)"** - MySQL with persistent data (development)
   - **"Debug Spring Boot App (MySQL Prod)"** - MySQL with persistent data (production)
   - **"Debug Spring Boot App (H2 Memory)"** - H2 in-memory database (quick testing)
3. Click the green play button or press `F5`

### Method 2: Using Tasks
1. Press `Ctrl+Shift+P` to open command palette
2. Type "Tasks: Run Task"
3. Select:
   - **"Spring Boot: Run (MySQL Dev - Persistent)"** - MySQL development with persistent data
   - **"Spring Boot: Run (MySQL Prod)"** - MySQL production mode
   - **"Spring Boot: Run (H2 Memory)"** - H2 in-memory database

### Method 3: Using Spring Boot Dashboard
1. Open the Spring Boot Dashboard (View > Open View > Spring Boot Dashboard)
2. You'll see your application listed
3. Click the play button to run or debug button to debug

## Debugging Features

### Breakpoints
- Click in the gutter (left margin) to set breakpoints
- Red dots indicate active breakpoints
- Debug execution will pause at breakpoints

### Debug Controls
- **Continue (F5)**: Resume execution
- **Step Over (F10)**: Execute next line
- **Step Into (F11)**: Step into function calls
- **Step Out (Shift+F11)**: Step out of current function
- **Restart (Ctrl+Shift+F5)**: Restart debugging session
- **Stop (Shift+F5)**: Stop debugging

### Variables and Watch
- **Variables panel**: View local variables and their values
- **Watch panel**: Add expressions to monitor
- **Call Stack**: See the execution path

## Database Profiles

### Development Profile (MySQL)
- Uses MySQL database with `update` DDL mode
- Database schema is updated incrementally
- **Data persists between application restarts**
- Detailed logging enabled for debugging
- Same database persistence as production but with development-friendly settings

### Production Profile (MySQL)
- Uses MySQL database with `update` DDL mode
- Database schema is updated incrementally
- Data persists between application restarts
- Optimized for performance
- Minimal logging

### H2 Profile (In-Memory)
- Uses in-memory H2 database
- No external database required
- Data is lost when application stops
- H2 console available at: http://localhost:8080/h2-console
- Perfect for quick testing and development without database setup

## Environment Configuration

Edit your `.env` file:
```env
DB_HOST=localhost
DB_PORT=3306
DB_NAME=justblog
DB_USERNAME=your_username
DB_PASSWORD=your_password
```

## Common Tasks

### Start MySQL with Docker
```bash
docker-compose up -d
```

### Clean and Rebuild
- Task: "Maven: Clean"
- Task: "Maven: Compile"
- Task: "Maven: Package"

### Run Tests
- Task: "Maven: Test"
- Or use Test Explorer in VSCode

## Troubleshooting

### Java Extension Issues
1. Open Command Palette (`Ctrl+Shift+P`)
2. Run "Java: Reload Projects"
3. Or "Java: Restart Language Server"

### Port Already in Use
- Change `SERVER_PORT` in `.env` file
- Or kill the process using port 8080:
  ```bash
  netstat -ano | findstr :8080
  taskkill /PID <PID> /F
  ```

### MySQL Connection Issues
1. Ensure MySQL is running
2. Check credentials in `.env` file
3. Verify database exists
4. Check firewall settings

## Hot Reload

The application includes Spring Boot DevTools for hot reload:
- Changes to Java files trigger automatic restart
- Changes to static resources are refreshed automatically
- Changes to templates are refreshed automatically

## Useful Shortcuts

- `F5`: Start debugging
- `Ctrl+F5`: Run without debugging
- `Shift+F5`: Stop debugging
- `Ctrl+Shift+F5`: Restart debugging
- `Ctrl+Shift+P`: Command palette
- `Ctrl+Shift+D`: Debug view
- `Ctrl+Shift+E`: Explorer view
- `Ctrl+` `: Terminal

## Access Points

When running:
- **Application**: http://localhost:8080
- **H2 Console** (h2 profile only): http://localhost:8080/h2-console
  - URL: `jdbc:h2:mem:blogdb`
  - Username: `sa`
  - Password: (empty)

## Profile Summary

| Profile | Database | DDL Mode | Data Persistence | Use Case |
|---------|----------|----------|------------------|----------|
| `dev` | MySQL | update | ✅ Persistent | Development with data persistence |
| `prod` | MySQL | update | ✅ Persistent | Production with persistent data |
| `h2` | H2 Memory | create-drop | ❌ Lost on restart | Quick testing without database setup |
| `test` | H2 Memory | create-drop | ❌ Lost on restart | Unit testing |
