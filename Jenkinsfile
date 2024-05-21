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
        stage('test') {
            steps {
                echo 'second stage added'
                sh 'echo Integrating Jenkins Pipeline with GitHub Webhook using Jenkinsfile'
            }
        }
        stage('ALL TEST RUN') {
                    steps {
                        // Get some code from a GitHub repository
                        git 'https://github.com/hakantektas/appium-parallel-test.git'

                        // Run Maven on a Unix agent.
                        sh "https://github.com/hakantektas/appium-parallel-test.git"

                        // To run Maven on a Windows agent, use
                        // bat "mvn -Dmaven.test.failure.ignore=true clean package"
                    }

                    post {
                        // If Maven was able to run the tests, even if some of the test
                        // failed, record the test results and archive the jar file.
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
                stage('Search Test') {
                    steps {
                        // Get some code from a GitHub repository
                        git 'https://github.com/hakantektas/appium-parallel-test.git'

                        // Run Maven on a Unix agent.
                        sh "mvn test -DdeviceName="emulator-5554" -DplatformVersion="10.0" -Dapp="./app/sample.apk" -Dudid="emulator-5554" -Dport="4723" -Dtest=com.example.project.ParallelTestAndroid"

                        // To run Maven on a Windows agent, use
                        // bat "mvn -Dmaven.test.failure.ignore=true clean package"
                    }
                }
    }
}