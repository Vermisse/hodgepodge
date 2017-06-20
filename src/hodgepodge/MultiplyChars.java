package hodgepodge;

public class MultiplyChars {

	public static String[] loop(int count, char... chars) {
		String[] result = new String[chars.length];
		for (int i = 0; i < chars.length; i++)
			result[i] = String.valueOf(chars[i]);

		for (int i = 0; i < count - 1; i++) {
			String[] tmp = new String[result.length * (chars.length - 1 - i)];
			for (int j = 0, x = 0; j < result.length; j++)
				for (int k = 0; k < chars.length; k++)
					if (result[j] == null || result[j].indexOf(chars[k]) < 0)
						tmp[x++] = result[j] + chars[k];
			
			result = tmp;
		}

		for (String item : result)
			System.out.print(item + ",");
		
		System.out.println();
		return result;
	}

	public static void main(String[] args) {
		loop(1, 'a', 'b', 'c', 'd');
		loop(2, 'a', 'b', 'c', 'd');
		loop(3, 'a', 'b', 'c', 'd');
		loop(4, 'a', 'b', 'c', 'd');
	}
}