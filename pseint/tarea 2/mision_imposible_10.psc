Algoritmo mision_imposible_10
		clave = 4872
		intentos = 0
		acceso <- Falso
		
		Mientras intentos < 3 y acceso = Falso Hacer
			intentos = intentos + 1
			Escribir "Intento ", intentos, " - Ingresa la contrasena:"
			Leer clave_ingresada
			
			Si clave_ingresada = clave Entonces
				acceso <- Verdadero
				Escribir "Acceso concedido, cargando datos..."
				Escribir "xd"
			Sino
				Escribir "clave incorrecta, le quedan: ", 3 - intentos " intentos"
			Fin Si
		Fin Mientras
		
		Si acceso = Falso Entonces
			Escribir "hackeo fallido, cerrando sistema..."
		Fin Si
		
FinAlgoritmo
