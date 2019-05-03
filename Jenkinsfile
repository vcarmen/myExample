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
        stage('SonarQube - Gradle') {
            steps {
                sh 'echo Sonar Analysis'
                /*'./gradlew sonarqube \
                        -Dsonar.projectKey=vcarmen_myExample \
                        -Dsonar.organization=vcarmen-github \
                        -Dsonar.host.url=https://sonarcloud.io \
                        -Dsonar.login=8ec75efdc743b51295d9243a127f322d66abc7e9'*/
            }
        }
    }

}
//https://www.youtube.com/watch?v=y-Oz9lBYsH8
//https://gist.github.com/merikan/228cdb1893fca91f0663bab7b095757c
//https://jenkins.io/doc/pipeline/steps/sonar/