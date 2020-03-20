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

    // Print In Order Traversal of the BST
    public void inOrderTrav() {
        recursiveInOrder(root);
    }

    // Recursively go through the BST in order - ONLY computing the print if stock is higher than 0
    public void recursiveInOrder(BSTNode current) {
        if (current != null) {
            recursiveInOrder(current.left);
            if (current.data.numberInStock > 0) {
                System.out.println(current.data);
            }
            recursiveInOrder(current.right);
        }
    }

    // Search for an item by name
    public boolean search(String weaponName) {
        // If the current node is null, the item is not there
        if (getCurrentNode(weaponName) == null)
            return false;
        // else the node is in the tree
        return true;
    }

    // Update an item by weaponName
    public BSTNode update(String weaponName, Weapon item, int quantity) {
        // Find the current node and assign it to current
        BSTNode current = getCurrentNode(weaponName);
        // If the current node is null, the item is not there
        if (current == null)
            return null;
        // We now know the current node is now the item we're looking for
        // Instantiate a ShopItem object with the parameters item and quantity and assign the current node to it
        current.data = new ShopItem(item, quantity);
        return current;
    }

    // Return the current node by weaponName
    public BSTNode getCurrentNode(String weaponName) {
        if (root == null) {
            return null;
        }
        BSTNode current = root;
        // While the current node is not null and is not the item we're looking for, keep iterating
        while (current != null && !current.data.item.weaponName.equalsIgnoreCase(weaponName)) {
            // if the current item is greater than the item we're searching for, set current to left
            if (current.data.item.weaponName.compareToIgnoreCase(weaponName) > 0) {
                current = current.left;
            } else { // if the current item is less, set current to right
                current = current.right;
            }
        }
        // If the current node equals null, we know the item is not in the tree
        if (current == null) {
            return null;
        }
        return current;
    }

    // Delete a weapon from the list
    public void delete(String weaponName, Player player) {
        root = deleteRec(root, weaponName);
        player.numItems--;
    }

    // recursive function to delete a node: ShopItem by weaponName
    public BSTNode deleteRec(BSTNode current, String weaponName) {
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
    public int recursiveSize(BSTNode current) {
        if (current == null) {
            return 0;
        } else {
            return (recursiveSize(current.left) + 1 + recursiveSize(current.right));
        }
    }


}
