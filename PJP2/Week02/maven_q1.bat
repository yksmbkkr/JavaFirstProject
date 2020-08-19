@Echo Off
echo Phase:Plugin Description:Goal
echo.
echo.
cd learn-maven
call mvn help:describe -Dcmd=deploy
echo.
echo Done. 
pause >nul