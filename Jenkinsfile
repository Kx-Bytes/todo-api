pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building the application...'
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                echo 'Running unit tests...'
                sh 'mvn test'
            }
        }

        stage('Package Docker Image') {
            steps {
                echo 'Packaging the app into a Docker image...'
                sh 'docker build -t todo-api .'
            }
        }

        stage('Run Docker Container') {
            steps {
                echo 'Running the Docker container...'
                sh 'docker run -d -p 9000:9000 --name todo-container todo-api'
            }
        }
    }
}