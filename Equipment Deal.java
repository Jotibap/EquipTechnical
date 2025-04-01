import java.util.*;

class OptimalEquipmentDeal {

    public static List<Integer> findOptimalDeals(List<Pair<String, Integer>> requests,
                                                 List<Pair<String, Integer>> sellers) {
        List<Integer> results = new ArrayList<>();
        for (Pair<String, Integer> request : requests) {
            String equipment = request.getKey();
            int maxPrice = request.getValue();
            PriorityQueue<Integer> eligibleSellers = new PriorityQueue<>();

            for (Pair<String, Integer> seller : sellers) {
                if (seller.getKey().equals(equipment) && seller.getValue() <= maxPrice) {
                    eligibleSellers.offer(seller.getValue());
                }
            }

            if (!eligibleSellers.isEmpty()) {
                results.add(eligibleSellers.poll());
            } else {
                results.add(null);
            }
        }
        return results;
    }

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of requests: ");
        int reqCount = scanner.nextInt();
        scanner.nextLine();

        List<Pair<String, Integer>> requests = new ArrayList<>();
        System.out.println("Enter requests (equipment max_price):");
        for (int i = 0; i < reqCount; i++) {
            String[] reqInput = scanner.nextLine().split(" ");
            requests.add(new Pair<>(reqInput[0], Integer.parseInt(reqInput[1])));
        }

        System.out.print("Enter number of sellers: ");
        int sellCount = scanner.nextInt();
        scanner.nextLine();

        List<Pair<String, Integer>> sellers = new ArrayList<>();
        System.out.println("Enter sellers (equipment price):");
        for (int i = 0; i < sellCount; i++) {
            String[] sellInput = scanner.nextLine().split(" ");
            sellers.add(new Pair<>(sellInput[0], Integer.parseInt(sellInput[1])));
        }

        List<Integer> result = findOptimalDeals(requests, sellers);
        System.out.println(result);

        scanner.close();
    }
}

//Output

Enter number of requests: 2
Enter requests (equipment max_price):
excavator 300
bulldozer 200
Enter number of sellers: 3
Enter sellers (equipment price):
excavator 250
excavator 350
bulldozer 180
        [250, 180]

Process finished with exit code 0