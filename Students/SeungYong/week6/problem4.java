
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		//	반례를 못찾겠어요...
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] leftDp = new int[n];
		int[] rigthDp = new int[n];

		leftDp[0] = arr[0];

		for (int i = 1; i < n; i++) {
			leftDp[i] = Math.max(arr[i], leftDp[i - 1] + arr[i]);
		}

		rigthDp[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rigthDp[i] = Math.max(arr[i], rigthDp[i + 1] + arr[i]);
		}

		//양쪽 끝단 수 뺄 경우 
		int ans = Math.max(rigthDp[1],leftDp[n - 2]);
		// 아무도 안 뺄 경
		ans = Math.max(ans, rigthDp[0]);
		
		for (int i = 1; i < n - 1; i++) {
			ans = Math.max(ans, leftDp[i - 1] + rigthDp[i + 1]);
		}

		System.out.println(ans);
	}

}
