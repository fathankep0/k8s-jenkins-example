node {
    environment {
        REGISTRY = 'fathandocker/k8s-jenkins-example'
        REGISTRY_CREDENTIAL = 'dockerhub-fathandocker'
        VERSION = ''
    }
    stage('Preparation') { // for display purposes
        // Get some code from a GitHub repository
        git credentialsId: 'github-key', url: 'https://github.com/fathankep0/k8s-jenkins-example.git'
        // Get the Maven tool.
        // ** NOTE: This 'M3' Maven tool must be configured
        // **       in the global configuration.

    }
    stage ('test maven') {
        def mvnHome = tool name: 'maven', type: 'maven'
        sh "${mvnHome}/bin/mvn -Dmaven.test.failure.ignore clean package"
    }
    stage ('Checking docker Version') {
        
        withCredentials([string(credentialsId: 'dockerPwd', variable: 'dockerHUb')]) {
    // some block
    }
        sh 'docker --version'
    }
}
