pipeline {
    agent any
    environment {
        DOCKER_IMAGE = 'yourdockerhub/calculator'   // Change to your Docker Hub repository
        DOCKER_CREDENTIALS = 'docker-credentials-id' // Change to your Jenkins Docker credentials ID
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from GitHub repository
                git 'https://github.com/AadilMdhusain/SPE-Mini-Project.git'
            }
        }

        stage('Build') {
            steps {
                // Run Maven clean and install
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                // Run Maven tests (JUnit tests)
                sh 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                // Build Docker image
                sh 'docker build -t $DOCKER_IMAGE:latest .'
            }
        }

        stage('Docker Push') {
            steps {
                // Docker login using Jenkins credentials
                withCredentials([usernamePassword(credentialsId: '$DOCKER_CREDENTIALS', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    // Docker login command
                    sh 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin'
                    
                    // Push Docker image to Docker Hub
                    sh 'docker push $DOCKER_IMAGE:latest'
                }
            }
        }
    }

    post {
        success {
            echo 'Build and push succeeded!'
        }
        failure {
            echo 'Build or push failed!'
        }
    }
}

