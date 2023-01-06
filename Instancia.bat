@ECHO OFF
cd .
START java -Dserver.port=8080 -classpath ./build/install/mp01/lib/* com.distribuida.Servidor
START java -Dserver.port=9090 -classpath ./build/install/mp01/lib/* com.distribuida.Servidor
START java -Dserver.port=7070 -classpath ./build/install/mp01/lib/* com.distribuida.Servidor
START java -Dserver.port=6060 -classpath ./build/install/mp01/lib/* com.distribuida.Servidor