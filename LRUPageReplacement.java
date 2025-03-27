import java.util.*;

public class LRUPageReplacement {

    public static int lruPageReplacement(int frames, int[] refString) {
        List<Integer> memory = new ArrayList<>();
        int pageFaults = 0;

        for (int page : refString) {
            if (!memory.contains(page)) {
                if (memory.size() == frames) {
                    memory.remove(0); 
                }
                pageFaults++;
            } else {
                memory.remove((Integer) page);
            }
            memory.add(page); 
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
        int pageFaults = lruPageReplacement(frames, refString);
        System.out.println("Total LRU Page Faults: " + pageFaults);

        scanner.close();
    }
}
