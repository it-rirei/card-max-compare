package card.max;
import java.util.Comparator;


public class CardComparator implements Comparator<Cards>{
    public int compare(Cards c1, Cards c2) {
        // スーツとカードの値の配列を作成し、比較して特定のカードの値（大きさ）を計算します
        String[] suit = {"♦", "♣", "♥", "♠"};
        String[] number = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "11","12","13","14"};


        int valueOfC1 = 0;
        int valueOfC2 = 0;
        for(int i=0;i<number.length;i++){
            if(c1.getNumber().equals(number[i])) valueOfC1 += i*10;
            if(c2.getNumber().equals(number[i])) valueOfC2 += i*10;
        }
        for(int i=0;i<suit.length;i++){
            if(c1.getSuit().equals(suit[i])) valueOfC1 += i;
            if(c2.getSuit().equals(suit[i])) valueOfC2 += i;
        }

        if( valueOfC1 > valueOfC2 ) return -1;
        if( valueOfC1 < valueOfC2 ) return 1;

        return 0;
    }


}
