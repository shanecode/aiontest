@ECHO off
TITLE Aion Lightning - Game Server Panel
:MENU
CLS
ECHO.
ECHO   ^*-------------------------------------------------------------------------^*
ECHO   ^|                    Aion Lightning - Game Server Panel	                  ^|
ECHO   ^*-------------------------------------------------------------------------^*
ECHO   ^|                             1 - START                                   ^|
ECHO   ^|                             2 - Quit                                    ^|
ECHO   ^|                                                                         ^|
ECHO   ^*-------------------------------------------------------------------------^*
ECHO.
SET /P OPTION=Type your option and press ENTER: 
IF %OPTION% == 1 (
SET MODE=START
SET JAVA_OPTS=-Xms700m -Xmx1512m -Xdebug -Xrunjdwp:transport=dt_socket,address=8998,server=y,suspend=n -ea
CALL StartGS.bat
)
IF %OPTION% == 2 (
EXIT
)
