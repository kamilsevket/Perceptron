package perceptron;


/**
 *
 * @author Kamil Demirtaş
 */
public class Trainer {

    private double[] inputs;
    private int answer;

    public Trainer( double x, double y, int a ) {
        inputs = new double[3];
        inputs[ 0 ] = x;
        inputs[ 1 ] = y;
        inputs[ 2 ] = 1; //bias
        answer = a;
    }

    public Trainer (double z, int b){
        inputs = new double[2];
        inputs[ 0 ] = z;
        inputs[ 1 ] = 1; //bias
        answer = b;
    }

    public double[] getInputs() {
        return inputs;
    }

    public int getAnswer() {
        return answer;
    }
    
}
