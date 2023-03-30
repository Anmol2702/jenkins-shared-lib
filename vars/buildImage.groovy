def call(String imageName) {
    echo "Building the Docker Image"
    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'pass', usernameVariable: 'user')]){
        sh "docker build -t $imageName ."
        sh "echo $pass | docker login -u $user --password-stdin"
        sh "docker push $imageName"
    }
}