package src;

import java.util.*;

public class FIFOPageReplacement {

    // Method to implement FIFO Page Replacement Algorithm
    public static int fifoPageReplacement(int frames, int[] refString) {
        Queue<Integer> memory = new LinkedList<>();
        Set<Integer> pages = new HashSet<>();
        int pageFaults = 0;

        for (int page : refString) {
            // If the page is not in memory, it's a page fault
            if (!pages.contains(page)) {
                if (memory.size() == frames) {
                    int removed = memory.poll();  // Remove the oldest page
                    pages.remove(removed);
                }
                memory.add(page);
                pages.add(page);
                pageFaults++;
            }
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

        // Run FIFO algorithm and display result
        int pageFaults = fifoPageReplacement(frames, refString);
        System.out.println("Total FIFO Page Faults: " + pageFaults);

        scanner.close();
    }
}
