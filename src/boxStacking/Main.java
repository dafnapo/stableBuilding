//Dafna Porat 318797685
//Anastasiya Ternovski 324561802
package boxStacking;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        //20 Boxes Tower Example
        int lengthArr1[] = new int[20];
        int widthArr1[] = new int[20];
        int heightArr1[] = new int[20];

        //30 Boxes Tower Example
        int lengthArr2[] = new int[30];
        int widthArr2[] = new int[30];
        int heightArr2[] = new int[30];

        Random rand = new Random();
        for(int i=0;i<lengthArr1.length;i++) {
            lengthArr1[i] = rand.nextInt(200) +1;
            widthArr1[i] = rand.nextInt(200) +1;
            heightArr1[i] = rand.nextInt(200) +1;
        }

        for(int i=0;i<lengthArr2.length;i++) {
            lengthArr2[i] = rand.nextInt(200) +1;
            widthArr2[i] = rand.nextInt(200) +1;
            heightArr2[i] = rand.nextInt(200) +1;
        }

        BoxStacking bs1 = new BoxStacking(lengthArr1,widthArr1,heightArr1);
        ArrayList<Box> StableTower1;
        int maxHeight1 =0;

        BoxStacking bs2 = new BoxStacking(lengthArr2,widthArr2,heightArr2);
        ArrayList<Box> StableTower2;
        int maxHeight2 =0;

        //Example 1
        System.out.println("The 20 Boxes with their Dimensions are: ");
        bs1.printArr();
        System.out.println();
        System.out.println("The Highest Stable Tower of the 20 Boxes Sorted From Top to Bottom: ");
        StableTower1 = bs1.highestStableTower();
        for(Box b : StableTower1) {
            maxHeight1+=b.getHeight();
            System.out.println(b);
        }
        System.out.println("The Maximum Height of this Tower is: "+maxHeight1 );

        System.out.println();
        System.out.println();

        //Example2
        System.out.println("The 30 Boxes with their Dimensions are: ");
        bs2.printArr();
        System.out.println();
        System.out.println("The Highest Stable Tower of the 30 Boxes Sorted From Top to Bottom: ");
        StableTower2 = bs2.highestStableTower();
        for(Box b : StableTower2) {
            maxHeight2+=b.getHeight();
            System.out.println(b);
        }
        System.out.println("The Maximum Height of this Tower is: "+maxHeight2 );


    }

}
