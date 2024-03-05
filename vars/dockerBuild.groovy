def call(String dockerHubUsername, String imageName) {
    // Build the Docker image
    sh "docker build --build-arg REACT_APP_RAPID_API_KEY=a16484f704msh1d544d09b252e05p1b1054jsn4aafc2eb9adf -t ${imageName} ."
     // Tag the Docker image
    sh "docker tag ${imageName} ${dockerHubUsername}/${imageName}:latest"
    // Push the Docker image
    withDockerRegistry([url: 'https://index.docker.io/v1/', credentialsId: 'docker-cred']) {
        sh "docker push ${dockerHubUsername}/${imageName}:latest"
    }
}
