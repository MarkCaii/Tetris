public class Shape{
	private final int WIDTH = 10;
	private final int HEIGHT = 20;
	public int tempx1, tempx2, tempx3, tempx4, tempy1, tempy2, tempy3, tempy4;
	public int num, current;
	public int position = 1;
	int [] currentX = new int[4];
	int [] currentY = new int[4];
	int pivotx, pivoty;
	int tempMax = 0;
	int count = 0;
	boolean dropped;
	boolean rotated = false;
	boolean under = false;
	public void rotateS(int[][]grid) {
		//System.out.println(position);
		switch(position) {
			case 1:
				findCurrentPoint(grid);
				pivotx = tempx1;
				pivoty = tempy1;
				if(grid[tempy4+1][tempx4] != 0 && grid[tempy4+1][tempx4] != current) {
					currentX[0] = pivotx;
					currentX[1] = pivotx;
					currentX[2] = pivotx+1;
					currentX[3] = pivotx+1;
					currentY[0] = pivoty-1;
					currentY[1] = pivoty;
					currentY[2] = pivoty;
					currentY[3] = pivoty+1;
				}else{
					currentX[0] = pivotx;
					currentX[1] = pivotx;
					currentX[2] = pivotx+1;
					currentX[3] = pivotx+1;
					currentY[0] = pivoty;
					currentY[1] = pivoty+1;
					currentY[2] = pivoty+1;
					currentY[3] = pivoty+2;
				}
				grid[tempy1][tempx1] = 0;
				grid[tempy2][tempx2] = 0;
				grid[tempy3][tempx3] = 0;
				grid[tempy4][tempx4] = 0;
				grid[currentY[0]][currentX[0]] = current;
				grid[currentY[1]][currentX[1]] = current;
				grid[currentY[2]][currentX[2]] = current;
				grid[currentY[3]][currentX[3]] = current;
				position = 2;
				break;
			case 2:
				findCurrentPoint(grid);
				pivotx = tempx3;
				pivoty = tempy3;
				if((pivotx-2) < 0) {
					System.out.println("here");
					currentX[0] = pivotx;
					currentX[1] = pivotx+1;
					currentX[2] = pivotx-1;
					currentX[3] = pivotx;
					currentY[0] = pivoty-1;
					currentY[1] = pivoty-1;
					currentY[2] = pivoty;
					currentY[3] = pivoty;
				}else if(grid[tempy1+1][tempx1] != 0 && grid[tempy1+1][tempx1] != current) {
					currentX[0] = pivotx;
					currentX[1] = pivotx;
					currentX[2] = pivotx+1;
					currentX[3] = pivotx+1;
					currentY[0] = pivoty-1;
					currentY[1] = pivoty;
					currentY[2] = pivoty;
					currentY[3] = pivoty+1;
				} else {
					currentX[0] = pivotx-1;
					currentX[1] = pivotx;
					currentX[2] = pivotx-2;
					currentX[3] = pivotx-1;
					currentY[0] = pivoty-1;
					currentY[1] = pivoty-1;
					currentY[2] = pivoty;
					currentY[3] = pivoty;
				}
				grid[tempy1][tempx1] = 0;
				grid[tempy2][tempx2] = 0;
				grid[tempy3][tempx3] = 0;
				grid[tempy4][tempx4] = 0;
				grid[currentY[0]][currentX[0]] = current;
				grid[currentY[1]][currentX[1]] = current;
				grid[currentY[2]][currentX[2]] = current;
				grid[currentY[3]][currentX[3]] = current;
				position = 3;
				break;
			case 3:
				findCurrentPoint(grid);
				pivotx = tempx1;
				pivoty = tempy1;
				if(grid[tempy1+1][tempx1] != 0 && grid[tempy1+1][tempx1] != current) {
					currentX[0] = pivotx;
					currentX[1] = pivotx;
					currentX[2] = pivotx+1;
					currentX[3] = pivotx+1;
					currentY[0] = pivoty-1;
					currentY[1] = pivoty;
					currentY[2] = pivoty;
					currentY[3] = pivoty+1;
				} else {
					currentX[0] = pivotx-1;
					currentX[1] = pivotx-1;
					currentX[2] = pivotx;
					currentX[3] = pivotx;
					currentY[0] = pivoty;
					currentY[1] = pivoty+1;
						currentY[2] = pivoty+1;
						currentY[3] = pivoty+2;
					}
				grid[tempy1][tempx1] = 0;
				grid[tempy2][tempx2] = 0;
				grid[tempy3][tempx3] = 0;
				grid[tempy4][tempx4] = 0;
				grid[currentY[0]][currentX[0]] = current;
				grid[currentY[1]][currentX[1]] = current;
				grid[currentY[2]][currentX[2]] = current;
				grid[currentY[3]][currentX[3]] = current;
				position = 4;
				break;
			case 4:
				findCurrentPoint(grid);
				pivotx = tempx3;
				pivoty = tempy3;
				if((pivotx+1) > 9) {
					currentX[0] = pivotx-1;
					currentX[1] = pivotx;
					currentX[2] = pivotx-2;
					currentX[3] = pivotx-1;
					currentY[0] = pivoty-1;
					currentY[1] = pivoty-1;
					currentY[2] = pivoty;
					currentY[3] = pivoty;
				}else if(grid[tempy1+1][tempx1] != 0 && grid[tempy1+1][tempx1] != current) {
					currentX[0] = pivotx;
					currentX[1] = pivotx;
					currentX[2] = pivotx+1;
					currentX[3] = pivotx+1;
					currentY[0] = pivoty-1;
					currentY[1] = pivoty;
					currentY[2] = pivoty;
					currentY[3] = pivoty+1;
				} else {
					currentX[0] = pivotx;
					currentX[1] = pivotx+1;
					currentX[2] = pivotx-1;
					currentX[3] = pivotx;
					currentY[0] = pivoty-1;
					currentY[1] = pivoty-1;
					currentY[2] = pivoty;
					currentY[3] = pivoty;
				}
				grid[tempy1][tempx1] = 0;
				grid[tempy2][tempx2] = 0;
				grid[tempy3][tempx3] = 0;
				grid[tempy4][tempx4] = 0;
				grid[currentY[0]][currentX[0]] = current;
				grid[currentY[1]][currentX[1]] = current;
				grid[currentY[2]][currentX[2]] = current;
				grid[currentY[3]][currentX[3]] = current;
				position = 1;
				break;
		}
	}
	public void rotateI(int grid[][]){
		//System.out.println(position);
		switch(position) {
			case 1:
				findCurrentPoint(grid);
				pivotx = tempx2;
				pivoty = tempy2;
				currentX[0] = pivotx;
				currentX[1] = pivotx;
				currentX[2] = pivotx;
				currentX[3] = pivotx;
				if(tempy1-1 < 0){
					currentY[0] = 0;
					currentY[1] = 1;
					currentY[2] = 2;
					currentY[3] = 3;					
				}else if(tempy4+1 > 19 || tempy4+2 > 19) {	
					System.out.println("here");
					currentY[0] = 16;
					currentY[1] = 17;
					currentY[2] = 18;
					currentY[3] = 19;
					rotated = true;
				}else if(grid[pivoty+2][pivotx] != 0 && grid[pivoty+2][pivotx] != current){
					currentY[0] -= 2;
					currentY[1] -= 1;
					currentY[3] += 1;
				}else if((grid[tempy1+1][tempx1] != 0 && grid[tempy1+1][tempx1] != current) 
						&& (grid[tempy4+1][tempx4] != 0 && grid[tempy4+1][tempx4] != current)){
					return;
				}else{
					currentY[0] -= 1;
					currentY[2] += 1;
					currentY[3] += 2;
				}
				if(!rotated) {
					if(grid[pivoty+2][pivotx] != 0){
						currentY[0] -= 1;
						currentY[1] -= 1;
						currentY[2] -= 1;
						currentY[3] -= 1;
					}
				}
				grid[tempy1][tempx1] = 0;
				grid[tempy2][tempx2] = 0;
				grid[tempy3][tempx3] = 0;
				grid[tempy4][tempx4] = 0;
				grid[currentY[0]][currentX[0]] = current;
				grid[currentY[1]][currentX[1]] = current;
				grid[currentY[2]][currentX[2]] = current;
				grid[currentY[3]][currentX[3]] = current;
				rotated = false;
				position = 2;
				break;
			case 2:
				findCurrentPoint(grid);
				pivotx = tempx2;
				pivoty = tempy2;
				currentY[0] = pivoty;
				currentY[1] = pivoty;
				currentY[2] = pivoty;
				currentY[3] = pivoty;
				if(tempx1-1 < 0) {
 					if(grid[pivoty][pivotx+3] != 0 || grid[pivoty][pivotx+1] != 0 || grid[pivoty][pivotx+2] != 0){
 	 					if(checkLeftandRight(pivoty, pivotx, grid)) {
 	 	 					return;
 	 	 				}
 						currentY[0] -= 1;
 						currentY[1] -= 1;
 						currentY[2] -= 1;
 						currentY[3] -= 1;
 					}
					currentX[0] = 0;
					currentX[1] = 1;
					currentX[2] = 2;
					currentX[3] = 3;
 				}else if(tempx4+2 > 9) {
 					if(grid[pivoty][pivotx-1] != 0 || grid[pivoty][pivotx-2] != 0 || grid[pivoty][pivotx-3] != 0){
 	 					if(checkLeftandRight(pivoty, pivotx, grid)) {
 	 	 					return;
 	 	 				}
 						currentY[0] -= 1;
 						currentY[1] -= 1;
 						currentY[2] -= 1;
 						currentY[3] -= 1;
 					}
 					currentX[3] = 9;
 					currentX[2] = 8;
 					currentX[1] = 7;
 					currentX[0] = 6;
 				}else if((grid[pivoty][pivotx-1] != 0 && grid[pivoty][pivotx-1] != current) 
 						&& (grid[pivoty][pivotx] != 0 && grid[pivoty][pivotx] != current)
 						&& (grid[pivoty][pivotx+1] != 0 && grid[pivoty][pivotx+1] != current)
 						&& (grid[pivoty][pivotx+2] != 0 && grid[pivoty][pivotx+2] != current)) {
 					currentY[0] = pivoty-1;
 					currentY[1] = pivoty-1;
 					currentY[2] = pivoty-1;
 					currentY[3] = pivoty-1;
 					currentX[0] = pivotx-1;
 					currentX[1] = pivotx;
 					currentX[2] = pivotx+1;
 					currentX[3] = pivotx+2;
 				}else if((grid[pivoty+1][pivotx-1] != 0 && grid[pivoty+1][pivotx-1] != current)){
 					if(checkLeftandRight(pivoty, pivotx, grid)) {
 	 					return;
 	 				}
 					currentY[0] = pivoty-1;
 					currentY[1] = pivoty-1;
 					currentY[2] = pivoty-1;
 					currentY[3] = pivoty-1;
 					currentX[0] = pivotx-1;
 					currentX[1] = pivotx;
 					currentX[2] = pivotx+1;
 					currentX[3] = pivotx+2;
 				}else if((grid[pivoty+1][pivotx+1] != 0 && grid[pivoty+1][pivotx+1] != current)){
 					if(checkLeftandRight(pivoty, pivotx, grid)) {
 	 					return;
 	 				}
 					currentY[0] = pivoty-1;
 					currentY[1] = pivoty-1;
 					currentY[2] = pivoty-1;
 					currentY[3] = pivoty-1;
 					currentX[0] = pivotx-1;
 					currentX[1] = pivotx;
 					currentX[2] = pivotx+1;
 					currentX[3] = pivotx+2;
 				}else {
 					currentX[0] = pivotx-1;
 					currentX[1] = pivotx;
 					currentX[2] = pivotx+1;
 					currentX[3] = pivotx+2;
 				}
				grid[tempy1][tempx1] = 0;
				grid[tempy2][tempx2] = 0;
				grid[tempy3][tempx3] = 0;
				grid[tempy4][tempx4] = 0;
				grid[currentY[0]][currentX[0]] = current;
				grid[currentY[1]][currentX[1]] = current;
				grid[currentY[2]][currentX[2]] = current;
				grid[currentY[3]][currentX[3]] = current;
				position = 3;
				break;
			case 3:
				findCurrentPoint(grid);
				pivotx = tempx3;
				pivoty = tempy3;
				currentX[0] = pivotx;
				currentX[1] = pivotx;
				currentX[2] = pivotx;
				currentX[3] = pivotx;
				if(tempy1-1 > 0){
					currentY[0] -=1;
					currentY[1] += 1;
					currentY[3] += 2;					
				}else if(tempy4+1 > 19 || tempy4+2 > 19) {		
					currentY[0] = 16;
					currentY[1] = 17;
					currentY[2] = 18;
					currentY[3] = 19;
				}else if(grid[pivoty+2][pivotx-1] != 0 && grid[pivoty+2][pivotx-1] != current){
					currentY[0] -= 2;
					currentY[1] -= 1;
					currentY[3] += 1;
				}else if((grid[tempy1+1][tempx1] != 0 && grid[tempy1+1][tempx1] != current) 
						&& (grid[tempy4+1][tempx4] != 0 && grid[tempy4+1][tempx4] != current)){
					return;
				}else{
					currentY[0] = 0;
					currentY[1] = 1;
					currentY[2] = 2;
					currentY[3] = 3;
				}
				grid[tempy1][tempx1] = 0;
				grid[tempy2][tempx2] = 0;
				grid[tempy3][tempx3] = 0;
				grid[tempy4][tempx4] = 0;
				grid[currentY[0]][currentX[0]] = current;
				grid[currentY[1]][currentX[1]] = current;
				grid[currentY[2]][currentX[2]] = current;
				grid[currentY[3]][currentX[3]] = current;
				position = 4;
				break;
			case 4:
				findCurrentPoint(grid);
				pivotx = tempx2;
				pivoty = tempy2;
				currentY[0] = pivoty;
				currentY[1] = pivoty;
				currentY[2] = pivoty;
				currentY[3] = pivoty;
				if(tempx4+2 > 9){
 					currentX[3] = 9;
 					currentX[2] = 8;
 					currentX[1] = 7;
 					currentX[0] = 6;
 				}else if(tempx1-1 < 0){
					currentX[0] = 0;
					currentX[1] = 1;
					currentX[2] = 2;
					currentX[3] = 3;
 				}else{
 					currentX[0] = pivotx-2;
 					currentX[1] = pivotx-1;
 					currentX[2] = pivotx;
 					currentX[3] = pivotx+1;
 				}
				grid[tempy1][tempx1] = 0;
				grid[tempy2][tempx2] = 0;
				grid[tempy3][tempx3] = 0;
				grid[tempy4][tempx4] = 0;
				grid[currentY[0]][currentX[0]] = current;
				grid[currentY[1]][currentX[1]] = current;
				grid[currentY[2]][currentX[2]] = current;
				grid[currentY[3]][currentX[3]] = current;
				position = 1;
				break;
		}
	}
	public void rotateT(int grid[][]) {
		//System.out.println(position);
		switch(position) {
		case 1:
			findCurrentPoint(grid);
			pivotx = tempx3;
			pivoty = tempy3;
			if(pivoty+1 > 19) {
				pivoty-=1;
				currentX[0] = pivotx;
				currentX[1] = pivotx;
				currentX[2] = pivotx+1;
				currentX[3] = pivotx;
				currentY[0] = pivoty-1;
				currentY[1] = pivoty;
				currentY[2] = pivoty;
				currentY[3] = pivoty+1;
			}else if(grid[tempy3+1][tempx3] != 0 && grid[tempy3+1][tempx3] != current) {
				currentX[0] = pivotx;
				currentX[1] = pivotx;
				currentX[2] = pivotx+1;
				currentX[3] = pivotx;
				currentY[0] = pivoty-1;
				currentY[1] = pivoty;
				currentY[2] = pivoty;
				currentY[3] = pivoty+1;
			}else {
				currentX[0] = pivotx;
				currentX[1] = pivotx;
				currentX[2] = pivotx+1;
				currentX[3] = pivotx;
				currentY[0] = pivoty-1;
				currentY[1] = pivoty;
				currentY[2] = pivoty;
				currentY[3] = pivoty+1;
			}
			grid[tempy1][tempx1] = 0;
			grid[tempy2][tempx2] = 0;
			grid[tempy3][tempx3] = 0;
			grid[tempy4][tempx4] = 0;
			grid[currentY[0]][currentX[0]] = current;
			grid[currentY[1]][currentX[1]] = current;
			grid[currentY[2]][currentX[2]] = current;
			grid[currentY[3]][currentX[3]] = current;
			position = 2;
			break;
		case 2:
			findCurrentPoint(grid);
			pivotx = tempx2;
			pivoty = tempy2;
			if(pivotx-1 < 0) {
				pivotx += 1;
			}else if(grid[pivoty][pivotx-1] != 0) {
				if(grid[pivoty-1][pivotx-1] != 0) {
					return;
				}
				pivoty -= 1;
			}
			currentX[0] = pivotx-1;
			currentX[1] = pivotx;
			currentX[2] = pivotx+1;
			currentX[3] = pivotx;
			currentY[0] = pivoty;
			currentY[1] = pivoty;
			currentY[2] = pivoty;
			currentY[3] = pivoty+1;
			grid[tempy1][tempx1] = 0;
			grid[tempy2][tempx2] = 0;
			grid[tempy3][tempx3] = 0;
			grid[tempy4][tempx4] = 0;
			grid[currentY[0]][currentX[0]] = current;
			grid[currentY[1]][currentX[1]] = current;
			grid[currentY[2]][currentX[2]] = current;
			grid[currentY[3]][currentX[3]] = current;
			position = 3;
			break;
		case 3:
			findCurrentPoint(grid);
			pivotx = tempx2;
			pivoty = tempy2;
			currentX[0] = pivotx;
			currentX[1] = pivotx;
			currentX[2] = pivotx-1;
			currentX[3] = pivotx;
			currentY[0] = pivoty-1;
			currentY[1] = pivoty;
			currentY[2] = pivoty;
			currentY[3] = pivoty+1;
			grid[tempy1][tempx1] = 0;
			grid[tempy2][tempx2] = 0;
			grid[tempy3][tempx3] = 0;
			grid[tempy4][tempx4] = 0;
			grid[currentY[0]][currentX[0]] = current;
			grid[currentY[1]][currentX[1]] = current;
			grid[currentY[2]][currentX[2]] = current;
			grid[currentY[3]][currentX[3]] = current;
			position = 4;
			break;
		case 4:
			findCurrentPoint(grid);
			pivotx = tempx3;
			pivoty = tempy3;
			if(pivotx+1 > 9) {
				pivotx -= 1;
			}else if(grid[pivoty+1][pivotx] != 0){
				if(grid[pivoty-1][pivotx+1] != 0) {
					return;
				}
				pivoty -=1;
			}
			currentX[0] = pivotx;
			currentX[1] = pivotx-1;
			currentX[2] = pivotx;
			currentX[3] = pivotx+1;
			currentY[0] = pivoty-1;
			currentY[1] = pivoty;
			currentY[2] = pivoty;
			currentY[3] = pivoty;
			grid[tempy1][tempx1] = 0;
			grid[tempy2][tempx2] = 0;
			grid[tempy3][tempx3] = 0;
			grid[tempy4][tempx4] = 0;
			grid[currentY[0]][currentX[0]] = current;
			grid[currentY[1]][currentX[1]] = current;
			grid[currentY[2]][currentX[2]] = current;
			grid[currentY[3]][currentX[3]] = current;
			position = 1;
			break;
	}
	}
	public void rotateL(int grid[][]) {
		//System.out.println(position);
		switch(position) {
			case 1:
				findCurrentPoint(grid);
				pivotx = tempx3;
				pivoty = tempy3;
				if(pivoty+1 > 19) {
					pivoty -= 1;
				}
				currentX[0] = pivotx;
				currentX[1] = pivotx+1;
				currentX[2] = pivotx;
				currentX[3] = pivotx;
				currentY[0] = pivoty-1;
				currentY[1] = pivoty-1;
				currentY[2] = pivoty;
				currentY[3] = pivoty+1;
				grid[tempy1][tempx1] = 0;
				grid[tempy2][tempx2] = 0;
				grid[tempy3][tempx3] = 0;
				grid[tempy4][tempx4] = 0;
				grid[currentY[0]][currentX[0]] = current;
				grid[currentY[1]][currentX[1]] = current;
				grid[currentY[2]][currentX[2]] = current;
				grid[currentY[3]][currentX[3]] = current;
				position = 2;
				break;
			case 2:
				findCurrentPoint(grid);
				pivotx = tempx3;
				pivoty = tempy3;
				if(pivotx-1 < 0) {
					pivotx += 1;
				}else if(grid[pivoty][pivotx-1] != 0) {
					if(grid[pivoty-1][pivotx-1] != 0) {
						pivoty -=2;
					}else {
						pivoty -=1;
					}
				}
				currentY[0] = pivoty;
				currentY[1] = pivoty;
				currentY[2] = pivoty;
				currentY[3] = pivoty+1;
				currentX[0] = pivotx-1;
				currentX[1] = pivotx;
				currentX[2] = pivotx+1;
				currentX[3] = pivotx+1;
				grid[tempy1][tempx1] = 0;
				grid[tempy2][tempx2] = 0;
				grid[tempy3][tempx3] = 0;
				grid[tempy4][tempx4] = 0;
				grid[currentY[0]][currentX[0]] = current;
				grid[currentY[1]][currentX[1]] = current;
				grid[currentY[2]][currentX[2]] = current;
				grid[currentY[3]][currentX[3]] = current;
				position = 3;
				break;
			case 3:
				findCurrentPoint(grid);
				pivotx = tempx2;
				pivoty = tempy2;
				try {
					if(grid[pivoty+3][pivotx] != 0) {
						pivoty -= 1;
					}
				}catch(Exception e) {
					
				}
				currentX[0] = pivotx;
				currentX[1] = pivotx;
				currentX[2] = pivotx-1;
				currentX[3] = pivotx;
				currentY[0] = pivoty-1;
				currentY[1] = pivoty;
				currentY[2] = pivoty+1;
				currentY[3] = pivoty+1;
				grid[tempy1][tempx1] = 0;
				grid[tempy2][tempx2] = 0;
				grid[tempy3][tempx3] = 0;
				grid[tempy4][tempx4] = 0;
				grid[currentY[0]][currentX[0]] = current;
				grid[currentY[1]][currentX[1]] = current;
				grid[currentY[2]][currentX[2]] = current;
				grid[currentY[3]][currentX[3]] = current;
				position = 4;
				break;
			case 4:
				findCurrentPoint(grid);
				pivotx = tempx2;
				pivoty = tempy2;
				if(pivotx+1 > 9) {
					pivotx-=1;
				}
				currentX[0] = pivotx-1;
				currentX[1] = pivotx-1;
				currentX[2] = pivotx;
				currentX[3] = pivotx+1;
				currentY[0] = pivoty-1;
				currentY[1] = pivoty;
				currentY[2] = pivoty;
				currentY[3] = pivoty;
				grid[tempy1][tempx1] = 0;
				grid[tempy2][tempx2] = 0;
				grid[tempy3][tempx3] = 0;
				grid[tempy4][tempx4] = 0;
				grid[currentY[0]][currentX[0]] = current;
				grid[currentY[1]][currentX[1]] = current;
				grid[currentY[2]][currentX[2]] = current;
				grid[currentY[3]][currentX[3]] = current;
				position = 1;
				break;
		}
	}
	public Shape() {
		dropped = false;
		//num = (int)(Math.random()*5)+1;
		num = 1;
		current = num + 10;
	}
	public boolean checkLeftandRight(int a, int b, int[][]grid) {
			if(grid[a-1][b+1] != 0 && grid[a-1][b+1] != 0) {
				return true;
			}else if(grid[a-1][b-1] != 0 && grid[a-1][b-1] != current) {
				return true;
			}else {
				return false;
			}
	}
	public void findCurrentPoint(int [][] grid) {
		count = 0;
		//System.out.println(current);
		for(int i = 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				if(grid[i][j] == current) {
					currentY[count] = i;
					currentX[count] = j;					
					count++;
				}
			}
		}
		//System.out.println(current);
		tempx1 = currentX[0];
		tempx2 = currentX[1];
		tempx3 = currentX[2];
		tempx4 = currentX[3];
		tempy1 = currentY[0];
		tempy2 = currentY[1];
		tempy3 = currentY[2];
		tempy4 = currentY[3];
//		for(int i = 0; i < HEIGHT; i++) {
//			System.out.println();
//			for(int j = 0; j < WIDTH; j++) {
//				System.out.print(grid[i][j] + " ");
//			}
//		}
//		System.out.println();
		
	}
	public void speedUp(int [][] grid) {
		findCurrentPoint(grid);
		if(currentY[0] < 19 && currentY[1] < 19 && currentY[2] < 19 && currentY[3] < 19) {
			if((grid[tempy1+1][tempx1] == 0 || grid[tempy1+1][tempx1] == current)
					&& (grid[tempy2+1][tempx2] == current || grid[tempy2+1][tempx2] == 0)
					&& (grid[tempy3+1][tempx3] == current || grid[tempy3+1][tempx3] == 0)
					&& (grid[tempy4+1][tempx4] == current ||grid[tempy4+1][tempx4] == 0)) {
				grid[tempy1][tempx1] = 0;
				grid[tempy2][tempx2] = 0;
				grid[tempy3][tempx3] = 0;
				grid[tempy4][tempx4] = 0;
				grid[tempy1+1][tempx1] = current;
				grid[tempy2+1][tempx2] = current;
				grid[tempy3+1][tempx3] = current;
				grid[tempy4+1][tempx4] = current;				
//				System.out.println("After");
//				for(int i = 0; i < HEIGHT; i++) {
//					System.out.println();
//					for(int j = 0; j < WIDTH; j++) {
//						System.out.print(grid[i][j] + " ");
//					}
//				}
//				System.out.println();
			}else{
				grid[tempy1][tempx1] = current-10;
				grid[tempy2][tempx2] = current-10;
				grid[tempy3][tempx3] = current-10;
				grid[tempy4][tempx4] = current-10;
				dropped = true;
				position = 1;
			}
		}else if(tempy1 == 19 || tempy2 == 19 || tempy3 == 19 || tempy4 == 19){
			grid[tempy1][tempx1] = current-10;
			grid[tempy2][tempx2] = current-10;
			grid[tempy3][tempx3] = current-10;
			grid[tempy4][tempx4] = current-10;
			dropped = true;
			position = 1;
		}
	}
	public void drop(int [][] grid){
//		for(int i = 0; i < HEIGHT; i++) {
//			System.out.println();
//			for(int j = 0; j < WIDTH; j++) {
//				System.out.print(grid[i][j] + " ");
//			}
//		}
//		System.out.println();
		findCurrentPoint(grid);
		if(tempy1 == 19 || tempy2 == 19 || tempy3 == 19 || tempy4 == 19) {
			System.out.println("bottom");
			dropped = true;
			grid[tempy1][tempx1] = num;
			grid[tempy2][tempx2] = num;
			grid[tempy3][tempx3] = num;
			grid[tempy4][tempx4] = num;
			return;
		}
		if((grid[tempy1+1][tempx1] != 0 && grid[tempy1+1][tempx1] != current)
				|| (grid[tempy2+1][tempx2] != 0 && grid[tempy2+1][tempx2] != current)
				|| (grid[tempy3+1][tempx3] != 0 && grid[tempy3+1][tempx3] != current)
				|| (grid[tempy4+1][tempx4] != 0 && grid[tempy4+1][tempx4] != current)) {
			dropped = true;
			grid[tempy1][tempx1] = num;
			grid[tempy2][tempx2] = num;
			grid[tempy3][tempx3] = num;
			grid[tempy4][tempx4] = num;
			return;
		}
		tempMax = Math.max(Math.max(tempy1, tempy2), Math.max(tempy3, tempy4));
		for(int i = tempMax+1; i < HEIGHT; i++) {
			if((grid[i][tempx1] != 0 && grid[i][tempx1] != current) 
					|| (grid[i][tempx2] != 0 && grid[i][tempx2] != current) 
					|| (grid[i][tempx3] != 0 && grid[i][tempx3] != current) 
					|| (grid[i][tempx4] != 0 && grid[i][tempx4] != current)) {
				if((grid[tempy1+(i-tempMax)][tempx1] == 0 || grid[tempy1+(i-tempMax)][tempx1] == current)
						&& (grid[tempy2+(i-tempMax)][tempx2] == 0 || grid[tempy2+(i-tempMax)][tempx2] == current)
						&& (grid[tempy3+(i-tempMax)][tempx3] == 0 || grid[tempy3+(i-tempMax)][tempx3] == current)
						&& (grid[tempy4+(i-tempMax)][tempx4] == 0 || grid[tempy4+(i-tempMax)][tempx4] == current)) {
					if(grid[tempy2+(i-tempMax+1)][tempx2] != 0) {
						under = true;
						grid[tempy1+(i-tempMax)][tempx1] = current-10;				
						grid[tempy2+(i-tempMax)][tempx2] = current-10;
						grid[tempy3+(i-tempMax)][tempx3] = current-10;
						grid[tempy4+(i-tempMax)][tempx4] = current-10;
						grid[tempy1][tempx1] = 0;
						grid[tempy2][tempx2] = 0;
						grid[tempy3][tempx3] = 0;
						grid[tempy4][tempx4] = 0;
						break;
					}else {
						continue;
					}
				}else{
					under = true;
					grid[tempy1+(i-tempMax-1)][tempx1] = current-10;
					grid[tempy1][tempx1] = 0;
			
					grid[tempy2+(i-tempMax-1)][tempx2] = current-10;
					grid[tempy2][tempx2] = 0;
		 
					grid[tempy3+(i-tempMax-1)][tempx3] = current-10;
					grid[tempy3][tempx3] = 0;
				
					grid[tempy4+(i-tempMax-1)][tempx4] = current-10;
					grid[tempy4][tempx4] = 0;
					break;
				}
			}
		}
		if(!under) {
			grid[tempy1+(19-tempMax)][tempx1] = current-10;
			grid[tempy1][tempx1] = 0;
			
			grid[tempy2+(19-tempMax)][tempx2] = current-10;
			grid[tempy2][tempx2] = 0;
			
			grid[tempy3+(19-tempMax)][tempx3] = current-10;
			grid[tempy3][tempx3] = 0;
			
			grid[tempy4+(19-tempMax)][tempx4] = current-10;
			grid[tempy4][tempx4] = 0;
		}
//		System.out.println("After");
//		for(int i = 0; i < HEIGHT; i++) {
//			System.out.println();
//			for(int j = 0; j < WIDTH; j++) {
//				System.out.print(grid[i][j] + " ");
//			}
//		}
//		System.out.println();
		under = false;
		dropped = true;
		position = 1;
	}
	public void moveLeft(int [][] grid) {
		findCurrentPoint(grid);
		if(tempx1-1 < 0 || tempx2-1 < 0 || tempx3-1 < 0 || tempx4-1 < 0) {
			return;
		}
		if((grid[tempy1][tempx1-1] == 0 || grid[tempy1][tempx1-1] == current && tempx1-1 > 0) && (grid[tempy2][tempx2-1] == 0 || grid[tempy2][tempx2-1] == current  && tempx2-1 > 0) && (grid[tempy3][tempx3-1] == 0 || grid[tempy3][tempx3-1] == current  && tempx3-1 > 0) && (grid[tempy4][tempx4-1] == 0 || grid[tempy4][tempx4-1] == current  && tempx4-1 > 0)) {
			grid[tempy1][tempx1] = 0;
			grid[tempy2][tempx2] = 0;
			grid[tempy3][tempx3] = 0;
			grid[tempy4][tempx4] = 0;
			
			grid[tempy1][tempx1-1] = current;		
			grid[tempy2][tempx2-1] = current;
			grid[tempy3][tempx3-1] = current;
			grid[tempy4][tempx4-1] = current;	
		}
//		System.out.println("After");
//		for(int i = 0; i < HEIGHT; i++) {
//			System.out.println();
//			for(int j = 0; j < WIDTH; j++) {
//				System.out.print(grid[i][j] + " ");
//			}
//		}
//		System.out.println();
	}
	public void moveRight(int [][] grid) {
		findCurrentPoint(grid);
		if(tempx1+1 > 9 || tempx2+1 > 9 || tempx3+1 > 9 || tempx4+1 > 9) {
			return;
		}
		if((grid[tempy1][tempx1+1] == 0 || grid[tempy1][tempx1+1] ==current && tempx1+1 < 9) && (grid[tempy2][tempx2+1] == 0 || grid[tempy2][tempx2+1] == current  && tempx2+1 < 9) && (grid[tempy3][tempx3+1] == 0 || grid[tempy3][tempx3+1] == current  && tempx3+1 < 9) && (grid[tempy4][tempx4+1] == 0 || grid[tempy4][tempx4+1] == current  && tempx4+1 > 9)) {
			grid[tempy1][tempx1] = 0;
			grid[tempy2][tempx2] = 0;
			grid[tempy3][tempx3] = 0;
			grid[tempy4][tempx4] = 0;
			
			grid[tempy1][tempx1+1] = current;		
			grid[tempy2][tempx2+1] = current;
			grid[tempy3][tempx3+1] = current;
			grid[tempy4][tempx4+1] = current;
			
		}
//		System.out.println("After");
//		for(int i = 0; i < HEIGHT; i++) {
//			System.out.println();
//			for(int j = 0; j < WIDTH; j++) {
//				System.out.print(grid[i][j] + " ");
//			}
//		}
//		System.out.println();
	}
}
