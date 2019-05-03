pipeline {
    agent any
    stages {
        stage('Build In DockerContainer') {
            agent {
                dockerfile true
                }
            stages {
                stage('stage1'){
                    steps {
                        sh 'echo stage1-step1'
                    }
                }
                stage('stage2'){
                    steps {
                        sh 'echo stage2-step1'
                    }
                }
                stage('build') {
                    steps {
                        sh './gradlew build'
                        sh 'touch build/test-results/*.xml'
                        junit 'build/test-results/*.xml'
                    }
                } //with gradle
                stage('SonarQube') {
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
        stage('Run on Master') {
            steps {
                sh 'uname -a'
                sh 'pwd'
                sh 'ls -la /tmp'
            }
            steps {
                sh 'docker ps -a'
            }
        }
    }

}
//https://www.youtube.com/watch?v=y-Oz9lBYsH8
//https://gist.github.com/merikan/228cdb1893fca91f0663bab7b095757c
//https://jenkins.io/doc/pipeline/steps/sonar/