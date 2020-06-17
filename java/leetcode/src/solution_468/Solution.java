package solution_468;

public class Solution {
    public String validIPAddress(String IP) {
        if (IP.length() < 7) {
            return "Neither";
        }
        if (IP.contains(".")) {
            if (IP.startsWith(".") || IP.endsWith(".")) {
                return "Neither";
            }
            String[] items = IP.split("\\.");
            if (items.length != 4) {
                return "Neither";
            }
            for (String item : items) {
                if (item.length() == 0 || item.startsWith("0") && item.length() > 1 || item.startsWith("-")) {
                    return "Neither";
                }
                try {
                    int n = Integer.parseInt(item);
                    if (n > 255) {
                        return "Neither";
                    }
                } catch (Exception e) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else if (IP.contains(":")) {
            if (IP.startsWith(":") || IP.endsWith(":")) {
                return "Neither";
            }
            String[] items = IP.split(":");
            if (items.length != 8) {
                return "Neither";
            }
            for (String item : items) {
                if (item.length() == 0 || item.length() > 4 || item.startsWith("-")) {
                    return "Neither";
                }
                try {
                    Integer.parseInt(item, 16);
                } catch (Exception e) {
                    return "Neither";
                }
            }
            return "IPv6";
        }
        return "Neither";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }
}
