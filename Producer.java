class Producer extends Thread {
    int N;
    buffer q;

    public Producer(int num, buffer q) {
        this.N = num;
        this.q = q;
    }

    static boolean isPrime(int n) {
        if (n != 1 && n != 0) {
            for(int i = 2; (double)i <= Math.sqrt(n); ++i) {
                if (n % i == 0) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    String str1;
    int cntr = 0;
    public void run() {
        int i;
        for(i = 1; i <= this.N; ++i) {
            if (isPrime(i)) {
                str1 = Integer.toString(i);
                this.q.produce(str1);
                cntr++;
            }

        }
        System.out.print("The largest prime number: ");
        System.out.println(str1);

        System.out.print("Number of elements generated: ");
        System.out.println(cntr);
    }
}