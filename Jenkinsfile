pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Clean and install the project
                //Se salta los TESTS en la instalacion ya que lo hara despues. 
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Start API') {
            steps {
                // Change directory to target
                dir('target/') {
                    // Run the jar in background and set port to 8081
                    //Luego de la instalacion, le decimos que se dirija a la carpeta target/ 
                    // Y que busque el .jar que se creo para ejecutarlo en el puerto 8081 en 2do plano. 
                    sh 'java -jar App-de-Prueba.jar  &'
                }
            }
        }
        stage('Wait') {
            steps {
                // Wait for 30 seconds before running the load test
                sh 'sleep 30'
            }
        }
        stage('Load test') {
            steps {
                //
                 sh 'mvn test -Dbrowser=chrome'
            }
        }

    }
}

