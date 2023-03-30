def call() {
    echo "Building the Docker Image"
    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'pass', usernameVariable: 'user')]){
        sh 'docker build -t anmol0503/docker-prac:2.0 .'
        sh "echo $pass | docker login -u $user --password-stdin"
        sh 'docker push anmol0503/docker-prac:2.0'
}