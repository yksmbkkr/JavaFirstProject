@Echo Off
echo Build Logs will be saved to file build-logs.txt in this directory.
echo.
echo.
cd learn-maven
call mvn clean install > ../build-logs.txt
echo.
echo Build Logs Saved. Press any key to continue... 
pause >nul