/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/
job("test_php_here") {
    
    container(displayName="Say Hello", image = "composer") {
        resources {
            cpu = 1.cpu
            memory = 2000.mb
        }
            env["TEST_PARAM"] = Params("test_param")
        	env["THIS_IS_SECRET"] = Secrets("this_is_secret")
        shellScript {
            content = """
            		echo ${'$'}TEST_PARAM
                    echo ${'$'}THIS_IS_SECRET
                    echo ${'$'}JB_SPACE_WORK_DIR_PATH
                    ls -a
                    php --version

                    composer --version
                    composer install
                    ls -a
                    vendor/bin/phpunit .
                """
        }
    }

    container (displayName="testing ls", image = "ubuntu") {
        shellScript {
            content = """
                    echo Hello World!
                    ls -la
                """
        }
    }
    
    container("openjdk:11") {
        kotlinScript { api ->
            api.space().projects.automation.deployments.start(
                project = api.projectIdentifier(),
                targetIdentifier = TargetIdentifier.Key("to-somewhere"),
                version = "1.0.0",
                // automatically update deployment status based on a status of a job
                syncWithAutomationJob = true
            )
        }
	}
}
