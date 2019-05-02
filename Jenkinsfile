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
        } //with gradle
        /*stage('SonarQube - Gradle') {
            steps {
                sh './gradlew sonarqube \
                        -Dsonar.projectKey=vcarmen_myExample \
                        -Dsonar.organization=vcarmen-github \
                        -Dsonar.host.url=https://sonarcloud.io \
                        -Dsonar.login=8ec75efdc743b51295d9243a127f322d66abc7e9'
            }
        }*/ //with jenkins

        stage("build & SonarQube analysis") {
            agent any
            steps {
                sh './gradlew sonarqube \
                        -Dsonar.projectKey=vcarmen_myExample \
                        -Dsonar.organization=vcarmen-github \
                        -Dsonar.host.url=https://sonarcloud.io \
                        -Dsonar.login=8ec75efdc743b51295d9243a127f322d66abc7e9'
                }
        }

        stage("Quality Gate") {
            agent any
            steps {
                timeout(time: 1, unit: 'MINUTES') {
                waitForQualityGate abortPipeline: true
                }
            }
        }
    



    }

}