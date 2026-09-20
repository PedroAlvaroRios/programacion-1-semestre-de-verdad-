/*
16-	Estadísticas de Curso: Leer las notas de una cantidad N de estudiantes.
Al finalizar, mostrar el promedio del curso, la nota más alta, la nota más baja y el porcentaje de aprobados.
*/

import java.util.Scanner;

public class tarea4_16 {
    public static void main(String[] args) {

        double nota_mayor = 0;       //usare esto para ver quien tiene la mayor nota
        double nota_menor = 100;     //usare esto para ver quien tiene la peor nota
        int aprobados = 0;
        double suma_promedios = 0;      //lo invoco para que no me de problemas al sumar multiples veces

        Scanner teclado = new Scanner(System.in); //optimizamos el escaner para evitar reutilizar e invocar un escaner demasido

        System.out.println("Ingrese el numero de estudiantes:");
        int estudiantes_num = teclado.nextInt();

        System.out.println("Ingrese el numero de notas por estudiante:");
        int notas_num = teclado.nextInt();

        //aquí pondré mi almacén de datos
        double[] promedios = new double[estudiantes_num]; //double[] funciona como un array donde podras almacenar muchos datos, un array basicamente


        for (int i = 1; i <= estudiantes_num; i++) {
            double suma = 0;

            for (int j = 1; j <= notas_num; j++) {
                System.out.println("ingrese el las notas del estudiante " + i);
                double nota_ingresada = teclado.nextDouble();

                suma = suma + nota_ingresada;

            }
            double promedio = suma / notas_num; //aqui se saca el promedio del estudiante
            promedios[i - 1] = promedio;  //aqui invocamos el array promedio con un -1 para que empieze desde el número 0
            suma_promedios = suma_promedios + promedio;

            // de aqui sacaremos al mejor estudiante y al peor estudiante
            if (promedio > nota_mayor) //utilizamos nota_mayor y no 0 para que pueda leer multiples veces y reempalazar si encuentra un mejor candidato
                nota_mayor = promedio;

            if (promedio < nota_menor)
                nota_menor = promedio;

            // contamos cuantos aprueban aprobados
            if (promedio >= 51)
                aprobados++;

            // aqui mandamos a ver si esta aprobado o reprobado o pasa a segunda instancia
            String estado;
            if (promedio >= 51)
                estado = "Aprobado";
            else if (promedio >= 40)
                estado = "Segunda instancia";
            else
                estado = "Reprobado";

            System.out.println("La nota promedio del estudiante " + i + " es " + promedio + " y este su estado es: " + estado);

        }
        //estadísticas generales del curso
        double promedio_curso = suma_promedios / estudiantes_num; //sumamos todos los promedio y los dividimos por la cantidad de estudiantes
        double aprobados_porcentaje = ((double) (aprobados / estudiantes_num) * 100); //utilizamos un double dentro de la ecuacion por si esque sale un decimal antes de tiempo

        System.out.println("el promedio del curso es: " + promedio_curso);
        System.out.println("la mejor nota es: " + nota_mayor);
        System.out.println("la nota mas baja es: " + nota_menor);
        System.out.println("han aprobado " + aprobados + " de " + estudiantes_num + " estudiantes");
        System.out.println("el porcentaje de aprobados es: " + aprobados_porcentaje);
    }
}