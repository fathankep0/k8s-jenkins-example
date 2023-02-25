import jenkins.model.*
def instance = Jenkins.getInstance()
pipeline {
  agent any
  environment {
    def githubRepo = "https://github.com/fathankep0/k8s-jenkins-example"
    def githubCredId ="github"
  }
  stages {
    stage ('preperation shared-library') {
      steps {
        script {
          sh """
          printenv | sort
          println "githubRepo = ${env.githubRepo}."
          println "githubCredId = ${env.githubCredId}."
          """
        }
      }
    }
  }
}
