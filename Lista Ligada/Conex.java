01
import java.net.*;
02
 
03
import java.io.*;
04
 
05
/**
06
 
07
*
08
 
09
* @author Jorge V
10
 
11
*/
12
 
13
public class Conex {
14
 
15
final int PUERTO=5000;
16
 
17
ServerSocket sc;
18
 
19
Socket so;
20
 
21
DataOutputStream salida;
22
 
23
String mensajeRecibido;
24
 
25
//SERVIDOR
26
 
27
public void initServer()
28
 
29
{
30
 
31
BufferedReader entrada;
32
 
33
try
34
 
35
{
36
 
37
sc = new ServerSocket(PUERTO );/* crea socket servidor que escuchara en puerto 5000*/
38
 
39
so=new Socket();
40
 
41
System.out.println("Esperando una conexión:");
42
 
43
so = sc.accept();
view source
01
//Inicia el socket, ahora esta esperando una conexión por parte del cliente
02
 
03
System.out.println("Un cliente se ha conectado.");
04
 
05
//Canales de entrada y salida de datos
06
 
07
entrada = new BufferedReader(new InputStreamReader(so.getInputStream()));
08
 
09
salida = new DataOutputStream(so.getOutputStream());
10
 
11
System.out.println("Confirmando conexion al cliente....");
12
 
13
salida.writeUTF("Conexión exitosa...n envia un mensaje :D");
14
 
15
//Recepcion de mensaje
16
 
17
mensajeRecibido = entrada.readLine();
18
 
19
System.out.println(mensajeRecibido);
20
 
21
salida.writeUTF("Se recibio tu mensaje.n Terminando conexion...");
22
 
23
salida.writeUTF("Gracias por conectarte, adios!");
24
 
25
System.out.println("Cerrando conexión...");
26
 
27
sc.close();//Aqui se cierra la conexión con el cliente
28
 
29
}catch(Exception e )
30
 
31
{
32
 
33
System.out.println("Error: "+e.getMessage());
34
 
35
}
36
 
37
}
38
 
39
}

