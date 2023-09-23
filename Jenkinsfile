pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Check out the specific Git repository
                script {
                    def scmVars = checkout([
                        $class: 'GitSCM',
                        branches: [[name: 'main']], // Replace with your branch name
                        doGenerateSubmoduleConfigurations: false,
                        extensions: [
                            [$class: 'CloneOption', noTags: false, shallow: false, depth: 0, reference: '', honorRefspec: false],
                            [$class: 'PruneStaleBranch'],
                            [$class: 'CleanCheckout'],
                        ],
                        submoduleCfg: [],
                        userRemoteConfigs: [[url: 'https://github.com/wassimbnh/pipeline-test.git']] // Replace with your Git repository URL
                    ])
                }
            }
        }

        stage('Build') {
            steps {
                // Build your Spring Boot project using Maven
                sh 'mvn clean package'
            }
        }
    }
}


