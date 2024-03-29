class KthLargest {

        PriorityQueue<Integer> queue;

        final int k;

        public KthLargest(int k, int[] nums) {

            this.k = k;

            queue = new PriorityQueue<>(k);

            for (int num : nums)

                add(num);

        }

        public int add(int val) {

            queue.offer(val);

            /**

             Because there is only an add method and no remove method,

             the kth largest element will become larger and larger,

             so we can remove the smaller one

             */

            if (queue.size() > k)

                queue.poll();

            return queue.peek();

        }

    }

        

    
        
    


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */