pipeline {
    agent any
    // tools{
    //     // maven "Maven-3.9"
    // }
    parameters{
        // string(name:'VERSION', defaultValue:'', description:'version to deploy on prod')
        choice(name:'VERSION', choices:['1.1.0', '1.2.0', '1.3.0'], description:'')
        booleanParam(name:'executeTests', defaultValue:true, description:'')
    }

    // environment {
    // // NEW_VERSION = '1.3.0'
    // // SERVER_CREDENTIALS = credentials('server-credentials')
    // }
    stages {
        stage('build') {
            steps {
                echo 'building the application...'
            // echo "building version ${NEW_VERSION}"
            }
        }

            stage('test') {
                when {
                    expression {
                        params.executeTests
                    //         BRANCH_NAME == 'dev' || BRANCH_NAME == 'master'
                    }
                }
                steps {
                    echo 'testing the application...'
                }
            }
                stage('deploy') {
                    steps {
                        echo 'deploying the application...'
                        echo "deploying the application ${params.VERSION}"
                    // withCredentials([
                    //     usernamePassword(credentials:'server-credentials', usernameVariable:USER, passwordVariable:PWD)
                    // ]) {
                    //     sh "somescript ${USER} ${PWD}"
                    // }
                    }
                }
    }
        // post {
        //     always {

        //     }
        //     success {

        //     }

        //     failure {

//     }
// }
}
