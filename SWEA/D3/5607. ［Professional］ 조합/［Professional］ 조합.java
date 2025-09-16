import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 페르마의 소정리
// a^p === a (%p)
// a^p-2 === a^-1 (%p)
public class Solution {
    static long[] fact, invfact;
    static long mod = 1234567891;

    static void Fact(int n) {
        fact[0] = 1;

        for(int i = 1; i <= n; i++) {
            fact[i] = (fact[i-1] * i) % mod;
        }
    }

    static long pow(long n, long p){
        if(p == 0) return 1;
        if(p % 2 == 0){
            long half = pow(n, p / 2);
            return (half * half) % mod;
        }

        return (n * pow(n, p -1) % mod) % mod;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            fact = new long[N+1];
            invfact = new long[N+1];

            Fact(N);

            // (N * N-1 * ... * N -R +1) / R!
            long ans = (fact[N] * pow(fact[N - R], mod - 2)) % mod * pow(fact[R], mod - 2) % mod;
            System.out.println("#" + t + " "+ ans);
        }

    }

}
