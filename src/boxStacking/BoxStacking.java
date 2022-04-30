//Dafna Porat 318797685
//Anastasiya Ternovski 324561802
package boxStacking;

import java.util.ArrayList;
import java.util.Comparator;

public class BoxStacking {
    private ArrayList<Box> arr;

    public BoxStacking(int[] lengthArr, int[] widthArr, int[] heightArr) {
        //Box i in the Array is made of lengthArr[i],widthArr[i],heightArr[i]
        arr = new ArrayList<Box>();
        Box b;
        for (int i = 0; i < lengthArr.length; i++) {
            b = new Box(lengthArr[i], widthArr[i], heightArr[i]);
            arr.add(b);
        }
    }

    public ArrayList<Box> getArr() {
        return arr;
    }

    public void setArr(ArrayList<Box> arr) {
        this.arr = arr;
    }

    //Box Stacking Problem - Dynamic Programming
    //Getting highest possible tower from Array of Boxes in Time-Complexity of O(n^2)
    public ArrayList<Box> highestStableTower() {
        ArrayList<Box> FinalStableTower = new ArrayList<Box>();
        //Sorting the Array by the base surface area
        arr.sort(new BaseAreaComparator());

        //Making two arrays:
        //maxHeight Array will keep the maximum height we claimed so far for each corresponding Box
        //result Array will keep the index of the box that can be underneath the corresponding Box
        int maxHeight[] = new int[this.arr.size()];
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < this.arr.size(); i++) {
            maxHeight[i] = this.arr.get(i).getHeight();
            result.add(i);
        }

        for (int i = 1; i < this.arr.size(); i++) {
            for (int j = 0; j < i; j++) {
                //Legality terms of the problem is that a Box1 can be on top of other Box2
                // only if Length[Box1]<Length[Box2] AND Width[Box]1<Width[Box2]
                if (arr.get(i).getLength() < arr.get(j).getLength() &&
                        arr.get(i).getWidth() < arr.get(j).getWidth()) {
                    //IF LEGAL : we check if the current box height PLUS the maximum height we claimed
                    //until this box is GREATER than the current maximum height we claimed
                    if (maxHeight[j] + arr.get(i).getHeight() > maxHeight[i]) {
                        maxHeight[i] = maxHeight[j] + arr.get(i).getHeight();
                        result.set(i, j);
                    }

                }

            }
        }

        //Checking which index holds the maximum height of the tower
        int maxIndex = 0;
        for (int i = 0; i < maxHeight.length; i++) {
            if (maxHeight[i] > maxHeight[maxIndex])
                maxIndex = i;
        }

        //Backtracking through the array from the top box of the tower(maxIndex) to the Bottom of the tower
        int t = maxIndex;
        int newT = maxIndex;

        do {
            t = newT;
            FinalStableTower.add(this.arr.get(t));
            newT = result.get(t);

        } while (t != newT);

        return FinalStableTower;
    }


    public void printArr() {
        arr.forEach(System.out::println);
    }


}

class BaseAreaComparator implements Comparator<Box> {

    @Override
    public int compare(Box b1, Box b2) {
        return b2.getLength() * b2.getWidth() - b1.getLength() * b1.getWidth();
    }

}