Algoritmo mision_imposible_6
	
    total_distancia = 0
    numero_saltos = 0
	
    Escribir "Ingresa la longitud de cada salto en metros (ingrese el numero 0 para detener la cuenta):"
	
    Leer salto
	
    Mientras salto <> 0 Hacer
        Si salto > 0 Entonces
            total_distancia = total_distancia + salto
            numero_saltos = numero_saltos + 1
        Fin Si
        Leer salto
    Fin Mientras
	
    Escribir "has saltado: " ,numero_saltos, " veces y recorriste: " ,total_distancia, " metros"
	
Fin Algoritmo