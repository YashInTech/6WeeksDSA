import java.util.ArrayList;
import java.util.Arrays;

public class P006c_RearrangeArrayElementsBySignWithExtraElements {
    public static ArrayList<Integer> rearrangeArrayExtra(ArrayList<Integer> aList) {
        int n = aList.size();

//      Declared pos & neg ArrayLists
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

//      Add elements to pos & neg ArrayLists
        for(int i = 0; i < n; i++) {
            if(aList.get(i) > 0) {
                pos.add(aList.get(i));
            } else {
                neg.add(aList.get(i));
            }
        }

//      Add elements alternatively from pos & neg ArrayLists
        if(pos.size() > neg.size()) {
            for(int i = 0; i < neg.size(); i++) {
                aList.set(2 * i, pos.get(i));
                aList.set(2 * i + 1, neg.get(i));
            }
            int idx = pos.size() * 2;
            for(int i = pos.size() * 2; i < n; i++) {
                aList.set(idx, pos.get(i));
                idx++;
            }
        } else {
            for(int i = 0; i < pos.size(); i++) {
                aList.set(2 * i, neg.get(i));
                aList.set(2 * i + 1, pos.get(i));
            }
            int idx = neg.size() * 2;
            for(int i = neg.size() * 2; i < n; i++) {
                aList.set(idx, neg.get(i));
                idx++;
            }
        }
        return aList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> aList = new ArrayList<>(Arrays.asList(1, 2, -4, -5, 3, 4));

        System.out.println("The altered array is: " + rearrangeArrayExtra(aList));
    }
}