# Bead Sort (Descending) Implementation in Java

## Project Description

This project implements the **Bead Sort** algorithm in Java without using any built-in sorting functions. The program sorts a list of integers in **descending order** while also tracking the number of **comparisons** and **swaps (movements)** performed by the algorithm.

The project also includes performance experiments where the algorithm is executed on lists of different sizes to observe how the number of operations and execution time grow as the input size increases.

---

## How the Bead Sort Algorithm Works

Bead Sort is inspired by the natural behavior of gravity. It works by representing numbers as rows of beads on vertical rods.

The algorithm follows these steps:

1. Each number in the list is represented by a row of beads.
2. The number of beads placed in a row corresponds to the value of that number.
3. The beads are arranged in vertical columns.
4. Gravity is simulated, causing beads to fall downward in each column.
5. After the beads settle, the number of beads in each row forms the sorted list.

> In this implementation, the resulting list is **reversed** at the end in order to produce descending order.

---

## Step-by-Step Example

Consider the list:

```
[5, 3, 1, 7, 4]
```

### Step 1 – Represent Numbers as Beads

```
5 → *****  
3 → ***  
1 → *  
7 → *******  
4 → ****
```

### Step 2 – Align Beads in Columns

```
Row representation:

*******  
*****  
****  
***  
*
```

### Step 3 – Apply Gravity

Beads fall to the bottom of each column. After gravity is applied, the rows correspond to sorted values.

```
1
3
4
5
7
```

### Step 4 – Reverse for Descending Order

Final result:

```
[7, 5, 4, 3, 1]
```

---

## Time Complexity Analysis

Let `n` represent the number of elements in the list.

| Case | Complexity | Description |
|------|------------|-------------|
| **Best Case** | `O(n)` | Numbers are already arranged such that minimal bead movement occurs. |
| **Average Case** | `O(n × m)` | `m` = maximum value in the list. The algorithm must process each bead in the bead matrix. |
| **Worst Case** | `O(n × m)` | Large numbers make the bead matrix large; gravity must be simulated across many beads. |

> This makes the algorithm less efficient than traditional sorting algorithms such as **Merge Sort** or **Quick Sort**.

---

## Space Complexity

```
O(n × m)
```

Where:
- `n` = number of elements
- `m` = maximum value in the list

The algorithm creates a **2-dimensional bead matrix** to simulate the beads falling under gravity. For large values of `m`, memory usage increases significantly.

---

## Experiment Results

The algorithm was tested on lists of different sizes as required by the assignment.

| Size | Comparisons | Swaps | Time (ns) |
|------|-------------|-------|-----------|
| 1 | 103 | 102 | 16,499 |
| 2 | 354 | 227 | 105,601 |
| 3 | 369 | 231 | 45,300 |
| 4 | 228 | 170 | 27,901 |
| 5 | 985 | 416 | 85,499 |
| 10 | 1,690 | 801 | 918,300 |
| 250 | 49,750 | 23,339 | 7,346,101 |
| 999 | 198,801 | 101,567 | 5,511,900 |
| 9,999 | 1,989,801 | 980,999 | 213,998,100 |
| 89,786 | 17,867,414 | 8,926,937 | 467,231,500 |
| 789,300 | 157,070,700 | 78,542,144 | 3,016,490,399 |
| 1,780,000 | 354,220,000 | 177,117,182 | 8,462,072,800 |

---

## Experiment Analysis

From the experimental results, the following trends are observed:

### 1. Comparisons and Swaps Increase Rapidly
As the input size increases, both comparisons and swaps grow significantly. This occurs because Bead Sort processes every bead in the bead matrix.

### 2. Execution Time Increases with Input Size
The runtime increases dramatically for larger inputs. For example:
- Sorting **10 elements** takes less than a millisecond.
- Sorting **1.78 million elements** takes several seconds.

### 3. Memory Usage Grows with Maximum Value
Since Bead Sort creates a matrix whose width depends on the maximum number in the list, large values increase memory usage considerably.

### 4. Algorithm is Not Practical for Large Datasets
Although Bead Sort is an interesting algorithm conceptually, it is **not commonly used in real systems** due to its high memory consumption and `O(n × m)` complexity.

---

## Repository

**EB3/67277/23 – Mike Mwongela**  
🔗 [https://github.com/Mike-205/Bead-Sort-Assignment-Desc](https://github.com/Mike-205/bead-sort-assignment)