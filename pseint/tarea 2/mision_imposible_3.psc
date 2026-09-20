Algoritmo mision_imposible_3
	Definir distancias, ruta Como Entero
	Dimension distancias[5,5]
	Dimension ruta[5]
	
	Para i = 1 Hasta 5 Hacer
		Para j = 1 Hasta 5 Hacer
				distancias[i,j] = Aleatorio(1, 20) //distancia random de 1 a 20 ya que no quiero ingresar datos
		FinPara
	FinPara
	

	Para i = 1 Hasta 5 Hacer
		Escribir "ingrese el primer punto a visitar (punto de 1 al 5) :"
		Leer ruta[i]
	FinPara
	
	Para i <- 1 Hasta 4 Hacer
		punto_origen = ruta[i]
		punto_destino = ruta[i+1]
		
		distancia_total = distancia_total + distancias[punto_origen, punto_destino]
		
		Escribir "de punto ", punto_origen, " hacia punto", punto_destino, "el total en kilometros es igual a: ", distancias[punto_origen, punto_destino], " km."
	FinPara

	Escribir "la distancia total es igual a: ", distancia_total, " km."
	
FinAlgoritmo