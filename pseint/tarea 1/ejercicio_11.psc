Algoritmo ejercicio_11
	Escribir "por favor introduzca el momento del dia con una letra (m:mañana t:tarde n:noche)"
	Leer hora
	Si hora="n" Entonces //aqui
		hora <- 'buenas noches,'
	SiNo
		Si hora="t" Entonces
			hora <- 'buenas tardes,'
		SiNo
			hora <- 'buenos dias,'
		FinSi
	FinSi
	Escribir 'por favor introduzca su sexo con una letra (m:masculino f:femenenino)'
	Leer sexo
	Si sexo="m" Entonces //aqui
		sexo <- 'señor'
	SiNo
		sexo <- 'señora'
	FinSi
	Escribir hora, sexo
FinAlgoritmo

//tomar en cuenta poner entre comillas para que pueda "leer" el texto como una variable de caracter