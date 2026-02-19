# RLAD - Record Losses And Debt

A minimalistic, user-centric financial tracker.

## Project Structure

```
src/main/java/seedu/RLAD/
├── RLAD.java                 # Main entry point
├── Parser.java               # Parses user input, creates Command objects
├── Transaction.java          # Transaction data model
├── TransactionManager.java   # Data storage (Model layer)
├── TransactionSorter.java    # Sorting utility for transactions
├── Ui.java                   # User interface / output display
├── Logo.java                 # ASCII logo
├── exception/
│   └── RLADException.java    # Custom exception
└── command/
    ├── Command.java          # Abstract base class
    ├── AddCommand.java       # Add new transaction
    ├── DeleteCommand.java    # Delete transaction by ID
    ├── ModifyCommand.java    # Modify existing transaction
    ├── ListCommand.java      # List transactions (with optional sorting)
    ├── FilterCommand.java    # Filter transactions by type/category/amount/date
    ├── SortCommand.java      # Set global sort order
    ├── SummarizeCommand.java # Summarize transactions
    └── HelpCommand.java      # Show help
```

## Architecture

The project follows the **MVC pattern** with the **Command Design Pattern**:

```
┌─────────────────────────────────────────────────────────────────┐
│                           USER INPUT                            │
│               (e.g., "add --type credit --amount 50")          │
└─────────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────────┐
│  PARSER (Parser.java)                                           │
│  • Validates command format                                     │
│  • Acts as Factory - creates appropriate Command object        │
│  • Does NOT interact with TransactionManager                   │
└─────────────────────────────────────────────────────────────────┘
                              │
                    returns Command object
                              ▼
┌─────────────────────────────────────────────────────────────────┐
│  COMMAND (Command.java - base class)                            │
│                                                                  │
│  ┌──────────────┐ ┌──────────────┐ ┌──────────────┐           │
│  │ AddCommand   │ │DeleteCommand │ │ ListCommand  │  ...       │
│  │              │ │              │ │              │           │
│  │ execute()    │ │ execute()    │ │ execute()    │           │
│  │ → addTrans() │ │ → delete()   │ │ → getTrans() │           │
│  │              │ │ → find()     │ │ + sort       │           │
│  └──────────────┘ └──────────────┘ └──────────────┘           │
└─────────────────────────────────────────────────────────────────┘
                              │
              uses TransactionManager methods
                              ▼
┌─────────────────────────────────────────────────────────────────┐
│  TRANSACTION MANAGER (TransactionManager.java)                  │
│  • Model layer - handles data storage                          │
│  • CRUD operations: add, find, delete, update, get              │
│                                                                  │
│  ┌────────────────┐ ┌────────────────┐ ┌────────────────┐      │
│  │addTransaction()│ │findTransaction()│ │getTransactions()    │
│  │deleteTransaction()    │updateTransaction()  │                    │
│  └────────────────┘ └────────────────┘ └────────────────┘      │
└─────────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────────┐
│  UI (Ui.java)                                                   │
│  • Displays results to user                                    │
└─────────────────────────────────────────────────────────────────┘
```

## How Commands Use TransactionManager

| Command | TransactionManager Methods Used |
|---------|--------------------------------|
| **AddCommand** | `addTransaction(t)` |
| **DeleteCommand** | `findTransaction(id)`, `deleteTransaction(id)` |
| **ModifyCommand** | `findTransaction(id)`, `updateTransaction(id, t)` |
| **ListCommand** | `getTransactions()` + `TransactionSorter.sort()` |
| **FilterCommand** | `getTransactions()` + `buildPredicate()` + `TransactionSorter.sort()` |
| **SortCommand** | Sets global sort field/direction on `TransactionManager` |
| **SummarizeCommand** | `getTransactions()` |

## Setup

### Prerequisites
- JDK 17

### Build
```bash
./gradlew build
```

### Run
```bash
./gradlew run
```

## Usage

```
add --type <credit/debit> --amount <amount> --category <category>
list
list --sort <amount|date>
filter --type <credit/debit> --category <category> --amount <operator> <value>
sort <amount|date> [asc|desc]
delete <id>
modify <id> --amount <new amount>
summarize
help
```
