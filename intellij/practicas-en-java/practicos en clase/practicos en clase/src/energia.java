public class energia 
{
    public static void main(String[] args)
    {
        int energia = 54;
        int recarga= 54;
        for (int nivel = 1; nivel <=4; nivel++)
        {
            if (nivel%2==0)
            {
                energia = energia-nivel;
            }
            else {
                energia = energia + recarga;
            }
        }
        System.out.println("Energia final :"+energia);
    }
}
