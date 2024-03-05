def call() {
    sh 'trivy image mamadoudev/youtube:latest > trivyimage.txt'
}
