/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/
job("test_php_here") {
    // check-out main
    git("test_php_here")
    container(displayName = "Show dir", image = "amazoncorretto:17-alpine") {
        shellScript {
            content = """
                echo Directory structure
                ls -R /mnt
                echo Working dir is
                pwd
            """
        }
    }
    // If the main repository is 'main-repo', then
    // working dir is /mnt/space/work/main-repo
}
