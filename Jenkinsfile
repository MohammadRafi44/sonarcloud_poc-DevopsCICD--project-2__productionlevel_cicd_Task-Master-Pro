pipeline {
    agent any
    
    tools {
        jdk 'jdk17'
        maven 'maven3'
        // docker 'docker-latest'
    }
    
    environment {
        SCANNER_HOME = tool 'sonar-scanner'
        // DOCKERHUB_CREDENTIALS = credentials('jenkins-docker-id')
    }

    stages {
        stage('Git-Checkout') {
            steps {
                checkout changelog: false, poll: false, scm: scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/MohammadRafi44/DevopsCICD--project-2__productionlevel_cicd_Task-Master-Pro.git']])
            }
        }
        
        stage('Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }
        
        stage('Unit-Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('SONARQUBE-ANALYSIS'){
            steps {
                withSonarQubeEnv('sonar') {
                    sh ''' $SCANNER_HOME/bin/sonar-scanner -Dsonar.projectName=taskmaster \
                    -Dsonar.java.binaries=. \
                    -Dsonar.projectKey=taskmaster '''
                }
            }
        }
        stage('Trivy-FS-Scan'){
            steps {
                // sh 'trivy fs --security-checks vuln,config /var/lib/jenkins/workspace/cicd-devops-pipiline'
                sh 'trivy fs --format table -o trivy-fs-report.html .'
            }
        }

        stage('Build'){
            steps {
                sh " mvn package"
            }
        }

        stage('publish-artifact'){
            steps {
                withMaven(globalMavenSettingsConfig: 'settings-maven', jdk: 'jdk17', maven: 'maven3', mavenSettingsConfig: '', traceability: true) {
                   sh 'mvn deploy'
                }
            }
        }
        stage('DOCKER-BUILD'){
            steps {
                script {
                    withDockerRegistry(credentialsId: 'dockerhub-cred', url: 'https://index.docker.io/v1/') {
                        sh "docker build -t mohammadrafi44/taskmaster:latest ."
                    }
                }
            }
        }

        // stage('DOCKER-PUBLISH'){
        //     steps {
        //         withDockerRegistry(credentialsId: 'dockerhub-cred', url: 'https://index.docker.io/v1/') {
        //             sh "docker tag cicd-devops mohammadrafi44/devopscicd-project-1_devops-cicd-main:$BUILD_ID"
        //             sh "docker push mohammadrafi44/devopscicd-project-1_devops-cicd-main:$BUILD_ID"
        //         }
        //     }
        // }
        // stage("DOCKER-IMAGE-CLEANUP"){
        //     steps {
        //         script {
        //             echo 'docker images cleanup started'
        //             sh 'docker system prune -af'
        //             echo 'docker images cleanup finished'
        //         }
        //     }
        // }
        // stage("K8S-DEPLOY"){
        //     steps {
        //         script {
        //             withKubeConfig(caCertificate: '', clusterName: 'kubernetes', contextName: '', credentialsId: 'k8s-token-for-jenkins', namespace: 'jenkins', restrictKubeConfigAccess: false, serverUrl: 'https://172.31.37.170:6443') {
        //                 sh "sed -i 's|mohammadrafi44/devopscicd-project-1_devops-cicd-main:.*|mohammadrafi44/devopscicd-project-1_devops-cicd-main:${BUILD_ID}|' deploymentservice.yaml"
        //                 sh "kubectl apply -f deploymentservice.yaml"
        //                 sleep 20
        //             }
        //         }
        //     }
        // }
        // stage("VERIFY-DEPLOYMENT"){
        //     steps {
        //         script {
        //             withKubeConfig(caCertificate: '', clusterName: 'kubernetes', contextName: '', credentialsId: 'k8s-token-for-jenkins', namespace: 'jenkins', restrictKubeConfigAccess: false, serverUrl: 'https://172.31.37.170:6443') {
        //                 sh "kubectl get pods"
        //                 sh "kubectl get svc"
        //             }
        //         }
        //     }
        // }
    }
}
