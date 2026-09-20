Algoritmo ejercicio_5
	
	Escribir  "ingrese la cantidad de dias a convertir a segundos"
	Leer dias
	
	Escribir  "ingrese la cantidad de horas a convertir a segundos"
	Leer horas
	
	Escribir "ingrese la cantidad de minutos a convertir a segundos"
	Leer minutos
	
	dias_en_segundos=dias*24*60*60
	horas_en_segundos=horas*60*60
	minutos_en_segundos=minutos*60
	
	Escribir "el total de dias en segundos es: ", dias_en_segundos
	Escribir "el total de horas en segundos es: ", horas_en_segundos
	Escribir "el total de minutos en segundos es: ", minutos_en_segundos
	
	total_segundos=dias_en_segundos+horas_en_segundos+minutos_en_segundos
	
	Escribir "el total de segundos es: " total_segundos
	
FinAlgoritmo