package Threads.RecursiveAction;

import java.util.concurrent.RecursiveAction;

/**
 * @author ssadasivan
 * @since 3/5/2017.
 */
public class SimpleRecursiveAction extends RecursiveAction {
    private int simulatedWork;

    public SimpleRecursiveAction(int simulatedWork) {
        this.simulatedWork = simulatedWork;
    }

    @Override
    protected void compute() {
        if (simulatedWork > 100) {
            System.out.println("Parallel Execution started.. " + simulatedWork);
            SimpleRecursiveAction simpleRecursiveAction1 = new SimpleRecursiveAction(simulatedWork / 2);
            SimpleRecursiveAction simpleRecursiveAction2 = new SimpleRecursiveAction(simulatedWork / 2);
            simpleRecursiveAction1.fork();
            simpleRecursiveAction2.fork();
        } else {
            System.out.println("No Need of parallel, sequential is OK  " + simulatedWork);
        }
    }
}
