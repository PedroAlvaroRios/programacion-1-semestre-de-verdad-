Algoritmo mision_imposible_1

    alfabeto = "abcdefghijklmnopqrstuvwxyz"
	
    Escribir "ingresa el mensaje encriptado (en minusculas):"
    Leer mensaje
	
    largo_mensaje = Longitud(mensaje)
    descifrado = ""
	
    Para leer_men = 1 Hasta largo_mensaje Hacer
        letra = Subcadena(mensaje, leer_men, leer_men)
		
        Para leer_alf = 1 Hasta 26 Hacer
            Si letra = Subcadena(alfabeto, leer_alf, leer_alf) Entonces
                posicion = leer_alf
            Fin Si
        Fin Para
		
        Si posicion > 0 Entonces
            posicion = posicion + 3
            descifrado = descifrado + Subcadena(alfabeto, posicion, posicion)
        Sino
            descifrado = descifrado + letra
        Fin Si
    Fin Para
	
    Escribir "mensaje descifrado es: ", descifrado
	
Fin Algoritmo