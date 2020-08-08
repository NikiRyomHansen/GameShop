package game;

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
        BSTNode newNode = new BSTNode(shopItem);

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


    // Returns true if node was updated OR false if node not found
    public boolean update(Weapon weapon, int quantity){

        BSTNode nodee = search(weapon.weaponName);
        // if current is null then search could not find the node to be updated
        if(nodee == null){
            System.out.println("Node is null");
            return false; }

        // finally, updates the original node (nodee) to the params
        nodee.data = new ShopItem(weapon,quantity);
        return true;
    }

    // Returns the BSTNode for update OR null if node not found
    public BSTNode search(String weaponName){

        // return null if BST is empty
        if(this.root == null){ return null; }

        BSTNode current = this.root;
        while(current != null){
            if(current.data.item.weaponName.equals(weaponName)){
                return current;
            }
            if(current.data.item.weaponName.compareToIgnoreCase(weaponName)>0){
                current = current.left;
            }
            else{
                current = current.right;
            }
        }
        return null;
    }


    // Print In Order Traversal of the BST
    public void inOrderTrav() {
        recursiveInOrder(root);
    }

    // Recursively go through the BST in order - ONLY printing if stock is higher than 0
    private void recursiveInOrder(BSTNode current) {
        if (current != null) {
            recursiveInOrder(current.left);
            if (current.data.numberInStock > 0) {
                System.out.println(current.data);
            }
            recursiveInOrder(current.right);
        }
    }

    // Delete a weapon from the list
    public void delete(String weaponName, Player player) {
        root = deleteRec(root, weaponName);
        player.numItems--;
    }

    // recursive function to delete a node: ShopItem by weaponName
    private BSTNode deleteRec(BSTNode current, String weaponName) {
        // base case, if root == null
        if (root == null)
            return current;

        // recursively go down the tree
        if (current.data.item.weaponName.compareToIgnoreCase(weaponName) > 0) {
            current.left = deleteRec(current.left, weaponName);
        } else if (current.data.item.weaponName.compareToIgnoreCase(weaponName) < 0) {
            current.right = deleteRec(current.right, weaponName);
        } else {
            // if the Node only has one child or no child
            if (current.left == null)
                return current.right;
            else if (current.right == null)
                return current.left;

            // Node with two children, get the inOrder successor (smallest value greater than the input)
            current.data = minValue(current.right);

            // Delete the inorder successor
            current.right = deleteRec(current.right, current.data.item.weaponName);
        }

        return current;
    }

    // find the lowest value in the current tree or subtree
    ShopItem minValue(BSTNode root) {
        ShopItem minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }


    // return the size of the BST
    public int size() {
        return recursiveSize(root);
    }

    // Recursively computes the size of the BST
    private int recursiveSize(BSTNode current) {
        if (current == null) {
            return 0;
        } else {
            return (recursiveSize(current.left) + 1 + recursiveSize(current.right));
        }
    }


}
