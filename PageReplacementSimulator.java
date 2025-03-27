import java.util.*;

public class PageReplacementSimulator {
    
    // FIFO Page Replacement Algorithm
    public static void fifoPageReplacement(int frames, int[] refString) {
        Queue<Integer> memory = new LinkedList<>();
        Set<Integer> pages = new HashSet<>();
        int pageFaults = 0;

        for (int page : refString) {
            if (!pages.contains(page)) {
                if (memory.size() == frames) {
                    int removed = memory.poll();
                    pages.remove(removed);
                }
                memory.add(page);
                pages.add(page);
                pageFaults++;
            }
        }
        System.out.println("FIFO Page Faults: " + pageFaults);
    }

    // LRU Page Replacement Algorithm
    public static void lruPageReplacement(int frames, int[] refString) {
        List<Integer> memory = new ArrayList<>();
        int pageFaults = 0;

        for (int page : refString) {
            if (!memory.contains(page)) {
                if (memory.size() == frames) {
                    memory.remove(0); // Remove least recently used
                }
                pageFaults++;
            } else {
                memory.remove((Integer) page); // Remove from current position
            }
            memory.add(page); // Add page at the end (most recently used)
        }
        System.out.println("LRU Page Faults: " + pageFaults);
    }

    // Optimal Page Replacement Algorithm
    public static void optimalPageReplacement(int frames, int[] refString) {
        List<Integer> memory = new ArrayList<>();
        int pageFaults = 0;

        for (int i = 0; i < refString.length; i++) {
            int page = refString[i];

            if (!memory.contains(page)) {
                if (memory.size() == frames) {
                    int farthestIndex = -1, pageToReplace = -1;

                    for (int memPage : memory) {
                        int index = Integer.MAX_VALUE;
                        for (int j = i + 1; j < refString.length; j++) {
                            if (refString[j] == memPage) {
                                index = j;
                                break;
                            }
                        }
                        if (index > farthestIndex) {
                            farthestIndex = index;
                            pageToReplace = memPage;
                        }
                    }
                    memory.remove((Integer) pageToReplace);
                }
                memory.add(page);
                pageFaults++;
            }
        }
        System.out.println("Optimal Page Faults: " + pageFaults);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of frames: ");
        int frames = scanner.nextInt();

        System.out.print("Enter the number of pages in reference string: ");
        int n = scanner.nextInt();
        int[] refString = new int[n];

        System.out.println("Enter the reference string: ");
        for (int i = 0; i < n; i++) {
            refString[i] = scanner.nextInt();
        }

        System.out.println("\nChoose Page Replacement Algorithm:");
        System.out.println("1. FIFO");
        System.out.println("2. LRU");
        System.out.println("3. Optimal");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                fifoPageReplacement(frames, refString);
                break;
            case 2:
                lruPageReplacement(frames, refString);
                break;
            case 3:
                optimalPageReplacement(frames, refString);
                break;
            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}      
