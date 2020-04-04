package test;

import algorithms.mazeGenerators.*;
import algorithms.search.AState;
import algorithms.search.MazeState;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class testClass {
    public static void timeTaken (IMazeGenerator gen, int row, int col){
        System.out.println(String.format("Time taken to generate a %dx%d maze : %d mills",row,col,gen.measureAlgorithmTimeMillis(row,col)));

    }
    public static void main(String[] args) {
        IMazeGenerator empty = new EmptyMazeGenerator();
        Maze testEmpty = empty.generate(10,10);
        timeTaken(empty,1000,1000);
        testEmpty.print();
        System.out.println();

        IMazeGenerator simple = new SimpleMazeGenerator();
        Maze testSimple = simple.generate(10,10);
        timeTaken(simple,1000,1000);
        testSimple.print();
        System.out.println();

        IMazeGenerator my = new MyMazeGenerator();
        timeTaken(my,1000,1000);
        Maze myMaze = my.generate(20,20);
        myMaze.print();
        System.out.println("Steps taken: "+my.getSteps());

        AState a = new MazeState(1,new Position(0,0), null);
        AState b = new MazeState(1,new Position(0,1), null);
        AState c = new MazeState(1,new Position(1,0), null);
        AState d = new MazeState(1,new Position(1,1), null);
        Map q = new LinkedHashMap<String,AState>();
        Set<AState> q1 = new LinkedHashSet<>();
//        q.put(b.toString(),b);
//        q.put(a.toString(),a);
//        q.put(c.toString(),c);
//        q.put(d.toString(),d);
//        System.out.println(q.isEmpty());
//        Object first = ((Map.Entry)q.entrySet().iterator().next()).getValue();
//        AState firstState= (AState)first;
        q1.add(a);
        q1.add(b);
        q1.add(c);
        q1.add(d);
        AState firstState= q1.iterator().next();
        System.out.println(firstState.toString());
        System.out.println(firstState==null);
        System.out.println(q1.contains(a));



    }
}