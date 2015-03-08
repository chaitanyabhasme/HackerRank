package graphTheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EvenTree {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			String[] input = br.readLine().split(" ");
			int vertices = Integer.parseInt(input[0]);
			int edges = Integer.parseInt(input[1]);
			checkInput(vertices, 2, 100);
			int[][] edgeMatrix = new int[vertices][vertices];
			
			//init edgeMatrix;
			for(int i = 0; i < edges; i++){
				for(int j = 0; j < edges; j++){
					edgeMatrix[i][j] = 0;
				}
			}
			for(int i = 0; i < edges;i++){
				String[] edgeIn = br.readLine().split(" ");
				int v1 = Integer.parseInt(edgeIn[0]);
				int v2 = Integer.parseInt(edgeIn[1]);
				if(v1 > v2){
					edgeMatrix[v2-1][v1-1] = 1;
				}
				else{
					edgeMatrix[v1-1][v2-1] = 1;
				}
			}
			//print matrix
			for(int i = 0; i < vertices; i++){
				for(int j = 0; j < vertices; j++){
					System.out.print(edgeMatrix[i][j] + " ");
				}
				System.out.println("");
			}
			decomposeTree(edgeMatrix,vertices);
		}catch(Exception e){
			System.out.println("Unable to read the Input!");
			System.exit(1);
		}
	}
	
	public static void decomposeTree(int [][] matrix, int no_vertices){
		int cntEdges = 0;
		for(int i = 0; i< no_vertices; i++){
			for(int j = i+1; j < no_vertices; j++){
				if(matrix[i][j] == 1){
					int tmpCount = 1 + findNodes(matrix, j, no_vertices);
					if(tmpCount % 2 == 0){		//i.e. even num of nodes for this edge then this edge can be removed.
						matrix[i][j] = 0;
						cntEdges++;
					}
				}
			}
		}
		
		System.out.println(cntEdges);
	}
	
	public static int findNodes(int[][] matrix, int i, int numVertices){
		if(i >= numVertices){
			return 0;
		}
		int totalNodes = 0;
		for(int j = i; j<numVertices; j++){
			if(matrix[i][j] == 1){
				totalNodes++;
				totalNodes = totalNodes + findNodes(matrix,j,numVertices);
			}
		}
		return totalNodes;
	}
	public static void checkInput(int num, int min, int max){
		if(num < min || num > max)
			System.exit(1);
	}

}
