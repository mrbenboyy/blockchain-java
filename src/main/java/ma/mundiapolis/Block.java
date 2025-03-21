package ma.mundiapolis;


import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


public class Block {
    private long index;
    //private String data;
    private List<Transaction> transactions;
    private Timestamp timestamp;
    private String currentHash;
    private String previousHash;

    public Block(long index, List<Transaction> transactions, String previousHash) {
        this.index = index;
        //this.data = data;
        this.transactions = transactions;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.currentHash = calculateHash();
        this.previousHash = previousHash;
    }

    private String calculateHash(){
        String data = "";
        for (Transaction transaction: transactions){
            data += transaction.toString();
        }
        String calculatedHash = DigestUtils.sha256Hex(index+data+timestamp.toString()+previousHash).toString();
        return calculatedHash;
    }

    @Override
    public String toString() {
        return "Block{" +
                "index=" + index +
                ", timestamp=" + timestamp +
                ", currentHash='" + currentHash + '\'' +
                ", previousHash='" + previousHash + '\'' +
                '}';
    }

    public String getCurrentHash() {
        return currentHash;
    }

    public String getPreviousHash() {
        return previousHash;
    }
}
