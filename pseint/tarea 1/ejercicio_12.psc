Algoritmo ejercicio_12 //REQUIERE OPTIMIZACION
	Escribir "ingrese el 1er valor"
	Leer a
	Escribir "ingrese el 2do valor"
	Leer b
	Escribir "ingrese el 3er valor"
	Leer c
	Si a>b y a>c Entonces
		Si b > c Entonces
			Escribir "el mayor es ", a ,", el segundo mayor es ", b , " y el menor es " c
		SiNo
			Escribir "el mayor es ", a ,", el segundo mayor es ", c , " y el menor es " b
		FinSi
	SiNo
		Si b > a y b > c Entonces
			Si a > c Entonces
				Escribir "el mayor es ", b ,", el segundo mayor es ", a , " y el menor es " c
			SiNo
				Escribir "el mayor es ", b ,", el segundo mayor es ", c , " y el menor es " a
			FinSi
		SiNo
			Si c > a y c > b Entonces
				si b > a Entonces
					Escribir "el mayor es ", c ,", el segundo mayor es ", b , " y el menor es " a
				SiNo
					Escribir "el mayor es ", c ,", el segundo mayor es ", a , " y el menor es " b
				FinSi
			FinSi
		FinSi
	FinSi
FinAlgoritmo
