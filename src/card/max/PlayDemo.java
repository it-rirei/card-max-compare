package card.max;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PlayDemo {
    public Player setPlayer(){
        int id=0;
        String name="";
        Scanner console = new Scanner(System.in);
        boolean ready = true;
        do{
            try{
                System.out.println("IDを輸入：");
                id = console.nextInt();
                ready = true;
            }catch(Exception e){
                System.out.println("Int型のIDを輸入！");
                ready = false;
                console.nextLine();
            }
        }while(ready==false);

        System.out.println("名前を輸入：");
        name = console.next();
        return new Player(id, name);
    }

    public static void main(String[] args) {

        PlayDemo game = new PlayDemo();
        //（1）カードのデッキを作成する
        Getcard cards = new Getcard();
        //（2）新しいカードのデッキを表示する
        cards.showCards();
        //（3）シャッフル
        cards.shufCards();
        //（4）プレーヤーを作成する
        System.out.println("--------------ゲームを開始するために2人（またはそれ以上）を作成します！-------------");
        List<Player> p = new ArrayList<Player>();
        for(int i=0;i<2;i++)
        {
            System.out.println(+(i+1)+"人目のプレイヤーのIDと名前を入力してください:");
            p.add(game.setPlayer());
        }
        for(int i=0;i<p.size();i++)
        {
            System.out.println("ウェルカムプレイヤー："+p.get(i).getName());
        }
        //（5）ポーカーゲームが始まりました〜
        int count = 0;
        System.out.println("------------------開始する---------------------");
        //各人が2つを取るように設定します
        for(int i=0; i<2;i++){
            //プレイヤーは交代で
            for(int j=0; j< p.size(); j++){
                System.out.println(">プレイヤー"+p.get(j).getName()+"カードを");
                p.get(j).setHandCards(cards.getList().get(count));
                count++;
            }
        }
        System.out.println("------------------カードの配りが終わり！--------------------");
        System.out.println("-----------------ゲームを開始 ---------------------");
        for(int i=0;i<p.size();i++){
            System.out.print("プレイヤー"+p.get(i).getName()+"が引いたカードは：[ ");
            for(int j=0;j<p.get(i).getHandCards().size();j++){
                Cards cur = p.get(i).getHandCards().get(j);

                System.out.print(""+cur.getSuit().getSuitValue()+cur.getNumber().getNumberValue()+" ");
            }
            System.out.println(" ]");
        }


        for(int i=0;i<p.size();i++){
            Collections.sort(p.get(i).getHandCards(), new CardComparator());
        }
        List<Cards> maxCard = new ArrayList<Cards>();
        for(int i=0;i<p.size();i++){
            Cards maxCur = p.get(i).getHandCards().get(0);

            System.out.println("プレイヤー"+p.get(i).getName()+"最大のカードは："+ maxCur.getSuit().getSuitValue()+maxCur.getNumber().getNumberValue());
            maxCard.add(maxCur);
        }


        List<Cards> temp = new ArrayList<Cards>();
        temp.addAll(maxCard);
        Collections.sort(temp, new CardComparator());
        for(int i=0;i<p.size();i++){
            if(maxCard.get(i).equals(temp.get(0))) System.out.println("プレイヤー："+p.get(i).getName()+"勝利！");
        }

    }
}
