## Exercice 1


| Class | LOC | NOM | Short description of responsability |
| --- | --- | --- | --- |
| `Bank` | 412 | 14 | This class manages the bank accounts, it can also save them and transfer money between the accounts. |
| `BankAccount` | 469 | 20 | Class that holds information about a bank account (balance, limits, amount withdrawn, etc.) with getters, setters, a constructor and a way to load an account from a text file. |
| `Person` | 324 | 23 | Class that holds a couple attributes related to a person, with a few constructors and a validation method. |
| `BankAccountApp` | 482 | 2 | Contains the code that runs the app with a bank, as well as a CLI to interact with the bank. |

### Do you feel its size roughly matches its responsibility?

Definitely not, but the size of the classes that have little responsibility is still high mainly due to the boilerplate caused by the getters and setters.




