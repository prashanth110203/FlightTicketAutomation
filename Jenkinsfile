pipeline {
    agent any
    
    tools {
        maven 'Maven3'
        jdk 'JDK-11'
    }
    
    options {
        timestamps()
        timeout(time: 30, unit: 'MINUTES')
    }
    
    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out code from repository...'
                checkout scm
            }
        }
        
        stage('Clean') {
            steps {
                echo 'Cleaning previous builds...'
                bat 'mvn clean'
            }
        }
        
        stage('Compile') {
            steps {
                echo 'Compiling source code...'
                bat 'mvn compile'
            }
        }
        
        stage('Create Excel File') {
            steps {
                echo 'Creating test data Excel file...'
                bat 'mvn exec:java -Dexec.mainClass="com.blazedemo.utils.ExcelFileCreator"'
            }
        }
        
        stage('Run Tests') {
            steps {
                echo 'Running flight booking automation tests...'
                bat 'mvn test'
            }
        }
    }
    
    post {
        always {
            junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
            archiveArtifacts artifacts: '**/target/surefire-reports/**/*,screenshots/**/*', allowEmptyArchive: true
        }
        
        success {
            echo 'Flight booking automation completed successfully!'
        }
        
        failure {
            echo 'Flight booking automation failed! Check screenshots for details.'
        }
    }
}