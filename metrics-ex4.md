These are 3 issues found by SonarQube that I would consider as important (sorted by priority):

- Removing assignment of static fields in constructors. This can easily lead to unintentional and unpredictable behaviour. Example of this issue : `private static ArrayList<BankAccount> Accounts` found in `Bank.java`

- Making fields static when applicable, like the following :
`private final int initialSize = 1000` found in `Bank.java`.
- Removing class fields and declaring it as a local variable in the relevant methods. For instance `private boolean success` in `BankAccount.java` is only used in one method `withdrawMoney`.

Fixing these issues has caused their corresponding reports to disappear.

It seems as though SonarQube issues are mainly found in files that have the higher WMC / CBO values, however they're mainly due to the lack of application for Java conventions and have little impact on the performance of the app. Although, they're still worth giving attention to as it helps maintaining the project.