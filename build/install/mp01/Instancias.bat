@ECHO OFF
cd .\build\install\mp01
START java -Dserver.port=7090 -classpath lib/* com.distribuida.Servidor
START java -Dserver.port=8080 -classpath lib/* com.distribuida.Servidor
START java -Dserver.port=2030 -classpath lib/* com.distribuida.Servidor
START java -Dserver.port=9090 -classpath lib/* com.distribuida.Servidor