@echo off
title Aion Lightning Build

CLS
:MENU
ECHO.
ECHO.
ECHO.
ECHO    -----------------------------------------------------------------
ECHO    .             1 - Build All server                              .
ECHO    .             2 - Build Commons server                          .
ECHO    .             3 - Build GameServer server                       .
ECHO    .             4 - Build LoginServer server                      .
ECHO    .             5 - Build ChatServer server                       .
ECHO    .             6 - Build BL-Manager server                       .
ECHO    .             8 - Quit                                          .
ECHO    .                                                               .
ECHO    .             Developed by Aion Lightning                       .
ECHO    -----------------------------------------------------------------
ECHO.
ECHO.
SET /P Ares=Type 1, 2 ,3, 4, 5, 6, 7 or 8 to QUIT, then press ENTER:
IF %Ares%==1 GOTO FULL
IF %Ares%==2 GOTO Commons
IF %Ares%==3 GOTO GameServer
IF %Ares%==4 GOTO LoginServer
IF %Ares%==5 GOTO ChatServer
IF %Ares%==6 GOTO AE-Manager
IF %Ares%==7 GOTO PacketSamurai
IF %Ares%==8 GOTO QUIT
:FULL

cd ..\Commons 
start /WAIT /B ..\Tools\Ant\bin\ant clean dist

cd ..\GameServer
start /WAIT /B ..\Tools\Ant\bin\ant clean dist

cd ..\LoginServer
start /WAIT /B ..\Tools\Ant\bin\ant clean dist

cd ..\ChatServer
start /WAIT /B ..\Tools\Ant\bin\ant clean dist

cd ..\Tools\BL-Manager
start /WAIT /B ..\Ant\bin\ant clean dist
GOTO :QUIT


:Commons
cd ..\Commons 
start /WAIT /B ..\Tools\Ant\bin\ant clean dist
GOTO :QUIT

:GameServer
cd ..\GameServer
start /WAIT /B ..\Tools\Ant\bin\ant clean dist
GOTO :QUIT

:LoginServer
cd ..\LoginServer
start /WAIT /B ..\Tools\Ant\bin\ant clean dist
GOTO :QUIT

:ChatServer
cd ..\ChatServer
start /WAIT /B ..\Tools\Ant\bin\ant clean dist
GOTO :QUIT

:AE-Manager
cd ..\Tools\BL-Manager
start /WAIT /B ..\Ant\bin\ant clean dist
GOTO :QUIT

:QUIT
exit
