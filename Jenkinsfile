pipeline {
    agent any
    tools {
        maven 'Maven-3.9'
    }

    stages {
            stage('increment version') {
                steps {
                    script {
                        echo 'incrementing app version...'
                        sh '''
                            mvn build-helper:parse-version versions:set -DnewVersion=\${parsedVersion.majorVersion}.\${parsedVersion.minorVersion}.\${parsedVersion.nextIncrementalVersion} versions:commit
                        '''
                        def matcher = readFile('pom.xml') =～ '<version>(.+)</version>'
                        env.IMAGE_NAME = matcher[0][1] + '-' + env.BUILD_NUMBER
                    }
                }
            }

            stage('build app') {
                steps {
                    script {
                        echo 'building the application..'
                        sh 'mvn clean package'
                    }
                }
            }
        
            stage('build image') {
                steps {
                    script {
                        echo 'building the docker image...'
                        withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'DOCKER_PASS', usernameVariable: 'DOCKER_USER')]) {
                            sh """
                                docker build -t 0yorkzhang0/demo-app:${env.IMAGE_NAME} .
                                echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin
                                docker push 0yorkzhang0/demo-app:${env.IMAGE_NAME}
                            """
                        }
                    }
                }
            }

            stage('deploy') {
                steps {
                    script {
                        echo 'Deploying the application...'
                    }
                }
            }
    }
}