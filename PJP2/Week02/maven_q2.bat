@Echo Off
echo See The Dependency Tag to understand how to include local repo
echo.
echo.
cd learn-maven
call mvn help:effective-pom
echo.
echo Done. 
echo Press any key to exit
pause >nul