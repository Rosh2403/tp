# RLAD User Guide

## Table of Contents
- [Introduction](#introduction)
- [Quick Start](#quick-start)
- [Commands](#commands)
  - [Adding a transaction: `add`](#adding-a-transaction-add)
  - [Listing transactions: `list`](#listing-transactions-list)
  - [Deleting a transaction: `delete`](#deleting-a-transaction-delete)
  - [Modifying a transaction: `modify`](#modifying-a-transaction-modify)
  - [Viewing a summary: `summarize`](#viewing-a-summary-summarize)
  - [Getting help: `help`](#getting-help-help)
  - [Exiting the app: `exit`](#exiting-the-app-exit)
- [UI Examples](#ui-examples)
- [FAQ](#faq)
- [Command Summary](#command-summary)

## Introduction

Record Losses And Debt (RLAD) is a minimalist CLI finance tracker for users who want to manage their
spending without the overhead of spreadsheets or bloated apps. Track your income and expenses, sort and
filter transactions, and get quick summaries of where your money is going -- all from your terminal.

## Quick Start

1. Ensure that you have **Java 17** or above installed.
2. Download the latest `RLAD.jar` from the [Releases](https://github.com/AY2526S2-CS2113-T06-4/tp/releases) page.
3. Copy the file to the folder you want to use as the home folder for RLAD.
4. Open a command terminal, `cd` into the folder, and run:
   ```
   java -jar RLAD.jar
   ```
5. You should see the RLAD welcome screen:
   ```
   ╔════════════════════════════════════════════════╗
   ║       ██████╗  ██╗       █████╗  ██████╗       ║
   ║       ██╔══██╗ ██║      ██╔══██╗ ██╔══██╗      ║
   ║       ██████╔╝ ██║      ███████║ ██║  ██║      ║
   ║       ██╔══██╗ ██║      ██╔══██║ ██║  ██║      ║
   ║       ██║  ██║ ███████╗ ██║  ██║ ██████╔╝      ║
   ║       ╚═╝  ╚═╝ ╚══════╝ ╚═╝  ╚═╝ ╚═════╝       ║
   ║              Record Losses And Debt            ║
   ╚════════════════════════════════════════════════╝

   Hello and welcome to RLAD!
   Handle your financial life from one spot without the spreadsheet headaches
   ```
6. Type a command at the `>` prompt and press Enter.

## Commands

All commands follow this format:

```
$action --option_0 $argument_0 ... --option_k $argument_k
```

### Adding a transaction: `add`

Adds a new credit (income) or debit (expense) entry.

**Format:**
```
add --type TYPE --amount AMOUNT --date DATE [--category CATEGORY] [--description DESCRIPTION]
```

| Flag | Required | Description |
|------|----------|-------------|
| `--type` | Yes | `credit` (income) or `debit` (expense) |
| `--amount` | Yes | Dollar amount (e.g. `15.00`) |
| `--date` | Yes | Date in `YYYY.MM.DD` format |
| `--category` | No | Category label (e.g. `food`, `transport`) |
| `--description` | No | Short description of the transaction |

**Example:**
```
> add --type credit --category food --amount 15.00 --date 2026.02.18 --description Hawker stall lunch set
```

> Note: `add` is currently under development. The command is recognised but execution logic is not yet implemented.

### Listing transactions: `list`

Displays your recorded transactions. Supports sorting by amount or date.

**Format:**
```
list [--sort FIELD]
```

| Flag | Required | Description |
|------|----------|-------------|
| `--sort` | No | Sort by `amount` or `date` (ascending) |

**Examples:**
```
> list
```
```
> list --sort amount
```
```
> list --sort date
```

**Sample output:**
```
[a7b2] DEBIT | 2026-02-10 | $5.50 | transport | Bus fare
[f1c3] DEBIT | 2026-02-15 | $25.00 | food | Lunch
[e9d4] CREDIT | 2026-01-01 | $3000.00 | salary | Monthly salary
```

> Note: Filtering by `--type`, `--category`, `--from`, and `--to` is planned but not yet implemented.

### Deleting a transaction: `delete`

Removes a transaction from the records permanently using its hash ID.

**Format:**
```
delete --hashID HASH_ID
```

**Example:**
```
> delete --hashID a7b2
```

> Note: `delete` is currently under development. The command is recognised but execution logic is not yet implemented.

### Modifying a transaction: `modify`

Updates specific fields of an existing entry via its hash ID.

**Format:**
```
modify --hashID HASH_ID [--type TYPE] [--amount AMOUNT] [--date DATE] [--category CATEGORY] [--description DESCRIPTION]
```

**Example:**
```
> modify --hashID a7b2 --amount 20.00 --description Fancy hawker lunch
```

> Note: `modify` is currently under development. The command is recognised but execution logic is not yet implemented.

### Viewing a summary: `summarize`

Provides a statistical overview of your finances.

**Format:**
```
summarize [--by GROUPING]
```

| Flag | Required | Description |
|------|----------|-------------|
| `--by` | No | Group by `category`, `month`, or `type` |

**Example:**
```
> summarize --by category
```

> Note: `summarize` is currently under development. The command is recognised but execution logic is not yet implemented.

### Getting help: `help`

Displays available commands and their usage.

**Format:**
```
help [COMMAND_NAME]
```

**Examples:**
```
> help
> help add
> help list
```

### Exiting the app: `exit`

Exits the application.

**Format:**
```
> exit
Thank you for abusing me!
 See you next time...
```

## UI Examples

Here is what a typical session looks like:

```
▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀
Hello and welcome to RLAD!
Handle your financial life from one spot without the spreadsheet headaches
Available actions:
  add       : Record a new transaction
  modify    : Edit an existing entry
  delete    : Remove an entry
  list      : View your transaction history with filters
  summarize : Get a high-level breakdown of your spending

Format:
	$action --option_0 $argument_0 ... --option_k $argument_k
Type 'help' for the full list or '$action help' for specific argument details.
▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀
> list --sort amount
Your wallet is empty! Use 'add' to record a transaction.
▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀
> exit
Thank you for abusing me!
 See you next time...
```

## FAQ

**Q**: How do I find the hash ID of a transaction?

**A**: Use the `list` command. Each transaction is displayed with its 4-character hash ID in square brackets
at the start, e.g. `[a7b2]`.

**Q**: Can I sort transactions in descending order?

**A**: Not yet. Currently, `--sort amount` and `--sort date` sort in ascending order only.

**Q**: What happens if I enter an invalid command?

**A**: RLAD will show an error message and display the list of available commands.

## Command Summary

| Command | Format | Status |
|---------|--------|--------|
| **add** | `add --type TYPE --amount AMOUNT --date DATE [--category CAT] [--description DESC]` | Planned |
| **list** | `list [--sort amount\|date]` | Working |
| **delete** | `delete --hashID ID` | Planned |
| **modify** | `modify --hashID ID [--type TYPE] [--amount AMT] [--date DATE] ...` | Planned |
| **summarize** | `summarize [--by category\|month\|type]` | Planned |
| **help** | `help [COMMAND]` | Working |
| **exit** | `exit` | Working |
