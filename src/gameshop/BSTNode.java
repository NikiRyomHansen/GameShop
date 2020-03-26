package gameshop;

public class BSTNode {

    // fields - access modifier is public for code consistency
    public ShopItem data;
    public BSTNode left;
    public BSTNode right;

    // Constructor
    public BSTNode(ShopItem data) {
        this.data = data;
        left = right = null;
    }


}
