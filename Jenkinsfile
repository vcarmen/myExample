pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'ls -la'
                sh 'echo stage1-step1'
            }
        }
    }
    post {
        always{
            cleanWs()
        }
    }
}
