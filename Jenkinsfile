pipeline {
      agent any 
      stages {
            stage('Docker image build started') { 
				steps {
					git 'https://github.com/pramila-git/docker-report.git'
					//dir ('docker-report'){
					sh "sudo docker build \
						--build-arg url=https://github.com/pramila-git/AutomatedTestReport.git\
						--build-arg path=AutomatedTestReport/testng-test\
						--build-arg folder=reports\
						-t sparktest ."
					sh "sudo docker images"
					// } 
                }
                  
            }   
            stage('Script execution started') {
                steps {
                        sh "sudo docker run --name spark -v $WORKSPACE/reports:/app/target/surefire-reports sparktest"
                }
            }
          
			stage('Delete all the images and containers') {
                steps {
                         sh "sudo docker rm spark"
                         sh "sudo docker rmi -f sparktest"
                }
			}
		}
}
