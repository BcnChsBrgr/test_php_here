/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/

job("Hello World!") {
    container(displayName = "Say Hello", image = "hello-world" ) 
    {
        shellScript {
        content = """
        	echo hello!
        """
        }
    }
}
job("Docker and test....") {
    git ("main")
	container (displayName = "Docker build and php version", image= "php:8.1.5-fpm") {
    	shellScript {
        	content = """
            	echo we are currently in 
                pwd
                we are having the below files:
                ls -a
            """
        }
    }
}