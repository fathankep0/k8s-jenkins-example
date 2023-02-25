@library("shared-library@master")_

pipeline {
    agent any
    environment {
        def githubUrl = "api.github.com"
        def githubRepo = "https://github.com/fathankep0/k8s-jenkins-example.git"
        def credentialsId = "github"
        def ansibleCred = ""
        stages {
            stage ('parameters') {
                steps {
                    script {
                        sh """
                        printenv
                        echo githubUrl = "${env.githubUrl}"
                        echo githubRepo = "${env.githubRepo}"
                        echo credentialsId = "${env.credentialsId}"
                        echo ansibleCred = "${env.ansibleCred}"
                        
                        """
                    }
                }
            }
        }
    }
}
