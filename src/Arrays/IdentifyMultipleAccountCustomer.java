package Arrays;

import java.util.*;

/**
 * Sample Input:
 * (1, 103)
 * (2, 107)
 * (1, 107)
 * (2, 103)
 * (4, 64)
 * (6, 120)
 * (7, 107)
 * (8, 180)
 * (7, 64)
 * (9, 129)
 */

public class IdentifyMultipleAccountCustomer {

    public static void main(String[] args) {
        Scanner standardInput = new Scanner(System.in);
        System.out.println("Enter the total number of account input ");
        int numberOfInput = Integer.valueOf(standardInput.nextLine());
        System.out.println("Enter the account information ");
        Set<Integer> matchingAccountHolders = new HashSet<>();
        Map<Integer, List<Integer>> customerAccounts = new HashMap<>();

        for (int i = 0; i < numberOfInput; i++) {
            int userId = Integer.parseInt(standardInput.next());
            int accountNumber = Integer.parseInt(standardInput.next());


            if (customerAccounts.get(userId) != null) {
                List<Integer> existingAccount = customerAccounts.get(userId);
                existingAccount.add(accountNumber);
                if (existingAccount.size() > 1)
                    Collections.sort(existingAccount);
                customerAccounts.put(userId, existingAccount);
            } else {
                List<Integer> newAccount = new ArrayList<>();
                newAccount.add(accountNumber);
                customerAccounts.put(userId, newAccount);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : customerAccounts.entrySet()) {
            int accountNumber = entry.getKey();
            List<Integer> accountList = entry.getValue();
            Set<Integer> userIdsToVerify = customerAccounts.keySet();
            for (int userId : userIdsToVerify) {
                if (userId != accountNumber) {
                    List<Integer> accountsToVerify = customerAccounts.get(userId);
                    if (arraysEquals(accountList, accountsToVerify)) {
                        matchingAccountHolders.add(accountNumber);
                        matchingAccountHolders.add(userId);
                    }
                }

            }
        }

        System.out.print("The customer ID's with matching accounts are : " + matchingAccountHolders);
    }

    private static boolean arraysEquals(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne == null || arrayTwo == null)
            return false;
        if (arrayOne.size() != arrayTwo.size())
            return false;
        for (int i = 0; i < arrayOne.size(); i++) {
            if (!arrayOne.get(i).equals(arrayTwo.get(i)))
                return false;
        }
        return true;
    }
}
