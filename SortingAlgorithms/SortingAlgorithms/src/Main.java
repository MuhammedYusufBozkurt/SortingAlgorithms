import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] sayilar = new int[1000];
        Random r = new Random();
        for (int i = 0 ; i< sayilar.length ; i++)
        {
            sayilar[i] = r.nextInt(100,10000);
            System.out.println(sayilar[i]);
        }


        System.out.println("------------------------------------------");
        System.out.println("SELECTİON SORT");
        System.out.println("------------------------------------------");
        int min = 0;
        int sayac = 0;
        int temp1 = 0;
        for(int i = 0 ; i < sayilar.length ;i++)
        {
            min = i;
            for (int j = i+1; j < sayilar.length  ; j++)
            {

                if (sayilar[j] <= sayilar[min])
                {
                    min = j;
                }
            }
            temp1 = sayilar[i];
            sayilar[i] = sayilar[min];
            sayilar[min] = temp1;


        }

        for (int i = 0 ; i< sayilar.length ; i++)
        {
            System.out.println(sayilar[i]);
        }


        System.out.println("------------------------------------------");
        System.out.println("BUBBLE SORT");
        System.out.println("------------------------------------------");

        int temp = 0;
        for (int i = 0 ; i < sayilar.length - 1 ; i++)
        {
            for (int j = 0 ; j < sayilar.length - 1 - i ; j++)
            {

                if (sayilar[j] < sayilar[j+1])
                {
                    temp = sayilar[j];
                    sayilar[j] = sayilar[j+1];
                    sayilar[j+1] = temp;
                }

            }
        }

        for (int i = 0 ; i< sayilar.length ; i++)
        {
            System.out.println(sayilar[i]);
        }


        System.out.println("------------------------------------------");
        System.out.println("COUNTING SORT");
        System.out.println("------------------------------------------");

        int max = sayilar[0] ;

        //-------------------------------------------------------------
        for(int i = 0; i< sayilar.length -1;i++)
        {
            if (sayilar[i]>max)
            {
                max=sayilar[i];
            }
        }
        //-------------------------------------------------------------
        System.out.println(max);

        int [] count = new int[max+1];
        int [] yaz = new int[sayilar.length];
        //-------------------------------------------------------------
        for(int i = 0; i< count.length;i++)
        {
            count[i]=0;
        }
        //-------------------------------------------------------------
        for(int i = 0; i< sayilar.length;i++)
        {
            count[sayilar[i]]++;
        }
        //-------------------------------------------------------------

        System.out.println("-----------------------------------------------------");
        //-------------------------------------------------------------
        for(int i = 1; i< count.length;i++)
        {
            count[i]=count[i]+count[i-1];
        }
        //-------------------------------------------------------------


        for (int i = 0 ; i < sayilar.length ; i++)
        {
            yaz[count[sayilar[i]]-1] = sayilar[i];
            count[sayilar[i]]--;
        }

        //--------------------------------------------------

        for (int i = 0 ; i< yaz.length; i++)
        {
            System.out.println(yaz[i]);
        }


        System.out.println("------------------------------------------");
        System.out.println("RADIX SORT");
        System.out.println("------------------------------------------");

        int max1 = 0;
        int basamak;
        for(int i = 0; i< sayilar.length -1;i++)
        {
            if (sayilar[i] >max1)
            {
                max1=sayilar[i];
            }
        }

        basamak = (int)Math.round(Math.log10(max1));
        int [] yaz1 = new int[sayilar.length];
        int [] count1 = new int[10];

        for (int j = 1; j<(int)Math.pow(10,basamak); j =j*10)
        {




            //-------------------------------------------------------------
            for(int i = 0; i< count1.length;i++)
            {
                count1[i]=0;
            }
            //-------------------------------------------------------------
            for(int i = 0; i< sayilar.length;i++)
            {
                count1[(sayilar[i] / j) % 10]++;
            }
            //-------------------------------------------------------------
            for(int i = 1; i< count1.length;i++)
            {
                count1[i]+=count1[i-1];
            }
            //-------------------------------------------------------------
            for (int i = sayilar.length - 1 ; i >= 0; i--)
            {
                yaz1[count1[(sayilar[i] / j) % 10]-1] = sayilar[i];
                count1[(sayilar[i] / j) % 10]--;
            }
            //--------------------------------------------------
            for (int i = 0 ; i < sayilar.length ; i++)
            {
                sayilar[i] = yaz1 [i];
            }
            //--------------------------------------------------
            for(int i = 0; i< count1.length;i++)
            {
                count1[i]=0;
            }
        }

        for (int i = 0 ; i< yaz1.length; i++)
        {
            System.out.println(yaz1[i]);
        }


    }
}