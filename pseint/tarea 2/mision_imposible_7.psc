Algoritmo mision_imposible_7
	
    Dimension edades[11]
    Dimension alturas[11]
	
    Para i = 1 Hasta 10 Hacer
        Escribir "ingrese la edad del sospechoso numero " ,i
        Leer edades[i]
        Escribir "ingrese la altura el sospechoso numero " ,i, " en metros"
        Leer alturas[i]
    Fin Para
	
    Escribir "los siguientes sospechosos encajan en un aproximado:"
	
    Para i = 1 Hasta 10 Hacer
        Si edades[i] >= 30 Y alturas[i] >= 1.75 Entonces
            Escribir "sospechoso ", i, " - Edad: ", edades[i], " - Altura: ", alturas[i]
		SiNo
            Escribir "el sospechoso ", i, " esta limpio"
		FinSi
    Fin Para
	
Fin Algoritmo