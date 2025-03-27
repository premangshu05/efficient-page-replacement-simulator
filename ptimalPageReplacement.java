import java.util.*;

public class OptimalPageReplacement {

    // Method to implement Optimal Page Replacement Algorithm
    public static int optimalPageReplacement(int frames, int[] refString) {
        List<Integer> memory = new ArrayList<>();
        int pageFaults = 0;

        for (int i = 0; i < refString.length; i++) {
            int page = refString[i];

            // If the page is not in memory, it's a page fault
            if (!memory.contains(page)) {
                if (memory.size() == frames) {
                    int farthestIndex = -1, pageToReplace = -1;

                    // Find the page in memory that will be used farthest in the future
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
                    memory.remove((Integer) pageToReplace); // Remove the least useful page
                }
                memory.add(page);
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

        // Run Optimal algorithm and display result
        int pageFaults = optimalPageReplacement(frames, refString);
        System.out.println("Total Optimal Page Faults: " + pageFaults);

        scanner.close();
    }
}
