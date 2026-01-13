def buildJar() {
    echo 'building the application'
    sh 'mvn package'
}

def buildImg() {
    echo 'building the docker image...'
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable:'PASS', usernameVariable:'USER')]) {
        sh 'docker build -t 0yorkzhang0/demo-app:jma-2.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push 0yorkzhang0/demo-app:jma-2.0'
    }
}

def deployApp() {
    echo 'deploying the application...'
    echo "deploying the application ${params.VERSION}"
}
return this
