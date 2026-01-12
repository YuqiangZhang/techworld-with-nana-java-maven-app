def gv

pipeline {
    agent any
    // tools{
    //     // maven "Maven-3.9"
    // }
    parameters {
        // string(name:'VERSION', defaultValue:'', description:'version to deploy on prod')
        choice(name:'VERSION', choices:['1.1.0', '1.2.0', '1.3.0'], description:'')
        booleanParam(name:'executeTests', defaultValue:true, description:'')
    }

    // environment {
    // // NEW_VERSION = '1.3.0'
    // // SERVER_CREDENTIALS = credentials('server-credentials')
    // }
    stages {
        stage('init') {
            steps {
                script {
                    gv = load 'script.groovy'
                }
            }
        }
        stage('build') {
            steps {
                script {
                    gv.buildApp()
                }
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
                    script {
                    gv.testApp()
                    }
                }
            }
                stage('deploy') {
                    input {
                        message 'Select the environment to deploy to'
                        ok 'Done'
                        parameters {
                    choice(name:'ONE', choices:['dev', 'staging', 'prod'], description:'')
                    choice(name:'TWO', choices:['dev', 'staging', 'prod'], description:'')
                        }
                    }
                    steps {
                    script {
                        gv.deployApp()
                        echo "deploying to ${ONE}"
                        echo "deploying to ${TWO}"
                    }
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
