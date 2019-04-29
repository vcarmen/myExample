pipeline {
    agent {
        dockerfile true
    }
    stages {
        stage('Examples') {
            steps {
                echo "Hello Class"
            }
        }
        stage('Verify if project copied') {
            steps {
                sh 'ls -la /data'
            }
        }
        stage('build') {
            steps {
                sh './gradlew build'
                sh 'ls -la /data/build/**'
                sh 'touch build/test-results/*.xml'
                junit 'build/test-results/*.xml'
            }
        }
    }

}