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
                echo "Hello World 2"
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

                    post {
                        // If Maven was able to run the tests, even if some of the test
                        // failed, record the test results and archive the jar file.
                        always {
                            // Allure raporlarını göster
                            allure([
                                includeProperties: false,
                                jdk: '',
                                properties: [],
                                reportBuildPolicy: 'ALWAYS',
                                results:[dir('target/allure-results')]
                            ])
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
        stage('Generate') {
            steps {
                echo 'second stage added'
                sh 'echo Integrating Jenkins Pipeline with GitHub Webhook using Jenkinsfile'
                // Allure raporlarını oluşturmak için Allure'ı yükle ve testleri çalıştır
                sh 'mvn io.qameta.allure:allure-maven:serve'
            }
        }
    }

}