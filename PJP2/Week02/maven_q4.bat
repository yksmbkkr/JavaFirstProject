@Echo Off
echo Maven build without internet (i.e. in offline mode).
echo.
echo.
cd learn-maven
call mvn clean install -o
echo.
echo Build Complete. Press any key to continue... 
pause >nul