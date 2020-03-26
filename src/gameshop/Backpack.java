package gameshop;

// The backpack can hold any number of weapons as long as maxWeight is not crossed.
// If an attempt to add a weapon to backpack is rejected due to weight
class Backpack {

    // fields
    private BackpackNode head;
    public double maxWeight;
    public double presentWeight;

    // Constructor
    public Backpack() {
        this.presentWeight = 0;
        this.maxWeight = 50;
        this.head = null;
    }

    // Add a new weapon to the end of the Linked List
    public void append(Weapon weapon) {
        // Instantiate a new node
        BackpackNode newNode = new BackpackNode(weapon);
        if (head == null) {
            head = newNode;
            presentWeight += weapon.weight;
            return;
        }
        BackpackNode current = head;
        // Iterate through the List
        while (current.next != null) {
            current = current.next;
        }
        // Add the new node at the end of the list
        current.next = newNode;
        presentWeight += weapon.weight;

    }

    // Search for a weapon in the list
    public boolean search(String weaponName) {
        if (head == null)
            return false;
        // if head == the weapon we're searching for then return true
        if (head.data.weaponName.equalsIgnoreCase(weaponName))
            return true;

        BackpackNode current = head;
        // iterate through the list
        while (current.next != null) {
            // if the next node equals the input, then return true
            if (current.next.data.weaponName.equalsIgnoreCase(weaponName))
                return true;
            current = current.next;
        }
        // if the next node is null, we're at the end of the list and the item was not found
        return false;

    }

    // Print the list
    public void printList() {
        if (head == null)
            System.out.println("Backpack is empty");
        else {
            BackpackNode current = head;
            while (current != null) {
                System.out.println("Overview of the weapons in your backback");
                System.out.println(current.data);
                current = current.next;
            }
        }
    }
}
