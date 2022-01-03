# 2021AdventCode
Advent of Code 2021 code

This repository is ongoing, and contains all of my solutions to the 2021 Advent of Code puzzles. All of the solutions were written in Java. 



Day 1, Part 1 and 2

The first day, both parts, was fairly straightforward. First, I had to find out how many times the given input increased compared to the previous value in the input. The second part required me to count the number of times the sum of a set of segments increased compared to the previous segement. These were algorithms I had written before. I did learn how to use "parseInt", which allowed me to convert the input into number values. This proved useful for nearly all the other days. 

Day 2, Part 1 and 2

The second day, both parts was also fairly straightforward. I had to use a set of rules to determine the final position of the submarine. I found that combining parseInt with substring methods allowed me to set up the needed equation to determine the location in a more efficient manner. The second part merely altered the rules, the same reasoning was used. 

Day 3 Part 1 and 2

Day 3 was a little trickier compared to the previous two, but still fairly easy. Using an input in binary, I had to create a binary number using the most common bits, and the least common bits. That part was a fairly easy set of for loops. I discovered that I could use "parseInt(String,2)" to convert from binary back to a normal number. The second part had me follow these same rules, but additionally eliminate any line of binary that did not match the most common or least common bit. This was somewhat harder than the first part. I iterated through my list of combinations, removing anything that did not match, until I had one left for most common and least common. 

Day 4 Part 1 and 2

Day 4 required me to import a set of bingo grids, and to figure out the scores for them. The hardest part initially for this day was understanding how the important method I had been using worked, and making modifacations to it to ensure that I could successfully create multiple 2d arrays. The import process required keeping track of how far through I had gone, in order to keep the right size for each grid. After that, the actual code was fairly simple, only requiring a set of nested for loops to iterate through all the 2d arrays. I learned how to make and use a 3d array, which was what I stored all of my 2d arrays within. 

Day 5 Part 1 and 2

Day 5 served as a mental turning point in terms of how I addressed the puzzles. For this puzzle, I created an object to represent each range of points given in the input. I titled it hydropoints. From there, I made a 2d array to represent the map, and would iterate through a list of my point objects, to update the map. Updating the map merely increased the respective position, hence the 2d array. From there, I just needed to iterate through the 2d array and count all instances over the set value. The Second part to the puzzle was trickier, as I had to consider diagnol lines on top of vertical and horizonatal. To handle this, I checked the slope of the line based on the values in the point object, and iterated from there. 

Day 6 Part 1 and 2

Day 6 was a particularly fun puzzle. I had to model the exponential growth of a fish that reproduced every 7 days, and then determine the number of fish after a certian period of time. The first part was easy enough, modeling only 80 days. I had an arraylist, and a loop, and with each iteration, every value inside was increased by one. Once the value hit the needed mark, a new value was added to the arrayList, and the previous value was reset. This worked perfectly fine for the first part, but ended up crashing my computer on the second part. The second part was functionally the same thing, only 256 days instead of 80. In order to deal with the very large number in play, I made a histogram to represent the number of fish at each count value until reproduction, instead of a list of every single fish. From there, using long numbers in Java, which I learned about during this puzzle, I was able to properly represent the large number of fish. 

Day 7 Part 1 and 2

This puzzle required me to find the "fuel" cost of moving crabs a certian distance. This was fairly simple. By subtracting the absolute value of the original position and iterating through all possible positions, I was able to find which position had the lowest fuel sum. I learned of the existance of java's Integer.MAX_VALUE, which I used to ensure that my starting number for lowest fuel was as high as possible. The second part used this same rhetoric to solve, just with a different fuel equation, as the rules had changed. 

Day 8 Part 1 and 2

This was an interesting puzzle. The first part had me take a string of random letters, and based on the length, determine what numerical value was assigned to them. This part of the puzzle was very easy. I used a "clock" object, mostly to keep track of the different parts to the input. The second half of the puzzle I was unable to get working. I suspect I misunderstood the task. It seems, in hindsight, that I am supposed to use the first part of the input, determine the positions of each letter to form a number, then use that to translate. That results in needing to identify 10 possible combinations, something that I was unsuccessful in implementing. 

Day 9 Part 1 and 2

