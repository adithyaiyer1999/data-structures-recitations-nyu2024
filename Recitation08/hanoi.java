package recitation_recirsion;

public class hanoi {

    public static void main(String[] args) {
        int n = 6; // Number of disks
        hanoi(n, 'A', 'C', 'B'); // A, B, and C are the names of the rods
    }

    // Recursive function to solve the Tower of Hanoi problem
    public static void hanoi(int n, char from_rod, char to_rod, char aux_rod) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + from_rod + " to rod " + to_rod);
            return;
        }
        hanoi(n - 1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + n + " from rod " + from_rod + " to rod " + to_rod);
        hanoi(n - 1, aux_rod, to_rod, from_rod);
    }
}