# Project 4 @ CSC 201 Fall 2024: Hash Tables

## Pledged Work Policy

This is a ___Pledged Work___ assignment.  This means that the work you submit for grading ___must___ be your work product.  
You may not submit the work of others outside of your team, or the modification of work of others outside of your team.
You are encouraged to talk with each other about general problems.  For example, you may talk to someone about "What does
it mean when the compiler says there is a semicolon missing on line 20", or "I can not get my assignment template to
download from GitHub, what did you do?".  However, you may not engage in "Could you send me a copy of your work so I can
see how to get started?".  You may get full and detailed assistance from me, the Teaching Assistant (TA), and the TAs in
the Computer Science Center.  If you have any question about the appropriateness of assistance, do not hesitate to
consult with me.

If I believe you have violated our ___Pledge Work___ agreement, I will pursue this matter through the college Honor Council.

## Overview

A hash table is a fundamental data structure that stores key-value pairs. It uses a hash function to compute an index
(hash) into an array of buckets or slots, from which the desired value can be found. The hash function is used to 
transform the key into the index of the array that will be used to store the value. Hash tables offer average case 
O(1) time complexity for lookups, insertions, and deletions, assuming that the hash function is well-designed and the
load factor is kept low.

In this project, you will 

1. Implement a hash table that uses separate chaining to handle collisions.
2. Perform the hash table insert, search, and delete operations using already-sorted, shuffled, and reversed datasets 
lists as input.
3. Time the insert, search, and delete operation performances for the different number of inputs.
4. Graph and analyze the performance of the hash table operations.
5. Document your dataset and results in a `README.md` file.

## Invocation and I/O Files:

The name of the program is `Proj4` ( provided with a `main` method in`Proj4.java` ).

You are encouraged to run and debug code in __IntelliJ IDEA__. Also, the program can be invoked from the command-line as:

```shell
java Proj4 {dataset-file} {number-of-lines}
```
## 1. **Implement Separate Chaining Hash Table**

I have enclosed one starter code:
1. `SeparateChainingHashTable.java`
2. `TestSeparateChainingHashTable.java`
3. `Proj4.java`

The `SeparateChainingHashTable.java` file contains an overall structure of that Separate Chaining Hash Table class, and 
you are expected to complete the code where it is indicated (Search for // FINISH ME). The 
`TestSeparateChainingHashTable.java` file must not be modified, and it will be used for testing your Separate Chaining 
Hash Table class. It does not check for every error, but I hope that it will be helpful for you. The Proj4.java file 
contains a starter code for you to implement the main driver of the program.

The program takes in two command line arguments: 1) the filename if your dataset and 2) the number of lines of your 
dataset to read.

## 2. **Perform Hash Table insert, search, and delete operations on Already-Sorted, Shuffled, and Reversed Lists**

You will read your dataset and store the data in an ArrayList. To sort and randomize your ArrayList, you will use the
`Collections.sort()`, `Collections.shuffle()`, and `Collections.sort(al, Collections.reverseOrder())` commands,
respectively.

## 3. **Time Sorting Algorithm Performance**

For the hash table insert, search, and delete operations, you will use `System.nanoTime()` to calculate
the time it takes to run them on already-sorted, shuffled, and reversed lists.

Your program will print out the number of lines evaluated and the times insert, search, and delete each of the dataset 
elements into the already-sorted, shuffled, and reversed lists to the screen in a human-readable format (i.e., nice to 
look at) and also separately to a file named `analysis.txt` in CSV format. Each time the program runs, it will append 
the timing results to `analysis.txt`. At the end of your run, your hash table should be completely empty.

## 4. **Graph and Analyze the Performance of the Sorting Algorithms**

Run your program several times for different number of lines of your dataset, N, by choosing different values of the
second command line argument. After several runs, your `analysis.txt` file will be filled with timing and comparison data.

Using your favorite graphing software (e.g., MS Excel or Google Sheets), plot the running time (in seconds) vs. N for 
each case. Take a screenshot of your graph and put them here by modifying this file, committing, and pushing
it to this repository.

