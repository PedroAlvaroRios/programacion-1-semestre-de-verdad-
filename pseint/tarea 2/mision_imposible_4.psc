Algoritmo mision_imposible_4
	
    Definir agente_doble Como Logico
	
    Escribir "cuantos agentes hay?"
    Leer agentes
	
    Dimension nombres[agentes+1]
    Dimension claves[agentes+1]
	
    Para i = 1 Hasta agentes Hacer
        Escribir "ingrese el nombre del agente ", i, ":"
        Leer nombres[i]
        Escribir "ingrese la clave del agente ", i, ":"
        Leer claves[i]
    Fin Para
	
    agente_doble = Falso
	
    Para i = 1 Hasta agentes-1 Hacer
        Para j = i+1 Hasta agentes Hacer
            Si claves[i] = claves[j] Entonces
                agente_doble = Verdadero
                Escribir "agente doble detectado: ", nombres[i], " y ", nombres[j], " tienen la misma clave (", claves[i], ")"
            Fin Si
        Fin Para
    Fin Para
	
    Si agente_doble = Falso Entonces
        Escribir "no se detectaron agentes dobles"
    Fin Si
	
Fin Algoritmo