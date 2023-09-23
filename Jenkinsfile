pipeline {
    agent any

    environment {
        // Define environment variables as needed
        JAVA_HOME = '/usr/lib/jvm/java-11-openjdk-amd64/'
        MAVEN_HOME = '/opt/apache-maven-3.6.3'
        DATABASE_URL = 'jdbc:postgresql://localhost:5432/kaddemDataBase'
        DATABASE_USER = 'admin'
        DATABASE_PASSWORD = 'rootage'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout your source code from version control (e.g., Git)
                checkout scm
            }
        }

        stage('Database Migration') {
            steps {
                // Run database migration scripts if needed (e.g., Flyway or Liquibase)
                sh 'mvn flyway:migrate -Dflyway.url=${DATABASE_URL} -Dflyway.user=${DATABASE_USER} -Dflyway.password=${DATABASE_PASSWORD}'
            }
        }

        stage('Build') {
            steps {
                // Set up the environment for building
                sh "export PATH=${JAVA_HOME}/bin:${MAVEN_HOME}/bin:$PATH"

                // Build the Spring Boot application
                sh 'mvn clean package'
            }
        }
        stage('Integration Tests') {
            steps {
                // Run integration tests that interact with the database
                sh 'mvn verify -Ddatabase.url=${DATABASE_URL} -Ddatabase.username=${DATABASE_USER} -Ddatabase.password=${DATABASE_PASSWORD}'
            }
        }
    }
}

