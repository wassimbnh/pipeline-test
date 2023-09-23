pipeline {
    agent any

    environment {
        // Define environment variables as needed
        JAVA_HOME = '/usr/lib/jvm/java-11-openjdk-amd64/'
        MAVEN_HOME = '/opt/apache-maven-3.6.3'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout your source code from version control (e.g., Git)
                checkout scm
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

       
    }

    
}
