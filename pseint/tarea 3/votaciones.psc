Algoritmo votaciones
	Escribir 'ingresar la cantidad de votos en unidad de miles (1=1000)'
	Escribir 'ingrese la cantidad de votos que del partido politico a'
	Leer partido_a
	Escribir 'ingrese la cantidad de votos que del partido politico b'
	Leer partido_b
	Escribir 'ingrese la cantidad de votos que del partido politico c'
	Leer partido_c
	Definir porcentaje_a, porcentaje_b, porcentaje_c Como Real
	total_votos <- partido_a+partido_b+partido_c
	porcentaje_a <- (partido_a*100)/total_votos
	porcentaje_b <- (partido_b*100)/total_votos
	porcentaje_c <- (partido_c*100)/total_votos
	suma_porcentaje <- porcentaje_a+porcentaje_b+porcentaje_c
	Escribir porcentaje_a
	Escribir porcentaje_b
	Escribir porcentaje_c
	Escribir suma_porcentaje
	Si porcentaje_a>porcentaje_b Y porcentaje_a>porcentaje_c Entonces
		Si porcentaje_b>porcentaje_c Entonces
			Escribir 'el mayor es ', porcentaje_a, ' para el partido politico a, el segundo mayor es ', porcentaje_b, ' para el partido politico b y el menor es ', porcentaje_c, ' para el partido politico c'
			mayor <- porcentaje_a
			medio <- porcentaje_b
			menor <- porcentaje_c
		SiNo
			Escribir 'el mayor es ', porcentaje_a, ' para el partido politico a, el segundo mayor es ', porcentaje_c, ' para el partido politico c y el menor es ', porcentaje_b, ' para el partido politico b'
			mayor <- porcentaje_a
			medio <- porcentaje_c
			menor <- porcentaje_b
		FinSi
	SiNo
		Si porcentaje_b>porcentaje_a Y porcentaje_b>porcentaje_c Entonces
			Si porcentaje_a>porcentaje_c Entonces
				Escribir 'el mayor es ', porcentaje_b, ' para el partido politico b, el segundo mayor es ', porcentaje_a, ' para el partido politico a y el menor es ', porcentaje_c, ' para el partido politico c'
				mayor <- porcentaje_b
				medio <- porcentaje_a
				menor <- porcentaje_c
			SiNo
				Escribir 'el mayor es ', porcentaje_b, ' para el partido politico b, el segundo mayor es ', porcentaje_c, ' para el partido politico c y el menor es ', porcentaje_a, ' para el partido politico a'
				mayor <- porcentaje_b
				medio <- porcentaje_c
				menor <- porcentaje_a
			FinSi
		SiNo
			Si porcentaje_c>porcentaje_a Y porcentaje_c>porcentaje_b Entonces
				Si porcentaje_b>porcentaje_a Entonces
					Escribir 'el mayor es ', porcentaje_c, ' para el partido politico c, el segundo mayor es ', porcentaje_b, ' para el partido politico b y el menor es ', porcentaje_a, ' para el partido politico a'
					mayor <- porcentaje_c
					medio <- porcentaje_b
					menor <- porcentaje_a
				SiNo
					Escribir 'el mayor es ', porcentaje_c, ' para el partido politico c, el segundo mayor es ', porcentaje_a, ' para el partido politico a y el menor es ', porcentaje_b, ' para el partido politico b'
					mayor <- porcentaje_c
					medio <- porcentaje_a
					menor <- porcentaje_b
				FinSi
			FinSi
		FinSi
	FinSi
	Escribir 'chekeando el primer mayor con el segundo mayor para comprobar si habra o no segunda ronda'
	Si mayor>medio+20 Entonces
		Escribir 'ganador absoluto'
	SiNo
		Escribir 'se va a segunda ronda'
	FinSi
	diferencia <- mayor-menor
	Escribir 'la diferencia en porcentaje entre el que recibio mas votos y el que recibio menos votos es: ', diferencia
FinAlgoritmo
