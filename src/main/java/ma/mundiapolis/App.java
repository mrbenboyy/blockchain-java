package ma.mundiapolis;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Block> blockchain = new ArrayList<>();
        List<Transaction> transactions1 = new ArrayList<>();
        transactions1.add(new Transaction("account 1", "account 2", 20));
        transactions1.add(new Transaction("account 3", "account 7", 29));
        blockchain.add(new Block(0, transactions1, "0"));

        List<Transaction> transactions2 = new ArrayList<>();
        transactions2.add(new Transaction("account 25", "account 2", 20));
        transactions2.add(new Transaction("account 54", "account 77", 20));
        blockchain.add(new Block(1, transactions2, blockchain.get(0).getCurrentHash()));
        /*blockchain.add(new Block(0, "block 1", "0"));
        blockchain.add(new Block(1, "block 2", blockchain.get(0).getCurrentHash()));
        blockchain.add(new Block(2, "block 3", blockchain.get(1).getCurrentHash()));
        blockchain.add(new Block(3, "block 4", blockchain.get(2).getCurrentHash()));*/

        blockchain.forEach(System.out::println);
        System.out.println(verifyChain(blockchain)?"BlockChain Valide": "BlockChain non Valide");
    }

    private static boolean verifyChain(List<Block> blockchain){
        for (int i = 1; i < blockchain.size(); i++) {
            if(!blockchain.get(i).getPreviousHash().equals(blockchain.get(i-1).getCurrentHash()))
                    return false;
        }
                return true;

    }
}
