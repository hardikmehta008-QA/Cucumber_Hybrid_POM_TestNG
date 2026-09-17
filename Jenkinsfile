pipeline {
    agent any

    tools {
        // Must match the exact name configured in Global Tool Configuration
        maven 'MAVEN_HOME'
        jdk 'JAVA_HOME'
    }

    stages {
        stage('Checkout Code') {
            steps {
                // Pulls code from your Git repository
                checkout scm
            }
        }

        stage('Build & Compile') {
            steps {
                // Compiles the source and test code
                sh 'mvn clean compile'
            }
        }

        stage('Execute Selenium Cucumber Tests') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    // Triggers Cucumber tests via Maven surefire/failsafe plugin
                    // headless mode is required unless running on a grid/node with a display desktop
                    sh 'mvn test -Dbrowser=chrome -Dheadless=true'
                }
            }
        }
    }

    post {
        always {
            // Generates advanced Cucumber HTML reports after the test execution
            cucumber buildStatus: 'FAILURE',
                     failedFeaturesNumber: 0,
                     failedScenariosNumber: 0,
                     failedStepsNumber: 0,
                     fileIncludePattern: '**/target/*.json',
                     trendsLimit: 10,
                     jsonReportDirectory: 'target'

            // Optional: Archive artifacts like screenshots or logs if a test fails
            archiveArtifacts artifacts: 'target/**/*.png', allowEmptyArchive: true
        }
    }
}