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
                php -r "copy('https://getcomposer.org/installer', 'composer-setup.php');"
				php -r "if (hash_file('sha384', 'composer-setup.php') === '55ce33d7678c5a611085589f1f3ddf8b3c52d662cd01d4ba75c0ee0459970c2200a51f492d557530c71c15d8dba01eae') { echo 'Installer verified'; } else { echo 'Installer corrupt'; unlink('composer-setup.php'); } echo PHP_EOL;"
				php composer-setup.php --install-dir=bin --filename=composer
                php bin/composer --version
				php -r "unlink('composer-setup.php');"
                
                composer --version
                composer install
                vendor/bin/phpunit .
            """
        }
    }
}
