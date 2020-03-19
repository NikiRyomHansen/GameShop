package gameshop;

// Binary Search Tree consisting of ShopItem objects
public class BSTree {

    // fields
    private BSTNode root;

    // Constructor
    public BSTree() {
        this.root = null;
    }

    // Insert an item, ordered by name
    public void insert(Weapon item, int quantity) {
        // Instantiating a ShopItem object for the new Node
        ShopItem shopItem = new ShopItem(item, quantity);
        // Instantiating a new Node for the BST
        BSTNode newNode =new BSTNode(shopItem);

        // if the root is null, set root to newNode
        if (root == null) {
            root = newNode;
            return;
        }
        // Initialize current and previous and assign them to equal root
        BSTNode current = root;
        BSTNode previous = root;
        while (current != null) {
            previous = current;
            // If the current item is greater than the one we're inserting, set current to left
            if (current.data.item.weaponName.compareToIgnoreCase(item.weaponName) > 0) {
                current = current.left;
            } else { // else if the current item is less than input, set current to right
                current = current.right;
            }
        }
        // now comparing the previous node to determine whether the input should be left or right
        if (previous.data.item.weaponName.compareToIgnoreCase(item.weaponName) > 0) {
            previous.left = newNode;
        } else {
            previous.right = newNode;
        }
    }

    // Print In Order Traversal of the BST
    public void inOrderTrav() {
        System.out.println("In Order Traversal");
        recursiveInOrder(root);
    }

    // Recursively go through the BST in order
    public void recursiveInOrder(BSTNode current) {
        if (current != null) {
            recursiveInOrder(current.left);
            System.out.println(current.data); // TODO: add an if statement if root.data.numberInStock < 1 { don't print }
            recursiveInOrder(current.right);
        }
    }

}
