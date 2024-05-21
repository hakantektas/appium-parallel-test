pipeline {
    agent any
    tools {
            // Install the Maven version configured as "M3" and add it to the path.
            maven "Maven 3.9.3"
        }
    stages {
        stage('build') {
            steps {
                echo "Hello World"
                sh 'echo using shell within Jenkinsfile'
                echo 'not using shell in the Jenkinsfile'
            }
        }
        stage('ALL TEST RUN') {
                    steps {
                        // Get some code from a GitHub repository
                        git 'https://github.com/hakantektas/appium-parallel-test.git'

                        // Run Maven on a Unix agent.
                        sh "mvn test -Dsurefire.suiteXmlFiles=/Users/hakantektas/appium-parallel-test/testng.xml"

                        // To run Maven on a Windows agent, use
                        // bat "mvn -Dmaven.test.failure.ignore=true clean package"
                    }
                    steps {
                        script {
                                allure([
                                        includeProperties: false,
                                        jdk: '',
                                        properties: [],
                                        reportBuildPolicy: 'ALWAYS',
                                        results: [[path: 'target/allure-results']]
                                ])
                            }
                        }
                    post {
                        always {
                            testNG()
                            publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: './target/surefire-reports/', reportFiles: 'index.html', reportName: 'HTML Report ALL TEST CASE', reportTitles: '', useWrapperFileDirectly: true])
                            mail subject: 'TEST RESULT', body: 'test', bcc: '', cc: '', from: 'hakan.tektas@mobven.com', replyTo: '', to: 'muh.hakantektas@gmail.com'
                        }
                        failure{
                            echo "test fail"
                        }
                        success{
                            echo "test başarılı"
                        }
                    }
                }

        stage('Generate Reporter') {
            steps {
                echo 'second stage added'
                sh 'echo Integrating Jenkins Pipeline with GitHub Webhook using Jenkinsfile'
                // Allure raporlarını oluşturmak için Allure'ı yükle ve testleri çalıştır
                sh 'allure serve'
            }
        }
    }
}