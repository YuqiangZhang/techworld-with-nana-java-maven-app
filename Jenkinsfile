#!/user/bin/env groovy

@Library('jenkins-shared-library')
def gv


pipeline {
    agent any
    tools {
        maven 'Maven-3.9'
    }

    stages {
        stage('init') {
            steps {
                script {
                    gv = load 'script.groovy'
                }
            }
        }

        stage('build jar') {
            steps {
                script {
                    buildJar()
                }
            }
        }

        stage('build image') {
            steps {
                script {
                        buildImg '0yorkzhang0/demo-app:jma-3.0'
                    }
                }
            }
        
        stage('deploy') {
            steps {
                script {
                    echo 'deploying the app...'
                }
            }
        }
    }
}

