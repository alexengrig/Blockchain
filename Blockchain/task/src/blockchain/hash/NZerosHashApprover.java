package blockchain.hash;

public class NZerosHashApprover implements HashApprover {
    private final String zeros;

    public NZerosHashApprover(int n) {
        this.zeros = "0".repeat(n);
    }

    @Override
    public boolean approve(String hash) {
        return hash.startsWith(zeros);
    }
}
