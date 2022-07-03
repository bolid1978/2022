package SimpleMovingAverage;

//https://andrewlock.net/creating-a-simple-moving-average-calculator-in-csharp-1-a-simple-moving-average-calculator/
//https://exceltable.com/formuly/formula-skolzyashchey-sredney?
public class Sma {
    static int[] a = new int[]{
            10,
            5,
            8,
            7,
            58,
            45,
            4,
            12,
            6,
            9,


    };
    static int[] b =  new int[10];
    static boolean flagAinB = true;


    public static void main(String[] args) {

        System.out.println(adjustment(78));
        System.out.println(adjustment(18));
        System.out.println(adjustment(22));
        System.out.println(adjustment(21));
        System.out.println(adjustment(45));




    }

        static double adjustment(int currentAdjustment){
        int[] temp ;

        //заполняем массив A или B в зависимости от флага
        if (flagAinB){
            for (int i = 0,j = 1; j < 10; i++,j ++) {
                b[i] = a[j];
            }
            b[9] = currentAdjustment;
            flagAinB = false;
            temp = b;
        }

        else{

            for (int i = 0, j = 1; j < 10; i++,j ++) {
                a[i] = b[j];
            }
            a[9] = currentAdjustment;
            flagAinB = true;
            temp = a;
        }

        //вычисляем среднее
        double result = 0;
            for (int i = 0; i < 10 ; i++) {
                result += temp[i];
            }
            System.out.println(result+"..........");
           return result/10;
    }
}
