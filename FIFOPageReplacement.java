import java.util.*;

public class FIFOPageReplacement {
    
    public static int fifoPageReplacement(int frames, int[] refString) {
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
        return pageFaults;
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

        int pageFaults = fifoPageReplacement(frames, refString);
        System.out.println("Total FIFO Page Faults: " + pageFaults);

        scanner.close();
    }
}
