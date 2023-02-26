import jenkins.model.*

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
          println System.getenv("$githubRepo")
          println System.getenv("$githubCredId")
          println "uname -a".execute().text
          """.trims()
        }
      }
    }
  }
}
