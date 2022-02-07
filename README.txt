/**
* Prueba Práctica Flowingsoft
* Solución Problema 1 con Java Spring
* Fuente de información para la comprensión del problema: World_Time_Zones_Map.png
**/

CUESTIONANTES

	1) Desarrollo de un servicio REST con Node js o Java usando Spring, que pueda ser consumido
	por un WebApp.
	Este servicio REST debe permitir, mediante un comando POST, obtener la hora en formato
	UTC a partir de 2 parámetros enviados al servicio: hora y timezone, (por ejemplo:
	dato1=18:31:45, dato2=-3), deberá devolver la hora calculada, en formato json con la siguiente
	estructura:
	
	DUDAS QUE SURGIERON DURANTE EL DESARROLLO:

	¿El parámetro "hora" está en la "timezone" (2do parámetro) y hay que transformarla en la timezone = 0 (hora mundial)? 
	o 
	¿El parámetro "hora" está en la timesone = 0 (hora mundial) y hay que transformarla a la timezone (2do parámetro)?
	
	SOLUCIÓN SEGÚN CON LA INCERTIDUMBRE

	Se hizo uso de una bandera que oscile ambos casos, esta valiable statica se la encuentra en la clase Tools.RETURN_WORLD_TIME,
	donde false es:
		El parámetro "hora" está en la "timezone" (2do parámetro) y hay que transformarla en la timezone = 0 (hora mundial)
	y true es:
		El parámetro "hora" está en la timesone = 0 (hora mundial) y hay que transformarla a la timezone (2do parámetro)

DATOS TÉCNICOS:
	
	Editor de código: ItelliJ IDEA versión Conmunity Edition 2021.2.2
	springframework versión: 2.6.3
	Versión de java: 11
	Postman (para realizar pruebas post): v9.13.1 
	
TUTORIAL:
	
	- Mediante POST a localhost:8080/api/utctime, mandar los atributos: 
		time=12:45:01  (por ejemplo)
		timezone=1  (por ejemplo)
	- el resultado será:
	  {
    	     "time": "13:45:01",
    	     "timezone": "utc"
	  }

	Nota: En caso de datos inconsistentes, devuelve los datos por defecto;
	 {
    	     "time": "00:00:00",
    	     "timezone": "utc"
	  }
