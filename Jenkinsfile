pipeline {
    agent any
    environment {
        DOCKER_IMAGE = "aadilmhusain/scientific-calculator"   // Change to your Docker Hub repository
        DOCKER_USERNAME = "aadilmhusain" // Change to your Jenkins Docker credentials ID
	DOCKER_PASSWORD = "aadildocker123"
    }

    stages {

	stage('Setup Permissions') {
            steps {
                script {
                    sh '
                    echo "Granting permissions to the Jenkins user.."
                    sudo usermod -aG docker jenkins
                    sudo mkdir -p /var/lib/jenkins/.ssh
                    sudo chown -R jenkins:jenkins /var/lib/jenkins/.ssh
                    sudo chmod 700 /var/lib/jenkins/.ssh
                    '
                }
            }
        }	

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
		sh 'sudo docker build -t ${DOCKER_IMAGE} .'
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
