Algoritmo notas_promedio
	Escribir "ingrese la cantidad de numeros"
	Leer num
	Dimension notas[num]
	suma=0
	Para n=1 Hasta num Con Paso 1 Hacer
		Escribir " ingrese nota " n, notas[n], ":"
		Leer notas[n]
		suma=suma+n
	Fin Para
	
	promedio= suma/num
	
	Escribir "promedio= " promedio
	Escribir "suma de notas= " suma
	
FinAlgoritmo
