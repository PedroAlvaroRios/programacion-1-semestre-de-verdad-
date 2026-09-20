Algoritmo mision_imposible_8
	
    Definir nivel Como Entero
	
    Escribir "Ingresa el nivel de amenaza (en una escala del 1 al 10):"
    Leer nivel

	Si nivel > 7 Entonces
		Escribir "evacuar inmediatamente las instalaciones ASAP"
	Sino 
		Si nivel >= 4 Entonces
			Escribir "neutralizar inmediatamente a la amenaza"
		Sino
			si nivel < 4
				Escribir "observar y analizar al objetivo"
			SiNo
				Escribir "nivel de amenaza no reconocida"
			FinSi
		Fin Si
	FinSi
	
Fin Algoritmo 