/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/
job("test_php_here") {
    container(displayName="Say Hello" , image = "php:8.1.5-fpm") {
    	shellScript {
        	content = """
        		echo hello
                echo world!!
                ls -a
                php --version
                composer --version
                composer install
                vendor/bin/phpunit .
            """
        }
    }
}
