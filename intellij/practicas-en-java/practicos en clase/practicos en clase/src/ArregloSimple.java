public class ArregloSimple
{
    public static void main(String[] arg)
    {
        //arreglo para trabajo con textos
        String[] nombres=new String[10];//10 representa la cantidad de elementos
        nombres[0] = "Jose Perez";
        nombres[1] = "Mariano Medina";
        System.out.println(nombres.length);//va salir 10 de tamaño aunque solo haya 2 valores ingresados
        System.out.println(nombres[1]);
        String ciudades[] = {"La Paz", "Cochabamba", "Santa Cruz", "Chuquisaca", "Potosi"};
        System.out.println(ciudades.length);
        Double precios[] = new Double[10];
        precios[0] = 1500.00;
        precios[1] = 2500.00;
        precios[2] = 300.00;
        precios[3] = 700.00;
        precios[4] = 2000.00;
        for (int i=0;i<=4;i++)
        {
            System.out.println("Ciudad = "+ciudades[i]+ " Precio = "+precios[i]);
        }
    }
}
