#!/user/bin/env groovy

// @Library('jenkins-shared-library')
library identifier: 'jenkins-shared-library@main',
        retriever: modernSCM(
            [$class: 'GitSCMSource',
             remote: 'https://github.com/YuqiangZhang/jenkins-shared-library',
             credentialsId: 'york-github-credentials'])

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
                        buildImg '0yorkzhang0/demo-app:jma-4.0'
                        dockerLogin()
                        dockerPush '0yorkzhang0/demo-app:jma-4.0'
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

