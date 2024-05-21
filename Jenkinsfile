pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo "Hello World"
                sh 'echo using shell within Jenkinsfile'
                echo 'not using shell in the Jenkinsfile'
            }
        }
        stage('test') {
            steps {
                echo 'second stage added'
                sh 'echo Integrating Jenkins Pipeline with GitHub Webhook using Jenkinsfile'
            }
        }
    }
}