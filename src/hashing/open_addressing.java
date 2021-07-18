package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class open_addressing {
    public static void main(String args[]) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        System.out.println("Enter size of hash table");
        int size = Integer.parseInt(br.readLine());
        my_hash_table obj = new my_hash_table(size);
        obj.insert(56); // insert at slot 0
        obj.insert(64); // insert at slot 1
        obj.insert(35); // collision at slot 0, tries probe+offset slot
        obj.insert(97); // collision at slot 0, tries probe+offset slot
        obj.search(56);
    }
}

class my_hash_table {
    int buckets;
    ArrayList<Integer> table;

    // constructor
    my_hash_table(int b) {
        buckets = b;
        table = new ArrayList<Integer>(b);
        for (int i = 0; i < b; i++) {
            table.add(-1);
        }
    }

    public void search(int key) {
        int probe = key % buckets;
        int offset = (buckets - 1) - (key % (buckets - 1));
        int i = probe;
        while (table.get(probe) != -1) {
            if (table.get(probe) == key) {
                System.out.println("Key found at index " + probe);
                return;
            }
            probe = (probe + offset) % buckets;
            if (probe == i) {
                break;
            }
        }
        System.out.println("Key not found");
    }

    public void insert(int key) {
        //System.out.println("Table before inserting");
        //print_table();
        int probe = key % this.buckets;
        int offset = (this.buckets - 1) - (key % (this.buckets - 1));
        while (this.table.get(probe) != -1 && this.table.get(probe) != -2 && table.get(probe)!=key) { // -1: empty, -2: deleted
            probe = (probe + offset) % this.buckets;

        }
        if(table.get(probe)== key){
            System.out.println("Key already exists");
            return;
        }
        this.table.add(probe, key);
        System.out.println("Table after inserting]");
        print_table();
    }

    public void delete(int key) {
        int probe = key % buckets;
        int offset = (this.buckets - 1) - (key % (this.buckets - 1));
        int i = probe;
        while(table.get(probe)!=-1){
            if(table.get(probe)==key){
                System.out.println("Table before deleting");
                print_table();
                table.set(probe, -2);
                System.out.println("Table after deleting");
                print_table();
                return;
            }
            probe = (probe+offset)%buckets;
            if(probe==i){
                break;
            }
        }

        System.out.println("Index empty");
    }

    public void print_table() {
        System.out.println(table + "\n\n");
    }

    private void debug(String s) {
        System.out.println(s);
    }
}
