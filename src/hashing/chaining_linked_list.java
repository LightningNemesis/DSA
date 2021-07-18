package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class chaining_linked_list {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter size of hash table");
        int size = Integer.parseInt(br.readLine());
        hash_table table = new hash_table(size);
        table.insert(60);
        table.insert(65);
        table.insert(10);
        System.out.println(table.search(50));
    }
}

class hash_table {
    int buckets;
    ArrayList<LinkedList<Integer>> table;

    public hash_table(int b) {
        buckets = b; // store the size of hash table in b
        table = new ArrayList<LinkedList<Integer>>(); // initialize the hash table
        for (int i = 0; i < b; i++) { // run a loop till b-1, storing empty linked list in each index
            table.add(new LinkedList<Integer>());
        }
    }

    private int hash_function(int key){
        return key%this.buckets;
    }

    boolean search(int key) {
        return this.table.get(hash_function(key)).contains(key);
    }

    void insert(int key) {
        for (int i = 0; i < this.table.get(hash_function(key)).size(); i++) {
            if (this.table.get(hash_function(key)).get(i) == key) {
                System.out.println("Duplicate key present in chain at index " + hash_function(key));
                return;
            }
        }
        this.table.get(hash_function(key)).add(key);
    }

    void delete(int index, int key) {
        this.table.get(index).remove((Integer) hash_function(key));
    }
}

class Node {
    Node next = null;
    int data;

    //Constructor, initializes class variables
    public Node(int d) {
        data = d;
    }

    // A -> B -> C -> D
    void append_to_tail(int val) {
        Node end = new Node(val);
        Node current = this; // Initialize current node with the one on which append to end method is called, for eg Node B
        while (current.next != null) current = current.next; // Iterate to next nodes till we reach previous last node
        current.next = end; // Make the previous last node (current) point to current last (end)
    }
}


