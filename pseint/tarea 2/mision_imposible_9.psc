Algoritmo mision_imposible_9
	
	Definir agentes, dificultad Como Entero


	Escribir "ingrese el numero de agentes que participaran en la mision:"
	Leer agentes

	Escribir "ingrese el nivel de dificultad de la mision en una escala del 1 al 10:"
	Leer dificultad

	mascaras = agentes
	explosivos = dificultad * 2
	rastreadores = agentes + dificultad
		
	Escribir "Mascaras necesarias:     ", mascaras
	Escribir "Explosivos necesarios:   ", explosivos
	Escribir "Rastreadores necesarios: ", rastreadores

Fin Algoritmo