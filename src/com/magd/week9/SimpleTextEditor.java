package com.magd.week9;

import java.io.*;
import java.util.Stack;

public class SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());
        Stack<String> st = new Stack<>();
        String str;
        while (l-- > 0) {
            String s = bufferedReader.readLine().trim();
            int op = Integer.parseInt(s.substring(0, 1));

            if (s.length() > 1) {
                String second = s.substring(2, s.length());
                switch (op) {
                    case 1:
                        if (st.size() > 0)
                            str = st.peek() + second;
                        else str = second;

                        st.push(str);
                        break;
                    case 2:
                        if (st.size() > 0) {
                            str = st.peek().substring(0, st.peek().length() - Integer.parseInt(second));
                            st.push(str);
                        }
                        break;
                    case 3:
                        if (st.size() > 0) {
                            str = st.peek();
                            char c = str.charAt(Integer.parseInt(second) - 1);

                            bufferedWriter.write(String.valueOf(c));
                            bufferedWriter.newLine();

                        }
                        break;
                }
            } else if (!st.isEmpty()) {
                st.pop();
            }

        }


        bufferedReader.close();
        bufferedWriter.close();
    }
}
