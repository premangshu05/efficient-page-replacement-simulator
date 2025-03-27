import java.util.*;

public class LRUPageReplacement {

    // Method to implement LRU Page Replacement Algorithm
    public static int lruPageReplacement(int frames, int[] refString) {
        List<Integer> memory = new ArrayList<>();
        int pageFaults = 0;

        for (int page : refString) {
            // If the page is not in memory, it's a page fault
            if (!memory.contains(page)) {
                if (memory.size() == frames) {
                    memory.remove(0); // Remove the least recently used page (first in list)
                }
                pageFaults++;
            } else {
                memory.remove((Integer) page); // Remove the page from its current position
            }
            memory.add(page); // Add page at the end (most recently used)
        }
        return pageFaults;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input for frames and reference string
        System.out.print("Enter the number of frames: ");
        int frames = scanner.nextInt();

        System.out.print("Enter the number of pages in reference string: ");
        int n = scanner.nextInt();
        int[] refString = new int[n];

        System.out.println("Enter the reference string: ");
        for (int i = 0; i < n; i++) {
            refString[i] = scanner.nextInt();
        }

        // Run LRU algorithm and display result
        int pageFaults = lruPageReplacement(frames, refString);
        System.out.println("Total LRU Page Faults: " + pageFaults);

        scanner.close();
    }
}
