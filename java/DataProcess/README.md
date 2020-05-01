##READ ME

I've included all the source codes in the project using Java;

To run, extract the original .gz file and put it into `/tmp/` folder.

To compile the project, using `mvn compile` or `mvn clean package`

I split the big file into small files, using a split number can be changed to fit the need;

Then use userId % m to split the file; process each file (since each file only contains certain users' data)

Eventually I merge them together in `step3` and generate the final result.

Time Complexity:
1. File read line by line, so it is O(N), N is lines in the file
2. For each file, I read each line and create map, so it is O(N);
3. Final merge also takes O(N);
So, it is O(N)

Space Complexity:
1. I used Map<Integer, Set> to trace how many url a user visited,
so it will be O(N)
2. I split the large file to smaller ones, it will also take some spaces;

Assumption:
1. The URL format will always like that, so I remove the prefix, and 
use Integer to store it (to save some spaces and improve the speed), but it will break
if the format changes;
2. I also use Integer to represent user id, it could break if it is a String not a Integer;

Final thoughts:
1. I should add some unit tests for testing;
2. This is a typical Hadoop map-reduce program, will more fit for the distributed computing;
3. If the format for each line has some extra spaces, it will break the program;

Thank you.