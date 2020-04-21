pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'ls -la'
                sh 'echo building'
            }
        }
        stage('SonarQube'){
            steps {
                sh 'echo running sonarqube scan'
            }
        }
        stage('DeployToDev'){
            environment {
                DEV_HOME='/deployments/dev'
            }
            steps {
                sh 'echo $DEV_HOME'
                sh 'echo docker-compose down,clean DeleteDirs'
                sh 'echo copy the install directory Dockerfile, docker-compose.yalm'
                sh 'echo deploying to Dev'
            }
        }
        stage('RunAceptanceTest'){
            steps {
                sh 'echo run aceptance tests'
            }
        }
        stage('PublishArtifacts'){
            steps{
                sh 'echo publish to artifactory'
            }
        }
        stage('PushToDockerHub'){
            steps{
                sh 'echo tag properly the image'
                sh 'echo push to docker hub'
            }
        }
        stage('DeployToQA'){
            environment {
                QA_HOME='/deployments/qa'
            }
            steps{
                sh 'echo $QA_HOME'
                sh 'echo clean docker-compose down, delete'
                sh 'echo copy the install directory docker image, docker-compose-qa.yalm'
                sh 'echo deploying to QA'
                sh 'echo deploy docker-compose-qa.yaml'
            }
        }
        stage('RunAutomationTest'){
            steps {
                sh 'echo run automation tests'
            }
        }     
    }
    post {
        always{
            cleanWs()
        }
    }
}
