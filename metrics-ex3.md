
| Class | LOC | WMC | CBO | LCOM | Quick Notes |
| --- | --- | --- | --- | --- | --- |
| `Bank` | 412 | 14 | 3 | 0 | This class's methods do a significant amount of management work. It seems worthy of prioritizing for maintenance. |
| `BankAccount` | 469 | 20 | 2 | 44 | This is not worrying, the high number is caused by the getters & setters. |
| `Person` | 324 | 23 | 0 | 79 | Same remarks as `BankAccount` |
| `BankAccountApp` | 482 | 2 | 3 | 1 | This represents the main application loop and takes care of the most important actions in the app. It's a priority for maintenance. |

### Remarks :

- `Person` has the highest WMC.
- `Bank` and `BankAccountApp` have the highest CBO.

Despite `Person` and `BankAccount` having the highest WMC+CBO+LCOM number, I would rather ignore these because the number is offset by the number of getters and setters. I would rather choose to worry `BankAccountApp` because it only has one function with a high CC value of 40.
