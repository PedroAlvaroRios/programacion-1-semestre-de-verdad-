Algoritmo mision_imposible_2

    codigo = 7391
    intentos = 5
    desactivada = Falso
	
    Escribir "la bomba esta activa, tiene ", intentos, " intentos para desactivarla."
	
    Mientras intentos > 0 y desactivada = Falso Hacer
		escribir " ingrese la contraseña: "
        Leer intento
		
        Si intento = codigo Entonces
            desactivada = Verdadero
            Escribir "contraseña correcta, desactivando bomba... "
        Sino
            intentos = intentos - 1
            Escribir "contraseña incorrecta, le quedan ", intentos, " intentos restantes"
        Fin Si
    Fin Mientras
	
    Si desactivada = Falso o intentos=0 Entonces
        Escribir "kabooooom!"
    Fin Si
	
Fin Algoritmo