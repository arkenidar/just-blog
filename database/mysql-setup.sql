-- MySQL Database Setup Script for Just Blog Application

-- Create database
CREATE DATABASE IF NOT EXISTS justblog 
CHARACTER SET utf8mb4 
COLLATE utf8mb4_unicode_ci;

-- Use the database
USE justblog;

-- Create user (optional - for production)
-- CREATE USER IF NOT EXISTS 'justblog_user'@'localhost' IDENTIFIED BY 'your_secure_password';
-- GRANT ALL PRIVILEGES ON justblog.* TO 'justblog_user'@'localhost';
-- FLUSH PRIVILEGES;

-- The blog_posts table will be automatically created by Hibernate
-- But here's the schema for reference:
--
-- CREATE TABLE blog_posts (
--     id BIGINT AUTO_INCREMENT PRIMARY KEY,
--     title VARCHAR(255) NOT NULL,
--     content TEXT NOT NULL,
--     author VARCHAR(255) NOT NULL,
--     created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
--     updated_at TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
-- );
