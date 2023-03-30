import com.example.Docker

def call(String imageName) {
    return new Deocker(this).buildDockerImage(imageName)
}