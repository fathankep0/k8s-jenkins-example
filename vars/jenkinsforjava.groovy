vars
| --- welcomeJob.groovy
| --- jenkinsForJava.groovy
 
// jenkinsForJava.groovy
def call(String repoUrl) {
  pipeline {
       agent any
       tools {
           def mvnHome = tool name: 'maven', type: 'maven'
           tool name: 'JDK-11', type: 'jdk'
       }
       stages {
           stage("Tools initialization") {
               steps {
                   sh "mvn --version"
                   sh "java -version"
               }
           }
           stage("Checkout Code") {
               steps {
                   git branch: 'master',
                       url: "${repoUrl}"
               }
           }
           stage("Cleaning workspace") {
               steps {
                   sh "mvn clean"
               }
           }
           stage("Running Testcase") {
              steps {
                   sh "mvn test"
               }
           }
           stage("Packing Application") {
               steps {
                   sh "mvn package -DskipTests"
               }
           }
       }
   }
}
