pipeline {
    agent any
    
    environment{
        DOCKER_IMAGE_NAME = 'mini-calculator'
        GITHUB_REPO_URL = 'https://github.com/doped-semiconductor/mini-scientific-calculator.git'
    }

    stages {
        stage('Git Clone') {
            steps {
                git branch: 'main', url: "${GITHUB_REPO_URL}"
            }
        }
        stage('Maven Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        
        stage('Maven Test') { 
            steps {
                sh 'mvn test' 
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
        }
        stage('Docker Build') {
            steps {
                script{
                    docker.build("${DOCKER_IMAGE_NAME}:${BUILD_NUMBER}", '.')
                }
            }
        }
        stage('Docker Push') {
            steps {
                script{
                    docker.withRegistry('', 'docker-hub-getsreya') {
                        sh 'docker tag %DOCKER_IMAGE_NAME%:%BUILD_NUMBER% getsreya/%DOCKER_IMAGE_NAME%:latest'
                        sh 'docker push getsreya/%DOCKER_IMAGE_NAME%'
                    }
                 }
            }
        }
    }
}