For this puzzle, I had to determine the risk level of a 2d array using the input values. I iterated through the 2d array, checking if the value was considered risky. If so, 1 + the value of the location was added to the overall risk value. This part was fairly easy, as by this point importing and handling 2d arrays was making sense to me. The next part was to identify the three largest "basins", which were just large regions that were low/risky. I then multiplied these together. I leanred that there is a method to automatically sort ArrayLists. 

Day 11 Part 1 and 2

Another 2d Array puzzle. It is almost as if I ended up specifically picking those first... With this puzzle, I had a 2d array, and every iteration, or step, anything at a certian value would "flash". I made a method that first iterates through the entire 2d array, then another one to update the 2d array, and each respective value, then another method to check for the "flashes" so that it could count them, and reset them. I found out I can make a "private static int", that I could reference throughout the program, seemingly without a dedicated object. That was very useful in tracking the flashes without having to pass the flash value back and forth, as the bulk of program functioned recursively to handle the chain reaction of flashes. For the second part, I just needed to find out when all the values would be 0 at the same time. I added a check within my loop that simple would check if everything was all 0s. Until it was true, the loop would contine and the count would continue. 

Day 13 Part 1 and 2

Much like past puzzles, I had an object to handle coordnates for the puzzle. The puzzle required me to create an program to "fold" the digital paper based on the given coords. Using absolute value, the first part was fairly simple. I had a 2d array of 1s and 0s, and each fold added 1s to the now smaller area. This worked fine for the first part. The second part required printing this out to see a set of letters. I was unable to come up with a readable way to see the letters, as all the methods I used to print the 2d array resulted in a painful to read grid of characters or numbers. Part 2 is a work in progress, as the picture is still incomprehensible.

Day 15 Part 1 and 2

At this point one might notice a trend in what I consider the fun puzzles. Day 15 is yet another 2d array. In this case, using a similar line of reasoning to day 9, I want to find the lowest risk value path from one corner to the other. Using a set of nested for loops and if statements, my code found the lowest values, creating a path. From there, I added it up. The second part, I had to make the map larger, based on the input values. I wrote a method to create a new 2d array, in the updated size, which then iterated through the old array and created the new larger one. Then I used the same mapping method to find the risk value. 

Day 17 Part 1 and 2

Day 17 was interesting as it required calculating trajectories, and the arc in which the coords would follow. The first part was very easy, I just had to multiple the minimum y value - 1 by the minimum y value over 2. The second part was a lot more complicated. Since I solved the first part with an equation, I assumed there was another equation I could use for trajectory. I found an equation called Gauss' sum formula, which was something used for space trajectory calculations. Surprisingly it worked. The second part I merely tested every possible launch. I learned that I need to be very careful with the order that I list parameters, and that it matches my method calls, as I accidently called xMax yMin, and that may have caused several issues. 

Day 22 Part 1 and 2

I started this one off by making an object to handle the cubes. This particular puzzle was time consuming. I ended up making a lot of arraylists of objects in this puzzle. I learned about java's continue method, which when used in a loop is similar to just saying i++. It checks if a condition is true, and if it is, it continues iterating. It was helpful for just ensuring a very specific set of conditions were avoided. The cube object that I used had the main job of using an absurd amount of if statements to check the conditions to turn on each cube. 

Day 25 Part 1

Since as of when I started writing this I do not have all 50 stars, part 2 is not yet accessible to me. The first part however, was not too bad. I made a 2d array of chars, to handle the input. I had somewhat forgot that I could make 2d arrays that were not number based. I made a while loop, and simply counted the iterations until nothing could move, using 2 methods to check if anything could move, and updating the grid when they did. 

End Comments

Overall, the Advent of Code puzzles have been very interesting. I have become a lot more proficient with 2d arrays, potentially even enjoying them. I found the value in recycling my own code, or at least the original thoughtprocess behind them. I became more comfertable with objects, and began to integrate them into my solutions. I also learned a few new java methods that I did not know about, mostly by accident, which helped increase my overall understanding, and improved the efficiency of my code. Time permittingly, I will continue to add the missing days as I figure out more java, and potentially optimize past programs within that may have been made in an inefficient manner. 
