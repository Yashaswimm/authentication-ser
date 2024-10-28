pipeline {
    agent any

    tools {
        maven 'my-maven'
        jdk 'my-jdk'
    }

    stages {
        stage('Clone') {
            steps {
                git url: 'https://github.com/Yashaswimm/authentication-ser.git', branch: 'master'
            }
        }
        stage('Build') {
            steps {
                bat "mvn clean install -DskipTests"
            }
        }
        stage('Test') {
            steps {
                bat "mvn test"
            }
        }
        stage('Deploy') {
            steps {
                bat "docker build -t authentication-service ."
                bat "docker run -p 8789:8789 -d --name authentication-sr authentication-service"
            }
        }
    }
} 


