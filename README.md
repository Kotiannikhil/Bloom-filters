# Bloom-filters

For a description about the project, kindly refer project2.pdf.

Description of the files and how to run them:

There are 3 java files, one for each type of bloom filter.
1. bloom.java for the bloom filter
2. countingb.java for the counting bloom filter 
3. codedb.java for the coded bloom filter

There are 3 text files, one for each algorithm's output (Note: These text files will be overwritten each time you run the code)
1. bloom.txt for the bloom filter
2. countingb.txt for the counting bloom filter 
3. codedb.txt for the coded bloom filter 

There is one README.md file

To run the programs:
1. To compile the java program, write "javac <file_name>.java". For instance, "javac bloom.java" for the bloom filter program.
2. To run the program, write "java <file_name>".  For instance, "java bloom" for the bloom filter program.
3. When you run it, you will be asked to enter the input based on the program you are running.
	 So the number of elements to be encoded, the number of bits in the filter and the number 
	 of hashes in case of the bloom filter.
4. Once you enter that, the program will execute and the output will be added to a text file (for example: bloom.txt for the bloom filter).
5. The output file contains the required output depending on the program you are executing.
	 For instance, the number of elements you find in the filter after a lookup on elements in A for the counting bloom filter.
6. Repeat the above process for all three algorithms.
