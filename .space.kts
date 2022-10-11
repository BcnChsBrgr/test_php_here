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
        shellScript {
            content = """
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
    
}
