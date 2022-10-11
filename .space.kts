/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/
job("test_php_here") {
    container(displayName="Say Hello" , image = "composer") {
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
