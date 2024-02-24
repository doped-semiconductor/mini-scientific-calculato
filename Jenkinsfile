pipeline {
    agent any
    
    environment{
        DOCKERHUB_CREDENTIALS= credentials('docker-hub-creds')
        DOCKER_IMAGE_NAME = 'mini-calculator'
        GITHUB_REPO_URL = 'https://github.com/doped-semiconductor/mini-scientific-calculator.git'
    }
    
    tools{
        maven 'mvn'
    }

    stages {
        stage('Git Clone') {
            steps {
                git branch: 'main', url: "${GITHUB_REPO_URL}"
            }
        }
        stage('Maven Build') {
            steps {
                script{
                    sh 'mvn clean package'
                }
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
                    sh 'docker build -t ${DOCKER_IMAGE_NAME}:${BUILD_NUMBER} .'
                }
            }
        }
        stage('Docker Push') {
            steps {
                script{
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                    sh 'docker tag ${DOCKER_IMAGE_NAME}:${BUILD_NUMBER} getsreya/${DOCKER_IMAGE_NAME}:latest'
                    sh 'docker push getsreya/${DOCKER_IMAGE_NAME}'
                 }
            }
        }
        stage('Ansible') {
            steps {
                script{
                    sh 'docker rmi -f getsreya/${DOCKER_IMAGE_NAME}'
                    sh 'ansible-playbook -i inventory deploy.yml'
                }
            }
        }
    }
}
