/**
 * @author Muhammad Faisal
 * @class Project3.java contains the main functionality to solve maze of 10x10 provided in given data file.
 * @func  FindWay() is to finds the possible path and marks the value '2' to constitute the path.
 * @func  PossibleToMove() visits the very next value in every direction i.e. east, north, west and south to find possible move
 * @func  printMaze() prints the maze table.
 * */
import java.io.BufferedReader;
import java.io.FileReader;

public class Project3 {
	
	/*Declaration*/
	static LinkedStack trackStack = new LinkedStack();  //Since we need to retrieve coordinates in reverse order.
	static int[][] maze = new int[10][10]; //because given maze tables are of 10x10.
	static int[][] temp = new int[10][10];  //size of temp must be of size maze
	
	static boolean found = false;  //for storing the status if the given location is equal to the destination.
	static int nr;  //for next row
	static int nc;  //for next column
	
	public static void main(String[] args) {
		String[] row;// for splitting the values of one line into
		
		if(args.length == 0) System.out.println("No file specified.");  //At least one argument should be passed via command line.
		else{
			FileReader theFile;  
			BufferedReader inFile;
			String oneLine;  //To store single line read from file
			try{
				theFile = new FileReader(args[0]);   // The only argument is provided data-file.
				inFile = new BufferedReader(theFile); 
				oneLine = inFile.readLine();  //reads first line from the file.
				while(oneLine !=null){  //since the line after the last line is always null.
					row = oneLine.split(" ");  //because every entry is separated by space bar " ".
					/* nested loop structure to read one complete table.*/
					for(int i=0;i<=9;i++){ //outer loop for one Maze table.
						for(int j=0;j<=9;j++){// inner loop for all the row entries.
							maze[i][j]= Integer.parseInt(row[j]);  //initialization of the maze
						}//end inner for
						oneLine = inFile.readLine();// this line is not null but contains no character
						if(oneLine != null){  // because splitting null line would throw exception.
							row = oneLine.split(" ");	//for next row of the current table.
						}
					}//end outer for
						
					/*nested loop structure to copy maze values into temp other doing 'temp=maze' temp and maze would refer to the same location in memory. */
					for(int i=0;i<maze[0].length;i++){
						for(int j=0;j<maze[0].length;j++){
							temp[i][j]=maze[i][j];// manually copying every value from maze to temp
						}
					}
					//temp = maze; //each 'maze' should be copied in 'temp' because original maze cannot be changed until printing solution.
					found = false; //because we cannot say there exist a solution before solving a maze. 
					
					Findway(0,0,9,9);  //determins the value of 'found'
					if(!found) {System.out.println("No solution is possible of this maze. Displaying no table because unsolvable maze is not asked to display.");
						System.out.println('\n');
						}
					else{
						printMaze(); System.out.println('\n');	//calling printMaze() for printing and new line to keep the distance b/w outputs of different mazes.
					}
					
					trackStack.makeEmpty(); //stack should be empty before and after solving a maze
					oneLine = inFile.readLine();  //this line could be null or first line of the 2nd maze.
					
				}//end while
			}
			catch (Exception e) {System.out.println(e);} //in case of an exception.
		}// end try-catch clock		
		
	}//end main
/**
 * * Traverses the consecutive zeros and to determine the possible path from starting position to destination. Also marks
 *  the value '2' all the way down from [0,0] to [9,9] to constitute the path. 
 * @param sr is short for starting row.
 * @param sc is short for starting column.
 * @param dr is short for destination row.
 * @param dc is short for destination column.
 * 
 */

public static void Findway(int sr, int sc, int dr, int dc){  // s: start d destination
if(sr==dr && sc==dc) found =true;  //comes true if and only if, the starting coordinates are equal to destination ones.
else{//
	if(!trackStack.isEmpty() && !PossibleToMove(sr,sc)) System.out.println(">>> Start backtracking from ["+sr+", "+sc+"]"); /*in first
	iteration, this condition is false. But printing begins from 2nd iteration when non empty stack is encounter with no possible to move
	location. Which means a new location to start backtracking from.*/
	temp[sr][sc]=1;  //to avoid re-traversal since only zero are traversed.
	trackStack.push(sr, sc); //to keep track of the pair of coordinates, they are pushed into the stack to get them later in reverse order	
	
	while(!found && PossibleToMove(sr,sc))  //for keep looking the possible path until there's no possible move or destination is got.
		Findway(nr, nc, dr, dc); //recursive call from the current location/coordinates
	}
			
if(found) maze[sr][sc] = 2;  // mark the path

else if(trackStack.size()!=1) { //from the last pair of coordinates, there's no need to backtrack.
	System.out.print(">>> Backtracking from ["+trackStack.top().getX()+", "+trackStack.pop().getY()+"]  to ");//printing and poping current location
	System.out.print("["+trackStack.top().getX()+", "+trackStack.top().getY()+"]"); System.out.println(); //printing and poping next location.
   }
}//End Findway()	



/*returns false if there is no place to go from (sr, sc) otherwise return true and sets(nr, nc) to a new position.*/
private static boolean PossibleToMove(int sr, int sc) {
	 if(sc<temp[0].length -1 && temp[sr][sc+1]==0){
		 nc = sc+1;  //moving to the east
		 nr = sr;
		 return true;
	}
	 else if(sr>0 && temp[sr-1][sc]==0){
			nr = sr-1;  //moving to the north
			nc = sc;
			return true;
		
		} 
	 else if(sc>0 && temp[sr][sc-1]==0){
			nc = sc-1;  //moving to the west
			nr = sr;
			return true;
		}
	 else if(sr<temp[0].length -1 && temp[sr+1][sc]==0){
		 nr = sr+1;  //moving to the south
		 nc = sc;
		 return true;
	}
	else{

		return false;  //the only case when no possible to move location exists. 
	}
	}



private static void printMaze() { //for printing Maze table.
	for(int i=0;i<maze[0].length;i++){
		for(int j=0;j<maze[0].length;j++){
			System.out.print(maze[i][j] + "   ");
		}
		System.out.println();
	}
	}

}
