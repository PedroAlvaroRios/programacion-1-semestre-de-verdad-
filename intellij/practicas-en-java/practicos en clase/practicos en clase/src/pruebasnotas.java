import java.util.Scanner;

public class pruebasnotas
{
    public static void main(String[] arg)
    {
        double nota_mayor = 0;// hacemos que lea 0 para que lea desde el cero
        double nota_menor = 100;//empezamos desde 100, que seria la nota maxima , para que lea desde ste numero
        double acomulador = 0;//acomula notas
        double promedio = 0;
        double nota = 0;
        int contador = 0;//cuenta de estudiantes
        int num_notas= 0;
        double promedio_respaldo= 0;
        Scanner sc = new Scanner(System.in);


        do {
            System.out.println("ingrese la nota");
            nota = sc.nextDouble();//pido notas
            if (nota >= 0) {
                num_notas++;

                acomulador = acomulador + nota;//acomulo las notas
                contador = contador + 1;//incremento la cantidad estudiante

                if (nota > nota_mayor) //utilizamos nota_mayor y no 0 para que pueda leer multiples veces y reempalazar si encuentra un mejor candidato
                    nota_mayor = nota;

                if (nota < nota_menor)
                    nota_menor = nota;
            }
        }while(nota!=-1);
        sc.close();
        if (contador>1)
        {
            promedio = acomulador / contador;
            System.out.println("El promedio es: "+promedio);

            System.out.println("la nota mas alta es: "+nota_mayor);
            System.out.println("la nota mas baja es: "+nota_menor);


        }
        else{
            System.out.println("No existen suficientes pruebasnotas");
        }
    }
}
