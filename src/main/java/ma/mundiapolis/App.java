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
        blockchain.add(new Block(0, "block 1", "0"));
        blockchain.add(new Block(1, "block 2", blockchain.get(0).getCurrentHash()));
        blockchain.add(new Block(2, "block 3", blockchain.get(1).getCurrentHash()));
        blockchain.add(new Block(3, "block 4", blockchain.get(2).getCurrentHash()));

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
