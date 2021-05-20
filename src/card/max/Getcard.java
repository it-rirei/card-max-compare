package card.max;
import java.util.*;


public class Getcard {
    private List<Cards> list = new ArrayList<Cards>();

    public Getcard() {
        Cards[] cards = Cards.values();
        List<Cards> list = new LinkedList<>(Arrays.asList(cards));
        this.list = list;
    }

    public List<Cards> getList() {
        return list;
    }



    //シャッフル
    public void shufCards(){
        System.out.println("--------------------シャッフル開始--------------------");
        Collections.shuffle(list);
        System.out.println("--------------------シャッフル終わり------------------------");
    }


    public void showCards(){
        System.out.print("現在のカードは：");
        System.out.print("[ ");
        for (Cards cards : list) {
            System.out.print(cards.getSuit().getSuitValue() + " ");
            System.out.print(cards.getNumber().getNumberValue() + " ");
        }
        System.out.println(" ]");
    }
}
