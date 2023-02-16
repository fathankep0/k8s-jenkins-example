node {
    stage('Preparation') { // for display purposes
        // Get some code from a GitHub repository
        git credentialsId: 'github', url: 'https://github.com/fathankep0/k8s-jenkins-example.git'
        // Get the Maven tool.
        // ** NOTE: This 'M3' Maven tool must be configured
        // **       in the global configuration.
    }
    stage('maven test package') {
        // Run the maven build
        def mvnHome = tool name: 'maven', type: 'maven'
        
        withEnv(["MVN_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh "${mvnHome}/bin/mvn -Dmaven.test.failure.ignore clean package"
            }
        }
    }
    stage ('build Image') {
        sh "docker build -t fathandocker/example:${BUILD_NUMBER} ."
    }
    stage ('docker Push Image') {
        withCredentials([string(credentialsId: 'Docker-PWD', variable: 'DockerHub')]) {
            sh "docker login -u fathandocker -p ${DockerHub}"
        }
    }
}
