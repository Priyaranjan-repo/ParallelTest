# ParallelExecute

This is sample project used to execute same testcases on differnt browser at same time



create mvn project
run parallel execution
run by testng.xml
run by mvn test (Call testng in pom.xml)
run by cmd
run by bat
run by windows schedular

--------------------------------------Create bat file------------------------------------------


@echo on
SET PROJECT_PATH=C:\Users\Alkesh\eclipse-workspace\MavenParallel

cd  %PROJECT_PATH%

call mvn clean
call mvn test

pause
-------------------------------------------------------------------------------------------------

