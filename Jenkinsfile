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

        stage('Test') {
            steps {
                // Run unit tests and other testing tasks
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                // Here, you would typically deploy the application to your environment
                // This could involve copying the JAR file to a server or deploying to a cloud platform

                // Example: Deploy to a Tomcat server (replace with your actual path)
                sh 'cp target/your-app-name.jar /path/to/your/tomcat/webapps/'

                // You may also need to restart your server or perform other deployment tasks
                // Example: Restart Tomcat
                sh 'sudo systemctl restart tomcat'
            }
        }
    }

    
}
