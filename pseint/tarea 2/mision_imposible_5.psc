Algoritmo mision_imposible_5		
	
		clave="IMF2023"
		intentos=3
		
		Escribir "ingresa el codigo de activacion del dispositivo:"
		Leer codigo_ingresado
		
		Mientras codigo_ingresado <> clave y intentos > 1 Hacer
			intentos=intentos - 1
			Escribir "codigo incorrecto. Intentos restantes: ", intentos
			Leer codigo_ingresado
		Fin Mientras
		
		Si codigo_ingresado = clave Entonces
			Escribir "contraseña aceptada, activando dispositivo."
		Sino
			Escribir "muchos intentos fallidos, bloqueando dispositivo."
		Fin Si
		
	Fin Algoritmo