![Firefly picture of a cat 86147](https://github.com/user-attachments/assets/8b2d008e-3011-4979-97b8-fa2e9886a01a)

<img width="493" alt="Screenshot 2024-12-05 at 9 01 37 AM" src="https://github.com/user-attachments/assets/c8a0fd62-69ac-4999-935b-37de3a105cda">


Insertion, search, and deletion running time (already sorted):

<img width="575" alt="Screenshot 2024-12-05 at 9 02 03 AM" src="https://github.com/user-attachments/assets/40ee9704-1c0e-4ef2-88a1-7baafdefe64d">


Insertion, search, and deletion running time (shuffled):

<img width="576" alt="Screenshot 2024-12-05 at 9 02 20 AM" src="https://github.com/user-attachments/assets/12074fe3-ff00-4cea-a8d1-0f559b14acce">


Insertion, search, and deletion running time (reversed):

<img width="589" alt="Screenshot 2024-12-05 at 9 02 12 AM" src="https://github.com/user-attachments/assets/90a67cd8-9cf8-4194-a877-fd66b9704413">



## 5. **Document your Dataset and Results**
Document the source of your dataset and any modifications you made to it. Describe the results of your analysis and 
how it compares to the theoretical performance of the hash table operations.

Dataset Source: Kaggle: https://www.kaggle.com/datasets/harios/box-office-data-1984-to-2024-from-boxofficemojo

Dataset Modifications ("None" if unchanged): None

Result Analysis: 

Insert Operation Analysis:

Sorted Data: The insert time decreased as the size of the dataset increased. With 500 data entries, the insert time was approximately 0.00000792 seconds, while for 5000 entries, it dropped to 0.00000709 seconds. This decrease is likely due to amortized constant time performance since the hash table is efficient in handling ordered inputs without the need for a lot of rehashing.

Reversed Data: The insert time was initially higher at 0.00001708 seconds for 500 entries, but decreased to 0.00000917 seconds for 5000 entries. The reversed order may have caused increased collisions early on, leading to longer insertion times. As the table filled and more buckets became available, performance improved.

Shuffled Data: Overall showed a minor decrease. The values ranged from 0.00000833 seconds for 500 entries to 0.00000625 seconds for 5000 entries. The shuffled nature of the data may cause more collisions, but it appears the hash table handled these collisions well, showing solid performance.

Conclusions: The insertions were generally fast across all datasets, with slight differences that can be attributed to the number of collisions encountered due to data ordering. The theoretical performance of hash table operations is O(1) for insertion, so I would say these results are as expected.


Search Operation Analysis

Sorted Data: The search time remained somewhat consistent with a slight decrease as the dataset increased. It started at 0.000001125 seconds for 500 entries and dropped to 0.000000709 seconds for 5000 entries. This is expected behavior, showing efficient look-up even for larger datasets.

Reversed Data: Similar to the shuffled data, search times were consistent. Starting at 0.000000542 seconds for 500 entries and remaining close to this value for larger datasets. This reflects the hash table's efficiency, regardless of data order.

Shuffled Data: The search time showed consistency across all sizes, averaging around 0.0000005 seconds. This suggests that the hash table's distribution of data was working well, resulting in a small difference between shuffled and sorted inputs.

Conclusions: The search times were very consistent, reinforcing the O(1) performance characteristic of hash tables.


Delete Operation Analysis

Sorted Data: The delete operation times were pretty stable, but showed some fluctuations. It started at 0.00000833 seconds for 500 entries and decreased to 0.00000667 seconds for 5000 entries. The performance here is expected to be similar to insert operations due to the hash table needing to locate the element before removal.

Reversed Data: The delete time remained consistent, starting at 0.00000666 seconds for 500 entries and slightly decreasing to 0.00000458 seconds for 5000 entries.

Shuffled Data: The delete times were very consistent across the different sizes, averaging around 0.00000458 seconds. The uniform distribution of keys seems to help maintain similar deletion performance.

Conclusions: The deletion times showed minimal fluctuation, similar to the insertion times, which is expected since deletion also involves searching for the key first.

## Submission:

Your project will be developed and graded via GitHub. Your final "push" is your final submission, and it must occur
before it is due. On Canvas, enter the url to your Github repository. Your project will not be graded without it.

## Recommendations:

I ___strongly suggest___ that you carefully think through your strategy before just jumping into the code.  Once that
is working, start adding in new features individually.  A good place to start is building your class.

*In order to get full points of Commenting and Code Style, you need to add comments to every method and head comments
for each file (providing file description, author, date, and acknowledgement).

```
/∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗*
∗ @file: filename.java
∗ @description: This program implements . . .
∗ @author: Your Name
∗ @date: December 5, 2024
∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗/
```
